package com.javadev.darphewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.darphewebapp.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
