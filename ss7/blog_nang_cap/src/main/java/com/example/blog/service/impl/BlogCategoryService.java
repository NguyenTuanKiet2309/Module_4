package com.example.blog.service.impl;

import com.example.blog.model.Category;
import com.example.blog.repository.IBlogCategoryRepository;
import com.example.blog.service.IBlogCatogoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryService implements IBlogCatogoryService {
    @Autowired
    private IBlogCategoryRepository blogCategoryRepository;

    @Override
    public List<Category> getCategory() {
        return this.blogCategoryRepository.findAll();
    }
}
