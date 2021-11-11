package ua.abdulaiev.hw26.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "id_customer_buying")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerBuying customerBuying;

    @JoinColumn(name = "id_order")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Order order;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
