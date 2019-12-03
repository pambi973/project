package com.deepexi.service.rest.api;

import com.deepexi.domain.eo.ApplicationEo;
import com.deepexi.domain.dto.Payload;

import java.util.Map;

/**
 * 描述。
 * <p>
 * <br>==========================
 * <br> 公司：滴普科技
 * <br> 开发：hudong@deepexi.com
 * <br> 版本：1.0
 * <br> 创建时间：2018/4/28 14:08
 * <br>==========================
 */
public interface ApplicationRestService {

//    Payload<ApplicationEo> getApplications(long id);

    Payload  createApplications(Map<String,Object> map);

    Payload findAll();

    Payload detail(Integer  pk);

    Payload update(Integer  pk,ApplicationEo eo);

    Payload create(ApplicationEo eo);

    Payload delete(Long  pk);

    Payload delete(Map<String,Long[]> map);
}
