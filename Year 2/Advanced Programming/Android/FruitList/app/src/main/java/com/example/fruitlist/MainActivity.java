package com.example.fruitlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] fruit = {"apple", "banana", "strawberry", "raspberry", "orange", "pineapple", "avocado", "cherry", "jackfruit", "grapefruit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView fruitListView = findViewById(R.id.ContactListView);

        // an array adapter to do all the hard work just tell it the (context, the layout, and the data)
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fruit);
        //set the adapter to the listview
        fruitListView.setAdapter(arrayAdapter);

    }
}
