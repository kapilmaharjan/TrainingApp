package app.frantic.trainingapp.database

import androidx.room.*
import app.frantic.trainingapp.movies.Movie

@Dao
interface MovieDao {
    @Insert
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM MOVIES")
    fun getAllMovies():List<Movie>
}