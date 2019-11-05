package pl.edu.wat.ai.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pl.edu.wat.ai.dto.TransactionDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaction;

    @Column(precision=10, scale=2)
    private BigDecimal value;

    private String description;

    @JsonFormat(pattern="YYYY-MM-DD")
    private Date date;

    @NonNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Category category;

    public void changeAttributes(TransactionDTO transactionDTO, User user, Category category){
        this.setValue(transactionDTO.getValue());
        this.setDescription(transactionDTO.getDescription());
        this.setDate(transactionDTO.getDate());
        this.setUser(user);
        this.setCategory(category);
    }
}
