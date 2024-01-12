package com.example.DistributedSystems.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "Username"),
                @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    @NotBlank
    private String Username;

    @Column
    @NotBlank
    private String Password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotBlank
    @Email
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FarmerUnion> farmerUnion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setFarmerUnion(List<FarmerUnion> farmerUnion) {
        this.farmerUnion = farmerUnion;
    }


    public User() {
    }

    public List<FarmerUnion> getFarmerUnion() {
        return null;
    }

    public User(Integer id, String username, String password, String firstName, String lastName, String email, List<FarmerUnion> farmerUnion, Set<Role> roles) {
        Id = id;
        Username = username;
        Password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.farmerUnion = farmerUnion;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", farmerUnion=" + farmerUnion +
                ", roles=" + roles +
                '}';
    }
}
