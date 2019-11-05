package pl.edu.wat.ai.services;

import pl.edu.wat.ai.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
}
