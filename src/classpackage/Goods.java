package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Goods {
    public int store_id;
    public int good_id;
    public String name;
    public String type;
    public double price;
    public int salesnum;

    public static List<Goods> getgoods(int store_id) {//获取某商店的所有商品
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from goods where store_id=?";
        List<Goods> goods = template.query(sql, new RowMapper<Goods>() {
            public Goods mapRow(ResultSet rs, int i) throws SQLException {
                Goods good = new Goods();
                int store_id = rs.getInt("store_id");
                int good_id = rs.getInt("good_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int salesnum = rs.getInt("salesnum");
                good.setStore_id(store_id);
                good.setGood_id(good_id);
                good.setName(name);
                good.setType(type);
                good.setPrice(price);
                good.setSalesnum(salesnum);
                return good;
            }
        }, store_id);
        return goods;
    }

    public static Goods getOneGoods(int good_id) {//获取指定商品号的商品
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from goods where good_id =?";
        Goods goods = template.queryForObject(sql, new RowMapper<Goods>() {
                    public Goods mapRow(ResultSet rs, int i) throws SQLException {
                        Goods good = new Goods();
                        int store_id = rs.getInt("store_id");
                        int good_id = rs.getInt("good_id");
                        String name = rs.getString("name");
                        String type = rs.getString("type");
                        double price = rs.getDouble("price");
                        int salesnum = rs.getInt("salesnum");
                        good.setStore_id(store_id);
                        good.setGood_id(good_id);
                        good.setName(name);
                        good.setType(type);
                        good.setPrice(price);
                        good.setSalesnum(salesnum);
                        return good;
                    }
                }
                , good_id);
        return goods;
    }

    public static List<Goods> getgoods(int store_id, String goodname) {//搜索制定名词的商品
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from goods where store_id = ? and name like ?";
        List<Goods> goods = template.query(sql, new RowMapper<Goods>() {
            public Goods mapRow(ResultSet rs, int i) throws SQLException {
                Goods good = new Goods();
                int store_id = rs.getInt("store_id");
                int good_id = rs.getInt("good_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int salesnum = rs.getInt("salesnum");
                good.setStore_id(store_id);
                good.setGood_id(good_id);
                good.setName(name);
                good.setType(type);
                good.setPrice(price);
                good.setSalesnum(salesnum);
                return good;
            }
        }, store_id, "%" + goodname + "%");
        return goods;
    }

    public static List<Goods> getgoods(int store_id, String goodname, String type) {//搜索指定名称或者品类的商品
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from goods where store_id = ? and (name like ? or type like ?)";
        List<Goods> goods = template.query(sql, new RowMapper<Goods>() {
            public Goods mapRow(ResultSet rs, int i) throws SQLException {
                Goods good = new Goods();
                int store_id = rs.getInt("store_id");
                int good_id = rs.getInt("good_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int salesnum = rs.getInt("salesnum");
                good.setStore_id(store_id);
                good.setGood_id(good_id);
                good.setName(name);
                good.setType(type);
                good.setPrice(price);
                good.setSalesnum(salesnum);
                return good;
            }
        }, store_id, "%" + goodname + "%", "%" + type + "%");
        return goods;
    }

    public static List<Goods> getOrdergoods(String ordernum) {//获取订单中的商品
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from goods where good_id in(select good_id from order_goods where ordernum = ?)";
        List<Goods> goods = template.query(sql, new RowMapper<Goods>() {
            public Goods mapRow(ResultSet rs, int i) throws SQLException {
                Goods good = new Goods();
                int store_id = rs.getInt("store_id");
                int good_id = rs.getInt("good_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int salesnum = rs.getInt("salesnum");
                good.setStore_id(store_id);
                good.setGood_id(good_id);
                good.setName(name);
                good.setType(type);
                good.setPrice(price);
                good.setSalesnum(salesnum);
                return good;
            }
        }, ordernum);
        return goods;
    }

    public static String getGoodsName(int store_id, int good_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select name from goods where store_id=? and good_id =? ";
        String goodsname = template.queryForObject(sql, String.class, store_id, good_id);
        return goodsname;
    }

    public static double getGoodsPrice(int store_id, int good_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select price from goods where store_id=? and good_id =? ";
        double price = template.queryForObject(sql, double.class, store_id, good_id);
        return price;


    }

    public static void main(String[] args) {
        List<Order_goods> ordergoodslist = Order_goods.getOrder_GoodsList("202002051459234184");
        System.out.println(ordergoodslist.get(0).store_id + ordergoodslist.get(0).good_id);

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSalesnum() {
        return salesnum;
    }

    public void setSalesnum(int salesnum) {
        this.salesnum = salesnum;
    }
}

