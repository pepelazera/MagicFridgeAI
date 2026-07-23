package MagicFridgeAI.example.MagicFridgeAI.Service;

import MagicFridgeAI.example.MagicFridgeAI.Model.FoodItemModel;
import MagicFridgeAI.example.MagicFridgeAI.Repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    // CREATE
    public FoodItemModel saved(FoodItemModel foodItemModel) {
        return foodItemRepository.save(foodItemModel);
    }

    public List<FoodItemModel> listFoods(FoodItemModel foodItemModel) {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItemModel> listFoodsById(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItemModel update(FoodItemModel foodItemModel) {
        return foodItemRepository.save(foodItemModel);
    }

    public void delete(Long id) {
        foodItemRepository.deleteById(id);
    }

}
