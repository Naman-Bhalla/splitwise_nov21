package dev.naman.splitwise_nov21.controllers;

import dev.naman.splitwise_nov21.dtos.CreateGroupRequestDto;
import dev.naman.splitwise_nov21.dtos.CreateGroupResponseDto;
import dev.naman.splitwise_nov21.models.Group;
import dev.naman.splitwise_nov21.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;

    public CreateGroupResponseDto create(CreateGroupRequestDto createGroupRequestDto) {

        Group group = this.groupService.createGroup(
                createGroupRequestDto.getName(),
                createGroupRequestDto.getAdmin(),
                createGroupRequestDto.getMember());

        CreateGroupResponseDto response= new CreateGroupResponseDto();
        response.setGroup(group);

        return response;
    }
}
