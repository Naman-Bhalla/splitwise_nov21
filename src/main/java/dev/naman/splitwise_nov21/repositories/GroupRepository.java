package dev.naman.splitwise_nov21.repositories;

import dev.naman.splitwise_nov21.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group save(Group group);
}
