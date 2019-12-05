package app.frantic.trainingapp.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.frantic.trainingapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.flower_list_item.view.*

class FlowerAdapter(val flowers:List<Flower>): RecyclerView.Adapter<FlowerAdapter.MyHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.flower_list_item,parent,false))

    }

    override fun getItemCount(): Int {
        return flowers.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var imageUrl="http://services.hanselandpetal.com/photos/"
        val flower = flowers.get(position)
        holder.name.text = flower.name
        holder.price.text = "$ ${flower.price}"
        Picasso.get().load(imageUrl.plus(flower.photo)).into(holder.imageView)
    }

    class MyHolder(view: View):RecyclerView.ViewHolder(view){
        var name = view.tv_flower_name;
        var price = view.tv_price;
        var imageView = view.iv_flower_image
    }


}