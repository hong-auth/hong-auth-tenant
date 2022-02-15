package com.hong.web;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.hong.api.TenantServiceI;
import com.hong.dto.*;
import com.hong.dto.data.TenantDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenhongbo
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tenant")
public class TenantController {
    private final TenantServiceI tenantService;

    @GetMapping("")
    public PageResponse<TenantDTO> pageList(TenantPageListQry qry) {
        return tenantService.pageList(qry);
    }

    @GetMapping("/")
    public SingleResponse<TenantDTO> findById(TenantFindByQry qry) {
        return tenantService.findById(qry);
    }

    @GetMapping("/{id}")
    public SingleResponse<TenantDTO> findById(@PathVariable("id") String id, TenantFindByQry qry) {
        qry.setId(id);
        return tenantService.findById(qry);
    }

    @PostMapping("")
    public Response addTenant(@RequestBody TenantAddCmd cmd) {
        return tenantService.addTenant(cmd);
    }

    @PutMapping("/{id}")
    public Response updateTenant(@PathVariable("id") String id, @RequestBody TenantUpdateCmd cmd) {
        cmd.getTenantDTO().setId(id);
        return tenantService.updateTenant(cmd);
    }

    @DeleteMapping("/{id}")
    public Response deleteTenant(@PathVariable("id") String id) {
        TenantDeleteCmd cmd = new TenantDeleteCmd();
        cmd.setId(id);
        return tenantService.deleteTenant(cmd);
    }
}
