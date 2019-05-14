package com.example.studentdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<Student> studentsArrayList = new ArrayList<>();
    RecyclerView studentsList;
    StudentsListAdapter adapter;

    private final String TAG = "MainActivity";
    private final String API_KEY = "31d1b82668";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studentsList = findViewById(R.id.recyclerView);

        adapter = new StudentsListAdapter(this, studentsArrayList, new ItemClickListener() {
            @Override
            public void onItemClick(Student stu) {
                int position = studentsArrayList.indexOf(stu);

                Log.d(TAG, "Item Clicked: "+ position + " Student: "+ stu.getName());
                Toast.makeText(getApplicationContext(), "You selected " + stu.getName(), Toast.LENGTH_LONG).show();
                goToStudentDetailsActivity(position);
            }
        });

        getAllStudents();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        studentsList.setLayoutManager(mLayoutManager);
        studentsList.setItemAnimator(new DefaultItemAnimator());
        studentsList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        studentsList.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void getAllStudents() {
        String URL = "http://radikaldesign.co.uk/sandbox/studentapi/getallstudents.php?apikey="+API_KEY;
        final JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL, null,  new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response == null) {
                    Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Please try again.", Toast.LENGTH_LONG).show();
                    return;
                }

                ArrayList<Student>tempStudentsList = new Gson().fromJson(response.toString(), new TypeToken<ArrayList<Student>>(){}.getType());

                Log.d(TAG, "ArrayList size -> "+tempStudentsList.size());
                studentsArrayList.clear();
                studentsArrayList.addAll(tempStudentsList);
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error List: " + error.getMessage() + " " );
                Toast.makeText(getApplicationContext(), "Error List: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton.getInstance(this).addToRequestQueue(request);
    }

    public void goToStudentDetailsActivity(int position) {
        Intent intent = new Intent(getApplicationContext(), StudentDetailsActivity.class);
        intent.putExtra("student", studentsArrayList.get(position));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
