package com.deepexi.mapper;

import com.deepexi.domain.eo.ApplicationEo;
import com.deepexi.domain.dto.ApplicationDto;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ApplicationMapper extends BaseMapper<ApplicationEo> {


//    @Select({"SELECT * FROM test_application WHERE status =#{status}"})
//    List<ApplicationEo> selectApplicationList(Pagination page, Integer status);//帶條件查詢

    @Select({"SELECT * FROM test_application"})
    List<ApplicationEo> selectApplicationList(Pagination page);

    @Select({"delete from test_application where id in (${ids})"})
    @Transactional
    void deleteByPks(@Param("ids")String ids);

    @Select({"<script>", "SELECT b.* FROM us_r_user_application  a",
            " INNER JOIN us_application b on b.id = a.application_id",
            " WHERE a.user_id = #{userId}",
            "</script>"})
    List<ApplicationDto> selectListByUserId(@Param("userId") Long userId);

    List<ApplicationEo> selectList();
//
//    @Select({"<script>", "SELECT u.*",
//            " FROM us_application u inner join us_r_user_application t ON u.id = t.application_id ",
//            " WHERE 1 = 1",
//            "<when test='userId != null'>", " AND t.user_id =#{userId}", "</when>",
//            "<when test='applicationEo != null'>",
//            "<when test='applicationEo.code != null'>", " AND u.code = #{applicationEo.code}", "</when>",
//            "<when test='applicationEo.tenantId != null'>", " AND u.tenant_id = #{applicationEo.tenantId}", "</when>",
//            "<when test='applicationEo.status != null'>", " AND u.org_id = #{applicationEo.status}", "</when>",
//            "<when test='applicationEo.id != null'>", " AND u.id = #{applicationEo.id}", "</when>",
//            "<when test='applicationEo.name != null'>", " AND u.name like '%${applicationEo.name}%'", "</when>",
//            "</when>",
//            " GROUP BY u.id ",
//            " ORDER BY u.create_time desc ",
//            "</script>"})
//    List<ApplicationEo> selectList(@Param("userId") Long userId, @Param("applicationEo") ApplicationEo applicationEo);

}