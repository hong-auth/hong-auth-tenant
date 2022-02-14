package com.hong.tenant.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.Assert;
import com.hong.ExecutorI;
import com.hong.dto.TenantDeleteCmd;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author chenhongbo
 */
@Component
@RequiredArgsConstructor
public class TenantDeleteCmdExe implements ExecutorI<Response, TenantDeleteCmd> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     *
     * @param cmd
     * @return
     */
    @Override
    public Response execute(TenantDeleteCmd cmd) {
        Optional<TenantDO> optionalTenantDO = tenantRepository.findById(cmd.getId());
        Assert.isTrue(optionalTenantDO.isPresent(), "租户不存在");
        TenantDO tenantDO = optionalTenantDO.get();
        tenantDO.setDeleted(true);
        tenantRepository.save(tenantDO);
        return Response.buildSuccess();
    }
}
