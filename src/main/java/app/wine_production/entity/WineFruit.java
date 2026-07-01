package app.wine_production.entity;

import app.wine_production.entity.enums.FruitType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "fruit")
@Builder
public class WineFruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType fruitType;

    private Double kilograms;

    @ManyToOne
    @JoinColumn(name = "wine_id", nullable = false)
    private Wine wine;
}
