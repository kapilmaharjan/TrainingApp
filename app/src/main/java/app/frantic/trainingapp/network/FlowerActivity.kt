package app.frantic.trainingapp.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import app.frantic.trainingapp.R
import kotlinx.android.synthetic.main.activity_flower.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerActivity : AppCompatActivity() {
    var adapter:FlowerAdapter?= null
    val flowerList:ArrayList<Flower> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower)

        adapter = FlowerAdapter(flowerList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        val response = RestApi!!.api().getFlower()
        response.enqueue(object : Callback<List<Flower>>{
            override fun onFailure(call: Call<List<Flower>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Flower>>, response: Response<List<Flower>>) {
                if (response.isSuccessful){
                    flowerList.addAll(response.body()!!)
                    adapter!!.notifyDataSetChanged()
                }
            }

        })
    }
}
