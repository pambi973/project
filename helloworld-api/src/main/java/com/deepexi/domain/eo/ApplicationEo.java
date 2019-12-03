package com.deepexi.domain.eo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *
 */
@TableName("test_application")
public class ApplicationEo {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String code;

    private String name;

    private Integer status; // 状态 1启用 2禁用

    public ApplicationEo() {
    }

    public ApplicationEo(String code,String name,Integer status) {
        this.name = name;
        this.code = code;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}