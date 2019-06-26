package controller;

import dao.pointMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Point;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;
import java.util.List;

/**
 * @ahthor Edward Drafy
 * @date 2019/6/25
 */
public class PointController extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据库，得到数据
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
                inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
                e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();//打开sql会话
        pointMapper pointMap = sqlSession.getMapper(pointMapper.class);//反射原理创建对象

        List<Point> points = pointMap.selectPoint();

        //给用户返回网页
        request.setAttribute("p",points);
        request.getRequestDispatcher("Point.jsp").forward(request,response);//转发网页
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }



}
