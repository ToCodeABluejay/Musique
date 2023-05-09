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
import java.util.HashMap;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.Holder> {
    Context context;
    ArrayList<Artist> artists;


    ArtistAdapter(Context context, ArrayList<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    @NonNull
    @Override
    public ArtistAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_song, parent, false);
        return new ArtistAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistAdapter.Holder holder, int position) {
        holder.name.setText(artists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
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
