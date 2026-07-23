package MagicFridgeAI.example.MagicFridgeAI.Controller;
import MagicFridgeAI.example.MagicFridgeAI.Model.FoodItemModel;
import MagicFridgeAI.example.MagicFridgeAI.Service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<FoodItemModel> create(@RequestBody FoodItemModel foodItemModel) {
        FoodItemModel savedFood = foodItemService.saved(foodItemModel);
        return (ResponseEntity<FoodItemModel>) ResponseEntity.ok(savedFood);
    }

    // READ
    @GetMapping("/read")
    public ResponseEntity<List<FoodItemModel>> read(FoodItemModel foodItemModel) {
        List<FoodItemModel> list = foodItemService.listFoods(foodItemModel);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FoodItemModel>> readById(@PathVariable Long id) {
        Optional<FoodItemModel> rodeFoodById = foodItemService.listFoodsById(id);
        return ResponseEntity.ok(rodeFoodById);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItemModel> update(@RequestBody FoodItemModel foodItemModel, @PathVariable Long id) {
        return foodItemService.listFoodsById(id)
                .map(ExistItem -> {
                    foodItemModel.setId(ExistItem.getId());
                    FoodItemModel updated = foodItemService.update(foodItemModel);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodItemService.delete(id);
        return ResponseEntity.noContent().build();  // Use build to not crash the codeline
    }

}
