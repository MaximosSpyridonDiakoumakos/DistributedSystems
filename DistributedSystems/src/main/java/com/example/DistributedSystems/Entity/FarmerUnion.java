package com.example.DistributedSystems.Entity;

import jakarta.persistence.*;

@Entity
public class FarmerUnion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private String Members;

    @Column
    private String Products;

    @Column
    private String Locations;

    @Column
    private String UnionName;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn( name = "user_id")
    private User user;

    public FarmerUnion() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMembers() {
        return Members;
    }

    public void setMembers(String members) {
        Members = members;
    }

    public String getProducts() {
        return Products;
    }

    public void setProducts(String products) {
        Products = products;
    }

    public String getLocations() {
        return Locations;
    }

    public void setLocations(String locations) {
        Locations = locations;
    }

    public String getUnionName() {
        return UnionName;
    }

    public void setUnionName(String unionName) {
        UnionName = unionName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FarmerUnion(Integer id, String members, String products, String locations, String unionName, User user) {
        Id = id;
        Members = members;
        Products = products;
        Locations = locations;
        UnionName = unionName;
        this.user = user;
    }

    @Override
    public String toString() {
        return "FarmerUnion{" +
                "Id=" + Id +
                ", Members='" + Members + '\'' +
                ", Products='" + Products + '\'' +
                ", Locations='" + Locations + '\'' +
                ", UnionName='" + UnionName + '\'' +
                ", user=" + user +
                '}';
    }
}
