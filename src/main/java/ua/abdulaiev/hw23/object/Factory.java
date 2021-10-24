package ua.abdulaiev.hw23.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class Factory {
    private final int id_factory;
    private final String name;
    private final String country;
}
