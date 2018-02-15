package it.communikein.popularmovies.network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String API_BASE_URL = "https://api.themoviedb.org/3/movie";
    private static final String API_KEY_PARAM = "?api_key=";

    private static final String URL_POPULAR_MOVIE = API_BASE_URL + "/popular" + API_KEY_PARAM +
            ApiKeyUtils.API_KEY;
    private static final String URL_TOP_RATED_MOVIE = API_BASE_URL + "/top_rated" + API_KEY_PARAM +
            ApiKeyUtils.API_KEY;


    public static URL getTopRatedMoviesUrl() {
        return buildUrl(false);
    }

    public static URL getPopularMoviesUrl() {
        return buildUrl(true);
    }

    private static URL buildUrl(boolean popular) {
        try {
            URL url;
            if (popular)
                url = new URL(URL_POPULAR_MOVIE);
            else
                url = new URL(URL_TOP_RATED_MOVIE);

            return url;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            String response = null;
            if (hasInput) {
                response = scanner.next();
            }
            scanner.close();
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }
}
