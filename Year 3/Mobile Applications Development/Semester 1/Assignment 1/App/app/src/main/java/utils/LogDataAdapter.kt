package utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.pritam.iotapp.R

class LogDataAdapter(context: Context, list: ArrayList<LogData>) : ArrayAdapter<LogData>(context, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.logs_list_item, parent, false)
        }

        view!!.findViewById<TextView>(R.id.logDateTextView)?.text = getItem(position)!!.attemptDate
        view.findViewById<TextView>(R.id.tagNameTextView)?.text = getItem(position)!!.tagName
        view.findViewById<TextView>(R.id.successTextView)?.text = getItem(position)!!.success

        return view
    }

}