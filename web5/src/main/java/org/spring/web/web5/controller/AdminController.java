package org.spring.web.web5.controller;

import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;
import org.spring.web.web5.service.RoleService;
import org.spring.web.web5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    @RequestMapping(value = "/admin/showAll", method = RequestMethod.GET)
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list.jsp");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("listUser", this.userService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/index", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addUsers(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/index.jsp");
        User user = new User(request.getParameter("name"), request.getParameter("login"), request.getParameter("password"));
        String roleName = request.getParameter("roles");
        int roleId;
        if (roleName.equalsIgnoreCase("admin")) {
            roleId = 1;
        } else {
            roleId = 2;
        }
        Role role = roleService.getRoleId(roleId);
        user.setRoles(role);
        userService.setUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public ModelAndView deleteUsers(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUserById(id);
        return new ModelAndView("redirect:/admin/showAll");
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView updateUsersGet (HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/update.jsp");
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getUser(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("allRoles", this.roleService.getRoles());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUsersPost (HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getUser(id);
        user.setLogin(request.getParameter("login"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin/showAll");
    }

    @RequestMapping(value = "/admin/deleteRole", method = RequestMethod.GET)
    public ModelAndView updateUsersDeleteRole (HttpServletRequest request) {
        int index = -1;
        User user = userService.getUser(Long.parseLong(request.getParameter("id")));
        List<Role> userRoles = user.getRoles();
        for (Role role : userRoles){
            if(role.getRole().equalsIgnoreCase(request.getParameter("role"))) {
                index = userRoles.indexOf(role);
            }
        }
        userRoles.remove(index);
        userService.updateUserRole(user);
        return new ModelAndView("redirect:/admin/update?id="+ user.getId());
    }

    @RequestMapping(value = "/admin/addRole", method = RequestMethod.GET)
    public ModelAndView updateUsersAddRole (HttpServletRequest request) {
        List<Role> roles = roleService.getRoles();
        Role roleForUser = null;
        for (Role role : roles){
            if(role.getRole().equalsIgnoreCase(request.getParameter("role"))) {
                roleForUser = role;
            }
        }
        //Role role = roleService.getRole(request.getParameter("role"));
        User user = userService.getUser(Long.parseLong(request.getParameter("id")));
        if (user.getRoles().contains(roleForUser)) {
            return new ModelAndView("redirect:/admin/update?id="+user.getId());
        } else {
            user.setRoles(roleForUser);
            userService.updateUserRole(user);
            return new ModelAndView("redirect:/admin/update?id="+user.getId());
        }



        /*Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getUser(id);
        user.setLogin(request.getParameter("login"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin/update?id="+user.getId());*/
    }


}
