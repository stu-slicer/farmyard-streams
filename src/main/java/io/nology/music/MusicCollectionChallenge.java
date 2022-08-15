package io.nology.music;

import java.util.List;
import java.util.Map;

public class MusicCollectionChallenge {

    private MusicCollection musicCollection;
    private List<Artist> artists;

    public MusicCollectionChallenge() {
        this.musicCollection = new MusicCollection();
        this.artists = musicCollection.getArtists();
    }

    /**
     * Select the total number of artists.
     * @return the total number of artists.
     */
    public int getNumberOfArtists() {
        return -1;
    }

    /**
     * Select the total number of tracks.
     * @return the total number of tracks.
     */
    public int getNumberOfTracks() {
        return -1;
    }

    /**
     * Select all artists from the USA
     * @return a {@link List} of all artists from USA.
     */
    public List<Artist> getArtistsFromUSA() {
        return null;

    }

    /**
     * Select the {@link Artist} with the least number of tracks.
     * @return the {@link Artist} with the least number of tracks
     */
    public Artist getArtistWithLeastTracks() {
        return null;
    }

    /**
     * Select the {@link Artist} with the most number of tracks.
     * @return the {@link Artist} with the most number of tracks
     */
    public Artist getArtistWithMostTracks() {
        return null;
    }

    /**
     * Calculate the average length of all tracks across all artists.
     * @return the average length of all tracks
     */
    public double getAverageOfAllTracks() {
        return -1D;
    }

    /**
     * Select the {@link Track} with the shortest length.
     * @return the {@link Track} with the shortest length.
     */
    public Track getShortestTrack() {
        return null;
    }

    /**
     * Select the five shortest tracks, ordered shortest first.
     * @return a {@link List} of the five shortest tracks.
     */
    public List<Track> getFiveShortestTracks() {
        return null;
    }

    /**
     * Select the {@link Track} with the longest length.
     * @return the {@link Track} with the longest length.
     */
    public Track getLongestTrack() {
        return null;
    }

    /**
     * Group the artists by their country of origin.
     * @return a {@link Map} keyed by country of origin with a value of a {@link List} of artists from that country.
     */
    public Map<String, List<Artist>> getArtistsByCountry() {
        return null;
    }

    /**
     * For eact {@link Artist} calculate the average length of their tracks and return as a {@link Map}.
     * @return a {@link Map} keyed by {@link Artist} with a value of the average length of their tracks.
     */
    public Map<Artist, Double> getAverageLengthForArtistTracks() {
        return null;
    }

    /**
     * Select all tracks rated as 5 star.
     * @return a {@link List} of tracks with a rating of 5 stars, ordered by {@link Track} title.
     */
    public List<Track> getFiveStarTracks() {
        return null;
    }

    /**
     * Selects the {@link Artist} with the most 5 star rated tracks.
     * @return the {@link Artist} with the most 5 star rated tracks.
     */
    public Artist getArtistWithMostFiveStarTracks() {
        return null;
    }

}
