package show;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QueryData {
    public Vector<Object> getinfo() {
        Vector<Object> info = new Vector<Object>();
        //定义SQL语句
        String sql = "select id,name,type,stock,price from product_data";
        ResultSet rs;
        try {
            //执行SQL语句
            DBCon db = new DBCon();
            rs = db.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                Vector<String> lineinfo = new Vector<String>();
                lineinfo.add(rs.getString(1));
                lineinfo.add(rs.getString(2));
                lineinfo.add(rs.getString(3));
                lineinfo.add(rs.getString(4));
                lineinfo.add(rs.getString(5));
                info.add(lineinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    public Vector<Object> getid() {
        Vector<Object> info = new Vector<Object>();
        //定义SQL语句
        String sql = "select id from product_data";
        ResultSet rs;
        try {
            //执行SQL语句
            DBCon db = new DBCon();
            rs = db.executeQuery(sql);
            //处理结果集
            while (rs.next()) {
                Vector<String> lineinfo = new Vector<String>();
                lineinfo.add(rs.getString(1));
                lineinfo.add(rs.getString(2));
                lineinfo.add(rs.getString(3));
                lineinfo.add(rs.getString(4));
                lineinfo.add(rs.getString(5));
                info.add(lineinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

}
