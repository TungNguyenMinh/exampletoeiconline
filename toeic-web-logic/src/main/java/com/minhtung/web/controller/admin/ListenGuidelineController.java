package com.minhtung.web.controller.admin;

import com.minhtung.core.dto.ListenGuidelineDTO;
import com.minhtung.core.service.ListenGuidelineService;
import com.minhtung.core.service.impl.ListenGuidelineServiceImpl;
import com.minhtung.core.web.common.WebConstant;
import com.minhtung.core.web.common.utils.UploadUitl;
import com.minhtung.core.web.util.FormUtil;
import com.minhtung.core.web.util.ResquestUtil;
import com.minhtung.web.controller.command.ListenGuidelineCommand;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

//@WebServlet("/admin-guideline-listen-list.html")
@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html", "/admin-guideline-listen-edit.html"})
public class ListenGuidelineController extends HttpServlet {

    private ListenGuidelineService guidelineService = new ListenGuidelineServiceImpl();
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class, request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
        HttpSession session = request.getSession();
        /*command.setMaxPageItems(2);
        ResquestUtil.InitSearchBean(request, command);
        Object[] objects = guidelineService.findListenGuidelineByProperties(null, null, command.getSortExpression(), command.getSortDirecttion(), command.getFirstItem(), command.getMaxPageItems());
        command.setListResult((List<ListenGuidelineDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));*/
        /*request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
        request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("lable.guideline.listen.add.success"));*/
        if (session != null) {
            request.setAttribute(WebConstant.ALERT, session.getAttribute(WebConstant.ALERT));
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, session.getAttribute(WebConstant.MESSAGE_RESPONSE));
        }
        request.setAttribute(WebConstant.LISR_ITEMS, command);
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
        session.removeAttribute(WebConstant.ALERT);
        session.removeAttribute(WebConstant.MESSAGE_RESPONSE);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListenGuidelineCommand command = new ListenGuidelineCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources");
        UploadUitl uploadUitl = new UploadUitl();
        HttpSession session = request.getSession();
        Set<String> valueTitle = builSetValueListenGuideline();
        try {
            Object[] objects = uploadUitl.writeOrUpdateFile(request, valueTitle, WebConstant.LISTENGUIDELINE);
            Map<String, String> mapValue = (Map<String, String>) objects[3];
            command = returnValueListenGuidelineCommand(valueTitle, command, mapValue);
            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("lable.guideline.listen.add.success"));
        } catch (FileUploadException e) {
            log.error(e.getMessage(), e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.error"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.error"));
        }
        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url_list");
    }

    private ListenGuidelineCommand returnValueListenGuidelineCommand(Set<String> valueTitle, ListenGuidelineCommand command, Map<String, String> mapValue) {
        for (String item : valueTitle) {
            if (mapValue.containsKey(item)) {
                if (item.equals("pojo.title")) {
                    command.getPojo().setTitle(mapValue.get(item));
                } else if (item.equals("pojo.content")) {
                    command.getPojo().setContent(mapValue.get(item));
                }
            }
        }
        return command;
    }

    private Set<String> builSetValueListenGuideline() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.title");
        returnValue.add("pojo.content");
        return returnValue;
    }
}
