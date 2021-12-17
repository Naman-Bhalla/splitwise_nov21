package dev.naman.splitwise_nov21.services;

import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
