package ua.abdulaiev.hw24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private int id;
    private String type;
    private String model;
    private Double price;
    private Date createDate;
    private String descriptions;
    private boolean stockAvailabilities;
    @ManyToOne
    @JoinColumn(name = "fc_id")
    private Factory factoryId;

    public Device(String type, String model, Double price, String createDate,
                  String descriptions, Factory factoryId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.type = type;
        this.model = model;
        this.price = price;
        Date date = null;
        try {
            date = format.parse(createDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        this.createDate = date;
        this.descriptions = descriptions;
        this.factoryId = factoryId;
    }
}
