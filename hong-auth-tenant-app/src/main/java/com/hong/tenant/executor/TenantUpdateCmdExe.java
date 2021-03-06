package com.hong.tenant.executor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.Assert;
import com.hong.ExecutorI;
import com.hong.dto.TenantUpdateCmd;
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
public class TenantUpdateCmdExe implements ExecutorI<Response, TenantUpdateCmd> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     *
     * @param cmd
     * @return
     */
    @Override
    public Response execute(TenantUpdateCmd cmd) {
        String id = cmd.getTenantDTO().getId();
        Optional<TenantDO> optionalTenantDO = tenantRepository.findById(id);
        Assert.isTrue(optionalTenantDO.isPresent(), "租户不存在");
        TenantDO tenantDO = optionalTenantDO.get();
        BeanUtil.copyProperties(cmd.getTenantDTO(), tenantDO, CopyOptions.create().ignoreNullValue());
        tenantRepository.save(tenantDO);

        return Response.buildSuccess();
    }
}
