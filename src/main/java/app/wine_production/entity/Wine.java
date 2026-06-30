package app.wine_production.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "wine")
@Builder
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "type")
    private String wineType;

    @Column(nullable = false)
    private ArrayList<String> fruits = new ArrayList<>();

    
}
