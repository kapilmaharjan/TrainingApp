package app.frantic.trainingapp.movies

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey val id : String = UUID.randomUUID().toString(),
    var title: String? = null,
    var genre: String? = null,
    var year: String? = null
)