package com.viran.ecom.service;

import com.viran.ecom.dto.SignUpRequest;
import com.viran.ecom.dto.UserDto;
import com.viran.ecom.entity.User;

public interface AuthenticationService {

    boolean hasUserWithEmail(String email);
    void createAdminAccount();

    UserDto createUser(SignUpRequest signUpRequest);
}
