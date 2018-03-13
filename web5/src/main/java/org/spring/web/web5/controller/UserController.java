package org.spring.web.web5.controller;

import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;
import org.spring.web.web5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.POST)
    public ModelAndView view(HttpServletRequest request, ModelMap model){
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.getUserLoginPass(login, password);
        boolean admin = false;
        if (user != null) {
            for (Role role: user.getRoles()){
                if (role.getRole().equalsIgnoreCase("admin")){
                    admin = true;
                }
            }
            if (admin){
                request.getSession().setAttribute("user", user); // Put user in session.
                //model.setViewName("/admin/list.jsp");
                return new ModelAndView("redirect:/admin/showAll", model);
                //model.SetVie("/admin/showAll"); // Go to some admin page.
            } else {
                request.getSession().setAttribute("user", user); // Put user in session.
                //model.setViewName("user"); // Go to user page.
                return new ModelAndView("redirect:/user.jsp", model);
            }
        } else {
            request.setAttribute("error", "Unknown login or password, try again"); // Set error msg for ${error}
            //model.setViewName("/index"); // Go back to login page.
            return new ModelAndView("redirect:/index.jsp", model);
        }
        //return model;
    }


}
