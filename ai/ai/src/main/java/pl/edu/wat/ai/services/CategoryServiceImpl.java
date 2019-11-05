package pl.edu.wat.ai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.ai.dto.CategoryDTO;
import pl.edu.wat.ai.models.Category;
import pl.edu.wat.ai.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(this::categoryMapToDTO).collect(Collectors.toList());
    }
    private CategoryDTO categoryMapToDTO(Category category){
        return CategoryDTO.build(category);
    }
}
