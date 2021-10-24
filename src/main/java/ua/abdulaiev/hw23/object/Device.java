package ua.abdulaiev.hw23.object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Device {
    private final int id_device;
    private final ModelType type;
    private final String deviceModel;
    private final int price;
    private final Date date;
    private final String description;
    private boolean stockAvailability;
    private int factoryId;

}
