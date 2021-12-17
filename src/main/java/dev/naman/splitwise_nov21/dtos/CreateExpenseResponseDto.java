package dev.naman.splitwise_nov21.dtos;

import dev.naman.splitwise_nov21.models.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateExpenseResponseDto extends ResponseDto {
    private Expense expense;
}
