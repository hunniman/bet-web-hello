package com.bet.repository;


import com.bet.domain.UserInfo;

import java.util.List;

/**
 * 自定义数据库操作接口，实现一些复杂的查询
 * Created by pengweiyuan on 16/06/2017.
 */
public interface UserRepositoryCustom {
    List<UserInfo> findAllAndOrder();
}
