package com.example.akumar.sample;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by akumar on 7/11/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private int rowLayout;
    FragmentActivity activity;
    Response<List<StudentModel>> studentResponse;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;
        LinearLayout parentLayout;

        public ViewHolder(View v) {
            super(v);
            studentName = (TextView) v.findViewById(R.id.studentName);
            parentLayout = (LinearLayout) v.findViewById(R.id.parentLayout);
        }

    }

    public StudentAdapter(Response<List<StudentModel>> studentResponse, int rowLayout, FragmentActivity activity) {
        this.studentResponse = studentResponse;
        this.rowLayout = rowLayout;
        this.activity = activity;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        holder.studentName.setText(studentResponse.body().get(position).getName());


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentModel studentModel = studentResponse.body().get(position);
                Intent i = new Intent(activity, StudentDetail.class);
                i.putExtra("studentDetail", studentModel);
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentResponse.body().size();
    }


}
