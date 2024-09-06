package com.viran.ecom.dto;

import com.viran.ecom.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
