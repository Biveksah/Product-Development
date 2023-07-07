package com.example.productdevelopment.Dao;


import com.example.productdevelopment.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
