package com.javadev.darphewebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/commentForm")
	public String showCommentForm(Model theModel) {
		
		// create the model attribute to bind form data
		Comment theComment = new Comment();
		
		theModel.addAttribute("comment", theComment);
		
		return "darphe/form-comment";
	}
	
	@PostMapping("/saveComment")
	public String createComment(@ModelAttribute("comment") Comment theComment) {
		cRepository.save(theComment);
		
		return "redirect:/darphe/comments";
	}
	
	@GetMapping("/likeForm")
	public String showLikeForm(Model theModel) {
		
		// create the model attribute to bind form data
		Like theLike = new Like();
		
		theModel.addAttribute("like", theLike);
		
		return "darphe/form-like";
	}
	
	@PostMapping("/saveLike")
	public String createLike(@ModelAttribute("like") Like theLike) {
		lRepository.save(theLike);
		 
		return "redirect:/darphe/likes";
	}
}
