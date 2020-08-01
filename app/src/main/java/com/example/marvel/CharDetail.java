package com.example.marvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.marvel.CharDisplay.EXTRA_AVB;
import static com.example.marvel.CharDisplay.EXTRA_DESC;
import static com.example.marvel.CharDisplay.EXTRA_IMG;
import static com.example.marvel.CharDisplay.EXTRA_NAME;

public class CharDetail extends AppCompatActivity {

//    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_detail);

//        description = findViewById(R.id.desc_comic);

        Intent intent = getIntent();
        String Desc = intent.getStringExtra(EXTRA_DESC);
        String Name = intent.getStringExtra(EXTRA_NAME);
        String img = intent.getStringExtra(EXTRA_IMG);
        String available = intent.getStringExtra(EXTRA_AVB);

        ImageView imageView = findViewById(R.id.img_char);
        TextView textViewName = findViewById(R.id.name_char);
        TextView textViewDesc = findViewById(R.id.desc_char);
        TextView textViewavb = findViewById(R.id.available_char);

        Picasso.get().load(img).into(imageView);
        textViewDesc.setText(Desc);
        textViewName.setText(Name);
        textViewavb.setText(available);
    }

}