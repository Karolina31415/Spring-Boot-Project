package pl.edu.wat.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.edu.wat.ai.models.Category;

@Data
@AllArgsConstructor
public class CategoryDTO {
    private Integer idCategory;
    private String categoryName;

    public static CategoryDTO build(Category category) {
        return new CategoryDTO(
                category.getIdCategory(),
                category.getCategoryName()
        );
    }
}
