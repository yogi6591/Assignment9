package Assignment9;

import java.util.*;
import java.io.Serializable;
import java.sql.Date;

class Movie implements Serializable{
	private int movieId;
	private String movieName;
	private String movieType;
	private String movieLanguage;
	private String releaseDate;
	private String castingList;
	private float rating;
    private float totalBusinessDone;
    
    
    Movie(int movieId, String movieName, String movieType, String movieLanguage, String releaseDate,
			String castingList, float rating, float totalBusinessDone) {
		super();
		setMovieId(movieId);
		setMovieName(movieName);
		setMovieType(movieType);
		setLanguage(movieLanguage);
		setReleaseDate(releaseDate);
		setCasting(castingList);
		setRating(rating);
		setTotalBusinessDone(totalBusinessDone);
	}

	public int getMovieId() {
		return this.movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return this.movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public String getLanguage() {
		return this.movieLanguage;
	}

	public void setLanguage(String language) {
		this.movieLanguage = language;
	}

	public String getCasting() {
		return this.castingList;
	}

	public void setCasting(String castingList) {
		this.castingList = castingList;
	}

	public float getTotalBusinessDone() {
		return this.totalBusinessDone;
	}

	public void setTotalBusinessDone(float totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieLanguage=" + movieLanguage + ", releaseDate=" + releaseDate + ", castingList=" + castingList
				+ ", rating=" + rating + ", totalBusinessDone=" + totalBusinessDone + "]";
	}
}