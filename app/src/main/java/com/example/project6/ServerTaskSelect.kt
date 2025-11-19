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
            scan.close()
            iStream.close()
        }catch (e: Exception) {
            Log.e("MainActivity", "ServerTaskSelect error")
        }
       Log.w("MainActivity", "JSON: " + result)


        try {
            val jsonArray = JSONArray(result)
            MainActivity.candies.clear()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val id = obj.getInt("id")
                val name = obj.getString("name")
                val price = obj.getDouble("price")

                val candy = Candy(id, name, price)
                MainActivity.candies.add(candy)
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "JSON parsing error")
        }

        activity.runOnUiThread { activity.showCandies() }

    }
}