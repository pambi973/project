package com.deepexi.service.rest;

import com.deepexi.api.ApplicationService;
import com.deepexi.api.query.ApplicationQueryService;
import com.deepexi.domain.eo.ApplicationEo;
import com.deepexi.domain.dto.Payload;
import com.deepexi.service.rest.api.ApplicationRestService;
import com.github.optimus.constant.ContentType;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.util.Map;

@Service
@Path("/api/v1/applications")
@Api(value = "/applications", description = "Operations about applications")
@Consumes({ContentType.APPLICATION_JSON_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public class ApplicationRestServiceImpl implements ApplicationRestService {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationQueryService applicationQueryService;

    @Override
    @POST
    @Path("/")
    @ApiOperation(value = "一个测试API", notes = "第一个测试api测试GET请求")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "int", required = true, value = "应用id", defaultValue = "1")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"), @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    public Payload createApplications(Map<String,Object> map) {
        return new Payload(applicationService.createApplication(map));
    }

    @Override
    @GET
    @Path("/")
    public Payload findAll() {
        return  new Payload(applicationQueryService.findAll());
    }

    @Override
    @GET
    @Path("/{id}")
    public Payload detail(@PathParam("id") Integer id) {
        return  new Payload(applicationQueryService.detail(id));
    }

    @Override
    @PUT
    @Path("/{id}")
    public Payload update(@PathParam("id") Integer id,ApplicationEo eo) {
        eo.setId(Long.valueOf(id));
        return  new Payload(applicationService.update(eo));
    }

    @Override
    @POST
    @Path("/")
    public Payload create(ApplicationEo eo) {
        return  new Payload(applicationService.create(eo));
    }

    @Override
    @DELETE
    @Path("/{id}")
    public Payload delete(@PathParam("id") Long id) {
        return  new Payload(applicationService.delete(id));
    }

    @Override
    @DELETE
    @Path("/")
    public Payload delete(Map<String,Long[]> map) {
        Long[] list = map.get("rows");
        if (list.length==0){
            return new Payload(false);
        }
        return new Payload(applicationService.delete(list));
    }
}
