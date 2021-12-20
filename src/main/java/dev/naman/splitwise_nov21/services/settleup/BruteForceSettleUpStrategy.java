package dev.naman.splitwise_nov21.services.settleup;

import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BruteForceSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        Map<Long, Map<Long, Long>> map_user_user_amount = new HashMap<>();


        for (Expense expense: expenses) {

        }

        return null;
    }
}
// Expense
// Owed By: A: 100 B: 50
// Paid BY: A: 20 B: 30 c: 100 d: 20

// Owed By: A: 80, B: 20 D: -20
// Paid By: C: 150

// Owed By: A: 100 B: 50
// Paid By: A: 150

// Owed BY: A: 20 B: 50 C: 60
// Paid By: C: 20 D: 80

// Owed By: A: 20 B: 50 C: 40
// Paid By: D: 100





// A, B, C, D, E
// (5 * (5 - 1)) / 2
//    A   B   C   D     E
// A  0   10  -5  0     0
// B      0   100 -200  60
// C           0  10    -10
// D               0    -60
// E                     0
