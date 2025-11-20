package com.example.project6

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ServerTaskDelete(val id: Int) : Thread() {

    override fun run() {
        try {
            val urlString = MainActivity.URL_DELETE + "?id=" + id
            val url = URL(urlString)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"

            val reader = BufferedReader(InputStreamReader(conn.inputStream))
            val response = reader.readLine()
            reader.close()

            Log.d("ServerTaskDelete", "Deleted candy id $id, response: $response")

        } catch (e: Exception) {
            Log.e("ServerTaskDelete", "Error deleting candy id $id")
        }
    }
}
