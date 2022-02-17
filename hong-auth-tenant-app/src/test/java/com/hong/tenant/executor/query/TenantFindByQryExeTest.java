package com.hong.tenant.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.hong.dto.TenantFindByQry;
import com.hong.dto.data.TenantDTO;
import com.hong.tenant.TenantDO;
import com.hong.tenant.TenantRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;

import java.util.Optional;

public class TenantFindByQryExeTest {
    @Mock
    TenantRepository tenantRepository;
    @InjectMocks
    TenantFindByQryExe tenantFindByQryExe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() {
        SingleResponse<TenantDTO> result = tenantFindByQryExe.execute(new TenantFindByQry());
        Assert.assertNull(result.getData());
        Assert.assertTrue(result.isSuccess());
    }

    @Test
    public void testExecuteReturnData() {
        final String code = "test";

        TenantDO tenantDO = new TenantDO();
        tenantDO.setCode(code);
        Mockito.when(tenantRepository.findOne(Mockito.any()))
                .thenReturn(Optional.of(tenantDO));

        TenantFindByQry qry = new TenantFindByQry();
        qry.setCode(code);
        SingleResponse<TenantDTO> response = tenantFindByQryExe.execute(qry);
        Assert.assertTrue(response.isSuccess());
        Assert.assertNotNull(response.getData());
        Assert.assertEquals(code, response.getData().getCode());
    }
}
