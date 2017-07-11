package com.example.akumar.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akumar on 7/11/2017.
 */

public class StudentModel implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("date_of_birth")
    @Expose
    private String date_of_birth;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("passing_mark")
    @Expose
    private String passing_mark;

    @SerializedName("address")
    @Expose
    private String address;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public String getPassing_mark() {
        return passing_mark;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    @Expose
    private String status;

}
