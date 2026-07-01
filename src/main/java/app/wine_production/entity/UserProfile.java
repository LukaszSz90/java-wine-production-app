package app.wine_production.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile")
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
@ToString(exclude = "user")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    private User user;

    @OneToMany(mappedBy = "userProfile",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wine> producedWines = new ArrayList<>();

}
