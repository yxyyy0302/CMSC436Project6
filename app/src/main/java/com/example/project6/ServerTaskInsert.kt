package com.example.project6

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ServerTaskInsert(val candyName: String, val candyPrice: Double) : Thread() {

    override fun run() {
        try {
            // Build the URL with the candy info
            val urlString = "${MainActivity.URL_INSERT}?id=-1&name=$candyName&price=$candyPrice"
            val url = URL(urlString)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"

            val reader = BufferedReader(InputStreamReader(conn.inputStream))
            val response = reader.readLine()
            reader.close()

            Log.d("ServerTaskInsert", "Inserted candy: $candyName, response: $response")

        } catch (e: Exception) {
            Log.e("ServerTaskInsert", "Error inserting candy: $candyName")
        }
    }
}
