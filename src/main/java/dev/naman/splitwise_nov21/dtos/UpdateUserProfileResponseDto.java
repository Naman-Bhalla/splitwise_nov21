package dev.naman.splitwise_nov21.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserProfileResponseDto extends ResponseDto {
    private UserDto user;
}


// there might be some common things that we want to put
// in every response
// eg: Status Code, Message, Response ID