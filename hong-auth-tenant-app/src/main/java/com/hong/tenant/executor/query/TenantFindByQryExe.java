package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.hong.ExecutorI;
import com.hong.dto.TenantFindByQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author chenhongbo
 */
@Component
@RequiredArgsConstructor
public class TenantFindByQryExe implements ExecutorI<SingleResponse<TenantDTO>, TenantFindByQry> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     */
    @Override
    public SingleResponse<TenantDTO> execute(TenantFindByQry tenantFindByQry) {
        TenantDO queryDo = new TenantDO();
        if (!StringUtils.isEmpty(tenantFindByQry.getId())) {
            queryDo.setId(tenantFindByQry.getId());
        }
        if (!StringUtils.isEmpty(tenantFindByQry.getCode())) {
            queryDo.setCode(tenantFindByQry.getCode());
        }
        Example<TenantDO> example = Example.of(queryDo);
        Optional<TenantDO> tenantDO = tenantRepository.findOne(example);

        if (tenantDO.isEmpty()) {
            return SingleResponse.of(null);
        }
        var dto = new TenantDTO();
        BeanUtils.copyProperties(tenantDO.get(), dto);
        return SingleResponse.of(dto);
    }
}
