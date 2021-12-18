package dev.naman.splitwise_nov21.services;

import dev.naman.splitwise_nov21.controllers.ExpenseController;
import dev.naman.splitwise_nov21.dtos.CreateExpenseRequestDto;
import dev.naman.splitwise_nov21.dtos.CreateExpenseResponseDto;
import dev.naman.splitwise_nov21.dtos.CreateGroupExpenseResponseDto;
import dev.naman.splitwise_nov21.dtos.Status;
import dev.naman.splitwise_nov21.models.Expense;
import dev.naman.splitwise_nov21.models.Group;
import dev.naman.splitwise_nov21.models.User;
import dev.naman.splitwise_nov21.repositories.GroupRepository;
import dev.naman.splitwise_nov21.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseController expenseController;
    public Group createGroup(String name, Long adminId, Set<Long> members) {

        Optional<User> admin = this.userRepository.findById(adminId);
        List<User> groupMembers = new ArrayList<>();

        groupMembers.add(admin.get());
        for (Long id : members) {
            Optional<User> member = this.userRepository.findById(id);
            groupMembers.add(member.get());
        }

        Group group = new Group();
        group.setAdmin(admin.get());
        group.setName(name);
        group.setMembers(groupMembers);
        return this.groupRepository.save(group);
    }

    public CreateGroupExpenseResponseDto createExpense(Long groupId, CreateExpenseRequestDto expenseRequestDto){

        CreateGroupExpenseResponseDto groupExpenseResponseDto =  new CreateGroupExpenseResponseDto();

        Optional<Group> group = this.groupRepository.findById(groupId);

        if(group.isEmpty()){
            groupExpenseResponseDto.setStatus(Status.ERROR);
            return groupExpenseResponseDto;
        }

        CreateExpenseResponseDto expense = this.expenseController.create(expenseRequestDto);

        List<Expense> expenseList = new ArrayList<>();
//        expenseList.add(expense.getExpense());

        Group updateGroup = group.get();
        updateGroup.getExpenses().add(expense.getExpense());

        Group updatedGroup = this.groupRepository.save(updateGroup);

        groupExpenseResponseDto.setGroup(updatedGroup);
        groupExpenseResponseDto.setExpense(expense.getExpense());

        return groupExpenseResponseDto;
    }
}
