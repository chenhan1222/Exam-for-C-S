package classpackage;

import JDBCUtil.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Userorder {
    public String ordernum;//������Ψһ
    public int store_id;//�̼ұ��Ψһ��ʶ
    public String usernum;//�����������û����˺ţ�Ψһ
    public String contact;//��ϵ��
    public String phonenum;//�绰��
    public String address;//��ϵ�˵�ַ
    // 	public String goodsname;//�������Ʒ��
    // 	public double totalprice;//��Ʒ�ܼ�
    public String note;//��ע
    public String buytime;//�µ�ʱ��
    //public String servicetime;//Ԥ���ʹ�ʱ��
    public String orderstatus;//����״̬

    public static List<Userorder> getAllUserorder(String usernum) {  //���ĳ�û���ȫ������
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where usernum = ?";
        List<Userorder> userorderlist = template.query(sql.toString(), new BeanPropertyRowMapper<Userorder>(Userorder.class), usernum);
        return userorderlist;
    }

    public static List<Userorder> getStoreOrder(int store_id) {  //���ĳ�̵��ȫ������
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where store_id = ? ";
        List<Userorder> userorderlist = template.query(sql.toString(), new BeanPropertyRowMapper<Userorder>(Userorder.class), store_id);
        return userorderlist;
    }

    public static List<Userorder> getStoreOneDayOrder(int store_id) {  //����̵�ĳ���ȫ������
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataStr = dateFormat.format(new Date());
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where store_id = ? and ordernum like ?";
        List<Userorder> userorderlist = template.query(sql, new RowMapper<Userorder>() {
            public Userorder mapRow(ResultSet rs, int i) throws SQLException {
                Userorder userorder = new Userorder();
                String ordernum = rs.getString("ordernum");//������
                String contact = rs.getString("contact");//��ϵ��
                String phonenum = rs.getString("phonenum");//�绰��
                String address = rs.getString("address");//��ϵ�˵�ַ
                int store_id = rs.getInt("store_id");//�̼���
                String note = rs.getString("note");
                String buytime = rs.getString("buytime");//�µ�ʱ��
                String orderstatus = rs.getString("orderstatus");//����״̬
                String usernum = rs.getString("usernum");      //�û���
                userorder.setOrdernum(ordernum);
                userorder.setContact(contact);
                userorder.setPhonenum(phonenum);
                userorder.setAddress(address);
                userorder.setStore_id(store_id);
                userorder.setOrderstatus(orderstatus);
                userorder.setBuytime(buytime);
                userorder.setNote(note);
                userorder.setUsernum(usernum);
                return userorder;
            }
        }, store_id, "%" + dataStr + "%");
        return userorderlist;
    }

    public static List<Userorder> getUserorder(String usernum, String X, String Y) {  //�û����ָ���Ķ���
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where usernum = ? and " + X + " = ?";
        List<Userorder> userorderlist = template.query(sql, new RowMapper<Userorder>() {
            public Userorder mapRow(ResultSet rs, int i) throws SQLException {
                Userorder userorder = new Userorder();
                String ordernum = rs.getString("ordernum");//������
                String contact = rs.getString("contact");//��ϵ��
                String phonenum = rs.getString("phonenum");//�绰��
                String address = rs.getString("address");//��ϵ�˵�ַ
                int store_id = rs.getInt("store_id");//�̼���
                String note = rs.getString("note");
                String buytime = rs.getString("buytime");//�µ�ʱ��
                String orderstatus = rs.getString("orderstatus");//����״̬
                String usernum = rs.getString("usernum");      //�û���
                userorder.setOrdernum(ordernum);
                userorder.setContact(contact);
                userorder.setPhonenum(phonenum);
                userorder.setAddress(address);
                userorder.setStore_id(store_id);
                userorder.setOrderstatus(orderstatus);
                userorder.setBuytime(buytime);
                userorder.setNote(note);
                userorder.setUsernum(usernum);
                return userorder;
            }
        }, usernum, Y);
        return userorderlist;
    }

    public static List<Userorder> getStoreOrder(int store_id, String X, String Y) {  //�������ָ���Ķ���
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where store_id = ? and " + X + " = ?";
        List<Userorder> userorderlist = template.query(sql.toString(), new BeanPropertyRowMapper<Userorder>(Userorder.class), store_id, Y);
        return userorderlist;
    }

    public static List<Userorder> getStoreOrderSortByData(int store_id) {  //������ð���������Ķ���
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where store_id = ? order by ordernum DESC";
        List<Userorder> userorderlist = template.query(sql.toString(), new BeanPropertyRowMapper<Userorder>(Userorder.class), store_id);
        return userorderlist;
    }

    public static int getDayAllOrderSaleNum(int store_id) {  //�������ĳ����ڵĶ�����
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataStr = dateFormat.format(new Date());
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(ordernum) from userorder where ordernum like ?";
        int daysalesnum;
        try {
            daysalesnum = template.queryForObject(sql, int.class, "%" + dataStr + "%");
        } catch (NullPointerException e) {
            daysalesnum = 0;
        }
        return daysalesnum;
    }

    public static int getDayFinishOrderSaleNum(int store_id) {  //�������ĳ���������ɵĶ�����
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataStr = dateFormat.format(new Date());
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(ordernum) from userorder where store_id = ? and ordernum like ? and orderstatus in(?,?)";
        int daysalesnum;
        try {
            daysalesnum = template.queryForObject(sql, int.class, store_id, "%" + dataStr + "%", "���������", "����������");
        } catch (NullPointerException e) {
            daysalesnum = 0;
        }
        return daysalesnum;
    }

    public static double getDayIncome(int store_id) {  //�������ĳ����ڵ�����
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataStr = dateFormat.format(new Date());
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select sum(price*buynum) "
                + "from O_G where store_id =? "
                + "and ordernum like ? "
                + "and ordernum in (select ordernum from userorder where orderstatus in (?,?))";

        double dayincome;
        try {
            dayincome = template.queryForObject(sql, Double.class, store_id, "%" + dataStr + "%", "���������", "����������");
        } catch (NullPointerException e) {
            dayincome = 0;
        }
        return dayincome;
    }

    public static List<Userorder> getToBeEvaluatedUserorder(String usernum) {  //�û���ô����۶���
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from userorder where usernum = ? and orderstatus = ?";
        List<Userorder> userorderlist = template.query(sql, new RowMapper<Userorder>() {
            public Userorder mapRow(ResultSet rs, int i) throws SQLException {
                Userorder userorder = new Userorder();
                String ordernum = rs.getString("ordernum");//������
                String contact = rs.getString("contact");//��ϵ��
                String phonenum = rs.getString("phonenum");//�绰��
                String address = rs.getString("address");//��ϵ�˵�ַ
                int store_id = rs.getInt("store_id");//�̼���
                String note = rs.getString("note");
                String buytime = rs.getString("buytime");//�µ�ʱ��
                String orderstatus = rs.getString("orderstatus");//����״̬
                String usernum = rs.getString("usernum");      //�û���
                userorder.setOrdernum(ordernum);
                userorder.setContact(contact);
                userorder.setPhonenum(phonenum);
                userorder.setAddress(address);
                userorder.setStore_id(store_id);
                userorder.setOrderstatus(orderstatus);
                userorder.setBuytime(buytime);
                userorder.setNote(note);
                userorder.setUsernum(usernum);
                return userorder;
            }
        }, usernum, "���������");
        return userorderlist;
    }

    public static void addUserorder(Userorder a) {  //��Ӷ���
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into userorder values(?,?,?,?,?,?,?,?,?)";
        template.update(sql, a.ordernum, a.usernum, a.store_id, a.contact, a.phonenum, a.address, a.note, a.buytime, a.orderstatus);
    }

    public static void updateOrderstatus(String ordernum, String neworderstatus) {//���¶�������״̬
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update userorder set orderstatus = ? where ordernum = ?";
        template.update(sql, neworderstatus, ordernum);

    }

    public static String makeOrdernum() {            //���ɶ�����
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumFractionDigits(4);
        numberFormat.setMinimumIntegerDigits(4);
        String numStr = numberFormat.format(new Random().nextInt(9999));
        String dataStr = dateFormat.format(new Date());
        String Ordernum = dataStr + numStr;
        return Ordernum;
    }

    public static String makeGoodsname(String ordernum) {//���������������Ʒ������
        String goodsnamelist = "";
        List<Goods> goods = Goods.getOrdergoods(ordernum);
        int size = goods.size();
        for (int i = 0; i < size; i++) {
            if (i != size - 1)
                goodsnamelist += (goods.get(i).name + ',');
            else
                goodsnamelist += (goods.get(i).name);
        }
        return goodsnamelist;
    }

    public static String makeBuytime() {    //�����µ�ʱ��
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String buytime = dateFormat.format(date);
        return buytime;
    }

    public static String makeServicetime(String buytime, int store_id) {//����Ԥ���ʹ�ʱ��
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select deliverytime from store where store_id = ?";
        int deliverytime = template.queryForObject(sql, int.class, store_id);
        String servicetime = null;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            Date date = formatter.parse(buytime);
            servicetime = formatter.format(new Date(date.getTime() + deliverytime * 60 * 1000));
            //servicetime=formatter.format(new Date(date.getTime()+deliverytime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return servicetime;
    }

    public static double countTotalprice(String ordernum) {//����ĳ�������ܼ�
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select sum(price*buynum) from O_G where ordernum=?";
        double totalprice = template.queryForObject(sql, double.class, ordernum);
        return totalprice;
    }

    public static String Getstorephone(String ordernum) {//����̵�绰
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select storephone from store where store_id =(select store_id from userorder where ordernum =?)";
        String storephone = template.queryForObject(sql, String.class, ordernum);
        return storephone;
    }

    public static void main(String[] args) {
        System.out.print(countTotalprice("202002051432227592"));
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }
}
