package app.frantic.trainingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.frantic.trainingapp.network.FlowerActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_shared.setOnClickListener {
            val i = Intent(this,SharedActivity::class.java)
            startActivity(i)
        }

        btn_room.setOnClickListener {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        btn_network.setOnClickListener {
            val i = Intent(this,FlowerActivity::class.java)
            startActivity(i)
        }
    }
}
