package MagicFridgeAI.example.MagicFridgeAI.Repository;

import MagicFridgeAI.example.MagicFridgeAI.Model.FoodItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemModel, Long> {

}
