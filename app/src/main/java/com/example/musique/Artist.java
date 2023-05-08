package com.example.musique;

import java.util.ArrayList;

public class Artist {
    String name;
    ArrayList<Album> albums;

    public Artist(String name, ArrayList<Album> albums) {
        this.name = name;
        this.albums = albums;
    }
}
