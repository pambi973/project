package com.deepexi.domain.dto;


import com.deepexi.domain.eo.ApplicationEo;

/**
 * 描述
 *
 * @author 管春
 * @date 2017/10/31
 * @since 0.6.0
 */
public class ApplicationDto extends ApplicationEo {

    /**
     * 是否初始化状态 1是 2否
     */
    private Integer initStatus;


    public Integer getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Integer initStatus) {
        this.initStatus = initStatus;
    }

}
