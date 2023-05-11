package com.example.musique;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;

import java.util.ArrayList;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.Holder> {
    Context context;
    static ArrayList<Song> songs;
    private final Interface inter;


    SongAdapter(Context context, ArrayList<Song> songs, Interface inter) {
        this.context = context;
        this.songs = songs;
        this.inter = inter;
    }

    @NonNull
    @Override
    public SongAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_song, parent, false);
        return new SongAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.Holder holder, int position) {
        //holder.name.setText(songs.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.song_cover);
            name = itemView.findViewById(R.id.song_name);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    MainActivity.playSong(songs, 0);
                }
            });
        }
    }
}
