package com.hong.tenant;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * @author chenhongbo
 */
@Data
public class TenantDO {
    private String id;
    private String name;
    private String code;

    /**
     * 状态 1 正常 2 停用
     */
    private Integer status;
    private Boolean deleted;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;
}
