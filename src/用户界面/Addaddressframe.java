package �û�����;

import classpackage.Receiveaddress;
import ��½����.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        frame.setTitle("\u65B0\u589E\u8054\u7CFB\u4EBA");
        frame.setBounds(100, 100, 435, 314);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        int windowWidth = frame.getWidth();                     //��ô��ڿ�
        int windowHeight = frame.getHeight();                   //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ

        JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");
        lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel.setBounds(10, 22, 63, 36);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(83, 30, 143, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5730\u5740\uFF1A");
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 82, 75, 15);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(82, 79, 221, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
        lblNewLabel_2.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 164, 58, 26);
        frame.getContentPane().add(lblNewLabel_2);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5148\u751F");
        //rdbtnNewRadioButton.setIcon(new ImageIcon("src/images/��ʿ.png"));
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setFont(new Font("����", Font.BOLD, 14));
        rdbtnNewRadioButton.setBounds(80, 166, 65, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("\u5973\u58EB");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setFont(new Font("����", Font.BOLD, 14));
        rdbtnNewRadioButton_1.setBounds(150, 166, 61, 23);
        frame.getContentPane().add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
        lblNewLabel_3.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 122, 90, 21);
        frame.getContentPane().add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(83, 122, 128, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("\u786E\u5B9A");
        btnNewButton.setIcon(new ImageIcon("src/images/�ύ.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//ȷ�ϰ�ť
                //String usernum=Login.usernum;
                String usernum = Login.usernum;
                String contact = textField.getText();
                String address = textField_1.getText();
                String phonenum = textField_2.getText();
                String sex = "";
                if (rdbtnNewRadioButton.isSelected())
                    sex = "����";
                else sex = "Ůʿ";
                Receiveaddress newaddress = new Receiveaddress();
                newaddress.usernum = usernum;
                newaddress.contact = contact;
                newaddress.address = address;
                newaddress.phonenum = phonenum;
                newaddress.sex = sex;
                if (contact.equals("") || address.equals("") || phonenum.equals("") || sex.equals(""))
                    JOptionPane.showMessageDialog(null, "�������Ϊ��", "��ʾ:", JOptionPane.PLAIN_MESSAGE);
                else {
                    Receiveaddress.addReceiveAddress(newaddress);
                    JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ʾ:", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);
                    MyReceivinginformationframe.refreshTable();
                }
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton.setBounds(129, 213, 97, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
