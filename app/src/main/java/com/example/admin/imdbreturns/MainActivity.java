package com.example.admin.imdbreturns;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        ListView listView;
        MyAdapter moviedataArrayAdapter;
        ArrayList<Moviedata>moviedataArrayList;
        ArrayList<String>movienames;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
           Bundle b=getArguments();
            int selectNumber=b.getInt(ARG_SECTION_NUMBER);

                if(selectNumber==1) {
                    listView = (ListView) rootView.findViewById(R.id.listview);
                    listView.setNestedScrollingEnabled(true);
                    moviedataArrayList = new ArrayList<>();
                    movienames = new ArrayList<>();
                    moviedataArrayAdapter = new MyAdapter(getActivity(), moviedataArrayList);
                    listView.setAdapter(moviedataArrayAdapter);
                    fetchCourses();
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent=new Intent(getContext(),DetailActivity.class);
                            intent.putExtra("title",moviedataArrayList.get(i).title);
                            intent.putExtra("rating",Double.toString(moviedataArrayList.get(i).vote_average));
                            intent.putExtra("posterpath",moviedataArrayList.get(i).poster_path);
                            intent.putExtra("overview",moviedataArrayList.get(i).overview);
                            intent.putExtra("language",moviedataArrayList.get(i).original_language);
                            intent.putExtra("releasedate",moviedataArrayList.get(i).release_date);
                            intent.putExtra("id",Integer.toString(moviedataArrayList.get(i).id));
                            startActivity(intent);
                        }
                    });
                }
                if(selectNumber==2){
                    listView = (ListView) rootView.findViewById(R.id.listview);
                    listView.setNestedScrollingEnabled(true);
                    moviedataArrayList = new ArrayList<>();
                    movienames = new ArrayList<>();
                    moviedataArrayAdapter = new MyAdapter(getActivity(), moviedataArrayList);
                    listView.setAdapter(moviedataArrayAdapter);
                    fetchCourses1();
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent=new Intent(getContext(),DetailActivity.class);
                            intent.putExtra("title",moviedataArrayList.get(i).title);
                            intent.putExtra("rating",Double.toString(moviedataArrayList.get(i).vote_average));
                            intent.putExtra("posterpath",moviedataArrayList.get(i).poster_path);
                            intent.putExtra("overview",moviedataArrayList.get(i).overview);
                            intent.putExtra("language",moviedataArrayList.get(i).original_language);
                            intent.putExtra("releasedate",moviedataArrayList.get(i).release_date);
                            intent.putExtra("id",Integer.toString(moviedataArrayList.get(i).id));
                            startActivity(intent);
                        }
                    });

                }
                if(selectNumber==3){
                    listView = (ListView) rootView.findViewById(R.id.listview);
                    listView.setNestedScrollingEnabled(true);
                    moviedataArrayList = new ArrayList<>();
                    movienames = new ArrayList<>();
                    moviedataArrayAdapter = new MyAdapter(getActivity(), moviedataArrayList);
                    listView.setAdapter(moviedataArrayAdapter);
                    fetchCourses();
                }

            return rootView;
        }
        private void fetchCourses() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiInterface apiInterface =  retrofit.create(ApiInterface.class);
            retrofit2.Call<MoviedataResponse> call  =  apiInterface.getPopularmovies();

            // apiInterface.getPost(1, 3);

            call.enqueue(new Callback<MoviedataResponse>() {
                @Override
                public void onResponse(retrofit2.Call<MoviedataResponse> call, Response<MoviedataResponse> response) {
                    MoviedataResponse moviedataResponse =  response.body();
                    ArrayList<Moviedata> movieArrayList = moviedataResponse.getPopularmovieslist();
                    onDownloadComplete(movieArrayList);
                }

                @Override
                public void onFailure(retrofit2.Call<MoviedataResponse> call, Throwable t) {

                }


            });
        }
        private void fetchCourses1() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.themoviedb.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiInterface1 apiInterface =  retrofit.create(ApiInterface1.class);
            retrofit2.Call<MoviedataResponse> call  =  apiInterface.getTopmovies();

            // apiInterface.getPost(1, 3);

            call.enqueue(new Callback<MoviedataResponse>() {
                @Override
                public void onResponse(retrofit2.Call<MoviedataResponse> call, Response<MoviedataResponse> response) {
                    MoviedataResponse moviedataResponse =  response.body();
                    ArrayList<Moviedata> movieArrayList = moviedataResponse.getPopularmovieslist();
                    onDownloadComplete(movieArrayList);
                }

                @Override
                public void onFailure(retrofit2.Call<MoviedataResponse> call, Throwable t) {

                }


            });
        }
        private void onDownloadComplete(ArrayList<Moviedata> movieArrayList) {
            moviedataArrayList.clear();
            moviedataArrayList.addAll(movieArrayList);
            moviedataArrayAdapter.notifyDataSetChanged();
        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "POPULAR MOVIES";
                case 1:
                    return "TOP RATED";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
