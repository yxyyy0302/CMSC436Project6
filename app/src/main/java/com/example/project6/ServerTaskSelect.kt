package com.example.project6

import android.util.Log
import org.json.JSONArray
import java.io.InputStream
import java.net.URL
import java.util.Scanner

class ServerTaskSelect : Thread {
    private lateinit var activity : MainActivity
    constructor( activity : MainActivity ) {
        this.activity = activity
    }

    override fun run(){
        var result = ""
        val jsonList = mutableListOf<String>()

        try {
            val url = URL(MainActivity.URL_ALL)
            val iStream: InputStream = url.openStream()
            val scan = Scanner(iStream)
            while (scan.hasNext())
                result += scan.nextLine()
        }catch (e: Exception) {
            Log.e("MainActivity", "ServerTaskSelect error")
        }
       Log.w("MainActivity", "JSON: " + result)


//        try {
//            val jsonArray = JSONArray(result)
//            for (i in 0 until jsonArray.length()) {
//                jsonList.add(jsonArray.getString(i))
//            }
//        } catch (e: Exception) {
//            Log.e("MainActivity", "JSON parsing error")
//        }

//        activity.runOnUiThread { activity.updateAutoText(jsonList) }

    }
}