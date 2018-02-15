package it.communikein.popularmovies;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Movie {

    public static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    private String originalTitle;
    private String posterThumb;
    private String plotSynopsis;
    private double ratings;
    private Date releaseDate;


    public Movie(String originalTitle, String posterThumb, String plotSynopsis, double ratings, Date releaseDate) {
        this.originalTitle = originalTitle;
        this.posterThumb = posterThumb;
        this.plotSynopsis = plotSynopsis;
        this.ratings = ratings;
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPosterThumbImageName() {
        return posterThumb;
    }

    public String getPosterThumbPath() {
        return "http://image.tmdb.org/t/p/w185" + posterThumb;
    }

    public void setPosterThumb(String posterThumb) {
        this.posterThumb = posterThumb;
    }

    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String printReleaseDate() {
        return dateFormat.format(getReleaseDate());
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public boolean displayEquals(Object obj) {
        if (! (obj instanceof Movie)) return false;

        Movie other = (Movie) obj;
        return this.getPosterThumbImageName().equals(other.getPosterThumbImageName()) &&
                this.getOriginalTitle().equals(other.getOriginalTitle()) &&
                this.getReleaseDate().getTime() == other.getReleaseDate().getTime();
    }
}
