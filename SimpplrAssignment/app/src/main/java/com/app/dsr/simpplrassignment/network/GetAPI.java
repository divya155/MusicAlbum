package com.app.dsr.simpplrassignment.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAPI {

    @GET("/list")
    Call<Student> getModel();
}
