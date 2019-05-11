package dk.w4.w4trails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import dk.w4.w4trails.room.ClueRepository
import dk.w4.w4trails.room.RoomViewModel
import dk.w4.w4trails.room.entry.Clue
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RoomViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    //@Rule
    //@JvmField
    //val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Spy
    private val clueListLiveData: MutableLiveData<List<Clue>> = MutableLiveData()

    @Mock
    lateinit var clueRepositoryMock: ClueRepository

    @Mock
    lateinit var observer: Observer<List<Clue>>

    private lateinit var viewModel: RoomViewModel
    private lateinit var allCluesLiveData: LiveData<List<Clue>>


    @Before
    fun setup(){
        //`when`(clueRepositoryMock.getAllClues()).thenReturn(clueListLiveData)
        //viewModel = RoomViewModel(clueRepositoryMock)

        allCluesLiveData = viewModel.observeClues()
    }

    @Test
    fun applyClueTest() {
        val clue = Clue(1,"test", "test")

        viewModel.observeClues().observeForever(observer)
        viewModel.applyClue(clue)

        assertEquals(listOf(clue), observer.onChanged(listOf(clue)))
    }

    @Test
    fun selectSingleClueTest(){
        val name = "test"
        val clue = Clue(1,name, "test")

        viewModel.applyClue(clue)
        viewModel.getSingleClue(name)

        verify(clueRepositoryMock).getClueByName(name)
        assertEquals(clue, clueRepositoryMock.getClueByName(name))
    }

    @Test
    fun removeClueTest() = runBlocking{
        val name = "test"
        val clue = Clue(1, name, "test")

        viewModel.applyClue(clue)
        assert(viewModel.observeClues().value.isNullOrEmpty())
        viewModel.removeClue(name)

        verify(clueRepositoryMock).removeClue(clue)
    }

}