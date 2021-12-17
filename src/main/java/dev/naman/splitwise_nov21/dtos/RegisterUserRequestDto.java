package dev.naman.splitwise_nov21.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String name;
    private String phoneNumber;
    private String password;
}
