package com.app.dsr.simpplrassignment.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetrofitArrayAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Student>> getStudentDetails();

}
