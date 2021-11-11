package ua.abdulaiev.hw26.dao;

import org.hibernate.cache.spi.support.RegionNameQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.abdulaiev.hw26.models.Artist;
import ua.abdulaiev.hw26.enums.ArtistNames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ArtistDaoTest {
    private static ArtistDao ARTIST_DAO;
    Artist artist1;
    Artist artist2;

    @BeforeAll
    static void beforeAll() {
        ARTIST_DAO = new ArtistDao();
    }

    @BeforeEach
    void setUp() {
        artist1 = new Artist();
        artist2 = new Artist();
    }

    @Test
    void saveArtist() {
        ARTIST_DAO.saveArtist(artist1);
        Assertions.assertEquals(artist1, ARTIST_DAO.getById(1));
    }

    @Test
    void updateArtist() {
        Random random = new Random();
        ARTIST_DAO.saveArtist(artist1);
        artist1.setName(ArtistNames.values()[random.nextInt(ArtistNames.values().length)]);
        ARTIST_DAO.updateArtist(artist1);
        Assertions.assertEquals(artist1, ARTIST_DAO.getById(1));
    }

    @Test
    void deleteArtist() {
        ARTIST_DAO.saveArtist(artist1);
        ARTIST_DAO.deleteArtist(1);
        Assertions.assertEquals(0, ARTIST_DAO.getAllArtist().size());
    }

    @Test
    void getArtist() {
        ARTIST_DAO.saveArtist(artist1);
        Assertions.assertEquals(artist1, ARTIST_DAO.getById(1));
    }

    @Test
    void getAllArtist() {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist1);
        artistList.add(artist2);
        ARTIST_DAO.saveArtist(artist1);
        ARTIST_DAO.saveArtist(artist2);
        Assertions.assertEquals(artistList, ARTIST_DAO.getAllArtist());
    }
}