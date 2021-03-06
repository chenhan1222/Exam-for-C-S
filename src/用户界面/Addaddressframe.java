package 用户界面;

import classpackage.Receiveaddress;
import 登陆界面.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//顾客收货信息管理
public class Addaddressframe {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JRadioButton rdbtnNewRadioButton_1;
    /**
     * Launch the application.
     */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addaddressframe window = new Addaddressframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

    /**
     * Create the application.
     */
    public Addaddressframe() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("\u65B0\u589E\u8054\u7CFB\u4EBA");//新增联系人
        frame.setBounds(100, 100, 435, 314);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        int windowWidth = frame.getWidth();                     //获得窗口宽
        int windowHeight = frame.getHeight();                   //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
        int screenWidth = screenSize.width;                     //获取屏幕的宽
        int screenHeight = screenSize.height;                   //获取屏幕的高
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//设置窗口居中显示

        JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");//联系人：
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 22, 63, 36);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(83, 30, 143, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5730\u5740\uFF1A");//地址：
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 82, 75, 15);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(82, 79, 221, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");//性别：
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 164, 58, 26);
        frame.getContentPane().add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5148\u751F");//先生
        //rdbtnNewRadioButton.setIcon(new ImageIcon("src/images/男士.png"));
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.BOLD, 14));
        rdbtnNewRadioButton.setBounds(80, 166, 65, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("\u5973\u58EB");//女士
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.BOLD, 14));
        rdbtnNewRadioButton_1.setBounds(150, 166, 61, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");//联系电话：
        lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 122, 90, 21);
        frame.getContentPane().add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(83, 122, 128, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("\u786E\u5B9A");//确定
        btnNewButton.setIcon(new ImageIcon("src/images/提交.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//确认按钮
                //String usernum=Login.usernum;
                String usernum = Login.usernum;
                String contact = textField.getText();
                String address = textField_1.getText();
                String phonenum = textField_2.getText();
                String sex = "";
                if (rdbtnNewRadioButton.isSelected())
                    sex = "先生";
                else sex = "女士";
                Receiveaddress newaddress = new Receiveaddress();
                newaddress.usernum = usernum;
                newaddress.contact = contact;
                newaddress.address = address;
                newaddress.phonenum = phonenum;
                newaddress.sex = sex;
                if (contact.equals("") || address.equals("") || phonenum.equals("") || sex.equals(""))
                    JOptionPane.showMessageDialog(null, "输入项不能为空", "提示:", JOptionPane.PLAIN_MESSAGE);
                else {
                    Receiveaddress.addReceiveAddress(newaddress);
                    JOptionPane.showMessageDialog(null, "添加成功", "提示:", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);
                    MyReceivinginformationframe.refreshTable();
                }
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
        btnNewButton.setBounds(129, 213, 97, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
