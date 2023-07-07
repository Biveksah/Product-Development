package com.example.productdevelopment.Dao;

import com.example.productdevelopment.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository <Contact, Long> {
}
