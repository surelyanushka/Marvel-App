package com.example.marvel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.ViewHolder> {
    private ArrayList<CharItemList> cList;
//    public static List<CharItemList> items = new ArrayList<>();
   // public static List<String> newimages = new ArrayList<>();
    private Context contx;
    //listener for interface
    private OnItemClickListener clistener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        clistener = listener;
    }

    public CharAdapter( Context contx, ArrayList<CharItemList> list) {
        cList = list;
        this.contx = contx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.char_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

//        items = CharDisplay.getCharItemList();
//        CharItemList x = items.get(1);

//        newimages = CharDisplay.getImages();

        final CharItemList item = cList.get(position);
        holder.textViewName.setText(item.getTextViewName());
//        holder.textViewDesc.setText(item.getTextViewDesc());
        Picasso.get().load(item.getImgId()).into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return cList.size();
    }

//    public RecyclerViewClickListener listener;
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public ImageView imageView;
        public ImageView img_char;
        public TextView textViewDesc;
//        public RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageView = itemView.findViewById(R.id.imageView);
            img_char = itemView.findViewById(R.id.img_comic);
            textViewDesc = itemView.findViewById(R.id.desc_comic);
//            recyclerView = itemView.findViewById(R.id.char_recycler);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clistener != null){
                        int position = getAdapterPosition();
                        //check for validity
                        if (position != RecyclerView.NO_POSITION){
                            clistener.onItemClick(position);
                        }
                    }
                }
            });
        }


    }
}