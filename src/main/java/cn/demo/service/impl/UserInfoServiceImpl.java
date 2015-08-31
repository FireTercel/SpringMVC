package cn.demo.service.impl;

import cn.demo.mapper.UserInfoMapper;
import cn.demo.entity.UserInfo;
import cn.demo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Atom on 2015/8/26.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource(name="userInfoMapper")
    private UserInfoMapper userInfoMapper;

    public boolean addUser(UserInfo user) {

        int count = userInfoMapper.addUser(user);
        if ( count > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userInfoMapper.getAllUserInfo();
    }

    @Override
    public UserInfo getByUserId(Integer userId) {
        return userInfoMapper.getByUserId(userId);
    }

    public List<UserInfo> queryByUserAttr(UserInfo user){
        return userInfoMapper.queryByUserAttr(user);
    }

    @Override
    public boolean delUser(Integer userId) {
        int count = userInfoMapper.delUser(userId);
        if( count > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(UserInfo user) {
        int count = userInfoMapper.updateUser(user);
        if(count > 0){
            return true;
        }
        return false;
    }

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }
}
