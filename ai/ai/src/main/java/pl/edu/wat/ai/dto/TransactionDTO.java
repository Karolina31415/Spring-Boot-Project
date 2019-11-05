package pl.edu.wat.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.edu.wat.ai.models.Transaction;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class TransactionDTO {
    private Integer idTransaction;
    private BigDecimal value;
    private String description;
    private Date date;
    private Integer idCategory;
    private String nameCategory;

    public static TransactionDTO build(Transaction transaction) {
        return new TransactionDTO(
                transaction.getIdTransaction(),
                transaction.getValue(),
                transaction.getDescription(),
                transaction.getDate(),
                transaction.getCategory().getIdCategory(),
                transaction.getCategory().getCategoryName()
        );
    }
}
