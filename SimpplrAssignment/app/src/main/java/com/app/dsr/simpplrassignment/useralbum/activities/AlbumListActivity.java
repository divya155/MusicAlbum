package com.app.dsr.simpplrassignment.useralbum.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Config;
import android.util.Log;

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
        // Check if result comes from the correct activity
        // The next 19 lines of the code are what you need to copy & paste! :)
        if (requestCode == ApiConstants.AUTH_REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, data);
            Log.d("SPOT::","type= "+response.getType());
            if (response.getType() == AuthenticationResponse.Type.TOKEN) {
                String accessToken = response.getAccessToken();
                int expiresIn = response.getExpiresIn();
                String code = response.getCode();
                String state = response.getState();
                Log.d("SPOT::","accessToken= "+accessToken+"\nexpiresIn= "+expiresIn+"\ncode= "+code+"state= "+state);
//                Config playerConfig = new Config(this, response.getAccessToken(), ApiConstants.CLIENT_ID);
//                Spotify.getPlayer(playerConfig, this, new SpotifyPlayer.InitializationObserver() {
//                    @Override
//                    public void onInitialized(SpotifyPlayer spotifyPlayer) {
//                        mPlayer = spotifyPlayer;
//                        mPlayer.addConnectionStateCallback(MainActivity.this);
//                        mPlayer.addNotificationCallback(MainActivity.this);
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        Log.e("MainActivity", "Could not initialize player: " + throwable.getMessage());
//                    }
//                });
            }
        }
    }
}
