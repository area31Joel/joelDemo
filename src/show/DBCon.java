package show;

import java.sql.*;

public class DBCon {
    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;

    public DBCon() {
        //本地MySQL连接
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立数据库的连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "123456");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //阿里云MySQL连接
        /*try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立数据库的连接
            con=DriverManager.getConnection("jdbc:mysql://rm-bp1kw61y09a291xqp4o.mysql.rds.aliyuncs.com/product?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false", "wuhao", "1463165@wh");
            stmt=con.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }*/

    }

    //关闭结果集
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭Statement对象
    public static void closeStatemment(Statement stm) {
        try {
            if (stm != null)
                stm.close();
            stm = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭连接
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && (!conn.isClosed()))
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //返回Connection对象
    public Connection getconn() {
        return con;
    }

    //执行查询语句，返回结果集
    public ResultSet executeQuery(String ssql) {
        try {
            rs = stmt.executeQuery(ssql);
            return rs;
        } catch (SQLException se) {
            System.out.println("DBCon.executeQuery()ERROR:" + se.getMessage());
            return rs;
        }
    }

    //执行数据库的更新，返回int值表示操作影响的记录条数
    public int executeUpdate(String ssql) {
        int iupdate;
        iupdate = 0;
        try {
            iupdate = stmt.executeUpdate(ssql);
            return iupdate;
        } catch (SQLException se) {
            System.out.println("DBCon.executeUpdate()ERROR:" + se.getMessage());
            return iupdate;
        }
    }
}

