package com.lfg.booksmanagementsystem.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

import java.util.Date;

@Data
public class Books {

    @TableId(type = IdType.ASSIGN_ID) // 使用自定义ID生成策略
    private String id;
    private String title;
    private String author;
    private int year;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;
    @TableLogic
    private Integer isDelete; // 逻辑删除标识
}
