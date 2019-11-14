package com.minhtung.core.service;

import com.minhtung.core.dto.UserDTO;

public interface UserService {
    UserDTO isUserExitst(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
}
