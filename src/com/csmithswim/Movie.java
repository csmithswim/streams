package com.csmithswim;

public class Movie implements Comparable<Movie> {
    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }
    public int getLikes() {
        return likes;
    }
    public Genre getGenre() {
        return genre;
    }

    //This method determines how they will be sorted, if you want to sort by different parameters
    //i.e. by number of likes or release date, you use the comparator interface
    @Override
    public int compareTo(Movie o) {
        return 0;
    }


}
