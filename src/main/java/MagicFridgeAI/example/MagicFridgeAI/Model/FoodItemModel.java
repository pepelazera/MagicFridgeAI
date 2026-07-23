package MagicFridgeAI.example.MagicFridgeAI.Model;

import MagicFridgeAI.example.MagicFridgeAI.Enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "food_item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 155, name = "category")
    private Category category;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "validate")
    private LocalDate validate;

}
