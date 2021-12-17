package dev.naman.splitwise_nov21.dtos;

import dev.naman.splitwise_nov21.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String phoneNumber;
    private Long id;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
    }

    private UserDto() {}

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.name = user.getName();
        userDto.phoneNumber = user.getPhoneNumber();
        return userDto;
    }
}
