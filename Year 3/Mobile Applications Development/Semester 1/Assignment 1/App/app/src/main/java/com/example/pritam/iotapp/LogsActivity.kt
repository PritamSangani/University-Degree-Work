package com.example.pritam.iotapp

import android.graphics.Typeface
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import utils.LogData
import utils.LogDataAdapter
import utils.Utils
import java.io.BufferedInputStream
import java.io.InputStream
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL

class LogsActivity : AppCompatActivity() {
    var username : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)
        username= getString(R.string.username)

        val logsTitle = getString(R.string.logsTitle, username)

        val logsTextView :TextView = findViewById(R.id.logs_title)
        logsTextView.text = logsTitle
        logsTextView.setTypeface(logsTextView.typeface, Typeface.BOLD)

        getAllLogs(R.id.logsList.toString())

    }

    private fun getAllLogs(listViewID : String) {
        val url = String.format("https://iot-mobile-assignment.herokuapp.com/attempt?username=%s", username)
        GetAllLogs().execute(url, listViewID)
    }

    inner class GetAllLogs : AsyncTask<String, Void, ArrayList<LogData>>() {
        var listViewID : String = ""
        val TAG : String = "LogsActivity"
        override fun onPostExecute(result: ArrayList<LogData>) {
            super.onPostExecute(result)
            val listView : ListView = findViewById(Integer.parseInt(listViewID))
            val adapter = LogDataAdapter(this@LogsActivity,result)
            Utils<LogData>().populateListView(listView, adapter)
        }

        override fun doInBackground(vararg params: String): ArrayList<LogData> {
            val urlConnection : HttpURLConnection?
            val inputStream : InputStream
            var logs : ArrayList<LogData> = ArrayList()

            try {
                val url = URL(params[0])
                listViewID = params[1]
                urlConnection = url.openConnection() as HttpURLConnection
                inputStream = BufferedInputStream(urlConnection.inputStream)
                val response : String = convertStreamToString(inputStream)
                val dataType : Type = object : TypeToken<ArrayList<LogData>>() {}.type
                Log.d(TAG, response)
                val json = JSONObject(response)
                val attempts = json.getJSONArray("attempts").toString()
                logs  = Gson().fromJson(attempts, dataType)

            } catch (e: Exception) {
                Log.d(TAG, e.message)
            }
            Log.d(TAG, "SIZE: "+ logs.size.toString())
            return logs
        }



        private fun convertStreamToString(inputStream: BufferedInputStream): String {
            val s = java.util.Scanner(inputStream).useDelimiter("\\A")
            return if (s.hasNext()) s.next() else ""
        }
    }


}
