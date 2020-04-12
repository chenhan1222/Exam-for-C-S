package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class User {
    public String type;//用户类型
    public String usernum;//用户名
    public String password;//密码
    public String nickname;//昵称
    public String phonenum;//手机号
    public ImageIcon head_sculpture;//头像

    public static void addUserfollow(String usernum, int store_id) {//为客户添加关心的店铺
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into focused_store values(?,?)";
        template.update(sql, usernum, store_id);
    }

    public static void deleteUserfollow(String usernum, int store_id) {//取消关心的店铺
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from focused_store where usernum =? and store_id=?";
        template.update(sql, usernum, store_id);
    }

    public static boolean ifFollow(String usernum, int store_id) {     //判断是否关心了某店铺的函数
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select usernum from focused_store where usernum =? and store_id =?";
        String rs = null;
        try {
            rs = template.queryForObject(sql, String.class, usernum, store_id);
        } catch (EmptyResultDataAccessException e) {
            rs = null;
        }
        if (rs == null)
            return false;
        else
            return true;
    }

    public static List<Store> getYourFollwStores(String usernum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from store where store_id in (select store_id from focused_store where usernum =?)";
        List<Store> stores = template.query(sql, new RowMapper<Store>() {
            public Store mapRow(ResultSet rs, int i) throws SQLException {
                Store store = new Store();
                int store_id = rs.getInt("store_id");
                String name = rs.getString("name");
                double grade = rs.getDouble("grade");
                String notice = rs.getString("notice");
                int monthsale = rs.getInt("salenum");
                String address = rs.getString("address");
                int deliverytime = rs.getInt("deliverytime");
                String storephone = rs.getString("storephone");
                store.setStore_id(store_id);
                store.setName(name);
                store.setGrade(grade);
                store.setNotice(notice);
                store.setSalesnum(monthsale);
                store.setDeliverytime(deliverytime);
                store.setStorephone(storephone);
                store.setAddress(address);
                return store;
            }
        }, usernum);
        return stores;
    }


    public static String getNickname(String usernum) {//获得昵称
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select nickname from user where usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }

    public static String getPhonenum(String usernum) {//获得电话
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select phonenum from user where usernum=?";
        String nickname = template.queryForObject(sql, String.class, usernum);
        return nickname;

    }

    public static String getUserType(String usernum) {//获得用户类型
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select type from user where usernum=?";
        String type = template.queryForObject(sql, String.class, usernum);
        return type;

    }

    public static void updatePersonalInformation(String usernum, String phonenum, String nickname, Image icon) {//修改个人信息
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update user set phonenum=?,nickname=? where usernum= ?";
        template.update(sql, phonenum, nickname, usernum);
        ImageDemo.readImage2DB(usernum, icon);
    }

    public static void main(String[] args) {
        //User.addShoppinglist("ss", 1, 2);
        System.out.println(User.ifFollow("170400327", 1));
        //User.deleteUserfollow("170400327", 1);
    }
}
