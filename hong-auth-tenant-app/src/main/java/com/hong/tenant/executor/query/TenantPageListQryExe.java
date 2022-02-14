package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.hong.ExecutorI;
import com.hong.dto.TenantPageListQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
        PageRequest pageRequest = PageRequest.of(qry.getPageIndex(), qry.getPageSize());
        Page<TenantDO> page = tenantRepository.findByNameOrCodeOrStatus(qry.getName(), qry.getCode(), qry.getStatus(), pageRequest);
        var list = new ArrayList<TenantDTO>();
        page.getContent().forEach(m -> {
            var dto = new TenantDTO();
            BeanUtils.copyProperties(m, dto);
            list.add(dto);
        });
        return PageResponse.of(list, ((int) page.getTotalElements()), page.getSize(), page.getNumber());
    }
}
