package com.example.musique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.Holder> {
    Context context;
    ArrayList<Album> albums;


    AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public AlbumAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_song, parent, false);
        return new AlbumAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.Holder holder, int position) {
        holder.name.setText(albums.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            cover = itemView.findViewById(R.id.song_cover);
            name = itemView.findViewById(R.id.song_name);
        }
    }
}
