package com.example.DistributedSystems.Controllers;

import com.example.DistributedSystems.DAO.UserDAO;
import com.example.DistributedSystems.Entity.FarmerUnion;
import com.example.DistributedSystems.Entity.User;
import com.example.DistributedSystems.Repository.FarmerUnionRepository;
import com.example.DistributedSystems.Service.UnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/FarmerUnion")
public class FarmerUnionController {

    @Autowired
    UnionService unionService;
    @Autowired
    UserDAO userDAO;


    @GetMapping("")
    public String ShowFarmerUnions(Model model){
        List<FarmerUnion> farmerUnions = unionService.getFarmerUnions();
        model.addAttribute("Farmer Unions", farmerUnions);

        return "farmerUnions";
    }

    @GetMapping({"user_id/new"})
    public String addFarmerUnion(@PathVariable Integer user_id, Model model){
        FarmerUnion farmerUnion = new FarmerUnion();
        model.addAttribute("farmerUnion", farmerUnion);
        model.addAttribute("user_id", user_id);
        return "add_farmerUnion";
    }

    @PostMapping("{user_id}")
    public String saveFarmerUnion(@PathVariable Integer user_id, @ModelAttribute("farmerUnions") FarmerUnion farmerUnion){
        System.out.println("user_id:"+user_id);
        System.out.println("farmerUnion:"+farmerUnion.getUnionName());
        unionService.saveFarmerUnion(farmerUnion,user_id);
        return "redirect:/farmerUnions/"+user_id;
    }

    @DeleteMapping("{user_id}/{FarmerUnion_id}")
    public String deleteFarmerUnion(@PathVariable int user_id, @PathVariable int FarmerUnion_id, Model model){
        unionService.deleteFarmerUnion(FarmerUnion_id);
        return "home";
    }
}
