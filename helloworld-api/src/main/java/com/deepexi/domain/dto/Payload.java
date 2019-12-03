package com.deepexi.domain.dto;

/**
 * 用于返回数据
 *
 * @param <T>
 * @author Jason
 */
public class Payload<T> {

    private Boolean success;
    private String errCode;
    private String errMsg;
    private T data;

    public Payload() {
        super();
    }

    public Payload(T data) {
        super();
        this.data = data;
        this.success = true;
    }

    public Payload(String errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.success = false;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result [success=" + success + ", errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + "]";
    }


}
