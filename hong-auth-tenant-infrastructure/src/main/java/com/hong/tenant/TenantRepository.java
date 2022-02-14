package com.hong.tenant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author chenhongbo
 */
public interface TenantRepository extends PagingAndSortingRepository<TenantDO, String> {
    /**
     * 分页
     */
    Page<TenantDO> findByNameOrCodeOrStatus(String name, String code, Integer status, Pageable pageable);

    /**
     * 查找
     */
    TenantDO findByIdOrCode(String id, String code);
}
