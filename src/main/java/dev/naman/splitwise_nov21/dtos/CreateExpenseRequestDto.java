package dev.naman.splitwise_nov21.dtos;

import dev.naman.splitwise_nov21.models.Currency;
import dev.naman.splitwise_nov21.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.util.Map;

@Getter
@Setter
public class CreateExpenseRequestDto extends AuthenticatedRequestDto {
    private String description;
    private long amount;
    private Currency currency;
    private Map<Long, Long> paidBy; // Id -> Amount
    private Map<Long, Long> owedBy; // Id -> Amount
}
