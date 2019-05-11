package dk.w4.w4trails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LiveDataTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val liveData = MutableLiveData<Boolean>()

    @Before
    fun setup(){

    }

    @Test
    fun `livedata starts as null`(){
        assertNull(liveData.value)
    }

    @Test
    fun `value can change`(){
        liveData.postValue(true)
        assertEquals(true, liveData.value)
    }

}