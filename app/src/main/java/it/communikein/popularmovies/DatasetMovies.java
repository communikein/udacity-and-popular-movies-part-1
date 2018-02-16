package it.communikein.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DatasetMovies implements Parcelable {

    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    private List<Movie> results;

    public DatasetMovies(Parcel in) {
        setPage(in.readInt());
        setTotalResults(in.readInt());
        setTotalPages(in.readInt());
        setResults(new ArrayList<>());
        in.readTypedList(results, Movie.CREATOR);
    }

    public DatasetMovies(int page, int totalResults, int totalPages, List<Movie> results) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getPage());
        dest.writeInt(getTotalResults());
        dest.writeInt(getTotalPages());
        dest.writeTypedList(getResults());
    }

    static final Parcelable.Creator<DatasetMovies> CREATOR = new Parcelable.Creator<DatasetMovies>() {

        public DatasetMovies createFromParcel(Parcel in) {
            return new DatasetMovies(in);
        }

        public DatasetMovies[] newArray(int size) {
            return new DatasetMovies[size];
        }
    };
}
