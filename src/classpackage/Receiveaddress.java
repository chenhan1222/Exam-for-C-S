package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * * �ջ���ַ��
 **/
public class Receiveaddress {
    public String usernum;
    public String contact;//��ϵ��;
    public String address;//�ջ���ַ
    public String phonenum;//��ϵ�绰
    public String sex;//�Ա�

    public static void addReceiveAddress(Receiveaddress newaddress) {//����ջ��ַ
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into receiveaddress values(?,?,?,?,?)";
        template.update(sql, newaddress.usernum, newaddress.contact, newaddress.address, newaddress.phonenum, newaddress.sex);
    }

    public static List<Receiveaddress> getReceiveAddress(String usernum) {//����ջ��ַ
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from receiveaddress where usernum = ? ";
        List<Receiveaddress> list = template.query(sql, new RowMapper<Receiveaddress>() {
            public Receiveaddress mapRow(ResultSet rs, int i) throws SQLException {
                Receiveaddress receiveaddress = new Receiveaddress();
                String usernum = rs.getString("usernum");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                String phonenum = rs.getString("phonenum");
                String sex = rs.getString("sex");
                receiveaddress.address = address;
                receiveaddress.contact = contact;
                receiveaddress.phonenum = phonenum;
                receiveaddress.sex = sex;
                receiveaddress.usernum = usernum;
                return receiveaddress;
            }
        }, usernum);
        return list;
    }

    public static void updateAddress(Receiveaddress newaddress) {//���µ�ַ
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update receiveaddress set address=?,phonenum=?,sex=? where usernum=? and contact=?";
        template.update(sql, newaddress.address, newaddress.phonenum, newaddress.sex, newaddress.usernum, newaddress.contact);
    }

    public static void deleteAddress(String usernum, String contact) {//ɾ����ַ��ť
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from receiveaddress where usernum=? and contact =?";
        template.update(sql, usernum, contact);
    }

    public static void main(String[] args) {
        String usernum = "1232";
        List<Receiveaddress> list = Receiveaddress.getReceiveAddress(usernum);
        System.out.println(list.get(0).usernum);
    }

}
