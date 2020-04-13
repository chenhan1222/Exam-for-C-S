package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author zjj
 */
/*
 	用户评价类
 */
public class Evaluate {
    public String ordernum;//订单号
    public String nickname;//用户的昵称
    public String comment;//评论
    public double grade;//评分
    public String reply;//商家回复
    public static void addEvaluate(Evaluate a) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into evaluate values(?,?,?,?,?)";
        template.update(sql, a.ordernum, a.nickname, a.comment, a.grade, null);
    }

    public static void modifyEvaluate(String ordernum, String reply) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update evaluate set reply =? where ordernum=?";
        template.update(sql, reply, ordernum);
    }

    public static List<Evaluate> getEvaluate(int store_id) {    //获取某商店的评论
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from evaluate natural join userorder where store_id =?";
        List<Evaluate> storeevaluates = template.query(sql.toString(), new BeanPropertyRowMapper<Evaluate>(Evaluate.class), store_id);
        return storeevaluates;
    }

    public static Evaluate getEvaluate(String ordernum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from evaluate where ordernum =?";
        Evaluate evaluate = template.queryForObject(sql, Evaluate.class, ordernum);
        return evaluate;
    }

    public static boolean ifEvaluate(String ordernum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select ordernum from evaluate where ordernum=?";
        try {
            template.queryForObject(sql, String.class, ordernum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int countEvaluateNum(int store_id) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(*) from evaluate natural join userorder where store_id =?";
        int count = template.queryForObject(sql, int.class, store_id);
        return count;
    }

    public static String getNikename(String ordernum) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select nickname from user where usernum = (select usernum from userorder where ordernum =? ) ";
        String nickname = template.queryForObject(sql, String.class, ordernum);
        return nickname;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}