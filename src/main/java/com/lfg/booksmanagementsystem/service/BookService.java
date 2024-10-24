package com.lfg.booksmanagementsystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfg.booksmanagementsystem.mapper.BookMapper;
import com.lfg.booksmanagementsystem.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends ServiceImpl<BookMapper, Books> {

    public boolean addBook(Books books) {
        return this.save(books);
    }

    public boolean deleteBook(Long id) {
        return this.removeById(id);
    }

    public boolean updateBook(Books books) {
        return this.updateById(books);
    }

    public Books getBookById(Long id) {
        return this.getById(id);
    }

    public List<Books> searchBooksByTitle(String title) {
        return this.lambdaQuery().like(Books::getTitle, title).list();
    }

    public Page<Books> getBooksByPage(int page, int size) {
        return this.page(new Page<>(page, size));
    }
}
