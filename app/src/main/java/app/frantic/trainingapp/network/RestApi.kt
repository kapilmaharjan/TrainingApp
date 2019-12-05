package app.frantic.trainingapp.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RestApi {

    companion object{
        val BASE_URL = "http://services.hanselandpetal.com/feeds/"
        fun api():RequestAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestAPI::class.java)
        }
    }

    public interface RequestAPI{
        @GET("flowers.json")
        fun getFlower(): Call<List<Flower>>
    }
}