package ua.abdulaiev.hw26.models;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer_buying")
public class CustomerBuying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_buying")
    private int id;

    @JoinColumn(name = "id_customer")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "id_album")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Album album;

    @Override
    public String toString() {
        return "CustomerBuying{" +
                "id=" + id +
                ", customer=" + customer +
                ", album=" + album +
                '}';
    }
}