package dev.naman.splitwise_nov21.services;

import dev.naman.splitwise_nov21.exceptions.InvalidGroupIdException;
import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.models.Group;
import dev.naman.splitwise_nov21.models.Transaction;
import dev.naman.splitwise_nov21.repositories.GroupRepository;
import dev.naman.splitwise_nov21.services.settleup.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private SettleUpStrategy settleUpStrategy;

    public List<Transaction> settleExpenses(Long groupId) throws InvalidGroupIdException {
        Optional<Group> group = groupRepository.findById(groupId);

        if (group.isEmpty()) {
            throw new InvalidGroupIdException();
        }

        List<Expense> expenses = group.get().getExpenses();

        List<Transaction> transactions = this.settleUpStrategy.settle(expenses);

        return transactions;
    }
}
