package dev.naman.splitwise_nov21.controllers;

import dev.naman.splitwise_nov21.dtos.*;
import dev.naman.splitwise_nov21.models.User;
import dev.naman.splitwise_nov21.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public RegisterUserResponseDto registerUser(
            RegisterUserRequestDto request
    ) {
        User user = userService.registerUser(
                request.getName(),
                request.getPhoneNumber(),
                request.getPassword()
        );

        RegisterUserResponseDto response = new RegisterUserResponseDto();
        response.setUser(UserDto.from(user));
        response.setRequestId(1234);
        response.setStatus(Status.SUCCESS);

        return response;
    }

    public UpdateUserProfileResponseDto updateUserProfile(
            UpdateUserProfileRequestDto request
    ) {
        Long id = request.getUserId();
        String name = request.getName();
        String password = request.getPassword();
        String phoneNumber = request.getPhoneNumber();

        User user = userService.updateUserProfile(id, name, phoneNumber, password);;

        UpdateUserProfileResponseDto responseDto = new UpdateUserProfileResponseDto();
        responseDto.setUser(UserDto.from(user));
        responseDto.setStatus(Status.SUCCESS);

        return responseDto;
    }
}
