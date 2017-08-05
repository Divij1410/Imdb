package com.example.admin.imdbreturns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ADMIN on 29-Jul-17.
 */

public class DetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    ArrayList<Videodata>videosarraylist;
    Context context;
    String id;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent i=getIntent();
        final String name=i.getStringExtra("title");
        String language1=i.getStringExtra("language");
        String overview1=i.getStringExtra("overview");
        String releasedate1=i.getStringExtra("releasedate");
        String rating1=i.getStringExtra("rating");
        String image=i.getStringExtra("posterpath");
        TextView nametext=(TextView)findViewById(R.id.detailtitle);
        TextView nametext1=(TextView)findViewById(R.id.textView3);
        TextView overviewtext=(TextView)findViewById(R.id.detailoverview);
        TextView releasetext=(TextView)findViewById(R.id.detailreleasedate);
        TextView ratingtext=(TextView)findViewById(R.id.detailrating);
        TextView languagetext=(TextView)findViewById(R.id.detaillanguage);
        ImageView imagev=(ImageView)findViewById(R.id.imageView2);
        id=i.getStringExtra("id");
        nametext.setText(name);
        nametext1.setText(name);
        overviewtext.setText(overview1);
        releasetext.setText(releasedate1);
        ratingtext.setText(rating1);
        languagetext.setText(language1);
        videosarraylist=new ArrayList<>();
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300/"+image).into(imagev);
        fetchCourses2();






    }
    private void fetchCourses2() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface2 apiInterface =  retrofit.create(ApiInterface2.class);
        Call<VideoResponse> call  =  apiInterface.getvideos(id);

        // apiInterface.getPost(1, 3);

        call.enqueue(new Callback<VideoResponse>() {
            @Override
            public void onResponse(Call<VideoResponse> call, Response<VideoResponse> response) {
                VideoResponse moviedataResponse =  response.body();
                ArrayList<Videodata> videoArrayList = moviedataResponse.getVideoslist();
                onDownloadComplete1(videoArrayList);
            }

            @Override
            public void onFailure(Call<VideoResponse> call, Throwable t) {

            }




        });
    }
    private void onDownloadComplete1(ArrayList<Videodata> videoArrayList) {
        videosarraylist.clear();
        videosarraylist.addAll(videoArrayList);
        Log.i("tag",videoArrayList.get(0).key);
        YouTubePlayerView youTubePlayerView=(YouTubePlayerView)findViewById(R.id.youtubeplayer);
        youTubePlayerView.initialize("AIzaSyDO5fVL3ixURxPI_wTy58RNqHTe76XahSk",this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);

        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        RadioButton radioButton=(RadioButton)findViewById(R.id.t1) ;
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayer.cueVideo(videosarraylist.get(0).key);
            }
        });
        RadioButton radioButton1=(RadioButton)findViewById(R.id.t2);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayer.cueVideo(videosarraylist.get(1).key);
            }
        });

    }
    private PlayerStateChangeListener playerStateChangeListener=new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(ErrorReason errorReason) {

        }
    };
    private PlaybackEventListener playbackEventListener=new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
