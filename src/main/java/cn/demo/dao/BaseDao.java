package cn.demo.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

/**
 * Created by Atom on 2015/8/28.
 */
public class BaseDao extends SqlSessionDaoSupport {

    private Logger log = LoggerFactory.getLogger(BaseDao.class);

    //��springע��ԭ�е�sqlSessionTemplate
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public <T> List<T> selectList(String sqlId){
        return (List<T>) this.getSqlSession().selectList(sqlId);
    }

    public <T> List<T> selectList(String sqlId, Object paramObj){
        return (List<T>) this.getSqlSession().selectList(sqlId, paramObj);
    }

    public <T> List<T> selectList(String sqlId, Object paramObj,RowBounds arg3){
        return (List<T>) this.getSqlSession().selectList(sqlId, paramObj, arg3);
    }

    public <T> T selectOne(String sqlId) {
        return (T) this.getSqlSession().selectOne(sqlId);
    }
    public <T> T selectOne(String sqlId, Object paramObj) {
        return (T) this.getSqlSession().selectOne(sqlId, paramObj);
    }
    public Map selectMap(String arg0,String arg1) {
        return this.getSqlSession().selectMap(arg0, arg1);
    }
    public Map selectMap(String arg0,Object arg1,String arg2) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2);
    }
    public Map selectMap(String arg0,Object arg1,String arg2,RowBounds arg3) {
        return this.getSqlSession().selectMap(arg0, arg1, arg2, arg3);
    }

    public int delete(String sqlId) {
        return this.getSqlSession().delete(sqlId);
    }

    public int delete(String sqlId,Object paramObj) {
        return this.getSqlSession().delete(sqlId, paramObj);
    }

    public int insert(String sqlId,Object paramObj) {
        return this.getSqlSession().insert(sqlId, paramObj);
    }
    public int insert(String sqlId) {
        return this.getSqlSession().insert(sqlId);
    }
    public void select(String sqlId,ResultHandler arg1) {
        this.getSqlSession().select(sqlId, arg1);
    }
    public void select(String sqlId,Object paramObj,ResultHandler arg1) {
        this.getSqlSession().select(sqlId, paramObj,arg1);
    }
    public void select(String sqlId,Object paramObj,RowBounds arg3,ResultHandler arg1) {
        this.getSqlSession().select(sqlId,paramObj,arg3, arg1);
    }

    public int update(String sqlId,Object paramObj) {
        return this.getSqlSession().update(sqlId, paramObj);
    }
    public int update(String sqlId) {
        return this.getSqlSession().update(sqlId);
    }

    /**
     * ��������
     * �����������������£�Ч��û���������ļ��ϵĸߣ�
     * @param statementName
     * @param list
     * @throws DataAccessException
     */
    public void batchUpdate(final String statementName, final List list)throws DataAccessException {
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try{
            if(null != list || list.size() > 0){
                int size = 10000;

                for (int i = 0, n = list.size(); i < n; i++) {
                    this.update(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //�ֶ�ÿ1000��һ�ύ���ύ���޷��ع�
                        session.commit();
                        //�����棬��ֹ���
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log.isDebugEnabled()) {
                e.printStackTrace();
                log.debug("batchUpdate error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    /**
     * ��������
     * �����������������루Ч��û���������ļ��ϵĸߣ�
     * @param statementName
     * @param list
     * @throws DataAccessException
     */
    public void batchInsert(final String statementName, final List list)  throws DataAccessException{
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        try{
            if(null != list || list.size() > 0){
                int size = 10000;

                for (int i = 0, n = list.size(); i < n; i++) {
                    this.insert(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //�ֶ�ÿ1000��һ�ύ���ύ���޷��ع�
                        session.commit();
                        //�����棬��ֹ���
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log.isDebugEnabled()) {
                e.printStackTrace();
                log.debug("batchInsert error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    /**
     * ����ɾ��
     * ��������������ɾ����Ч��û���������ļ��ϵĸߣ�
     * @param statementName
     * @param list
     * @throws DataAccessException
     */
    public void batchDelete(final String statementName, final List list)  throws DataAccessException{
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);

        int size = 10000;
        try{
            if(null != list || list.size() > 0){
                for (int i = 0, n = list.size(); i < n; i++) {
                    this.delete(statementName, list.get(i));
                    if (i % 1000 == 0 || i == size - 1) {
                        //�ֶ�ÿ1000��һ�ύ���ύ���޷��ع�
                        session.commit();
                        //�����棬��ֹ���
                        session.clearCache();
                    }
                }
            }
        }catch (Exception e){
            session.rollback();
            if (log.isDebugEnabled()) {
                e.printStackTrace();
                log.debug("batchDelete error: id [" + statementName + "], parameterObject [" + list + "].  Cause: " + e.getMessage());
            }
        } finally {
            session.close();
        }
    }



}
