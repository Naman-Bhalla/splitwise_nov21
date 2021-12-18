package dev.naman.splitwise_nov21.controllers;

import dev.naman.splitwise_nov21.dtos.*;
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
                createGroupRequestDto.getUserId(),
                createGroupRequestDto.getMember());

        CreateGroupResponseDto response= new CreateGroupResponseDto();
        response.setGroup(group);

        return response;
    }

    public CreateGroupExpenseResponseDto createExpense(CreateGroupExpenseRequestDto groupExpenseRequestDto){

        return this.groupService.createExpense(
                groupExpenseRequestDto.getGroupId(),
                groupExpenseRequestDto.getExpenseRequestDto());
    }
}
