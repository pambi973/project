package com.deepexi.api;

import com.deepexi.domain.eo.ApplicationEo;

import java.util.Map;

public interface ApplicationService {

    Object createApplication(Map<String,Object> map);

    Integer update(ApplicationEo eo);

    Object create(ApplicationEo eo);

    Object delete(Long pk);

    Object delete(Long[] pks);

}
