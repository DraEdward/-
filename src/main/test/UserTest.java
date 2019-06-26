import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ahthor Edward Drafy
 * @date 2019/6/25
 */
public class UserTest {
    SqlSessionFactory factory;//设置为全局变量
    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllUser(){

            SqlSession sqlSession = factory.openSession();//sql会话 对话
            List<User> users = sqlSession.selectList("do_select.findAllUser");
            for(User u : users){
                System.out.println(u.getUsername()+","+u.getPASSWORD());
            }

    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setUsername("王华");
        user.setPASSWORD("12223");
        user.setGender("男");

        sqlSession.insert("do_select.addUser",user);
        sqlSession.commit();
    }

    @Test
    public  void testUpdataUser(){
        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setId(2);
        user.setPASSWORD("122222");

        sqlSession.update("do_select.updataUser",user);
        sqlSession.commit();

    }
    @Test
    public void deleteUser(){

    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = factory.openSession();
        List list = new ArrayList();
        list.add(4);

        sqlSession.delete("delete",list);
        sqlSession.commit();
    }

}
