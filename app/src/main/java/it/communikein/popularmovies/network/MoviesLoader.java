package it.communikein.popularmovies.network;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import it.communikein.popularmovies.DatasetMovies;
import it.communikein.popularmovies.Movie;
import it.communikein.popularmovies.utilities.JsonParseUtils;

public class MoviesLoader extends AsyncTaskLoader<DatasetMovies> {

    private static final String TAG = MoviesLoader.class.getSimpleName();

    // Weak references will still allow the Context to be garbage-collected
    private final WeakReference<Activity> mActivity;
    private final boolean mPopular;
    private final int mPage;

    private MoviesLoader(Activity activity, boolean popular, int page) {
        super(activity);

        this.mActivity = new WeakReference<>(activity);
        this.mPopular = popular;
        this.mPage = page;
    }

    public static MoviesLoader createPopularMoviesLoader(Activity activity, int page) {
        return new MoviesLoader(activity, true, page);
    }

    public static MoviesLoader createTopRatedMoviesLoader(Activity activity, int page) {
        return new MoviesLoader(activity, false, page);
    }

    @Override
    public DatasetMovies loadInBackground() {
        Activity context = mActivity.get();
        if (context == null) return null;

        try {
            URL url = NetworkUtils.getMoviesUrl(mPopular, mPage);
            if (url == null)
                return null;

            Bundle response = NetworkUtils.getResponseFromHttpUrl(url);
            if (response.containsKey(NetworkUtils.KEY_DATA))
                return JsonParseUtils.getMoviesFromJson(response.getString(NetworkUtils.KEY_DATA));
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

}
