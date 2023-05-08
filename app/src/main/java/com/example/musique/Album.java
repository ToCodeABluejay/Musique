package com.example.musique;

import java.util.ArrayList;

public class Album {
    String name;
    ArrayList<Song> songs;

    public Album(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
