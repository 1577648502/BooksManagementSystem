package com.lfg.booksmanagementsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lfg.booksmanagementsystem.exception.BusinessException;
import com.lfg.booksmanagementsystem.model.Books;
import com.lfg.booksmanagementsystem.model.dto.BookAddRequest;
import com.lfg.booksmanagementsystem.model.dto.BookUpdateRequest;
import com.lfg.booksmanagementsystem.service.BookService;
import com.lfg.booksmanagementsystem.utils.BaseResponse;
import com.lfg.booksmanagementsystem.utils.ErrorCode;
import com.lfg.booksmanagementsystem.utils.ResultUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@Tag(name = "")
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
    @Operation(summary = "添加书籍", description = "添加书籍")
    @PostMapping
    public BaseResponse<String> addBook(@RequestBody BookAddRequest bookAddRequest) {
        if (bookAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数错误");
        }
        Books books = new Books();
        BeanUtils.copyProperties(bookAddRequest, books);//将bookAddRequest中的属性复制到books中

        boolean result = bookService.addBook(books);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "添加失败");
        }
        return ResultUtils.success(books.getTitle() + "添加成功");
    }

    /**
     * 删除书籍
     *
     * @param id
     * @return
     */
    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除书籍", description = "删除书籍")
    @DeleteMapping("/{id}")
    public BaseResponse<String> deleteBook(@PathVariable Long id) {
        if (id == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean book = bookService.deleteBook(id);
        if (!book) {
            return ResultUtils.error(ErrorCode.OPERATION_ERROR, "删除失败,书籍不存在");
        }
        return ResultUtils.success(id + "删除成功");
    }

    /**
     * 更新书籍
     *
     * @param id
     * @param bookUpdateRequest
     * @return
     */
    @Parameter(name = "id", description = "", in = ParameterIn.PATH, required = true)
    @Operation(summary = "更新书籍", description = "更新书籍")
    @PutMapping("/{id}")
    public BaseResponse<String> updateBook(@PathVariable String id, @RequestBody BookUpdateRequest bookUpdateRequest) {
        if (id == null || bookUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Books books = new Books();
        books.setId(id);
        BeanUtils.copyProperties(bookUpdateRequest, books);//将bookAddRequest中的属性复制到books中

        boolean result = bookService.updateBook(books);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "更新失败");
        }
        return ResultUtils.success("更新成功");
    }

    /**
     * 分页搜索书籍
     *
     * @param id, title, pageNo, pageSize
     * @return
     */
    @Parameters({
            @Parameter(name = "id", description = "", in = ParameterIn.QUERY),
            @Parameter(name = "title", description = "", in = ParameterIn.QUERY),
            @Parameter(name = "pageNo", description = "", in = ParameterIn.QUERY),
            @Parameter(name = "pageSize", description = "", in = ParameterIn.QUERY)
    })
    @Operation(summary = "分页搜索书籍", description = "分页搜索书籍")
    @GetMapping
    public BaseResponse<IPage<Books>> searchBooks(@RequestParam(required = false) Integer id, @RequestParam(required = false) String title, @RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageSize) {

        return ResultUtils.success(bookService.getBooks(id, title, pageNo, pageSize));
    }

}
