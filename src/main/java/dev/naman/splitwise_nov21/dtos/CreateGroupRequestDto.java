package dev.naman.splitwise_nov21.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateGroupRequestDto {
    private String name;
    private Long admin;
    private Set<Long> member;
}
