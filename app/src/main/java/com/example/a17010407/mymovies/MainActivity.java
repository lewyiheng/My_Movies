package com.example.a17010407.mymovies;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        alMovie = new ArrayList<>();

        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.set(2014,1,15);
        d2.set(2015,5,15);

        Movie movie1 = new Movie("The avengers","2012","PG13",4,"Action | Sci-Fi",d1,"Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movie movie2 = new Movie("Planes","2013","pg",2,"Animation | Comedy",d2,"Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovie.add(movie1);
        alMovie.add(movie2);

        caMovie = new CustomAdapter(this,R.layout.movielist,alMovie);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inMoviedetails = new Intent(getBaseContext(),MovieDetails.class);
                Movie movie = alMovie.get(position);
                inMoviedetails.putExtra("title",movie.message());
                startActivity(inMoviedetails);
            }
        });

    }

}



