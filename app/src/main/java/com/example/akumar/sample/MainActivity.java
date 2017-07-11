package com.example.akumar.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUserName = (EditText) findViewById(R.id.userName);
        final EditText editTextPassword = (EditText) findViewById(R.id.password);
        Button btnLogin = (Button) findViewById(R.id.login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserName.getText().toString().equals("") || editTextPassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter credential", Toast.LENGTH_SHORT).show();
                } else {
                    final ApiInterface apiService =
                            RestApiClient.getClient().create(ApiInterface.class);
                    Call<LoginResponse> call = apiService.login(editTextUserName.getText().toString(), editTextPassword.getText().toString());
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                            if (response.isSuccessful()) {
                                if (response.body().getStatus().equals("1")) {
                                    Intent i = new Intent(MainActivity.this, StudentActivity.class);
                                    startActivity(i);

                                } else {
                                    Toast.makeText(getApplicationContext(), "Inavlid Credential", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e("", "Unable to submit post to API.");
                        }
                    });
                }

            }
//            }
        });
    }
}
