package com.lfg.booksmanagementsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfg.booksmanagementsystem.mapper.BookMapper;
import com.lfg.booksmanagementsystem.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService extends IService<Books> {


    boolean addBook(Books books);

    boolean deleteBook(Long id);

    boolean updateBook(Books books);

    IPage<Books> getBooks(Integer id, String title, Integer pageNo, Integer pageSize);
}
