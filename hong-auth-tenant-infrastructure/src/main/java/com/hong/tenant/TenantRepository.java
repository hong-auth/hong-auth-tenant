package com.hong.tenant;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author chenhongbo
 */
public interface TenantRepository extends MongoRepository<TenantDO, String> {
    /**
     * 查找
     */
    Optional<TenantDO> findByIdOrCode(String id, String code);
}
