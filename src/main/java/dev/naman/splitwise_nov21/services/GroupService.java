package dev.naman.splitwise_nov21.services;

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
}
