package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.hong.ExecutorI;
import com.hong.dto.TenantFindByQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author chenhongbo
 */
@Component
@RequiredArgsConstructor
public class TenantFindByQryExe implements ExecutorI<SingleResponse<TenantDTO>, TenantFindByQry> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     *
     */
    @Override
    public SingleResponse<TenantDTO> execute(TenantFindByQry tenantFindByQry) {
        var tenantDO = tenantRepository.findByIdOrCode(tenantFindByQry.getId(), tenantFindByQry.getCode());
        var dto = new TenantDTO();
        BeanUtils.copyProperties(tenantDO, dto);
        return SingleResponse.of(dto);
    }
}
