package com.example.rtms;

import com.example.rtms.constant.AppConstants;
import com.example.rtms.dto.request.UserRequestDto;
import com.example.rtms.service.AuthenticationService;
import com.example.rtms.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createRoles();
        if (authenticationService.count() <= 0) {
            createUsers();
        }
    }

    private void createRoles() {
        roleService.findOrCreateByName(AppConstants.ROLE_ADMIN);
        roleService.findOrCreateByName(AppConstants.ROLE_STAFF);
        roleService.findOrCreateByName(AppConstants.ROLE_CUSTOMER);
    }

    private void createUsers() {
        UserRequestDto admin = UserRequestDto.builder()
                .name("Admin")
                .username("admin")
                .email("admin@restro.com")
                .password("Admin@123")
                .build();
        authenticationService.createUser(admin, List.of(AppConstants.ROLE_ADMIN, AppConstants.ROLE_STAFF));

        UserRequestDto staff = UserRequestDto.builder()
                .name("Staff")
                .username("staff")
                .email("staff@restro.com")
                .password("Staff@123")
                .build();
        authenticationService.createUser(staff, List.of(AppConstants.ROLE_STAFF));

        UserRequestDto customer1 = UserRequestDto.builder()
                .name("John Doe")
                .username("johndoe")
                .email("johndoe@restro.com")
                .password("Customer@123")
                .build();
        authenticationService.createUser(customer1, List.of(AppConstants.ROLE_CUSTOMER));

        UserRequestDto customer2 = UserRequestDto.builder()
                .name("Maya Smith")
                .username("mayasmith")
                .email("maya@restro.com")
                .password("Customer@123")
                .build();
        authenticationService.createUser(customer2, List.of(AppConstants.ROLE_CUSTOMER));

        UserRequestDto customer3 = UserRequestDto.builder()
                .name("Jackie Williams")
                .username("jackie")
                .email("jackie@restro.com")
                .password("Customer@123")
                .build();
        authenticationService.createUser(customer3, List.of(AppConstants.ROLE_CUSTOMER));
    }
}
