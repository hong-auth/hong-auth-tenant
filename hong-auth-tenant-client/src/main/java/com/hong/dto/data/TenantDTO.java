package com.hong.dto.data;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author chenhongbo
 */
@Data
public class TenantDTO {
    private String id;
    private String name;
    private String code;

    /**
     * 状态 1 正常 2 停用
     */
    private Integer status;
    private Boolean deleted;
    private LocalDateTime createdTime;
    private LocalDateTime lastUpdatedTime;
}
