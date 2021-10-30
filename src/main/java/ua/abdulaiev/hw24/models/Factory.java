package ua.abdulaiev.hw24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factory_id")
    private int id;
    private String names;
    private String countries;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryId", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Device> deviceSet;

    public Factory(String names, String countries) {
        this.names = names;
        this.countries = countries;
        deviceSet = new HashSet<>();
    }
}
