package in.upcode.demojsonxml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {
@Id
@GeneratedValue
    private int id;
    private String model;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Person owner;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }
}
