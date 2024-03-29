package com.minhtung.web.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.minhtung.core.dto.UserDTO;
import com.minhtung.core.service.UserService;
import com.minhtung.core.service.impl.UserServiceImpl;
import com.minhtung.core.web.common.WebConstant;
import com.minhtung.core.web.util.FormUtil;
import com.minhtung.web.controller.command.UserCommand;
import org.apache.log4j.Logger;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    //Khai báo để sử dụng logger
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        UserService userService = new UserServiceImpl();
        try {
            if (userService.isUserExitst(pojo) != null) {
                if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null) {
                    if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                        response.sendRedirect("/admin-home.html");
                    } else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                        response.sendRedirect("/home.html");
                    }
                }
            }
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên hoặc mật khẩu sai");
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        }
    }
}
