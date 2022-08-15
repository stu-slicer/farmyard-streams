package io.nology.music;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MusicCollectionSolution {

    private MusicCollection musicCollection;
    private List<Artist> artists;

    public MusicCollectionSolution() {
        this.musicCollection = new MusicCollection();
        this.artists = musicCollection.getArtists();
    }

    /**
     * Select the total number of artists.
     * @return the total number of artists.
     */
    public int getNumberOfArtists() {
        return (int) this.artists.stream()
                .count();
    }

    /**
     * Select the total number of tracks.
     * @return the total number of tracks.
     */
    public int getNumberOfTracks() {
        return this.artists.stream()
                .mapToInt( artists -> artists.getTracks().size() )
                .sum();
    }

    /**
     * Select all artists from the USA
     * @return a {@link List} of all artists from USA.
     */
    public List<Artist> getArtistsFromUSA() {
        return this.artists.stream()
                .filter( artist -> artist.getCountryOfOrigin().equals("USA"))
                .collect(Collectors.toList());

    }

    /**
     * Select the {@link Artist} with the least number of tracks.
     * @return the {@link Artist} with the least number of tracks
     */
    public Artist getArtistWithLeastTracks() {
        Optional<Artist> firstArtist = this.artists.stream()
                .sorted((a, b) -> a.getTracks().size() - b.getTracks().size())
                .findFirst();
        return firstArtist.orElse(null);
    }

    /**
     * Select the {@link Artist} with the most number of tracks.
     * @return the {@link Artist} with the most number of tracks
     */
    public Artist getArtistWithMostTracks() {
        Optional<Artist> firstArtist = this.artists.stream()
                .sorted((a, b) -> b.getTracks().size() - a.getTracks().size())
                .findFirst();
        return firstArtist.orElse(null);
    }

    /**
     * Calculate the average length of all tracks across all artists.
     * @return the average length of all tracks
     */
    public double getAverageOfAllTracks() {
        OptionalDouble result = this.artists.stream()
                .flatMap(artist -> artist.getTracks().stream())
                .mapToDouble(artists -> artists.getLength())
                .average();
        return result.orElse(0.0);
    }

    /**
     * Select the {@link Track} with the shortest length.
     * @return the {@link Track} with the shortest length.
     */
    public Track getShortestTrack() {
        Optional<Track> firstTrack = this.artists.stream()
                .flatMap(artist -> artist.getTracks().stream())
                .sorted((a, b) -> Double.compare(a.getLength(), b.getLength()))
                .findFirst();
        return firstTrack.orElse(null);
    }

    /**
     * Select the five shortest tracks, ordered shortest first.
     * @return a {@link List} of the five shortest tracks.
     */
    public List<Track> getFiveShortestTracks() {
        return this.artists.stream()
                .flatMap(artist -> artist.getTracks().stream())
                .sorted((a, b) -> Double.compare(a.getLength(), b.getLength()))
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * Select the {@link Track} with the longest length.
     * @return the {@link Track} with the longest length.
     */
    public Track getLongestTrack() {
        Optional<Track> firstTrack = this.artists.stream()
                .flatMap(artist -> artist.getTracks().stream())
                .sorted((a, b) -> Double.compare(b.getLength(), a.getLength()))
                .findFirst();
        return firstTrack.orElse(null);
    }

    /**
     * Group the artists by their country of origin.
     * @return a {@link Map} keyed by country of origin with a value of a {@link List} of artists from that country.
     */
    public Map<String, List<Artist>> getArtistsByCountry() {
        return this.artists.stream()
                .collect( Collectors.groupingBy( artist -> artist.getCountryOfOrigin() ));
    }

    /**
     * For eact {@link Artist} calculate the average length of their tracks and return as a {@link Map}.
     * @return a {@link Map} keyed by {@link Artist} with a value of the average length of their tracks.
     */
    public Map<Artist, Double> getAverageLengthForArtistTracks() {
        return this.artists.stream()
                .flatMap( artist -> artist.getTracks().stream())
                .collect( Collectors.groupingBy( track -> track.getArtist(),
                        Collectors.averagingDouble( track -> track.getLength() ) ) );
    }

    /**
     * Select all tracks rated as 5 star.
     * @return a {@link List} of tracks with a rating of 5 stars, ordered by {@link Track} title.
     */
    public List<Track> getFiveStarTracks() {
        return this.artists.stream()
                .flatMap( artist -> artist.getTracks().stream())
                .filter( artist -> artist.getRating() == StarRating.five )
                .sorted( (a,b) -> a.getTitle().compareTo( b.getTitle() ))
                .collect(Collectors.toList());
    }

    /**
     * Selects the {@link Artist} with the most 5 star rated tracks.
     * @return the {@link Artist} with the most 5 star rated tracks.
     */
    public Artist getArtistWithMostFiveStarTracks() {
        Map<Artist, Long> resultMap = this.artists.stream()
                .flatMap(artist -> artist.getTracks().stream())
                .filter(track -> track.getRating() == StarRating.five)
                .collect(Collectors.groupingBy(track -> track.getArtist(), Collectors.counting()));

        Optional<Map.Entry<Artist, Long>> resultEntry = resultMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().intValue() - a.getValue().intValue())
                .findFirst();
        return resultEntry.get().getKey();
    }

}
