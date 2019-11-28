package app.frantic.trainingapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared.*

class SharedActivity : AppCompatActivity() {

    private var pref: SharedPreferences? = null
    private lateinit var editor: SharedPreferences.Editor

    private val PREF_NAME = "training app"
    private val KEY_NAME = "name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref!!.edit()

        save_btn.setOnClickListener {
            editor.putString(KEY_NAME,ed_text.text.toString()).commit()
        }

        show_btn.setOnClickListener {
            tv_view.text = pref!!.getString(KEY_NAME,"")
        }

    }
}
