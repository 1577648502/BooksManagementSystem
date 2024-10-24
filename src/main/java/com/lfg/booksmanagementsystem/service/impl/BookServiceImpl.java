package com.lfg.booksmanagementsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfg.booksmanagementsystem.mapper.BookMapper;
import com.lfg.booksmanagementsystem.model.Books;
import com.lfg.booksmanagementsystem.service.BookService;
import org.springframework.stereotype.Service;


@Service

public class BookServiceImpl extends ServiceImpl<BookMapper, Books> implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean addBook(Books books) {
        return bookMapper.insert(books) > 0; // 使用 insert 方法添加书籍
    }

    @Override
    public boolean deleteBook(Long id) {
        Books byId = bookMapper.selectById(id); // 根据ID查询书籍
        if (byId == null) {
            return false; // 如果书籍不存在，返回 false
        }
        return bookMapper.deleteById(id) > 0; // 使用 deleteById 方法删除书籍
    }

    @Override
    public boolean updateBook(Books books) {
        return bookMapper.updateById(books) > 0; // 使用 updateById 方法更新书籍
    }

    @Override
    public IPage<Books> getBooks(Integer id, String title, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        Page<Books> page = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<Books> queryWrapper = new LambdaQueryWrapper<>();

        if (id != null) {
            queryWrapper.eq(Books::getId, id); // 根据 ID 查询
        }
        if (title != null && !title.isEmpty()) {
            queryWrapper.like(Books::getTitle, title); // 根据书名模糊查询
        }

        return bookMapper.selectPage(page, queryWrapper);
    }
}
