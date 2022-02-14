package com.hong.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.hong.dto.*;
import com.hong.dto.data.TenantDTO;

/**
 * @author chenhongbo
 */
public interface TenantServiceI {
    /**
     * 添加租户
     *
     * @param cmd
     * @return
     */
    Response addTenant(TenantAddCmd cmd);

    /**
     * 更新租户
     *
     * @param cmd
     * @return
     */
    Response updateTenant(TenantUpdateCmd cmd);

    /**
     * 删除租户
     *
     * @param cmd
     * @return
     */
    Response deleteTenant(TenantDeleteCmd cmd);

    /**
     * 分页
     *
     * @param qry
     * @return
     */
    PageResponse<TenantDTO> pageList(TenantPageListQry qry);

    /**
     * 获取
     *
     * @param qry
     * @return
     */
    SingleResponse<TenantDTO> findById(TenantFindByQry qry);
}
