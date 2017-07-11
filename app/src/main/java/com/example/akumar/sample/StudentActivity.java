package com.example.akumar.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akumar on 7/11/2017.
 */

public class StudentActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        final ApiInterface apiService =
                RestApiClient.getClient().create(ApiInterface.class);
        Call<List<StudentModel>> call = apiService.getStudentDetails();
        call.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                if (response.isSuccessful()) {
                    recyclerView.setAdapter(new StudentAdapter(response, R.layout.list_row, StudentActivity.this));
                    Log.e("", "Unable to submit post to API.");
                }
            }

            @Override
            public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                Log.e("", "Unable to submit post to API.");
            }
        });
    }


}
