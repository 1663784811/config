package cn.cyyaw.admin.table.service;


import cn.cyyaw.admin.table.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cyyaw-service-admin", fallback = AdminServiceFallback.class)
public interface AdminService {

}
