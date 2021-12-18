package dev.naman.splitwise_nov21.dtos;


import dev.naman.splitwise_nov21.models.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupResponseDto extends  ResponseDto{
    private Group group;
}
