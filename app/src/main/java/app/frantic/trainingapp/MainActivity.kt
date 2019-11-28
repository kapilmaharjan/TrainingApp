package app.frantic.trainingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import app.frantic.trainingapp.database.MovieDatabase
import app.frantic.trainingapp.movies.AddMoviesActivity
import app.frantic.trainingapp.movies.Movie
import app.frantic.trainingapp.movies.MoviesAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var movieList = ArrayList<Movie>()

    var movieDatabase:MovieDatabase? = null

    lateinit var adapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieDatabase = MovieDatabase.getDataBase(this)
        movieList = movieDatabase!!.movieDao().getAllMovies() as ArrayList<Movie>
        adapter = MoviesAdapter(movieList)
        val layoutManager = LinearLayoutManager(this)
        recycler_view.setLayoutManager(layoutManager)
        recycler_view.setItemAnimator(DefaultItemAnimator())
        recycler_view.setAdapter(adapter)

        fab.setOnClickListener { view ->
            val i = Intent(this,
                AddMoviesActivity::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        movieList = movieDatabase!!.movieDao().getAllMovies() as ArrayList<Movie>
        adapter.refreshLayout(movieList)
    }



}
