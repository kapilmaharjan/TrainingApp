package app.frantic.trainingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.frantic.trainingapp.movies.Movie

@Database(entities = [(Movie::class)], version = 1,exportSchema = false)
abstract class MovieDatabase:RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var INSTANCE: MovieDatabase? = null
        fun getDataBase(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, MovieDatabase::class.java, "movie-db")
                    .allowMainThreadQueries().build()
            }
            return INSTANCE as MovieDatabase
        }
    }
}