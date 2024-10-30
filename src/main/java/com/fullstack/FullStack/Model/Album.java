package com.fullstack.FullStack.Model;

public class Album {

    String artist;
    String album_title;
    String track;
    String track_duration;
    int release_year;
    String record_company;


    public Album(){

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTrack_duration() {
        return track_duration;
    }

    public void setTrack_duration(String track_duration) {
        this.track_duration = track_duration;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getRecord_company() {
        return record_company;
    }

    public void setRecord_company(String record_company) {
        this.record_company = record_company;
    }



}
