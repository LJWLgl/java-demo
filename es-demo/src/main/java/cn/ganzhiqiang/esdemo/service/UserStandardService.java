package cn.ganzhiqiang.esdemo.service;

import cn.ganzhiqiang.esdemo.domain.RoleDO;
import cn.ganzhiqiang.esdemo.domain.UserDO;

import java.util.List;

/**
 * @author zqgan
 * @since 2019/4/20
 **/

public interface UserStandardService {

    void batchAddUser(List<UserDO> users);

    void addUser(UserDO user);

    void deletedUserById(String id);

    void updateUser(UserDO user);

    List<UserDO> queryByUserName(String userName);

    List<UserDO> queryByRoleName(RoleDO role);

}
