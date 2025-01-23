package com.austinpedicab.shop_manager.controller;

import com.austinpedicab.shop_manager.database.dao.MaintenanceRequestDAO;
import com.austinpedicab.shop_manager.database.dao.RiderDAO;
import com.austinpedicab.shop_manager.database.dao.UserDAO;
import com.austinpedicab.shop_manager.database.entity.MaintenanceRequest;
import com.austinpedicab.shop_manager.database.entity.Rider;
import com.austinpedicab.shop_manager.database.entity.User;
import com.austinpedicab.shop_manager.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private MaintenanceRequestDAO maintenanceRequestDAO;
    @Autowired
    private RiderDAO RiderDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/admin/dashboard")
    public ModelAndView AdminDash(){
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/adminDashboard");
        List<MaintenanceRequest> openRequests = maintenanceRequestDAO.findOpenMaintenanceRequests();
        List<User> pendingUsers = userDAO.findPendingUsers();
        response.addObject("openRequests", openRequests);
        response.addObject("pendingUsers", pendingUsers);
        return response;
    }

    @GetMapping("/admin/manage-users")
    public ModelAndView manageUsers(){
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/manageUsers");
        return response;
    }

    @GetMapping("/admin/manage-users/search")
    public ModelAndView search(@RequestParam(required = false) String preferredName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/riderSearch");
        response.addObject("preferredName", preferredName);
        System.out.println(preferredName);

        if (preferredName != null) {
            List<Rider> riders = RiderDAO.findByPreferredName(preferredName);
            response.addObject("riders", riders);
            System.out.println(riders);
        }

        return response;
    }

}
