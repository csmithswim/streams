package com.csmithswim;

public class Movie implements Comparable<Movie> {
    private String title;
    private int likes;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
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

    //This method determines how they will be sorted, if you want to sort by different parameters
    //i.e. by number of likes or release date, you use the comparator interface
    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
