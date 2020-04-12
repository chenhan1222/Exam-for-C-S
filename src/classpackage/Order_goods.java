package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 * ������Ʒ��
 * ������¼ÿ�������ľ�����Ʒ��Ϣ
 * */
public class Order_goods {
    public String ordernum;//������
    public int store_id;//�̵��
    public int good_id;//��Ʒ��
    public int buynum;//��������

    /**
     * ���¶���-��Ʒ��
     **/
    public static void addorder_goods(String ordernum, int store_id, int good_id, int buynum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into order_goods values(?,?,?,?)";
        template.update(sql, ordernum, store_id, good_id, buynum);

    }

    public static void addorder_goods(String ordernum, List<Order_goods> ordergoodslist) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into order_goods values(?,?,?,?)";
        int size = ordergoodslist.size();
        for (int i = 0; i < size; i++)
            template.update(sql, ordernum, ordergoodslist.get(i).store_id, ordergoodslist.get(i).good_id, ordergoodslist.get(i).buynum);
    }

    public static List<Order_goods> getOrder_GoodsList(String ordernum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from order_goods where ordernum = ?";
        //List<Order_goods> order_goodslist = template.query(sql, new BeanPropertyRowMapper<>(Order_goods.class),ordernum);
        List<Order_goods> order_goodslist = template.query(sql, new RowMapper<Order_goods>() {
            public Order_goods mapRow(ResultSet rs, int i) throws SQLException {
                Order_goods order_goods = new Order_goods();
                String ordernum = rs.getString("ordernum");//������
                int store_id = rs.getInt("store_id");//�̵��
                int good_id = rs.getInt("good_id");//��Ʒ��
                int buynum = rs.getInt("buynum");//��������
                order_goods.setGood_id(good_id);
                order_goods.setBuynum(buynum);
                order_goods.setOrdernum(ordernum);
                order_goods.setStore_id(store_id);
                return order_goods;
            }
        }, ordernum);

        return order_goodslist;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
