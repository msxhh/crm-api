package com.crm.service;

import com.crm.common.result.PageResult;
import com.crm.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crm.entity.Department;
import com.crm.query.CustomerQuery;
import com.crm.query.IdQuery;
import com.crm.vo.CustomerVO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.resource.HttpResource;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crm
 * @since 2025-10-12
 */
public interface CustomerService extends IService<Customer> {
    /**
     * 客户列表 - 分页
     * @param query
     * @return
     */
    PageResult<CustomerVO> getPage(CustomerQuery query);

    /**
     * 导出客户信息
     * @param query
     * @param httpResource
     */
    void exportCustomer(CustomerQuery query, HttpServletResponse httpResource);


    /**
     * 保存或更新客户信息
     * @param
     */
    void saveOrUpdate(CustomerVO customerVO);

    /**
     * 删除客户信息
     * @param
     */
    void removeCustomer(List<Integer> ids);

    /**
     * 客户转⼊公海
     * @param idQuery
     */
    void customerToPublicPool(IdQuery idQuery);

    /**
     * 领取客户
     * @param idQuery
     */
    void publicPoolToPrivate(IdQuery idQuery);

}
