package com.im.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.im.sso.domain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

}
