package pl.edu.wat.ai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.edu.wat.ai.dto.CategoryDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @NotNull
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade=CascadeType.ALL)
    List<Transaction> transactions;
}
