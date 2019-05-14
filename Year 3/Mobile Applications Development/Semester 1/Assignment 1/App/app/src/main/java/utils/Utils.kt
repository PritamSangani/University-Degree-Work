package utils

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView

class Utils<T> {
    fun populateListView(listView : ListView?, adapter : ArrayAdapter<T>?) {
        listView?.adapter = adapter
    }
}