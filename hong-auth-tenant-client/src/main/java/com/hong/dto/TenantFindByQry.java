package com.hong.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

/**
 * @author chenhongbo
 */
@Data
public class TenantFindByQry extends Query {
    private String id;
    private String code;
}
