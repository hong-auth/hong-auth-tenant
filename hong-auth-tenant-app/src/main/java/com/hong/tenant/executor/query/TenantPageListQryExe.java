package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.hong.ExecutorI;
import com.hong.dto.TenantPageListQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author chenhongbo
 */
@Component
@RequiredArgsConstructor
public class TenantPageListQryExe implements ExecutorI<PageResponse<TenantDTO>, TenantPageListQry> {
    private final TenantRepository tenantRepository;

    /**
     * 执行
     *
     * @param qry
     * @return
     */
    @Override
    public PageResponse<TenantDTO> execute(TenantPageListQry qry) {
        
        return null;
    }
}
