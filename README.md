# TrainingApp
Training App


### Shared Preference



``` 
      private var pref: SharedPreferences? = null
    private lateinit var editor: SharedPreferences.Editor

    private val PREF_NAME = "training app"
    private val KEY_NAME = "name"

    // INITIALIZATION
     pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
     editor = pref!!.edit()
```


### save data
``` 
       editor.putString(KEY_NAME,ed_text.text.toString()).commit()

```

### retrieve data
``` 
        pref!!.getString(KEY_NAME,"")
```


# Room

###Initialize a database
``` 
       Room.databaseBuilder(context.applicationContext, MovieDatabase::class.java, "movie-db")
                    .allowMainThreadQueries().build()
```

### Initialize a table
``` 
      @Entity(tableName = "movies")
      data class Movie (
        @PrimaryKey val id : String = UUID.randomUUID().toString(),
        var title: String? = null,
        var genre: String? = null,
        var year: String? = null
        )
```

### Create a DAO
   ``` 
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
```

### Queries
   
   Fetch all datas
   ```    
  movieList = movieDatabase!!.movieDao().getAllMovies() as ArrayList<Movie>

```

Insert a data
   ```    
      fun addMovie(movie : Movie){
        GlobalScope.async {
            val db = MovieDatabase.getDataBase(applicationContext)
            db.movieDao().insertMovie(movie)
            finish()
        }
    }

```
   
