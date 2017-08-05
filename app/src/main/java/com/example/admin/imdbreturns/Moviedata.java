package com.example.admin.imdbreturns;

/**
 * Created by ADMIN on 27-Jul-17.
 */

public class Moviedata {
    public int id;
    public String title;
    public  String original_language;
    public double vote_average ;
    public String poster_path;
    public String overview;
    public String release_date;
    public Moviedata( String title, double vote_average, String original_language,String poster_path,String overview,String release_date,int id) {
        this.title = title;
        this.original_language = original_language;
        this.vote_average = vote_average;
        this.poster_path=poster_path;
        this.overview=overview;
        this.release_date=release_date;
        this.id=id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
