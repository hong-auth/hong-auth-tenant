package com.hong.tenant;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author chenhongbo
 */
public interface TenantRepository extends PagingAndSortingRepository<TenantDO, String>, QuerydslPredicateExecutor<TenantDO> {
}
