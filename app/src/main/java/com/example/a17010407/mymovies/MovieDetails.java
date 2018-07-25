package com.example.a17010407.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetails extends AppCompatActivity {

    ImageView pic;
    TextView title;
    TextView timer;
    TextView desc;
    RatingBar rates;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviedetails);

        pic = findViewById(R.id.imageView);
        title = findViewById(R.id.textViewTitle);
        timer = findViewById(R.id.textViewDate);
        desc = findViewById(R.id.description);
        rates = findViewById(R.id.rating);

        Intent inReceive = getIntent();
        String title = inReceive.getStringExtra("title");
        String date = inReceive.getStringExtra("date");
        String rated = inReceive.getStringExtra("rate");
        int stars = inReceive.getIntExtra("stars",0);
        String genre = inReceive.getStringExtra("genre");
        String desc = inReceive.getStringExtra("desc");
        String watch = inReceive.getStringExtra("watch");
        String theatre = inReceive.getStringExtra("cinema");

        if ("pg13".equals(rated)) {
            pic.setImageResource(R.drawable.rating_pg13);
        }
        else if ("pg".equals(rated)){
            pic.setImageResource(R.drawable.rating_pg);
        }
        else if ("r21".equals(rated)){
            pic.setImageResource(R.drawable.rating_r21);
        }
        else if ("nc16".equals(rated)){
            pic.setImageResource(R.drawable.rating_nc16);
        }
        else if ("m18".equals(rated)){
            pic.setImageResource(R.drawable.rating_m18);
        }
        else {
            pic.setImageResource(R.drawable.rating_g);
        }
        rates.setRating(stars);

    }
}
