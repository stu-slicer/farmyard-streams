package io.nology.music;

import java.util.Objects;

public class Track {

    private int id;
    private String title;
    private StarRating rating;
    private double length;
    private Artist artist;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StarRating getRating() {
        return rating;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Track{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }

    public static Track create(int id, String title, StarRating rating, double length) {
        Track track = new Track();
        track.setId(id);
        track.setTitle(title);
        track.setRating(rating);
        track.setLength(length);
        return track;
    }

    public static Track create(int id, String title, StarRating rating, double length, Artist artist) {
        Track track = new Track();
        track.setId(id);
        track.setTitle(title);
        track.setRating(rating);
        track.setLength(length);
        track.setArtist(artist);
        return track;
    }

}
