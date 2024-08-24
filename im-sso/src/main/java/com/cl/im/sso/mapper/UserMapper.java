package com.cl.im.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cl.im.sso.domain.entity.UserInfo;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

}
