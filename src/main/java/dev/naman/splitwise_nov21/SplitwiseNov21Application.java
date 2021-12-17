package dev.naman.splitwise_nov21;

import dev.naman.splitwise_nov21.controllers.ExpenseController;
import dev.naman.splitwise_nov21.controllers.UserController;
import dev.naman.splitwise_nov21.dtos.*;
import dev.naman.splitwise_nov21.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseNov21Application implements CommandLineRunner {
    @Autowired
    private UserController userController;

    @Autowired
    private ExpenseController expenseController;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseNov21Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RegisterUserRequestDto dto = new RegisterUserRequestDto();
        dto.setName("Naman");
        dto.setPassword("password");
        dto.setPhoneNumber("1234");

        userController.registerUser(dto);


        UpdateUserProfileRequestDto dto2 = new UpdateUserProfileRequestDto();
        dto2.setUserId(1L);
        dto2.setName("NAMANAAA");
        dto2.setPhoneNumber("1234");
        dto2.setPassword("password2");

        userController.updateUserProfile(dto2);

        String description = "Class charge";
        Map<Long, Long> paidBy = new HashMap<>();
        paidBy.put(1L, 100L);
        paidBy.put(2L, 30L);
        Map<Long, Long> owedBy = new HashMap<>();
        owedBy.put(3L, 130L);

        CreateExpenseRequestDto requestDto = new CreateExpenseRequestDto();
        requestDto.setAmount(130L);
        requestDto.setCurrency(Currency.INR);
        requestDto.setDescription(description);
        requestDto.setUserId(1L);
        requestDto.setOwedBy(owedBy);
        requestDto.setPaidBy(paidBy);

        expenseController.create(requestDto);


    }
}

// create an expense
//