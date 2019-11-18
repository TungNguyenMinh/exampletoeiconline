package com.minhtung.web.controller.admin;

import com.minhtung.core.dto.ListenGuidelineDTO;
import com.minhtung.core.web.common.WebConstant;
import com.minhtung.web.controller.command.ListenGuidelineCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ListenGuidelineDTO> listenGuidelineDTOS = new ArrayList<ListenGuidelineDTO>();
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        ListenGuidelineDTO dto1 = new ListenGuidelineDTO();
        dto1.setTitle("Bài hd 1");
        dto1.setContent("Nội dung bài hd 1");
        listenGuidelineDTOS.add(dto1);
        ListenGuidelineDTO dto2 = new ListenGuidelineDTO();
        dto2.setTitle("Bài hd 2");
        dto2.setContent("Nội dung bài hd 2");
        listenGuidelineDTOS.add(dto2);
        command.setListResult(listenGuidelineDTOS);
        request.setAttribute(WebConstant.LISR_ITEMS, command);
        command.setMaxPageItems(1);
        command.setTotalItems(listenGuidelineDTOS.size());
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
