package com.example.admin.imdbreturns;

import java.util.ArrayList;

/**
 * Created by ADMIN on 30-Jul-17.
 */class VideoResponse {
    public ArrayList<Videodata> results;

    public ArrayList<Videodata> getVideoslist() {
        return results;
    }

    public void setVideosList(ArrayList<Videodata> results) {
        this.results = results;
    }
}
