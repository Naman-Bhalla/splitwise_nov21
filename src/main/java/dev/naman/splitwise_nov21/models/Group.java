package dev.naman.splitwise_nov21.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group extends BaseModel {
    private String name;

    @ManyToOne
    private User admin;

    @ManyToMany
    private List<User> members;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name="group_expenses",
            joinColumns = @JoinColumn(name = "group_id")
    )
    private List<Expense> expenses;
}
