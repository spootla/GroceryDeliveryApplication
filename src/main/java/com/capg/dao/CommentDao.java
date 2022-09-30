package com.capg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
