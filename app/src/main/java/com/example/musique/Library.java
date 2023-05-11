package com.example.musique;

import java.util.ArrayList;
import java.util.HashMap;
import android.net.Uri;
import android.provider.MediaStore;
import android.database.Cursor;
import android.app.Activity;
import android.content.ContentUris;

public class Library {
    HashMap<String, Artist> artists;
    //ArrayList<Artist> artists_l;
    HashMap<String, Album> albums;
    //ArrayList<Album> albums_l;
    ArrayList<Song> songs;
    Song current;
    int count;

    Library(Activity activity) {
        Uri allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Cursor cursor = activity.managedQuery(allsongsuri, null, selection, null, null);
        this.artists = new HashMap<String, Artist>();
        this.albums = new HashMap<String, Album>();
        this.songs = new ArrayList<Song>();

        count = cursor.getCount();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Song s;
                    String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    Long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                    Uri cover_art = Uri.parse("content://media/external/audio/albumart");
                    Uri image = ContentUris.withAppendedId(cover_art, id);

                    s = new Song(artist, album, name, path, image);
                    songs.add(s);

                    Album a;
                    Artist b;
                    if ((a=albums.get(s.getAlbum()))==null) {
                        ArrayList<Song> k = new ArrayList<Song>();
                        k.add(s);
                        a = new Album(s.getAlbum(), k);
                        albums.put(s.getAlbum(), (a=new Album(s.getAlbum(), k)));
                        //albums_l.add(a);
                    }
                    else {
                        a.songs.add(s);
                    }
                    if ((b=artists.get(s.getArtist()))==null) {
                        ArrayList<Album> k = new ArrayList<Album>();
                        k.add(a);
                        artists.put(s.getArtist(), (b=new Artist(s.getArtist(), k)));
                        //artists_l.add(b);
                    }
                    else if (!b.albums.contains(a)) {
                        b.albums.add(a);
                    }
                    Progress.updateProgress(cursor.getPosition(), count);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        MainActivity.initPlayer();
    }
    public HashMap<String, Artist> getArtists() {
        return artists;
    }

    public HashMap<String, Album> getAlbums() {
        return albums;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
