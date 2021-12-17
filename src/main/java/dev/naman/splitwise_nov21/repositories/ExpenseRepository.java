package dev.naman.splitwise_nov21.repositories;

import dev.naman.splitwise_nov21.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense save(Expense expense);
}
