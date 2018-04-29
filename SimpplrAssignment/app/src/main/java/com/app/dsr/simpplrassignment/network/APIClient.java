package com.app.dsr.simpplrassignment.network;

import com.app.dsr.simpplrassignment.base.App;
import com.app.dsr.simpplrassignment.utils.AppConstants;
import com.app.dsr.simpplrassignment.utils.SharedPrefUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://api.spotify.com/v1/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("appName", "com.app.dsr.simpplrassignment")
                            .addHeader("platform", "android")
                            .addHeader("appVersion", "1.0")
                            .addHeader("Authorization", "Bearer " +SharedPrefUtils.getStringSharedPreference(App.getAppContext(), AppConstants.SharedPrefernce.KEY_USER_AUTH_TOKEN,""))
                            .addHeader("Secret", "adac91996b604f158cae7777f49d42a3")
                            .addHeader("Content-Type","application/json")
                            .addHeader("Accept","application/json")
                            .build();

                    return chain.proceed(newRequest);
                }
            }).build();


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();


        }

        return retrofit;
    }

}
