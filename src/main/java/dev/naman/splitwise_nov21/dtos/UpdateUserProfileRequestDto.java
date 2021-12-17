package dev.naman.splitwise_nov21.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserProfileRequestDto extends AuthenticatedRequestDto {
    private String name;
    private String phoneNumber;
    private String password;
}
