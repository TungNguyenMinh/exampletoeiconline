package com.minhtung.web.controller.admin;

import com.minhtung.core.dto.ListenGuidelineDTO;
import com.minhtung.core.service.ListenGuidelineService;
import com.minhtung.core.service.impl.ListenGuidelineServiceImpl;
import com.minhtung.core.web.common.WebConstant;
import com.minhtung.core.web.util.ResquestUtil;
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

    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ListenGuidelineCommand command = new ListenGuidelineCommand();
        command.setMaxPageItems(2);
        ResquestUtil.InitSearchBean(request, command);
        Object[] objects = guidelineService.findListenGuidelineByProperties(null, null, command.getSortExpression(), command.getSortDirecttion(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
        request.setAttribute(WebConstant.LISR_ITEMS, command);*/
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
