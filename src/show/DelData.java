package show;

public class DelData {
    public int insertinto(String id) {
        int i = 0;
        String sql = "delete from product_data where id=('" + id + "')";
        DBCon db = new DBCon();
        i = db.executeUpdate(sql);
        return i;
    }
}
