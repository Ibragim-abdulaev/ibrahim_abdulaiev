package ua.abdulaiev.hw26;

import ua.abdulaiev.hw26.dao.AlbumDao;
import ua.abdulaiev.hw26.dao.CustomerDao;
import ua.abdulaiev.hw26.enums.AlbumNames;
import ua.abdulaiev.hw26.enums.ArtistNames;
import ua.abdulaiev.hw26.enums.Tracks;
import ua.abdulaiev.hw26.models.Album;
import ua.abdulaiev.hw26.models.Artist;
import ua.abdulaiev.hw26.models.Customer;
import ua.abdulaiev.hw26.models.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Task {
    public static final AlbumDao ALBUM_DAO = new AlbumDao();
    public static final CustomerDao CUSTOMER_DAO = new CustomerDao();

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        saveRandom(15);
        for (int i = 1; i <= 7; i++) {
            Customer customer = new Customer("Customer" + i);
            CUSTOMER_DAO.saveCustomer(customer);
            orderList.add(CUSTOMER_DAO.buyRandomAlbum(customer));
        }
        orderList.forEach(System.out::println);
    }

    public static void saveRandom(int count) {
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            List<Tracks> tracksList = new ArrayList<>();
            for (int j = 0; j < ThreadLocalRandom.current().nextInt(1, Tracks.values().length); j++) {
                tracksList.add(Tracks.values()[random.nextInt(Tracks.values().length)]);
            }
            Artist artist = new Artist();
            artist.setName(ArtistNames.values()[random.nextInt(ArtistNames.values().length)]);
            Album album = new Album();
            album.setName(AlbumNames.values()[random.nextInt(AlbumNames.values().length)]);
            album.setPrice(random.nextDouble() + 10);
            album.setListTrack(tracksList);
            album.setArtist(artist);
            artist.setAlbum(album);
            ALBUM_DAO.save(album);
        }
    }
}
