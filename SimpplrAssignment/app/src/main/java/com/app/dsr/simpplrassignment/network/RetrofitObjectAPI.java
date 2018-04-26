package com.app.dsr.simpplrassignment.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitObjectAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/RetrofitAndroidObjectResponse")
    Call<Student> getStudentDetails();
}
