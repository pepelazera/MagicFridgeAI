package MagicFridgeAI.example.MagicFridgeAI.Controller;
import MagicFridgeAI.example.MagicFridgeAI.Model.FoodItemModel;
import MagicFridgeAI.example.MagicFridgeAI.Service.FoodItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemController {

    private FoodItemService foodItemService;

    // POST
    @PostMapping
    public ResponseEntity<FoodItemModel> create(@RequestBody FoodItemModel foodItemModel) {
        FoodItemModel savedFood = foodItemService.saved(foodItemModel);
        return (ResponseEntity<FoodItemModel>) ResponseEntity.ok(savedFood);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<FoodItemModel>> read(@RequestBody FoodItemModel foodItemModel) {
        List<FoodItemModel> list = foodItemService.listFoods(foodItemModel);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FoodItemModel>> readById(@RequestBody Long Id) {
        Optional<FoodItemModel> rodeFoodById = foodItemService.listFoodsById(Id);
        return ResponseEntity.ok(rodeFoodById);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItemModel> update(@RequestBody FoodItemModel foodItemModel, @PathVariable Long id) {
        return foodItemService.listFoodsById(id)
                .map(ExistIem -> {
                    foodItemModel.setId(ExistIem.getId());
                    FoodItemModel updated = foodItemService.update(foodItemModel);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    //DELETE
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
         foodItemService.delete(id);
        return (ResponseEntity<Void>) ResponseEntity.noContent();
    }

}
