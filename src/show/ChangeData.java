package show;

public class ChangeData {
    /*public int insertupon(String id,String name,String type,String stock,String price) {
        int i=0;
        String sql="update product_data set name='"+name+"',type='"+type+"',stock='"+stock+"',price='"+price+"' where id='"+id+"'";
        DBCon db=new DBCon();
        i=db.executeUpdate(sql);
        return i;
    }*/
    public int insertupname(String id, String name) {
        int i = 0;
        String sql = "update product_data set name='" + name + "' where id='" + id + "'";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }

    public int insertuptype(String id, String type) {
        int i = 0;
        String sql = "update product_data set type='" + type + "' where id='" + id + "'";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }

    public int insertupstock(String id, String stock) {
        int i = 0;
        String sql = "update product_data set stock='" + stock + "' where id='" + id + "'";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }

    public int insertupprice(String id, String price) {
        int i = 0;
        String sql = "update product_data set price='" + price + "' where id='" + id + "'";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }
}
