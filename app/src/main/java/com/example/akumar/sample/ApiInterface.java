package com.example.akumar.sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by akumar on 7/11/2017.
 */


public interface ApiInterface {

    @FormUrlEncoded
    @POST("login_arr.php")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @GET("get_all_student.php")
    Call<List<StudentModel>> getStudentDetails();
}

