package ua.abdulaiev.hw26.models;

import lombok.*;
import ua.abdulaiev.hw26.enums.ArtistNames;

import javax.persistence.*;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artist")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private ArtistNames name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Album album;

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
