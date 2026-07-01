package app.wine_production.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sugar")
@Builder
public class SugarAddition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double kilograms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private Wine wine;
}
