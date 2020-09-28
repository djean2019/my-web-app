package com.javadev.darphewebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javadev.darphewebapp.model.Comment;
import com.javadev.darphewebapp.model.Like;
import com.javadev.darphewebapp.repository.CommentRepository;
import com.javadev.darphewebapp.repository.LikeRepository;

@Controller
@RequestMapping("/darphe")
public class CommentController {

	private CommentRepository cRepository;
	private LikeRepository lRepository;
	 
	@Autowired
	public CommentController(CommentRepository cRepository, LikeRepository lRepository) {
		this.cRepository = cRepository;
		this.lRepository = lRepository;
	}

	@GetMapping("/home")
	public String display(Model theModel) {
		    
		return "darphe/home-page";
	}
	
	@GetMapping("/comments")
	public String showComments(Model theModel) {
		List<Comment> comments = cRepository.findAll();
		
		theModel.addAttribute("comments",comments); 
		 
		return "darphe/comments";
	}   
	 
	@GetMapping("/likes")
	public String showLikes(Model theModel) {
		List<Like> likes = lRepository.findAll();
		theModel.addAttribute("likes",likes);
		return "darphe/likes";
	}
 	 
	@GetMapping("/resume")
	public String showResume(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		 
		return "darphe/resume";
	}
}
