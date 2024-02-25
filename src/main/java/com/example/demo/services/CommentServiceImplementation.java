package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Comments;
import com.example.demo.repositories.CommentRepository;

public class CommentServiceImplementation implements CommentService
{

	@Autowired
	CommentRepository commentRepo;
	@Override
	public List<Comments> commentList() {
		return commentRepo.findAll();
	}
	@Override
	public String addComment(Comments comment) {
		commentRepo.save(comment);
		return "comment added";
	}
}
