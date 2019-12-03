package com.deepexi.service.rpc.query;


import com.deepexi.api.query.ApplicationQueryService;
import com.deepexi.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationQueryServiceImpl implements ApplicationQueryService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public Object findAll() {
        // 分页查询
//        Page<ApplicationEo> page = new Page(1, 10);
//        page.setRecords(applicationMapper.selectApplicationList(page));
//        //为了防止进行条件查询时，数目不正确的问题，所以必须把条件传回去
//        page.setTotal(applicationMapper.selectApplicationList(page).size());
//        return page;
        return applicationMapper.selectList();
    }

    @Override
    public Object detail(Integer pk) {
        return applicationMapper.selectById(pk);
    }

}
