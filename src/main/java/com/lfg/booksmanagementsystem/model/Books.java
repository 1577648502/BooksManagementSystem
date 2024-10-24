package com.lfg.booksmanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Schema
@Data
public class Books {

    @Schema(hidden = true)
    @TableId(type = IdType.ASSIGN_ID) // 使用自定义ID生成策略
    /**
     * 主键
     */
    private String id;
    /**
     * 书籍名称
     */
    @Schema(description = "书籍名称")
    private String title;
    /**
     * 作者
     */
    @Schema(description = "作者")
    private String author;
    /**
     * 出版时间
     */
    @Schema(description = "出版时间")
    private int year;
    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date updateTime;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;
    @Schema(hidden = true)
    @TableLogic
    /**
     * 逻辑删除标识
     */
    private Integer isDelete;
}
