package com.openclassrooms.dataLayer.service;

import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/***
 "Created by Moinahadidja Mohamed Chakir on "15/10/2022
 */

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments(){
        return  commentRepository.findAll();
    }

    public Comment getCommentById(Integer id){
        return commentRepository.findById(id).get();
    }

    public Comment saveComment(Comment c){
        return commentRepository.save(c);
    }

    public void deleteCommentById(int id){
        commentRepository.deleteById(id);
    }

    public Iterable<Comment> getCommentByContentContaining(String s){
        return commentRepository.findByContentContaining(s);
    }
}
