package �û�����;

import Test.JBoxTestCell;
import classpackage.Order_goods;
import classpackage.Store;
import classpackage.Userorder;
import ��½����.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Myorderframe {
    public JFrame orderframe;
    private JTable table;

    /**
     * Launch the application.
     */
    public Myorderframe() {
        String usernum = Login.usernum;
        orderframe = new JFrame();
        orderframe.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        //orderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderframe.getContentPane().setLayout(null);

        table = new JTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(654, 347);
        scrollPane.setLocation(10, 52);
        orderframe.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getAllUserorder(usernum);
        refreshUserorderTable(userorders, dtm);

        JButton btnNewButton = new JButton("\u53D6\u6D88\u8BA2\u5355");
        btnNewButton.setIcon(new ImageIcon("src/images/ȡ������.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    String value = table.getValueAt(i, 7).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                    String ordernum = table.getValueAt(i, 0).toString();
                    String orderstatus = table.getValueAt(i, 6).toString();
                    if (value == "true") {
                        if (orderstatus.equals("�ȴ��̼ҽӵ�")) {
                            JOptionPane.showMessageDialog(null, "�����˿���", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                            Userorder.updateOrderstatus(ordernum, "�����˿�");
                        } else {
                            JOptionPane.showMessageDialog(null, "����������������������Ҫ����ϵ�̼ң�", "�˿�ʧ��", JOptionPane.PLAIN_MESSAGE);
                        }

                    }
                }
                refreshUserorderTable(Userorder.getAllUserorder(usernum), dtm);
            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton.setBounds(674, 100, 140, 30);
        orderframe.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("��ϵ�̼�");
        btnNewButton_1.setIcon(new ImageIcon("src/images/��ϵ�̼�.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//��ϵ�̼�
                for (int i = 0; i < table.getRowCount(); i++) {
                    String value = table.getValueAt(i, 7).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                    String ordernum = table.getValueAt(i, 0).toString();
                    if (value == "true") {
                        JOptionPane.showMessageDialog(null, Userorder.Getstorephone(ordernum), "�̼���ϵ�绰:", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_1.setBounds(674, 168, 140, 30);
        orderframe.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u5F85\u8BC4\u4EF7");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //��ô����۵Ķ���
                List<Userorder> userorders = Userorder.getToBeEvaluatedUserorder(usernum);
                refreshUserorderTable(userorders, dtm);
            }
        });
        btnNewButton_2.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_2.setBounds(338, 10, 97, 25);
        orderframe.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u5DF2\u5B8C\u6210");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            //�������ɵĶ���
                String orderstatus = "���������";
                List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        btnNewButton_3.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_3.setBounds(180, 10, 97, 25);
        orderframe.getContentPane().add(btnNewButton_3);

        JButton button = new JButton("\u8BC4\u4EF7");
        button.setIcon(new ImageIcon("src/images/����.png"));
        button.addActionListener(new ActionListener() {//����
            //btnNewButton
            public void actionPerformed(ActionEvent e) {
                /**
                 *
                 ���۴���
                 */
                for (int i = 0; i < table.getRowCount(); i++) {
                    String value = table.getValueAt(i, 7).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                    String orderstatus = table.getValueAt(i, 6).toString();
                    String ordernum = table.getValueAt(i, 0).toString();
                    if (value == "true") {
                        if (orderstatus.equals("���������")) {
                            commentfram window = new commentfram();
                            window.setOrdernum(ordernum);
                            window.evaluateframe.setVisible(true);
                            //���۴��ڽ���
                        } else if (orderstatus.equals("����������"))
                            JOptionPane.showMessageDialog(null, "�����Ѿ����۹��ˣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null, "����δ��ɲ������ۣ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }
        });
        button.setFont(new Font("����", Font.BOLD, 16));
        button.setBounds(674, 240, 140, 30);
        orderframe.getContentPane().add(button);

        JButton btnNewButton_4 = new JButton("\u5168\u90E8\u8BA2\u5355");//����û������ж���
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getAllUserorder(usernum);
                refreshUserorderTable(userorders, dtm);
            }
        });
        btnNewButton_4.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_4.setBounds(23, 10, 105, 25);
        orderframe.getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("����һ��");
        btnNewButton_5.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < table.getRowCount(); i++) {
                    String value = table.getValueAt(i, 7).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                    String ordernum = table.getValueAt(i, 0).toString();
                    if (value == "true") {
                        goodframe.ordergoodslist = Order_goods.getOrder_GoodsList(ordernum);

                        //����ѡ���̵��Ĵ���
                        Payframe window = new Payframe();
                        window.frame.setVisible(true);
                        Customerframe.setCenter(window.frame);
                    }
                }
            }
        });
        btnNewButton_5.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_5.setBounds(674, 315, 140, 30);
        orderframe.getContentPane().add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("�˿�");
        btnNewButton_6.setIcon(new ImageIcon("src/images/�˿�.png"));
        btnNewButton_6.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        //��ȡ���˿�Ķ���
                String orderstatus = "���˿�";
                List<Userorder> userorders = Userorder.getUserorder(usernum, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        btnNewButton_6.setBounds(489, 10, 97, 25);
        orderframe.getContentPane().add(btnNewButton_6);
        orderframe.setTitle("\u6211\u7684\u8BA2\u5355");
        orderframe.setBounds(100, 100, 840, 484);
    }

    public void refreshUserorderTable(List<Userorder> userorders, DefaultTableModel dtm) {
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"������", "�̼�����", "������Ʒ", "�ܼ�", "�µ�ʱ��", "Ԥ���ʹ�ʱ��", "����״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < userorders.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(userorders.get(i).ordernum);
            v.add(Store.getStoreName(userorders.get(i).store_id));
            v.add(null);
            v.add(Userorder.countTotalprice(userorders.get(i).ordernum));
            v.add(userorders.get(i).buytime);
            v.add(Userorder.makeServicetime(userorders.get(i).buytime, userorders.get(i).store_id));
            v.add(userorders.get(i).orderstatus);
            v.add(false);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(2).setCellEditor(new JBoxTestCell(table));

        tcm.getColumn(7).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tcm.getColumn(7).setCellRenderer(new TestTableCellRenderer());

        tcm.getColumn(7).setPreferredWidth(50);
        tcm.getColumn(7).setWidth(50);
        tcm.getColumn(0).setMaxWidth(70);
        tcm.getColumn(3).setMaxWidth(40);
        tcm.getColumn(4).setMaxWidth(50);
        tcm.getColumn(5).setMaxWidth(65);
        tcm.getColumn(6).setMaxWidth(80);
        tcm.getColumn(7).setMaxWidth(50);
    }
}

