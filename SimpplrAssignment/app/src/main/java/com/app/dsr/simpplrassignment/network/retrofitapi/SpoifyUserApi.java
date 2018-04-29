package com.app.dsr.simpplrassignment.network.retrofitapi;

import com.app.dsr.simpplrassignment.network.model.UserPrivate;
import com.app.dsr.simpplrassignment.network.model.UserPublic;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpoifyUserApi {
    /**
     * Get the currently logged in user profile information.
     * The contents of the User object may differ depending on application's scope.
     *
     * @see <a href="https://developer.spotify.com/web-api/get-current-users-profile/">Get Current User's Profile</a>
     */
    @GET("users/{user_id}")
    Call<UserPrivate> getMe(@Path("user_id") String userID);

    /**
     * Get the currently logged in user profile information.
     * The contents of the User object may differ depending on application's scope.
     *
     * @return The current user
     * @see <a href="https://developer.spotify.com/web-api/get-current-users-profile/">Get Current User's Profile</a>
     */
//    @GET("/me")
//    UserPrivate getMe();

    /**
     * Get a user's profile information.
     *
     * @param userId   The user's User ID
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-users-profile/">Get User's Public Profile</a>
     */
    @GET("/users/{id}")
    void getUser(@Path("id") String userId, Callback<UserPublic> callback);

    /**
     * Get a user's profile information.
     *
     * @param userId The user's User ID
     * @return The user's profile information.
     * @see <a href="https://developer.spotify.com/web-api/get-users-profile/">Get User's Public Profile</a>
     */
    @GET("/users/{id}")
    UserPublic getUser(@Path("id") String userId);

}
