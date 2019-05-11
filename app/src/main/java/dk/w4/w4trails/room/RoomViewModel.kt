package dk.w4.w4trails.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dk.w4.w4trails.room.entry.Clue

class RoomViewModel(private val clueRepository: ClueRepository) : ViewModel() {

    private val singleClueData = MutableLiveData<Clue>()

    fun observeClues(): LiveData<List<Clue>> = clueRepository.getAllClues()
    fun observeSingleClue(): LiveData<Clue> =singleClueData

    fun applyClue(clue: Clue){
        clueRepository.insertClue(clue)
    }

    fun getSingleClue(name: String){
        clueRepository.getClueByName(name)
    }

    fun removeClue(name: String) {
        val clue = clueRepository.getClueByName(name)
        clueRepository.removeClue(clue)
    }

}