package com.deepexi.api.query;

import com.deepexi.domain.dto.Payload;
import com.deepexi.domain.eo.ApplicationEo;

import java.util.Map;

public interface ApplicationQueryService {

    Object findAll();

    Object detail(Integer pk);
}
