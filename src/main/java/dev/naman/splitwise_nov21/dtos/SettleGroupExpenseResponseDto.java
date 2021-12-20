package dev.naman.splitwise_nov21.dtos;

import dev.naman.splitwise_nov21.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleGroupExpenseResponseDto extends ResponseDto {
    private List<Transaction>  transactions;
}

// A request comes to settle up group with ID 1
// 1.) Fetch all the expenses of the group -> go to groupRepo
// 2.) Have a few implementation of SettleUpStrategy -> Transactions
// 3.) Return the response