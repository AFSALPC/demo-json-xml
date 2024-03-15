package in.upcode.demojsonxml.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Assignment {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer pages;
    
        
    
}
