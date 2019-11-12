package com.minhtung.web.controller.command;

import com.minhtung.core.dto.UserDTO;
import com.minhtung.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand(){
        this.pojo = new UserDTO();
    }
}
