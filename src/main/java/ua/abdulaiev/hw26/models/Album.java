package ua.abdulaiev.hw26.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import ua.abdulaiev.hw26.enums.AlbumNames;
import ua.abdulaiev.hw26.enums.Tracks;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private AlbumNames name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Tracks.class)
    private List<Tracks> listTrack;

    @JoinColumn(name = "artist_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Artist artist;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    private CustomerBuying customerBuying;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "album")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id && name == album.name &&
                Objects.equals(price, album.price) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(customerBuying, album.customerBuying) &&
                Objects.equals(order, album.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, artist, customerBuying, order);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", price=" + price +
                ", tracksList=" + listTrack +
                '}';
    }
}