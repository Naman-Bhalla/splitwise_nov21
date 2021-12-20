package dev.naman.splitwise_nov21.services.settleup;

import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.models.Transaction;
import dev.naman.splitwise_nov21.models.User;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreedySettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        Map<Long, Long> user_owed_amount = new HashMap<>();

        for (Expense expense: expenses) {
            for (User user : expense.getOwedBy().keySet()) {
                if (!user_owed_amount.containsKey(user.getId())) {
                    user_owed_amount.put(user.getId(), 0L);
                }

                user_owed_amount.put(user.getId(), user_owed_amount.get(user.getId()) +
                        expense.getOwedBy().get(user));
            }

            for (User user : expense.getPaidBy().keySet()) {
                if (!user_owed_amount.containsKey(user.getId())) {
                    user_owed_amount.put(user.getId(), 0L);
                }

                user_owed_amount.put(user.getId(), user_owed_amount.get(user.getId()) -
                        expense.getPaidBy().get(user));
            }
        }

        TreeSet<Pair<Long, Long>> set = new TreeSet<>(new Comparator<Pair<Long, Long>>() {
            @Override
            public int compare(Pair<Long, Long> o1, Pair<Long, Long> o2) {
                return (int)(o1.getFirst() - o2.getFirst());
            }
        }); // amount -> userID

        for (Long userId: user_owed_amount.keySet()) {
            set.add(Pair.of(user_owed_amount.get(userId), userId));
        }

        List<Transaction> transactions = new ArrayList<>();

        while (set.size() > 1) {
            Pair<Long, Long> smallestPair = set.first();
            Pair<Long, Long> largestPair = set.last();

            Transaction transaction = new Transaction();
            transaction.setFromId(largestPair.getSecond());
            transaction.setToId(smallestPair.getSecond());
            transaction.setAmount(largestPair.getFirst());

            set.remove(largestPair);
            set.remove(smallestPair);

            set.add(Pair.of(smallestPair.getFirst() + largestPair.getFirst(), smallestPair.getSecond()));
            transactions.add(transaction);
        }

        return transactions; // n - 1
    }
}

// go through all the expenses
// in every expense:
//   some people pay (paid_by)
//   some people borrow (owed_by)
//  A: 20  B: 30  C: 10 -> Paid
// A: 10  B: 10 C: 40 -> Owed

// A: 100 -> Paid
// A: 10 B: 30 C: 60 -> Owed

// Create a map from user -> amount (owed_money)
// A -> 10 - 20 + 10 - 100 = -100
// B -> 10 - 30 + 30 = 10
// C -> 40 - 10 + 60 = 90

// Priority Queue
// [(A, -100), (B, 10), (C, 90)]
// C -> A => 90
// [(A, -100 + 90), (B, 10)] = [(A, -10), (B, 10)]
// B -> A => 10
// [(A, -10 + 10)] = []

// go through every expnse