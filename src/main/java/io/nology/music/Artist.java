package io.nology.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artist {

    private int id;
    private String name;
    private String countryOfOrigin;
    private List<Track> tracks = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Artist addTrack(Track track) {
        this.tracks.add(track);
        return this;
    }

    public Artist addTracks(List<Track> tracks) {
        this.tracks.addAll(tracks);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Artist[");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", countryOfOrigin='").append(countryOfOrigin).append('\'');
        sb.append(", tracks=").append(tracks.size());
        sb.append(']');
        return sb.toString();
    }

    public static Artist create(int id, String name, String countryOfOrigin) {
        Artist artist = new Artist();
        artist.setId(id);
        artist.setName(name);
        artist.setCountryOfOrigin(countryOfOrigin);
        return artist;
    }

    public static Artist create(int id, String name, String countryOfOrigin, List<Track> tracks) {
        Artist artist = create(id, name, countryOfOrigin);
        if (!tracks.isEmpty()) {
            artist.setTracks( new ArrayList<>(tracks) );
        }
        return artist;
    }

}
