package com.app.dsr.simpplrassignment.useralbum.activities;

import android.content.Intent;
import android.os.Bundle;

import com.app.dsr.simpplrassignment.R;
import com.app.dsr.simpplrassignment.base.BaseNavigationDrawerActivity;
import com.app.dsr.simpplrassignment.network.ApiConstants;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

public class AlbumListActivity extends BaseNavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(ApiConstants.CLIENT_ID, AuthenticationResponse.Type.TOKEN, ApiConstants.REDIRECT_CALLBACK);
        builder.setScopes(new String[]{"user-read-private", "streaming"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, ApiConstants.AUTH_REQUEST_CODE , request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
