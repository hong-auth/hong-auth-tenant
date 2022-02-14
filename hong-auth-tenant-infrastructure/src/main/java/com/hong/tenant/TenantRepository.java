package com.hong.tenant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author chenhongbo
 */
public interface TenantRepository extends PagingAndSortingRepository<TenantDO, String> {
    /**
     * @param name
     * @param code
     * @param status
     * @return
     */
    Page<TenantDO> findByNameOrCodeOrStatus(String name, String code, Integer status, Pageable pageable);
}
