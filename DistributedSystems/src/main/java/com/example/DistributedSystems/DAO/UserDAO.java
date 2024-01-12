package com.example.DistributedSystems.DAO;

import com.example.DistributedSystems.Entity.FarmerUnion;
import com.example.DistributedSystems.Entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();
    public User getUser(Integer User_id);
    public User saveUser(User user);
    public void deleteUser(Integer User_id);

    public List<FarmerUnion> getFarmerUnion(Integer User_id);
}
