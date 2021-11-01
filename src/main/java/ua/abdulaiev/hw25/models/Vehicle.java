package ua.abdulaiev.hw25.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate manufactureDate;

    @Column(name = "price")
    private Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "tyres_type")
    private TyresType tyresType;

    @Column(name = "date_service")
    private LocalDate serviceDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_owner")
    private Owner owner;

    public Vehicle(String name, Owner owner, LocalDate manufactureDate, Integer price,
                   TyresType tyresType, LocalDate serviceDate) {
        this.name = name;
        this.owner = owner;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.tyresType = tyresType;
        this.serviceDate = serviceDate;
    }
}
