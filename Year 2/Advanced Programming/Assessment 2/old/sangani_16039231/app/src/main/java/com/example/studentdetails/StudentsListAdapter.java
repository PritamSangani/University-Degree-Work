package com.example.studentdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsListAdapter extends RecyclerView.Adapter<StudentsListAdapter.MyViewHolder> {
    private static final String TAG = "StudentsListAdapter";
    private ArrayList<Student> mDataSet;
    Context mContext;
    ItemClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, email;
        //public RelativeLayout viewBackground, viewForeground;

        public MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            email = view.findViewById(R.id.email);
            //viewBackground = view.findViewById(R.id.);
            //viewForeground = view.findViewById(R.id.item_foreground);
        }

        public void bind(final Student stu, final ItemClickListener listener) {
            name.setText(stu.getName());
            email.setText(stu.getEmail());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(stu);
                }
            });
        }
    }

    public StudentsListAdapter(Context mContext, ArrayList<Student> studentArrayList, ItemClickListener listener) {
        this.mContext = mContext;
        mDataSet = studentArrayList;
        this.listener = listener;
    }

    @Override
    public StudentsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentsListAdapter.MyViewHolder holder, int position) {
        Log.d(TAG, "Element "+position+" set.");
        holder.bind(mDataSet.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
