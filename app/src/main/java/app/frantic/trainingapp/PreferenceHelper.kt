package app.frantic.trainingapp

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private var pref: SharedPreferences? = null
    private lateinit var editor: SharedPreferences.Editor

    private val PREF_NAME = "training app"
    private val KEY_NAME = "name"

    fun init(context: Context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = pref!!.edit()
    }

    fun saveName(name:String){
        editor.run {
            putString(KEY_NAME,name)
        }.commit()
    }

    fun getAccessName(){
        pref!!.getString(KEY_NAME,null)
    }




}