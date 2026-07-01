package app.wine_production.entity;

import app.wine_production.entity.enums.Sweetness;
import app.wine_production.entity.enums.WineKind;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private WineKind wineKind;

    @Enumerated(EnumType.STRING)
    private Sweetness sweetness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yeast_id")
    private Yeast yeast;

    @Column(name = "yeast_nutrient")
    private boolean yeastNutrient;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SugarAddition> sugarAdditions;

    @OneToMany(mappedBy = "wine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WineFruit> fruits = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    @Column(name = "is_public")
    private boolean isPublic = false;

}
