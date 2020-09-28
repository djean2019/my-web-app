package com.javadev.darphewebapp.service;

import java.util.List;

import com.javadev.darphewebapp.model.Like;

public interface LikeService {

	public void save(Like like);
	public List<Like> getAll();
	public Like getById();
	public void delete();
	
}
