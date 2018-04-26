package com.app.dsr.simpplrassignment.network.retrofitapi;

import com.app.dsr.simpplrassignment.network.model.CategoriesPager;
import com.app.dsr.simpplrassignment.network.model.Category;
import com.app.dsr.simpplrassignment.network.model.FeaturedPlaylists;
import com.app.dsr.simpplrassignment.network.model.NewReleases;
import com.app.dsr.simpplrassignment.network.model.PlaylistsPager;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface SpotifyBrowseApi {

    /**
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">Get a List of Featured Playlists</a>
     */
    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(Callback<FeaturedPlaylists> callback);

    /**
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @return A FeaturedPlaylists object with the featured playlists
     * @see <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">Get a List of Featured Playlists</a>
     */
    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists();

    /**
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">endpoint documentation</a>
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">Get a List of Featured Playlists</a>
     */
    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(@QueryMap Map<String, Object> options, Callback<FeaturedPlaylists> callback);

    /**
     * Get a list of Spotify featured playlists (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">endpoint documentation</a>
     * @return n FeaturedPlaylists object with the featured playlists
     * @see <a href="https://developer.spotify.com/web-api/get-list-featured-playlists/">Get a List of Featured Playlists</a>
     */
    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists(@QueryMap Map<String, Object> options);

    /**
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-list-new-releases/">Get a List of New Releases</a>
     */
    @GET("/browse/new-releases")
    void getNewReleases(Callback<NewReleases> callback);

    /**
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @return A NewReleases object with the new album releases
     * @see <a href="https://developer.spotify.com/web-api/get-list-new-releases/">Get a List of New Releases</a>
     */
    @GET("/browse/new-releases")
    NewReleases getNewReleases();

    /**
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-list-new-releases/">endpoint documentation</a>
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-list-new-releases/">Get a List of New Releases</a>
     */
    @GET("/browse/new-releases")
    void getNewReleases(@QueryMap Map<String, Object> options, Callback<NewReleases> callback);

    /**
     * Get a list of new album releases featured in Spotify (shown, for example, on a Spotify player’s “Browse” tab).
     *
     * @param options Optional parameters. For list of supported parameters see
     *                <a href="https://developer.spotify.com/web-api/get-list-new-releases/">endpoint documentation</a>
     * @return A NewReleases object with the new album releases
     * @see <a href="https://developer.spotify.com/web-api/get-list-new-releases/">Get a List of New Releases</a>
     */
    @GET("/browse/new-releases")
    NewReleases getNewReleases(@QueryMap Map<String, Object> options);

    /**
     * Retrieve Spotify categories. Categories used to tag items in
     * Spotify (on, for example, the Spotify player’s “Browse” tab).
     *
     * @param options  Optional parameters.
     * @param callback Callback method.
     * @see <a href="https://developer.spotify.com/web-api/get-list-categories/">Get a List of Categories</a>
     */
    @GET("/browse/categories")
    void getCategories(@QueryMap Map<String, Object> options, Callback<CategoriesPager> callback);

    /**
     * Retrieve Spotify categories. Categories used to tag items in
     * Spotify (on, for example, the Spotify player’s “Browse” tab).
     *
     * @param options Optional parameters.
     * @return A paging object containing categories.
     * @see <a href="https://developer.spotify.com/web-api/get-list-categories/">Get a List of Categories</a>
     */
    @GET("/browse/categories")
    CategoriesPager getCategories(@QueryMap Map<String, Object> options);

    /**
     * Retrieve a Spotify category.
     *
     * @param categoryId The category's ID.
     * @param options    Optional parameters.
     * @param callback   Callback method.
     * @see <a href="https://developer.spotify.com/web-api/get-category/">Get a Spotify Category</a>
     */
    @GET("/browse/categories/{category_id}")
    void getCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options, Callback<Category> callback);

    /**
     * Retrieve a Spotify category.
     *
     * @param categoryId The category's ID.
     * @param options    Optional parameters.
     * @return A Spotify category.
     * @see <a href="https://developer.spotify.com/web-api/get-category/">Get a Spotify Category</a>
     */
    @GET("/browse/categories/{category_id}")
    Category getCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options);

    /**
     * Retrieve playlists for a Spotify Category.
     *
     * @param categoryId The category's ID.
     * @param options    Optional parameters.
     * @param callback   Callback method.
     * @see <a href="https://developer.spotify.com/web-api/get-categorys-playlists/">Get playlists for a Spotify Category</a>
     */
    @GET("/browse/categories/{category_id}/playlists")
    void getPlaylistsForCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options, Callback<PlaylistsPager> callback);

    /**
     * Retrieve playlists for a Spotify Category.
     *
     * @param categoryId The category's ID.
     * @param options    Optional parameters.
     * @return Playlists for a Spotify Category.
     * @see <a href="https://developer.spotify.com/web-api/get-categorys-playlists/">Get playlists for a Spotify Category</a>
     */
    @GET("/browse/categories/{category_id}/playlists")
    PlaylistsPager getPlaylistsForCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options);

}
