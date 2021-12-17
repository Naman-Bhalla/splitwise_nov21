package dev.naman.splitwise_nov21.dtos;

import dev.naman.splitwise_nov21.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto extends ResponseDto {
    private UserDto user;
}
