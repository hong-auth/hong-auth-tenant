package com.hong.tenant;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.hong.api.TenantServiceI;
import com.hong.dto.*;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.executor.TenantAddCmdExe;
import com.hong.tenant.executor.TenantDeleteCmdExe;
import com.hong.tenant.executor.TenantUpdateCmdExe;
import com.hong.tenant.executor.query.TenantFindByQryExe;
import com.hong.tenant.executor.query.TenantPageListQryExe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author chenhongbo
 */
@Service
@CatchAndLog
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantServiceI {
    private final TenantAddCmdExe tenantAddCmdExe;
    private final TenantUpdateCmdExe tenantUpdateCmdExe;
    private final TenantDeleteCmdExe tenantDeleteCmdExe;
    private final TenantPageListQryExe tenantPageListQryExe;
    private final TenantFindByQryExe tenantFindByQryExe;

    /**
     * 添加租户
     */
    @Override
    public Response addTenant(TenantAddCmd cmd) {
        return tenantAddCmdExe.execute(cmd);
    }

    /**
     * 更新租户信息
     */
    @Override
    public Response updateTenant(TenantUpdateCmd cmd) {
        return tenantUpdateCmdExe.execute(cmd);
    }

    /**
     * 删除租户
     */
    @Override
    public Response deleteTenant(TenantDeleteCmd cmd) {
        return tenantDeleteCmdExe.execute(cmd);
    }

    /**
     * 分页
     */
    @Override
    public PageResponse<TenantDTO> pageList(TenantPageListQry qry) {
        return tenantPageListQryExe.execute(qry);
    }

    /**
     * 获取
     */
    @Override
    public SingleResponse<TenantDTO> findById(TenantFindByQry qry) {
        return tenantFindByQryExe.execute(qry);
    }
}
