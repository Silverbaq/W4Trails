package dk.w4.w4trails.room

import androidx.room.Database
import androidx.room.RoomDatabase
import dk.w4.w4trails.room.entry.Clue
import dk.w4.w4trails.room.entry.ClueDao


@Database(entities = arrayOf(Clue::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clueDao(): ClueDao
}
