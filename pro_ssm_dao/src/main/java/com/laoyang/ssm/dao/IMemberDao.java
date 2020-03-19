package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Member;
import org.springframework.stereotype.Repository;

//会员Dao
@Repository
public interface IMemberDao {

    /**
     * 根据会员id获取会员信息
     * @param id
     * @return
     */
    Member findById(Integer id);
}
