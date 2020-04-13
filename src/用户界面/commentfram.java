package �û�����;

import classpackage.Evaluate;
import classpackage.Userorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//���۽���
public class commentfram {
    public JFrame evaluateframe;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private JRadioButton rdbtnNewRadioButton_3;
    private JRadioButton rdbtnNewRadioButton_4;
    private JTextArea textArea999;
    private String ordernum;
    private String usernum;

    public commentfram() {

        evaluateframe = new JFrame();
        evaluateframe.setTitle("\u8BC4\u4EF7");//����
        evaluateframe.setBounds(100, 100, 557, 371);
        //evaluateframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        evaluateframe.getContentPane().setLayout(null);

        int windowWidth = evaluateframe.getWidth();             //��ô��ڿ�
        int windowHeight = evaluateframe.getHeight();           //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        evaluateframe.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ

        JLabel lblNewLabel999 = new JLabel("\u60A8\u5BF9\u5546\u5BB6/\u83DC\u54C1\u6EE1\u610F\u5417\uFF1F");//�����̼�/��Ʒ������
        lblNewLabel999.setBounds(21, 26, 194, 22);
        lblNewLabel999.setFont(new Font("����", Font.BOLD, 18));
        evaluateframe.getContentPane().add(lblNewLabel999);

        rdbtnNewRadioButton = new JRadioButton("1\u5206");//1��
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton.setBounds(23, 55, 52, 23);
        rdbtnNewRadioButton.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("2\u5206");//2��
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_1.setBounds(80, 55, 54, 23);
        rdbtnNewRadioButton_1.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_1);

        rdbtnNewRadioButton_2 = new JRadioButton("3\u5206");//3��
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);

            }
        });
        rdbtnNewRadioButton_2.setBounds(133, 54, 52, 23);
        rdbtnNewRadioButton_2.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_2);

        rdbtnNewRadioButton_3 = new JRadioButton("4\u5206");//4��
        rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_4.setSelected(false);
            }
        });
        rdbtnNewRadioButton_3.setBounds(184, 53, 57, 23);
        rdbtnNewRadioButton_3.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_3);

        rdbtnNewRadioButton_4 = new JRadioButton("5\u5206");//5��
        rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rdbtnNewRadioButton.setSelected(false);
                rdbtnNewRadioButton_1.setSelected(false);
                rdbtnNewRadioButton_2.setSelected(false);
                rdbtnNewRadioButton_3.setSelected(false);
            }
        });
        rdbtnNewRadioButton_4.setBounds(240, 52, 51, 23);
        rdbtnNewRadioButton_4.setFont(new Font("����", Font.BOLD, 16));
        evaluateframe.getContentPane().add(rdbtnNewRadioButton_4);

        JButton btnNewButton999 = new JButton("\u63D0\u4EA4");//�ύ
        btnNewButton999.setIcon(new ImageIcon("src/images/�ύ.png"));
        btnNewButton999.addActionListener(new ActionListener() {//�����ύ
            public void actionPerformed(ActionEvent e) {
                int evaluategrade;
                String comment = textArea999.getText();
                //���ݷ���ѡ��ť���ص�����ȷ������
                if (rdbtnNewRadioButton.isSelected())
                    evaluategrade = 1;
                else if (rdbtnNewRadioButton_1.isSelected())
                    evaluategrade = 2;
                else if (rdbtnNewRadioButton_2.isSelected())
                    evaluategrade = 3;
                else if (rdbtnNewRadioButton_3.isSelected())
                    evaluategrade = 4;
                else
                    evaluategrade = 5;
                Evaluate evaluate = new Evaluate();
                String nickname = Evaluate.getNikename(ordernum);
                evaluate.ordernum = ordernum;
                evaluate.nickname = nickname;
                evaluate.comment = comment;
                evaluate.grade = evaluategrade;
                Evaluate.addEvaluate(evaluate);
                JOptionPane.showMessageDialog(null, "���۳ɹ���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                evaluateframe.dispose();
                Userorder.updateOrderstatus(ordernum, "����������");
            }
        });
        btnNewButton999.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton999.setBounds(33, 299, 97, 23);
        evaluateframe.getContentPane().add(btnNewButton999);

        JLabel lblNewLabel998 = new JLabel("\u53E3\u5473\u5982\u4F55\uFF0C\u5BF9\u5305\u88C5\u670D\u52A1\u6EE1\u610F\u5417\uFF1F");//��ζ��Σ��԰�װ����������
        lblNewLabel998.setFont(new Font("����", Font.BOLD, 18));
        lblNewLabel998.setBounds(19, 84, 258, 21);
        evaluateframe.getContentPane().add(lblNewLabel998);

        textArea999 = new JTextArea();
        textArea999.setLineWrap(true);
        textArea999.setWrapStyleWord(true);
        textArea999.setFont(new Font("����", Font.BOLD, 16));
        textArea999.setRows(10);
        textArea999.setBounds(26, 121, 413, 154);
        evaluateframe.getContentPane().add(textArea999);
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
