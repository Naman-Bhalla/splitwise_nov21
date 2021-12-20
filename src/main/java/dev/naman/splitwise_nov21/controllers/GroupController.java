package dev.naman.splitwise_nov21.controllers;

import dev.naman.splitwise_nov21.dtos.SettleGroupExpenseRequestDto;
import dev.naman.splitwise_nov21.dtos.SettleGroupExpenseResponseDto;
import dev.naman.splitwise_nov21.dtos.Status;
import dev.naman.splitwise_nov21.exceptions.InvalidGroupIdException;
import dev.naman.splitwise_nov21.models.Transaction;
import dev.naman.splitwise_nov21.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;

    public SettleGroupExpenseResponseDto settleExpenses(
            SettleGroupExpenseRequestDto request
            ) {
        List<Transaction> transactions;
        SettleGroupExpenseResponseDto response = new SettleGroupExpenseResponseDto();

        try {
            transactions = this.groupService.settleExpenses(request.getGroupId());
        } catch (InvalidGroupIdException exception)  {
            response.setStatus(Status.ERROR);
            return response;
        }

        response.setTransactions(transactions);

        return response;
    }

}
