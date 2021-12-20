package dev.naman.splitwise_nov21.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private Long fromId;
    private Long toId;
    private Long amount;
}
