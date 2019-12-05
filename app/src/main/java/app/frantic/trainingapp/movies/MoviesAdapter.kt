package app.frantic.trainingapp.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.frantic.trainingapp.R


class MoviesAdapter(private val moviesList: ArrayList<Movie>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    lateinit var context: Context

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var year: TextView
        var genre: TextView

        init {
            title = view.findViewById(R.id.title)
            genre = view.findViewById(R.id.genre)
            year = view.findViewById(R.id.year)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_row, parent, false)
        context = parent.context

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year

        holder.itemView.setOnClickListener({
            Toast.makeText(context, holder.title.text, Toast.LENGTH_LONG).show()
        })

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun refreshLayout(lists:ArrayList<Movie>){
        moviesList!!.clear()
        moviesList.addAll(lists)
        notifyDataSetChanged()
    }
}