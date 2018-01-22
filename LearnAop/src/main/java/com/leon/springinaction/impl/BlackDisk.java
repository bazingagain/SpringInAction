package com.leon.springinaction.impl;

import com.leon.springinaction.CompactDisc;

import java.util.List;

/**
 * Created on 21/01/2018.
 *
 * @author Xiaolei-Peng
 */
public class BlackDisk implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void playTrack(int trackNumber) {

    }
}
