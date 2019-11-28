package app.frantic.trainingapp.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.frantic.trainingapp.R
import app.frantic.trainingapp.database.MovieDatabase
import kotlinx.android.synthetic.main.activity_add_movies.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddMoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movies)

        submit_btn.setOnClickListener {
            val title = ed_title.text.toString()
            val genre = ed_genre.text.toString()
            val year = ed_year.text.toString()

            addMovie(
                Movie(
                    title = title,
                    genre = genre,
                    year = year
                )
            )
        }
    }


    fun addMovie(movie : Movie){
        GlobalScope.async {
            val db = MovieDatabase.getDataBase(applicationContext)
            db.movieDao().insertMovie(movie)
            finish()
        }
    }
}
