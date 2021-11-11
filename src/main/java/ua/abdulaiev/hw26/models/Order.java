package ua.abdulaiev.hw26.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int id;

    @JoinColumn(name = "id_customer")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Customer customer;

    @JoinColumn(name = "id_album")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Album album;

    @Column(name = "time")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", album=" + album +
                ", dateTime=" + dateTime +
                '}';
    }
}
