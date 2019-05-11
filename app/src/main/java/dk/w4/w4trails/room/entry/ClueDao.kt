package dk.w4.w4trails.room.entry

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClueDao {
    @Query("SELECT * FROM clue")
    fun getAllClues(): LiveData<List<Clue>>

    @Query("SELECT * FROM clue WHERE name LIKE :name LIMIT 1")
    fun getClueByName(name: String): Clue

    @Insert
    fun insertClue(vararg clue: Clue)

    @Delete
    fun removeClue(clue: Clue)
}