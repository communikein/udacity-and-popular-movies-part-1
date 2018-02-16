package it.communikein.popularmovies.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import it.communikein.popularmovies.DatasetMovies;
import it.communikein.popularmovies.Movie;

public class JsonParseUtils {

    public static String getJsonFromMoviesDataset(DatasetMovies datasetMovies) {
        Gson gson = new Gson();

        Type type = new TypeToken<DatasetMovies>(){}.getType();
        return gson.toJson(datasetMovies, type);
    }

    public static DatasetMovies getMoviesDatasetFromJson(String json) {
        Gson gson = new Gson();

        Type type = new TypeToken<DatasetMovies>(){}.getType();
        return gson.fromJson(json, type);
    }

    public static DatasetMovies getMoviesFromJson(String json) {
        Gson gson = new Gson();

        Type type = new TypeToken<DatasetMovies>(){}.getType();
        return gson.fromJson(json, type);
    }

}
