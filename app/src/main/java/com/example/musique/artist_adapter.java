package com.example.musique;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
//import android.databinding.DataBindingUtil;
//import android.support.v7.widget.RecyclerView;
import androidx.recyclerview.*;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class artist_adapter extends RecyclerView.Adapter<artist_adapter.ViewHolder> {

    private File[] music;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public artist_adapter(File[] f) {
        music = f;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return music.length;
    }
}
