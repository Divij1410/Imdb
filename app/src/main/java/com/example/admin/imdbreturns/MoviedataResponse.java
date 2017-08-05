package com.example.admin.imdbreturns;

import java.util.ArrayList;

/**
 * Created by ADMIN on 28-Jul-17.
 */

class MoviedataResponse {

    public ArrayList<Moviedata> results;

    public ArrayList<Moviedata> getPopularmovieslist() {
        return results;
    }

    public void setPopularMoviesList(ArrayList<Moviedata> results) {
        this.results = results;
    }
}
