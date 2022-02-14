package com.hong.dto;

import com.alibaba.cola.dto.Command;
import com.hong.dto.data.TenantDTO;
import lombok.Data;

/**
 * @author chenhongbo
 */
@Data
public class TenantUpdateCmd extends Command {
    private TenantDTO tenantDTO;
}
