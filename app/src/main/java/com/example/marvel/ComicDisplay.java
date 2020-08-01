package com.example.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.comicmodels.ComicFile;
import com.example.marvel.comicmodels.ComicImage;
import com.example.marvel.comicmodels.ComicResult;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComicDisplay extends AppCompatActivity implements CharAdapter.OnItemClickListener{

    public static  final String EXTRA_DESC = "Desc";
    public static  final String EXTRA_NAME = "Name";
    public static  final String EXTRA_IMG = "image";
    public static  final String EXTRA_PG = "pgcount";

    ApiInterface placeHolderAPI;
    TextView textView;

    private CharAdapter charAdapter;
    private RecyclerView rvcharacters;
    private RecyclerView.LayoutManager mLayoutManager;
    final int TS = 1;
    final String API_Key = "b14e1f60f4249d5f64ea428ddfdf1dc3";
    final String HASH = "70912f9f478ea4f3bf334ef9b8c7099c";

    private ArrayList<CharItemList> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_display);
        list = new ArrayList<>();

        rvcharacters = findViewById(R.id.char_recycler);
        rvcharacters.setHasFixedSize(true);
        rvcharacters.setLayoutManager(new GridLayoutManager(this,2));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        placeHolderAPI = retrofit.create(ApiInterface.class);

        parseJSON();
    }

    private void parseJSON(){
        Call<ComicFile> call = placeHolderAPI.loadComics(1, "b14e1f60f4249d5f64ea428ddfdf1dc3", "70912f9f478ea4f3bf334ef9b8c7099c");
        call.enqueue(new Callback<ComicFile>() {
            @Override
            public void onResponse(Call<ComicFile> call, Response<ComicFile> response) {

                if (!response.isSuccessful()) {
                    String x = String.valueOf(response.code());
                    Log.i("HELLLO", x);
                } else {
                    String Desc = "";
                    String Name = "";
                    String image = "";
                    String pgcount = "";
                    ComicResult[] comics = response.body().getData().getComicResults();

                    for (ComicResult comic : comics) {
                        Desc = comic.getComicdescription();
                        Name = comic.getComictitle();
                        pgcount = comic.getPgcount();

                        ComicImage img = comic.getComicthumbnail();
                        image = img.getPath()+ "." + img.getExtension();
                        Desc = comic.getComicdescription();
//                        Log.i("works",image);


                        list.add(new CharItemList( Name, image, Desc, pgcount));

                    }

                    charAdapter = new CharAdapter(ComicDisplay.this, list);
                    rvcharacters.setAdapter(charAdapter);
                    charAdapter.setOnItemClickListener(ComicDisplay.this);
                }
            }

            @Override
            public void onFailure(Call<ComicFile> call, Throwable t) {
                Toast.makeText(ComicDisplay.this,"Check your internet connection", Toast.LENGTH_SHORT).show();
                           }

        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, ComicDetail.class);
        CharItemList clickedItem = list.get(position);

        intent.putExtra(EXTRA_DESC, clickedItem.getTextViewDesc());
        intent.putExtra(EXTRA_NAME, clickedItem.getTextViewName());
        intent.putExtra(EXTRA_IMG, clickedItem.getImgId());
        intent.putExtra(EXTRA_PG, clickedItem.getPgavail());

        startActivity(intent);
    }
}