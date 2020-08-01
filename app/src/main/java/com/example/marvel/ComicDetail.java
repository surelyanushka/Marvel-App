package com.example.marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static com.example.marvel.CharDisplay.EXTRA_DESC;
import static com.example.marvel.CharDisplay.EXTRA_IMG;
import static com.example.marvel.CharDisplay.EXTRA_NAME;
import static com.example.marvel.ComicDisplay.EXTRA_PG;

public class ComicDetail extends AppCompatActivity {

    Button buy;
    String confirmation = "Visit gateway.marvel.com for details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        Intent intent = getIntent();
        String Desc = intent.getStringExtra(EXTRA_DESC);
        String Name = intent.getStringExtra(EXTRA_NAME);
        String img = intent.getStringExtra(EXTRA_IMG);
        String pgcount = intent.getStringExtra(EXTRA_PG);

        ImageView imageView = findViewById(R.id.img_comic);
        TextView textViewName = findViewById(R.id.name_comic);
        TextView textViewDesc = findViewById(R.id.desc_comic);
        TextView textViewPgcount = findViewById(R.id.pg_comic);

        Picasso.get().load(img).into(imageView);
        textViewDesc.setText(Desc);
        textViewName.setText(Name);
        textViewPgcount.setText(pgcount);

        buy = findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), confirmation, Toast.LENGTH_LONG).show();
            }
        });
    }
}