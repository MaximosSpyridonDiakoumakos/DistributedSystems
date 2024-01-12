package com.example.DistributedSystems.Service;

import com.example.DistributedSystems.DAO.UserDAO;
import com.example.DistributedSystems.Entity.FarmerUnion;
import com.example.DistributedSystems.Entity.User;
import com.example.DistributedSystems.Repository.FarmerUnionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnionService {
    @Autowired
    private FarmerUnionRepository farmerUnionRepository;
    @Autowired
    private UserDAO userDAO;


    @Transactional
    public List<FarmerUnion> getFarmerUnions(){
        return farmerUnionRepository.findAll();
    }

    @Transactional
    public void saveFarmerUnion(FarmerUnion farmerUnion, Integer user_id) {
        User user = userDAO.getUser(user_id);
        farmerUnion.setUser(user);
        farmerUnionRepository.save(farmerUnion);
    }

    @Transactional
    public FarmerUnion getFarmerUnion(int farmerUnionId) {
        return farmerUnionRepository.findById(farmerUnionId).get();
    }

    @Transactional
    public void deleteFarmerUnion(int farmerUnionId){
        farmerUnionRepository.deleteById(farmerUnionId);
    }
}