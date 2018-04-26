package com.app.dsr.simpplrassignment.network.retrofitapi;

import com.app.dsr.simpplrassignment.network.model.Album;
import com.app.dsr.simpplrassignment.network.model.Artist;
import com.app.dsr.simpplrassignment.network.model.Artists;
import com.app.dsr.simpplrassignment.network.model.Pager;
import com.app.dsr.simpplrassignment.network.model.Tracks;

import java.util.Map;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface SpoifyArtistApi {

    /**
     * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
     *
     * @param artistId The Spotify ID for the artist.
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-artist/">Get an Artist</a>
     */
    @GET("/artists/{id}")
    void getArtist(@Path("id") String artistId, Callback<Artist> callback);

    /**
     * Get Spotify catalog information for a single artist identified by their unique Spotify ID.
     *
     * @param artistId The Spotify ID for the artist.
     * @return Requested artist information
     * @see <a href="https://developer.spotify.com/web-api/get-artist/">Get an Artist</a>
     */
    @GET("/artists/{id}")
    Artist getArtist(@Path("id") String artistId);

    /**
     * Get Spotify catalog information for several artists based on their Spotify IDs.
     *
     * @param artistIds A comma-separated list of the Spotify IDs for the artists
     * @param callback  Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-several-artists/">Get Several Artists</a>
     */
    @GET("/artists")
    void getArtists(@Query("ids") String artistIds, Callback<Artists> callback);

    /**
     * Get Spotify catalog information for several artists based on their Spotify IDs.
     *
     * @param artistIds A comma-separated list of the Spotify IDs for the artists
     * @return An object whose key is "artists" and whose value is an array of artist objects.
     * @see <a href="https://developer.spotify.com/web-api/get-several-artists/">Get Several Artists</a>
     */
    @GET("/artists")
    Artists getArtists(@Query("ids") String artistIds);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String artistId, Callback<Pager<Album>> callback);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @return An array of simplified album objects wrapped in a paging object.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String artistId);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-artists-albums/">endpoint documentation</a>
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String artistId, @QueryMap Map<String, Object> options, Callback<Pager<Album>> callback);

    /**
     * Get Spotify catalog information about an artist’s albums.
     *
     * @param artistId The Spotify ID for the artist.
     * @param options  Optional parameters. For list of supported parameters see
     *                 <a href="https://developer.spotify.com/web-api/get-artists-albums/">endpoint documentation</a>
     * @return An array of simplified album objects wrapped in a paging object.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-albums/">Get an Artist's Albums</a>
     */
    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String artistId, @QueryMap Map<String, Object> options);

    /**
     * Get Spotify catalog information about an artist’s top tracks by country.
     *
     * @param artistId The Spotify ID for the artist.
     * @param country  The country: an ISO 3166-1 alpha-2 country code.
     * @param callback Callback method
     * @see <a href="https://developer.spotify.com/web-api/get-artists-top-tracks/">Get an Artist’s Top Tracks</a>
     */
    @GET("/artists/{id}/top-tracks")
    void getArtistTopTrack(@Path("id") String artistId, @Query("country") String country, Callback<Tracks> callback);

    /**
     * Get Spotify catalog information about an artist’s top tracks by country.
     *
     * @param artistId The Spotify ID for the artist.
     * @param country  The country: an ISO 3166-1 alpha-2 country code.
     * @return An object whose key is "tracks" and whose value is an array of track objects.
     * @see <a href="https://developer.spotify.com/web-api/get-artists-top-tracks/">Get an Artist’s Top Tracks</a>
     */
    @GET("/artists/{id}/top-tracks")
    Tracks getArtistTopTrack(@Path("id") String artistId, @Query("country") String country);

    /**
     * Get Spotify catalog information about artists similar to a given artist.
     *
     * @param artistId The Spotify ID for the artist.
     * @param callback Callback method.
     * @see <a href="https://developer.spotify.com/web-api/get-related-artists/">Get an Artist’s Related Artists</a>
     */
    @GET("/artists/{id}/related-artists")
    void getRelatedArtists(@Path("id") String artistId, Callback<Artists> callback);

    /**
     * Get Spotify catalog information about artists similar to a given artist.
     *
     * @param artistId The Spotify ID for the artist.
     * @return An object whose key is "artists" and whose value is an array of artist objects.
     * @see <a href="https://developer.spotify.com/web-api/get-related-artists/">Get an Artist’s Related Artists</a>
     */
    @GET("/artists/{id}/related-artists")
    Artists getRelatedArtists(@Path("id") String artistId);

}
