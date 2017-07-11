package com.example.akumar.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akumar on 7/11/2017.
 */

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("fullname")
    @Expose
    private String fullname;

    @SerializedName("email_id")
    @Expose
    private String email_id;

    @SerializedName("mobile_no")
    @Expose
    private String mobile_no;

    @SerializedName("is_verified")
    @Expose
    private String is_verified;


    @SerializedName("verify_by")
    @Expose
    private String verify_by;


    public String getStatus() {
        return status;
    }


}
