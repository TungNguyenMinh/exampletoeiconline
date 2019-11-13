package com.minhtung.web.controller.command;

import com.minhtung.core.dto.UserDTO;
import com.minhtung.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    private String confirmPassword;

    public UserCommand() {
        this.pojo = new UserDTO();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
