package com.deepexi.service.rpc;


import com.deepexi.api.ApplicationService;
import com.deepexi.domain.eo.ApplicationEo;
import com.deepexi.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public Object createApplication(Map<String, Object> map) {
        ApplicationEo applicationEo = new ApplicationEo(map.get("name").toString(),map.get("code").toString(),Integer.valueOf(map.get("status").toString()));
         applicationMapper.insert(applicationEo);
//        applicationMapper.selectById(Integer.valueOf(map.get("status").toString()));
        return "success";
    }

    @Override
    public Object create(ApplicationEo eo) {
        return applicationMapper.insert(eo);
    }

    @Override
    public Integer update(ApplicationEo eo) {
        return applicationMapper.updateById(eo);
    }

    @Override
    public Object delete(Long pk) {
        return applicationMapper.deleteById(pk);
    }

    @Override
    public Object delete(Long[] pks) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pks.length; i++) {
            sb.append(pks[i]);
            if ((i + 1) != pks.length) {
                sb.append(",");
            }
        }
        String _pks = sb.toString();
        applicationMapper.deleteByPks(_pks);
        return true;
    }

}
