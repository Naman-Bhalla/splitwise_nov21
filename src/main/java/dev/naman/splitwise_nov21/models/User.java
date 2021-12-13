package dev.naman.splitwise_nov21.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String hashedPassword;
}
