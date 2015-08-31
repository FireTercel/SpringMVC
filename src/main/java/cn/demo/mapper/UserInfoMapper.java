package cn.demo.mapper;

import cn.demo.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Atom on 2015/8/26.
 */
public interface UserInfoMapper {
    /**
     * 添加用户信息
     * @param user 用户信息
     * @return 返回影响行数
     */
    public int addUser(UserInfo user);

    /**
     * 获得所有用户信息
     * @return 返回用户信息列表
     */
    public List<UserInfo> getAllUserInfo();

    /**
     * 根据用户ID，获得用户信息
     * @param userId 用户ID
     * @return 返回用户信息
     */
    public UserInfo getByUserId(Integer userId);

    public List<UserInfo> queryByUserAttr(UserInfo user);

    /**
     * 根据用户ID，删除用户信息
     * @param userId 用户ID
     * @return 返回影响行数
     */
    public int delUser(Integer userId);

    /**
     * 更新用户信息
     * @param user 更新内容
     * @return 返回影响行数
     */
    public int updateUser(UserInfo user);



}
