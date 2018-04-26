package com.app.dsr.simpplrassignment.network.retrofitapi;

import com.app.dsr.simpplrassignment.network.model.Track;
import com.app.dsr.simpplrassignment.network.model.Tracks;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SpoifyTracksApi {

    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId  The Spotify ID for the track.
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    void getTrack(@Path("id") String trackId, Callback<Track> callback);

    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId The Spotify ID for the track.
     * @return Requested track information
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String trackId);

    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId  The Spotify ID for the track.
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-track/">endpoint documentation</a>
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    void getTrack(@Path("id") String trackId, @QueryMap Map<String, Object> options, Callback<Track> callback);

    /**
     * Get Spotify catalog information for a single track identified by their unique Spotify ID.
     *
     * @param trackId The Spotify ID for the track.
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-track/">endpoint documentation</a>
     * @return Requested track information
     * @see <a href="https://developer.spotify.com/web-api/get-track/">Get a Track</a>
     */
    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String trackId, @QueryMap Map<String, Object> options);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    void getTracks(@Query("ids") String trackIds, Callback<Tracks> callback);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    Tracks getTracks(@Query("ids") String trackIds);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-several-tracks/">endpoint documentation</a>
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    void getTracks(@Query("ids") String trackIds, @QueryMap Map<String, Object> options, Callback<Tracks> callback);

    /**
     * Get Several Tracks
     *
     * @param trackIds A comma-separated list of the Spotify IDs for the tracks
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-several-tracks/">endpoint documentation</a>
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-tracks/">Get Several Tracks</a>
     */
    @GET("/tracks")
    Tracks getTracks(@Query("ids") String trackIds, @QueryMap Map<String, Object> options);
}
