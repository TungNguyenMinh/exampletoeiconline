package com.minhtung.web.controller.command;

import com.minhtung.core.dto.ListenGuidelineDTO;
import com.minhtung.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
