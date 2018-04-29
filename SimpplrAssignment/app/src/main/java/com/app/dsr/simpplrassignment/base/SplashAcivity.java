package com.app.dsr.simpplrassignment.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.dsr.simpplrassignment.R;
import com.app.dsr.simpplrassignment.network.APIClient;
import com.app.dsr.simpplrassignment.network.model.Albums;
import com.app.dsr.simpplrassignment.network.model.Playlist;
import com.app.dsr.simpplrassignment.network.model.UserPrivate;
import com.app.dsr.simpplrassignment.network.retrofitapi.SpoifyAlbumApi;
import com.app.dsr.simpplrassignment.network.retrofitapi.SpoifyUserApi;
import com.app.dsr.simpplrassignment.useralbum.activities.AlbumListActivity;
import com.app.dsr.simpplrassignment.utils.ApiConstants;
import com.app.dsr.simpplrassignment.utils.AppConstants;
import com.app.dsr.simpplrassignment.utils.SharedPrefUtils;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.util.HashSet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acivity);

            AuthenticationRequest.Builder builder = new AuthenticationRequest.Builder(ApiConstants.CLIENT_ID, AuthenticationResponse.Type.TOKEN, ApiConstants.REDIRECT_CALLBACK);
            builder.setScopes(new String[]{"user-read-private", "streaming"});
            AuthenticationRequest request = builder.build();

            AuthenticationClient.openLoginActivity(this, ApiConstants.AUTH_REQUEST_CODE, request);
    }

    private void fetchUserData() {
        Retrofit retrofit = APIClient.getClient();

        SpoifyUserApi objectService = retrofit.create(SpoifyUserApi.class);
        Call<UserPrivate> call = objectService.getMe("nullvoidinfinity");
        call.enqueue(new Callback<UserPrivate>() {
            @Override
            public void onResponse(Call<UserPrivate> call, Response<UserPrivate> response) {
                Log.d("SPOT::","url= \n"+call.request().url()+"\n\n");
                Log.d("SPOT::","raw= \n"+response.raw()+"\n\n");
                if (response != null){
                    UserPrivate user = response.body();
                    if (user!=null){
                        Log.d("SPOT::","user= \n"+user);
                        SharedPrefUtils.setUserPrivateSharedPreference(SplashAcivity.this,user);
                        fetchUserAlubums();
                        return;
                    }

                }
                findViewById(R.id.prgressBar).setVisibility(View.GONE);
                ((TextView)findViewById(R.id.tvErrorMessage)).setText("User Null");
            }

            @Override
            public void onFailure(Call<UserPrivate> call, Throwable t) {
                findViewById(R.id.prgressBar).setVisibility(View.GONE);
                Log.d("SPOT::","error= \n"+t.getMessage());
                ((TextView)findViewById(R.id.tvErrorMessage)).setText("Error: "+t.getMessage());
            }
        });
    }

    private void fetchUserAlubums(){
        Retrofit retrofit = APIClient.getClient();

        SpoifyAlbumApi objectService = retrofit.create(SpoifyAlbumApi.class);
        Call<Playlist> call = objectService.getUserAlbum("nullvoidinfinity","10","5");
        call.enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                Log.d("SPOT::","url= \n"+call.request().url()+"\n\n");
                Log.d("SPOT::","raw= \n"+response.raw()+"\n\n");
                findViewById(R.id.prgressBar).setVisibility(View.GONE);
                if (response != null){
                    Playlist user = response.body();
                    if (user!=null){
                        Log.d("SPOT::","user= \n"+user);
                        onAlbumsFetched();
                        return;
                    }

                }
                ((TextView)findViewById(R.id.tvErrorMessage)).setText("User Null");
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {
                findViewById(R.id.prgressBar).setVisibility(View.GONE);
                Log.d("SPOT::","error= \n"+t.getMessage());
                ((TextView)findViewById(R.id.tvErrorMessage)).setText("Error: "+t.getMessage());
            }
        });

    }
    private void onAlbumsFetched(){
        launchAlbumActivity();
    }

    private void launchAlbumActivity() {
        Intent albumIntent = new Intent(this, AlbumListActivity.class);
        startActivity(albumIntent);
        finish();
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
                SharedPrefUtils.setStringSharedPreference(this,AppConstants.SharedPrefernce.KEY_USER_AUTH_TOKEN,accessToken);
                fetchUserData();
                Log.d("SPOT::","accessToken= "+accessToken+"\nexpiresIn= "+expiresIn+"\ncode= "+code+"state= "+state);
            }
        }
    }
}
