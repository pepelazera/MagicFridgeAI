package MagicFridgeAI.example.MagicFridgeAI.Repository;

import MagicFridgeAI.example.MagicFridgeAI.Model.FoodItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<Long, FoodItemModel> {


}
