package com.javadev.darphewebapp.service;

import java.util.List;

import com.javadev.darphewebapp.model.Comment;

public interface CommentService {
	public void save(Comment comment); 
	public List<Comment> getAll();
	public Comment getById(int theId);
	public void deleteById(int theId);
}
