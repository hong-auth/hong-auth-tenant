package com.hong.tenant.executor;

import com.alibaba.cola.dto.Response;
import com.hong.ExecutorI;
import com.hong.dto.TenantAddCmd;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author chenhongbo
 */
@Component
@RequiredArgsConstructor
public class TenantAddCmdExe implements ExecutorI<Response, TenantAddCmd> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     *
     * @param cmd
     * @return
     */
    @Override
    public Response execute(TenantAddCmd cmd) {
        TenantDO tenantDO = new TenantDO();
        BeanUtils.copyProperties(cmd.getTenantDTO(), tenantDO);
        tenantRepository.save(tenantDO);

        return Response.buildSuccess();
    }
}
