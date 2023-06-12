package com.example.asn2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//sends to the database
public interface UserRepository extends JpaRepository<Users,Integer> {
    List<Users> findByHeight(int height);
    List<Users> findByName(String name);
    List<Users> findByWeight(int weight);
    List<Users> findByGPA(float GPA);
    List<Users> findByHairColor(String hairColor);
    
}