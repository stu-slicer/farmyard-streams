package io.nology.music;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MusicCollectionChallengeTest {

    private static final String COUNTRY_UK = "UK";
    private static final String COUNTRY_USA = "USA";
    private static final String COUNTRY_SWEDEN = "Sweden";

    private static final Artist XTC = Artist.create( 1, "XTC", COUNTRY_UK);
    private static final Artist QUEEN = Artist.create( 2, "Queen", COUNTRY_UK);
    private static final Artist KATE_BUSH = Artist.create( 3, "Kate Bush", COUNTRY_UK );
    private static final Artist LILY_ALLEN = Artist.create( 4, "Lily Allen", COUNTRY_UK );
    private static final Artist ABBA = Artist.create( 5, "ABBA", COUNTRY_SWEDEN );
    private static final Artist PRINCE = Artist.create( 6, "Prince", COUNTRY_USA );
    private static final Artist GEORGE_EZRA = Artist.create( 7, "George Ezra", COUNTRY_UK);
    private static final Artist PAUL_SIMON = Artist.create( 8, "Paul Simon", COUNTRY_USA );
    private static final Artist SPARKS = Artist.create( 9, "Sparks", COUNTRY_UK);

    private static final Track BICYCLE_RACE = Track.create(6, "Bicycle Race", StarRating.four, 3.03, QUEEN );
    private static final Track BOHEMIAN_RHAP = Track.create(4, "Bohemian Rhapsody", StarRating.five, 5.54, QUEEN );
    private static final Track DANCING_QUEEN = Track.create(14, "Dancing Queen", StarRating.five, 3.53, ABBA );
    private static final Track HOUNDS_OF_LOVE = Track.create(8, "Hounds of Love", StarRating.five, 3.02, KATE_BUSH );
    private static final Track LDN = Track.create(12, "LDN", StarRating.four, 3.11, LILY_ALLEN );
    private static final Track RESPECTABLE_STREET = Track.create(3, "Respectable Street", StarRating.five, 3.18, XTC );
    private static final Track SAT_IN_YOUR_LAP = Track.create(10, "Sat in your Lap", StarRating.five, 3.30, KATE_BUSH );
    private static final Track SENSES_WORKING_OVERTIME = Track.create(2, "Senses Working Overtime", StarRating.five, 4.51, XTC );
    private static final Track THE_NUMBER_ONE_SONG = Track.create(22, "The Number One Song in Heaven", StarRating.three, 7.28, SPARKS );
    private static final Track THIS_TOWN = Track.create(20, "This Town Ain't Big Enough for the Both of Us", StarRating.five, 3.07, SPARKS );
    private static final Track WATERLOO = Track.create(13, "Waterloo", StarRating.four, 2.46, ABBA );
    private static final Track WURTHERING_HEIGHTS = Track.create(9, "Wurthering Heights", StarRating.five, 4.30, KATE_BUSH );
    private static final Track YOU_CAN_CALL = Track.create(18, "You Can Call Me Al", StarRating.five, 4.41, PAUL_SIMON );

    private MusicCollectionChallenge target;

    @BeforeEach
    void setUp() {
        this.target = new MusicCollectionChallenge();
    }

    @Test
    @DisplayName("Get number of artists")
    void getNumberOfArtists() {
        assertEquals(9, target.getNumberOfArtists());
    }

    @Test
    @DisplayName("Get number of tracks")
    void getNumberOfTracks() {
        assertEquals(22, target.getNumberOfTracks());
    }

    @Test
    @DisplayName("Select all artists from the USA")
    void getArtistsFromUSA() {
        assertEquals(List.of( PRINCE, PAUL_SIMON, SPARKS ), target.getArtistsFromUSA());
    }

    @Test
    @DisplayName("Select artist with the least tracks")
    void getArtistWithLeastTracks() {
        assertEquals( GEORGE_EZRA, target.getArtistWithLeastTracks());
    }

    @Test
    @DisplayName("Select artist with the most tracks")
    void getArtistWithMostTracks() {
        assertEquals( KATE_BUSH, target.getArtistWithMostTracks());
    }

    @Test
    @DisplayName("Average length of track across all tracks")
    void getAverageOfAllTracks() {
        assertEquals( 3.87, this.target.getAverageOfAllTracks(), 3);
    }

    @Test
    @DisplayName("Get shortest track")
    void getShortestTrack() {
        assertEquals( WATERLOO, target.getShortestTrack());
    }

    @Test
    @DisplayName("Get 5 shortest tracks")
    void getFiveShortestTracks() {
        List<Track> resultList = List.of( WATERLOO, HOUNDS_OF_LOVE, BICYCLE_RACE, THIS_TOWN, LDN );
        assertEquals( resultList, target.getFiveShortestTracks() );
    }

    @Test
    @DisplayName("Get longest track")
    void getLongestTrack() {
        assertEquals( THE_NUMBER_ONE_SONG, target.getLongestTrack());
    }

    @Test
    @DisplayName("Group artists by their country of origin")
    void getArtistsByCountry() {
        Map<String, List<Artist>> resultMap = Map.ofEntries(
                Map.entry(COUNTRY_UK, List.of(XTC, QUEEN, KATE_BUSH, LILY_ALLEN, GEORGE_EZRA)),
                Map.entry(COUNTRY_SWEDEN, List.of(ABBA)),
                Map.entry(COUNTRY_USA, List.of( PRINCE, PAUL_SIMON, SPARKS))
        );
        assertEquals( resultMap, target.getArtistsByCountry() );
    }

    @Test
    @DisplayName("Average length of track for each artist")
    void getAverageLengthForArtistTracks() {

        Map<Artist, Double> result = target.getAverageLengthForArtistTracks();
//        target.getAverageLengthForArtistTracks().forEach( (k,v) -> System.out.println(k + " " + v) );
        assertAll( "Average length",
                () -> assertEquals( result.get(XTC), 3.94, 3 ),
                () -> assertEquals( result.get(QUEEN), 3.95, 3 ),
                () -> assertEquals( result.get(KATE_BUSH), 3.90, 3 ),
                () -> assertEquals( result.get(LILY_ALLEN), 3.13, 3 ),
                () -> assertEquals( result.get(ABBA), 2.99, 3 ),
                () -> assertEquals( result.get(PRINCE), 3.42, 3 ),
                () -> assertEquals( result.get(GEORGE_EZRA), 3.21, 3 ),
                () -> assertEquals( result.get(PAUL_SIMON), 4.46, 3 ),
                () -> assertEquals( result.get(SPARKS), 4.86, 3 )
                );

    }

    @Test
    @DisplayName("Get all five star tracks")
    void getFiveStarTracks() {
        List<Track> resultList = List.of( BOHEMIAN_RHAP, DANCING_QUEEN, HOUNDS_OF_LOVE, RESPECTABLE_STREET, SAT_IN_YOUR_LAP, SENSES_WORKING_OVERTIME, THIS_TOWN, WURTHERING_HEIGHTS, YOU_CAN_CALL );
        assertEquals( resultList, this.target.getFiveStarTracks() );
    }

    @Test
    @DisplayName("Get artist with the most 5 star tracks")
    void getArtistWithMostFiveStarTracks() {
        assertEquals( KATE_BUSH, this.target.getArtistWithMostFiveStarTracks() );
    }

}