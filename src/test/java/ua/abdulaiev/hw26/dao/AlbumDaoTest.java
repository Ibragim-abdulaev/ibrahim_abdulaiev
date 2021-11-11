package ua.abdulaiev.hw26.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.abdulaiev.hw26.Task;
import ua.abdulaiev.hw26.models.Album;

import java.util.ArrayList;
import java.util.List;

class AlbumDaoTest {
    private static AlbumDao ALBUM_DAO;
    private static Task TASK;
    Album album1;
    Album album2;

    @BeforeAll
    static void beforeAll() {
        ALBUM_DAO = new AlbumDao();
    }

    @BeforeEach
    void setUp() {
        album1 = new Album();
        album2 = new Album();
    }

    @Test
    void saveAlbum() {
        ALBUM_DAO.save(album1);
        Assertions.assertEquals(album1, ALBUM_DAO.getById(1));
    }

    @Test
    void updateAlbum() {
        ALBUM_DAO.save(album1);
        album1.setPrice(1000.123);
        ALBUM_DAO.update(album1);
        Assertions.assertEquals(album1, ALBUM_DAO.getById(1));
    }

    @Test
    void deleteAlbum() {
        ALBUM_DAO.save(album1);
        ALBUM_DAO.delete(1);
        Assertions.assertEquals(0, ALBUM_DAO.getAllAlbum().size());
    }

    @Test
    void getById() {
        ALBUM_DAO.save(album1);
        Assertions.assertEquals(album1, ALBUM_DAO.getById(1));
    }

    @Test
    void getAllAlbum() {
        List<Album> customerList = new ArrayList<>();
        customerList.add(album1);
        customerList.add(album2);
        ALBUM_DAO.save(album1);
        ALBUM_DAO.save(album2);
        Assertions.assertEquals(customerList, ALBUM_DAO.getAllAlbum());
    }

    @Test
    void saveRandom() {
        int countBeforeSave = ALBUM_DAO.getAllAlbum().size();
        TASK.saveRandom(10);
        Assertions.assertEquals(countBeforeSave + 10, ALBUM_DAO.getAllAlbum().size());
    }
}