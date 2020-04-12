package ��½����;

import JDBCUtil.JDBCUtils;
import classpackage.Store;
import classpackage.User;
import org.springframework.jdbc.core.JdbcTemplate;
import �̼ҽ���.Businessframe;
import �̼ҽ���.Storeregistframe;
import �û�����.Customerframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    public static String usernum;//�û���
    public static int store_id;//�̵��
    private JFrame Loginframe;
    private JTextField textField;
    private JPasswordField passwordField;
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * Create the application.
     */
    public Login() {
        initialize();
    }

    /**
     * Launch the application.
     *
     * @throws UnsupportedLookAndFeelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    /*SubstanceBusinessBlackSteelLookAndFeel()
     * SubstanceCremeCoffeeLookAndFeel()
     * SubstanceCremeLookAndFeel()
     * SubstanceMistAquaLookAndFeel()
     * SubstanceOfficeSilver2007LookAndFeel()
     * substance.skin.SubstanceSaharaLookAndFeel()
     * */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel());
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                try {
                    UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel());
                    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    Login window = new Login();
                    window.Loginframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {
        Loginframe = new JFrame();
        Loginframe.setTitle("��ӭ������½����");
        Loginframe.setBounds(100, 100, 547, 418);
        Loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Loginframe.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(173, 146, 243, 25);
        Loginframe.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("\u8D26\u53F7\u540D:");
        lblNewLabel.setIcon(new ImageIcon("src/images/�û���.png"));
        lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
        lblNewLabel.setBounds(62, 140, 101, 34);
        Loginframe.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u5BC6 \u7801:");
        lblNewLabel_1.setIcon(new ImageIcon("src/images/����.png"));
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
        lblNewLabel_1.setBounds(62, 211, 101, 25);
        Loginframe.getContentPane().add(lblNewLabel_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(173, 211, 243, 28);
        Loginframe.getContentPane().add(passwordField);

        JButton btnNewButton = new JButton();
        //btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
        btnNewButton.setIcon(new ImageIcon("src/images/�ύ.png"));
        //btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);//
        btnNewButton.setText("\u767B\u9646");

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernum = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                try {
                    if (loginSQL(usernum, password) == 0)
                        JOptionPane.showMessageDialog(null, "���벻��Ϊ�����������룡");
                    if (loginSQL(usernum, password) == 1)
                        JOptionPane.showMessageDialog(null, "�û���������");
                    if (loginSQL(usernum, password) == 2)
                        JOptionPane.showMessageDialog(null, "�����������������");
                    if (loginSQL(usernum, password) == 3) {
                        JOptionPane.showMessageDialog(null, "��½�ɹ�");
                        Login.usernum = usernum;      //��½�ɹ�ʱ������¼�û���
                        // Loginframe.setVisible(false);
                        Loginframe.dispose();
                        if (User.getUserType(usernum).equals("�˿�")) {
                            Customerframe window = new Customerframe();
                            window.customerframe.setVisible(true);
                            Customerframe.setCenter(window.customerframe);
                        } else {
                            if (Store.ifRegist(usernum) == false) {
                                JOptionPane.showMessageDialog(null, "����û��ע���̵����Ƚ���ע�ᣡ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                                Storeregistframe window = new Storeregistframe();
                                window.frame.setVisible(true);
                                Customerframe.setCenter(window.frame);
                            } else {
                                store_id = Store.getStore_id(usernum);
                                Businessframe window = new Businessframe();
                                window.businessframe.setVisible(true);
                                Customerframe.setCenter(window.businessframe);
                            }
                        }
                    }
                } catch (HeadlessException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton.setBounds(54, 295, 100, 34);
        Loginframe.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("����");
        btnNewButton_1.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_1.setBounds(207, 295, 100, 34);
        Loginframe.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("ע��");//ע��
        btnNewButton_2.setIcon(new ImageIcon("src/images/ע��.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Registeframe window = new Registeframe();
                window.frame1.setVisible(true);
                Customerframe.setCenter(window.frame1);
            }
        });

        btnNewButton_2.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_2.setBounds(361, 294, 100, 34);
        Loginframe.getContentPane().add(btnNewButton_2);

        JLabel lblNewLabel_2 = new JLabel("\u723D\u6781\u4E86\u8BA2\u9910\u7CFB\u7EDF\u6B22\u8FCE\u60A8\uFF01");
        lblNewLabel_2.setIcon(new ImageIcon("src/images/��ʳ.png"));
        lblNewLabel_2.setFont(new Font("����", Font.BOLD, 20));
        lblNewLabel_2.setBounds(110, 26, 292, 70);
        Loginframe.getContentPane().add(lblNewLabel_2);

    }

    public int loginSQL(String usernum, String password) throws ClassNotFoundException {
        if (usernum.length() == 0 || password.length() == 0) {
            return 0;
        }
        //�������ݿ��ж��Ƿ��¼�ɹ�
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        //1.��ȡ����
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://47.95.200.90:3306/takeaway_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT", "takeaway_platform", "311214");
            conn.setAutoCommit(false);
            //2.����sql
            String sql1 = "select * from user where usernum = ? ";
            String sql2 = "select * from user where password = ?";
            //3.��ȡִ��sql�Ķ���
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //��?��ֵ
            pstmt1.setString(1, usernum);
            pstmt2.setString(1, password);
            //4.ִ�в�ѯ,����Ҫ����sql
            rs1 = pstmt1.executeQuery();
            rs2 = pstmt2.executeQuery();
            conn.commit();
            if (rs1.next() == false)
                return 1;
            else if (rs2.next() == false)
                return 2;
            else return 3;
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs1, pstmt1, conn);
            JDBCUtils.close(rs2, pstmt2, null);
        }

        return 0;
    }

    public void zhuce(String type, String usernum, String password1, String password2, String Address, String iphonenum) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs1 = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://47.95.200.90:3306/takeaway_platform?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT", "takeaway_platform", "311214");
            conn.setAutoCommit(false);
            String sql1 = "select * from user where usernum = ? ";
            String sql2 = "insert into user values(?,?,?,?,?)";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //��?��ֵ
            pstmt1.setString(1, usernum);
            pstmt2.setString(1, type);
            pstmt2.setString(2, usernum);
            pstmt2.setString(3, password1);
            pstmt2.setString(4, Address);
            pstmt2.setString(5, iphonenum);
            rs1 = pstmt1.executeQuery();
            conn.commit();
            if (usernum.length() == 0 || password1.length() == 0 || password2.length() == 0)
                JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
            else {
                if (rs1.next())
                    JOptionPane.showMessageDialog(null, "��������û����Ѵ������������룡");
                else if (!password1.equals(password2)) {
                    JOptionPane.showMessageDialog(null, "��������������벻һ�����������룡");
                } else {
                    template.update(sql2, type, usernum, password1, Address, iphonenum);
                    JOptionPane.showMessageDialog(null, "��ϲ����ע��ɹ���");
                }
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs1, pstmt1, conn);
        }

    }
}

