package com.example.DistributedSystems.Controllers;

import com.example.DistributedSystems.DAO.UserDAO;
import com.example.DistributedSystems.Entity.FarmerUnion;
import com.example.DistributedSystems.Entity.User;
import com.example.DistributedSystems.Service.UnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UnionService unionService;
    @Autowired
    private UserDAO UserDAO;

    @GetMapping("")
    public String ShowFarmerUnions(Model model){
        List<User> users = UserDAO.getUsers();
        model.addAttribute("Users", users);

        return "Users";
    }

    @GetMapping("{userId}")
    public String getUserUnions(@PathVariable Integer userId, Model model){
        List<FarmerUnion> farmerUnions = UserDAO.getFarmerUnion(userId);
        return "farmerUnions";
    }

    @DeleteMapping("{User_id}")
    public String deleteUser(@PathVariable Integer User_id){
        UserDAO.deleteUser(User_id);
        return "users";
    }
}
