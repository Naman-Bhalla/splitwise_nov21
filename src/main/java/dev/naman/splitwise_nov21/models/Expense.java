package dev.naman.splitwise_nov21.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "expenses")
public class Expense extends BaseModel {
    private String description;

    @ManyToOne
    private User createdBy;

    private long amount;

    private Currency currency;

    @ElementCollection
    Map<User, Long> paidBy;

    @ElementCollection
    Map<User, Long> owedBy;
    // key, value

    // user: key, lonmg: value

//    @ManyToOne
//    Group group;
}
// do remember about precision issues in double
// ~ 1 day
// ~2-3 hrs
// finish 1 requirement by 1 to 1
// 100.85 / 3