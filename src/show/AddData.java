package show;

public class AddData {
    public int insertinfo(String id, String name, String type, String stock, String price) {
        int i = 0;
        String sql = "insert into product_data values('" + id + "','" + name + "','" + type + "','" + stock + "','" + price + "')";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }
}
