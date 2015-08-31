package cn.demo.mapper;

import cn.demo.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Atom on 2015/8/26.
 */
public interface UserInfoMapper {
    /**
     * ����û���Ϣ
     * @param user �û���Ϣ
     * @return ����Ӱ������
     */
    public int addUser(UserInfo user);

    /**
     * ��������û���Ϣ
     * @return �����û���Ϣ�б�
     */
    public List<UserInfo> getAllUserInfo();

    /**
     * �����û�ID������û���Ϣ
     * @param userId �û�ID
     * @return �����û���Ϣ
     */
    public UserInfo getByUserId(Integer userId);

    public List<UserInfo> queryByUserAttr(UserInfo user);

    /**
     * �����û�ID��ɾ���û���Ϣ
     * @param userId �û�ID
     * @return ����Ӱ������
     */
    public int delUser(Integer userId);

    /**
     * �����û���Ϣ
     * @param user ��������
     * @return ����Ӱ������
     */
    public int updateUser(UserInfo user);



}
