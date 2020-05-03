package cn.cyyaw.admin.table.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "cyyaw-service-admin")
public interface AdminService {

    @RequestMapping(value = "/admin/table/findAllTAdmin", method = RequestMethod.GET)
    String findAllTAdmin();
}
