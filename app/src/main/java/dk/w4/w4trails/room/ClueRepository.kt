package dk.w4.w4trails.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import dk.w4.w4trails.room.entry.Clue

class ClueRepository(private val applicationContext: Context) {
    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getAllClues(): LiveData<List<Clue>> {
        return db.clueDao().getAllClues()
    }

    fun getClueByName(name: String): Clue {
        return db.clueDao().getClueByName(name)
    }

    suspend fun insertClue(clue: Clue) {
        db.clueDao().insertClue(clue)
    }

    fun removeClue(clue: Clue) {
        db.clueDao().removeClue(clue)
    }
}