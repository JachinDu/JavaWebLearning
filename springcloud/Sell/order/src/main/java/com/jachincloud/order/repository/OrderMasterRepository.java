package com.jachincloud.order.repository;

import com.jachincloud.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/09/12 16:12
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


}
