package com.example.studentdetails;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Singleton class to initiate the Volley Library - runs when app starts as defined in Android Manifest File
 */
public class MySingleton {

    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private MySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mInstance == null)
            mInstance = new MySingleton(context);

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null)
            //instantiate RequestQueue with Application Context NOT Activity Context
            //This is so RequestQueue doesn't recreate every time the Activity is recreated
            //e.g. device is rotated.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
