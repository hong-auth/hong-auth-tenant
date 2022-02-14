package com.hong.dto;

import com.alibaba.cola.dto.Command;
import com.hong.dto.data.TenantDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author chenhongbo
 */
@Data
public class TenantAddCmd extends Command {
    @NotNull
    private TenantDTO tenantDTO;
}
