package com.example.marvel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.model.CharImage;
import com.example.marvel.model.CharacterFile;
import com.example.marvel.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharDisplay extends AppCompatActivity implements CharAdapter.OnItemClickListener {

    public static  final String EXTRA_DESC = "Desc";
    public static  final String EXTRA_NAME = "Name";
    public static  final String EXTRA_IMG = "image";
    public static  final String EXTRA_AVB = "available";


    ApiInterface placeHolderAPI;
    TextView textView;

    private CharAdapter charAdapter;
    private RecyclerView rvcharacters;
    private RecyclerView.LayoutManager mLayoutManager;
    final int TS = 1;
    final String API_Key = "b14e1f60f4249d5f64ea428ddfdf1dc3";
    final String HASH = "70912f9f478ea4f3bf334ef9b8c7099c";
   private ArrayList<CharItemList> list ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_display);
        list = new ArrayList<>();

        rvcharacters = findViewById(R.id.char_recycler);
        rvcharacters.setHasFixedSize(true);
        rvcharacters.setLayoutManager(new GridLayoutManager(this, 2));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        placeHolderAPI = retrofit.create(ApiInterface.class);

        parseJson();
    }


    private void parseJson(){
        Call<CharacterFile> call = placeHolderAPI.loadCharacters(1, "b14e1f60f4249d5f64ea428ddfdf1dc3", "70912f9f478ea4f3bf334ef9b8c7099c");
        call.enqueue(new Callback<CharacterFile>() {
            @Override
            public void onResponse(Call<CharacterFile> call, Response<CharacterFile> response) {

                if (!response.isSuccessful()) {
                    String x = String.valueOf(response.code());
//                    Toast.makeText(CharDisplay.this,x, Toast.LENGTH_SHORT).show();
                    Log.i("HELLLO", x);
                } else {
                    String Desc = "";
                    String Name = "";
                    String image = "";
                    String available = "";
                    Result[] characters = response.body().getData().getResults();

                    for (Result character : characters) {
                        Desc = character.getDescription();
                        Name = character.getName();
                        available = character.getComics().getAvailable();


                        CharImage img = character.getThumbnail();
                        image = img.getPath() + "." + img.getExtension();
//                        Log.i("works",image);


                        list.add(new CharItemList( Name, image, Desc, available));
//                        images.add(image);
                    }

                    charAdapter = new CharAdapter(CharDisplay.this, list);
                    rvcharacters.setAdapter(charAdapter);
                    charAdapter.setOnItemClickListener(CharDisplay.this);
                }
            }

            @Override
            public void onFailure(Call<CharacterFile> call, Throwable t) {
                Toast.makeText(CharDisplay.this,"Check your internet connection", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, CharDetail.class);
        CharItemList clickedItem = list.get(position);

       intent.putExtra(EXTRA_DESC, clickedItem.getTextViewDesc() );
        intent.putExtra(EXTRA_NAME, clickedItem.getTextViewName());
        intent.putExtra(EXTRA_IMG, clickedItem.getImgId());
        intent.putExtra(EXTRA_AVB, clickedItem.getPgavail());

        startActivity(intent);
    }
}