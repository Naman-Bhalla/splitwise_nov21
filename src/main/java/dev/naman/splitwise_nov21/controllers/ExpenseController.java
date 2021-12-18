package dev.naman.splitwise_nov21.controllers;

import dev.naman.splitwise_nov21.dtos.CreateExpenseRequestDto;
import dev.naman.splitwise_nov21.dtos.CreateExpenseResponseDto;
import dev.naman.splitwise_nov21.dtos.Status;
import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.models.User;
import dev.naman.splitwise_nov21.repositories.UserRepository;
import dev.naman.splitwise_nov21.services.ExpenseService;
import dev.naman.splitwise_nov21.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
public class ExpenseController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseService expenseService;

    public CreateExpenseResponseDto create(CreateExpenseRequestDto request) {
        // 1. Change longs (ids) - > User objects
        CreateExpenseResponseDto responseDto = new CreateExpenseResponseDto();

        Map<User, Long> owedUserAmounts = new HashMap<>();
        for (Map.Entry<Long, Long> id_amount : request.getOwedBy().entrySet()) {
            Long id = id_amount.getKey();
            Long amount = id_amount.getValue();

            Optional<User> user = userRepository.findById(id);

            if (user.isEmpty()) {
                responseDto.setStatus(Status.ERROR);
                return responseDto;
            }

            owedUserAmounts.put(user.get(), amount);
        }

        Map<User, Long> paidUserAmounts = new HashMap<>();
        for (Map.Entry<Long, Long> id_amount : request.getPaidBy().entrySet()) {
            Long id = id_amount.getKey();
            Long amount = id_amount.getValue();

            Optional<User> user = userRepository.findById(id);

            if (user.isEmpty()) {
                responseDto.setStatus(Status.ERROR);
                return responseDto;
            }

            paidUserAmounts.put(user.get(), amount);
        }

        Optional<User> createdByUser = userRepository.findById(request.getUserId());

        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setCreatedBy(createdByUser.get());
        expense.setDescription(request.getDescription());
        expense.setCurrency(request.getCurrency());
        expense.setOwedBy(owedUserAmounts);
        expense.setPaidBy(paidUserAmounts);

        Expense createdExpense = expenseService.createExpense(expense);

        responseDto.setExpense(createdExpense);
        return  responseDto;
    }
}

// create api to create a group expense