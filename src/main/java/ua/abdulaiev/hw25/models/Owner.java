package ua.abdulaiev.hw25.models;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_owner")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Owner(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
