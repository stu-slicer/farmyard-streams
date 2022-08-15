package io.nology.music;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of music
 */
public class MusicCollection {

    private List<Artist> artists;

    public MusicCollection() {
        populateCollection();
    }

    public List<Artist> getArtists() {
        return artists;
    }

    private void populateCollection() {

        this.artists = new ArrayList<>();

        Artist xtc = Artist.create(1, "XTC", "UK");
        xtc.addTracks( List.of(
                Track.create(1, "Making Plans for Nigel", StarRating.three, 4.14, xtc ),
                Track.create(2, "Senses Working Overtime", StarRating.five, 4.51, xtc ),
                Track.create(3, "Respectable Street", StarRating.five, 3.18,xtc )
        ) );
        artists.add(xtc);

        Artist queen = Artist.create( 2, "Queen", "UK");
        queen.addTracks( List.of(
                Track.create(4, "Bohemian Rhapsody", StarRating.five, 5.54, queen ),
                Track.create(5, "Don't Stop Me Now", StarRating.three, 3.29, queen ),
                Track.create(6, "Bicycle Race", StarRating.four, 3.03, queen )
        ) );
        artists.add(queen);

        Artist kateBush = Artist.create( 3, "Kate Bush", "UK");
        kateBush.addTracks( List.of(
                Track.create(7, "Running up that Hill", StarRating.four, 5.01, kateBush ),
                Track.create(8, "Hounds of Love", StarRating.five, 3.02, kateBush ),
                Track.create(9, "Wurthering Heights", StarRating.five, 4.30, kateBush ),
                Track.create(10, "Sat in your Lap", StarRating.five, 3.30, kateBush )
        ) );
        artists.add(kateBush);

        Artist lilyAllen = Artist.create( 4, "Lily Allen", "UK");
        lilyAllen.addTracks( List.of(
                Track.create(11, "Smile", StarRating.four, 3.17, lilyAllen ),
                Track.create(12, "LDN", StarRating.four, 3.11, lilyAllen )
        ) );
        artists.add(lilyAllen);

        Artist abba = Artist.create( 5, "ABBA", "Sweden");
        abba.addTracks( List.of(
                Track.create(13, "Waterloo", StarRating.four, 2.46, abba ),
                Track.create(14, "Dancing Queen", StarRating.five, 3.53, abba )
        ) );
        artists.add(abba);

        Artist prince = Artist.create( 6, "Prince", "USA");
        prince.addTracks( List.of(
                Track.create(15, "1999", StarRating.three, 3.38, prince ),
                Track.create(16, "U Got the Look", StarRating.four, 3.48, prince )
        ) );
        artists.add(prince);

        Artist georgeEzra = Artist.create( 7, "George Ezra", "UK");
        georgeEzra.addTracks( List.of(
                Track.create(17, "Budapest", StarRating.four, 3.21, georgeEzra )
        ) );
        artists.add(georgeEzra);

        Artist paulSimon = Artist.create( 8, "Paul Simon", "USA");
        paulSimon.addTracks( List.of(
                Track.create(18, "You Can Call Me Al", StarRating.five, 4.41, paulSimon ),
                Track.create(19, "Graceland", StarRating.four, 4.51, paulSimon )
        ) );
        artists.add(paulSimon);

        Artist sparks = Artist.create( 9, "Sparks", "USA");
        sparks.addTracks( List.of(
                Track.create(20, "This Town Ain't Big Enough for the Both of Us", StarRating.five, 3.07, sparks ),
                Track.create(21, "Beat the Clock", StarRating.four, 4.24, sparks ),
                Track.create(22, "The Number One Song in Heaven", StarRating.three, 7.28, sparks )
        ) );
        artists.add(sparks);

    }

}
