package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>
{

}
