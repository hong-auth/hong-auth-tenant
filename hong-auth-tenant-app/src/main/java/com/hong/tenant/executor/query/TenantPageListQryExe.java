package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.hong.ExecutorI;
import com.hong.dto.TenantPageListQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
        PageRequest pageRequest = PageRequest.of(qry.getPageIndex() - 1, qry.getPageSize());
        TenantDO query = new TenantDO();
        if (!StringUtils.isEmpty(qry.getName())) {
            query.setName(qry.getName());
        }
        if (!StringUtils.isEmpty(qry.getCode())) {
            query.setCode(qry.getCode());
        }
        if (qry.getStatus() != null && qry.getStatus() > 0) {
            query.setStatus(qry.getStatus());
        }
        query.setDeleted(false);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains)
                .withMatcher("code", ExampleMatcher.GenericPropertyMatcher::contains);
        Example<TenantDO> example = Example.of(query, exampleMatcher);

        Page<TenantDO> page = tenantRepository.findAll(example, pageRequest);

        var list = new ArrayList<TenantDTO>();
        page.getContent().forEach(m -> {
            var dto = new TenantDTO();
            BeanUtils.copyProperties(m, dto);
            list.add(dto);
        });
        return PageResponse.of(list, ((int) page.getTotalElements()), page.getSize(), page.getNumber());
    }
}
