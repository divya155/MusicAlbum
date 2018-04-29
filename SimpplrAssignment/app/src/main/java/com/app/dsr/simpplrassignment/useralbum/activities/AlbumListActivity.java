package com.app.dsr.simpplrassignment.useralbum.activities;

import android.os.Bundle;

import com.app.dsr.simpplrassignment.R;
import com.app.dsr.simpplrassignment.base.BaseNavigationDrawerActivity;
import com.app.dsr.simpplrassignment.network.APIClient;
import com.app.dsr.simpplrassignment.network.model.Albums;
import com.app.dsr.simpplrassignment.network.retrofitapi.SpoifyAlbumApi;
import com.app.dsr.simpplrassignment.network.retrofitapi.SpoifyUserApi;

import retrofit2.Call;
import retrofit2.Retrofit;

public class AlbumListActivity extends BaseNavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

    }


}
