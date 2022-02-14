package com.hong.dto;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author chenhongbo
 */
@Data
public class TenantPageListQry extends PageQuery {
    private String id;
    private String name;
    private String code;

    /**
     * 状态 1 正常 2 停用
     */
    private Integer status;
}
