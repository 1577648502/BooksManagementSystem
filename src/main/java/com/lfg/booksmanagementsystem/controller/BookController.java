package com.lfg.booksmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfg.booksmanagementsystem.exception.BusinessException;
import com.lfg.booksmanagementsystem.model.Books;
import com.lfg.booksmanagementsystem.model.dto.BookAddRequest;
import com.lfg.booksmanagementsystem.model.dto.BookUpdateRequest;
import com.lfg.booksmanagementsystem.service.BookService;
import com.lfg.booksmanagementsystem.utils.BaseResponse;
import com.lfg.booksmanagementsystem.utils.ErrorCode;
import com.lfg.booksmanagementsystem.utils.ResultUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Resource
    private BookService bookService;

    /**
     * 添加书籍
     *
     * @param bookAddRequest
     * @return
     */
    @PostMapping
    public BaseResponse<String> addBook(@RequestBody BookAddRequest bookAddRequest) {
        if (bookAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Books books = new Books();
        BeanUtils.copyProperties(bookAddRequest, books);//将bookAddRequest中的属性复制到books中

        boolean result = bookService.addBook(books);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(books.getId());
    }

    /**
     * 删除书籍
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResponse<Long> deleteBook(@PathVariable Long id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        bookService.deleteBook(id);
        return ResultUtils.success(id);
    }

    /**
     * 更新书籍
     *
     * @param id
     * @param bookUpdateRequest
     * @return
     */
    @PutMapping("/{id}")
    public BaseResponse<Boolean> updateBook(@PathVariable String id, @RequestBody BookUpdateRequest bookUpdateRequest) {
        if (id == null || bookUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Books books = new Books();
        books.setId(id);
        BeanUtils.copyProperties(bookUpdateRequest, books);//将bookAddRequest中的属性复制到books中

        boolean result = bookService.updateBook(books);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        return ResultUtils.success(result);
    }

    /**
     * 分页搜索书籍
     *
     * @param id, title, pageNo, pageSize
     * @return
     */
    @GetMapping
    public BaseResponse<IPage<Books>> searchBooks(@RequestParam(required = false) Integer id, @RequestParam(required = false) String title, @RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageSize) {

        return ResultUtils.success(bookService.getBooks(id, title, pageNo, pageSize));
    }

}
