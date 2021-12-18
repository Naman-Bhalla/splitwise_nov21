package dev.naman.splitwise_nov21.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupExpenseRequestDto extends AuthenticatedRequestDto{
    Long groupId;
    CreateExpenseRequestDto expenseRequestDto;
}
