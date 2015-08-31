package cn.demo.service;

import cn.demo.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Atom on 2015/8/26.
 */
public interface UserInfoService {

    public boolean addUser(UserInfo user);

    public List<UserInfo> getAllUserInfo();

    public UserInfo getByUserId(Integer userId);

    public List<UserInfo> queryByUserAttr(UserInfo user);

    public boolean delUser(Integer userId);

    public boolean updateUser(UserInfo user);
}
