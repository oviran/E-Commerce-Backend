package com.viran.ecom.service.impl;

import com.viran.ecom.dto.SignUpRequest;
import com.viran.ecom.dto.UserDto;
import com.viran.ecom.entity.User;
import com.viran.ecom.enums.UserRole;
import com.viran.ecom.repository.UserRepo;
import com.viran.ecom.service.AuthenticationService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {


    private final UserRepo userRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignUpRequest signUpRequest) {
        User user = new User();

        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepo.save(user);

        UserDto userDto = new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount() {
        User adminAccount = userRepo.findByRole(UserRole.ADMIN);
        if (null == adminAccount) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepo.save(user);
        }
    }
}
