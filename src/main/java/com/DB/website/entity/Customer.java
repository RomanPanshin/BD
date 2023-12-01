package com.DB.website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_id")
    private Integer customerId;

    @Column(name = "Branch_id")
    private Integer branchId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Age", nullable = false)
    private Integer age;

    @Column(name = "Profession")
    private String profession;

    @Column(name = "Sex", nullable = false)
    private String sex;

    // Getters and setters


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
