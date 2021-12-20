package dev.naman.splitwise_nov21.services.settleup;

import dev.naman.splitwise_nov21.models.Transaction;
import dev.naman.splitwise_nov21.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SettleUpStrategy {

    List<Transaction> settle(List<Expense> expenses);
}
