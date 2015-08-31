package cn.demo.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Atom on 2015/8/31.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("conf/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
