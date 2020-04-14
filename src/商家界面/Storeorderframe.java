package �̼ҽ���;

import Test.JBoxTestCell;
import classpackage.Userorder;
import ��½����.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class Storeorderframe {
    public JFrame frame;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public Storeorderframe() {
        int store_id = Login.store_id;
        frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 939, 557);
        frame.setTitle("\u6211\u7684\u8BA2\u5355");
        frame.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        frame.getContentPane().setLayout(null);

        table_1 = new JTable();
        DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setSize(743, 451);
        scrollPane.setLocation(10, 29);
        frame.getContentPane().add(scrollPane);
        List<Userorder> userorders = Userorder.getStoreOrder(store_id);
        refreshUserorderTable(userorders, dtm);

        JButton btnNewButton_7 = new JButton("�ܾ��ӵ�");
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String neworderstatus = "�̼��Ѿܵ�";
                for (int i = 0; i < table_1.getRowCount(); i++) {
                    String getvalue = table_1.getValueAt(i, 8).toString();
                    String ordernum = table_1.getValueAt(i, 0).toString();
                    String orderstatus = table_1.getValueAt(i, 7).toString();
                    if (getvalue == "true") {
                        if (orderstatus.equals("�ȴ��̼ҽӵ�")) {
                            Userorder.updateOrderstatus(ordernum, neworderstatus);
                            JOptionPane.showMessageDialog(null, "�ܵ��ɹ���");
                            List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                            refreshUserorderTable(userorders, dtm);
                        } else
                            JOptionPane.showMessageDialog(null, "�ܵ�ʧ�ܣ�");
                    }

                }
            }
        });
        btnNewButton_7.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_7.setBounds(763, 78, 111, 30);
        frame.getContentPane().add(btnNewButton_7);

        JButton btnNewButton_8 = new JButton("\u63A5\u5355");
        btnNewButton_8.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String neworderstatus = "�̼��ѽӵ�";
                for (int i = 0; i < table_1.getRowCount(); i++) {
                    String getvalue = table_1.getValueAt(i, 8).toString();
                    String ordernum = table_1.getValueAt(i, 0).toString();
                    String orderstatus = table_1.getValueAt(i, 7).toString();
                    if (getvalue == "true") {
                        if (orderstatus.equals("�ȴ��̼ҽӵ�")) {
                            Userorder.updateOrderstatus(ordernum, neworderstatus);
                            JOptionPane.showMessageDialog(null, "�ӵ��ɹ���");
                            List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                            refreshUserorderTable(userorders, dtm);
                        } else
                            JOptionPane.showMessageDialog(null, "�ӵ�ʧ�ܣ�");
                    }

                }
            }
        });
        btnNewButton_8.setBounds(763, 152, 111, 30);
        frame.getContentPane().add(btnNewButton_8);

        JButton btnNewButton_9 = new JButton("\u5F00\u59CB\u914D\u9001");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String neworderstatus = "������";
                for (int i = 0; i < table_1.getRowCount(); i++) {
                    String getvalue = table_1.getValueAt(i, 8).toString();
                    String ordernum = table_1.getValueAt(i, 0).toString();
                    String orderstatus = table_1.getValueAt(i, 7).toString();
                    if (getvalue == "true") {
                        if (orderstatus.equals("�̼��ѽӵ�")) {
                            Userorder.updateOrderstatus(ordernum, neworderstatus);
                            JOptionPane.showMessageDialog(null, "������ʼ���ͣ�");
                            List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                            refreshUserorderTable(userorders, dtm);
                        } else
                            JOptionPane.showMessageDialog(null, "�ӵ�����ܿ�ʼ���ͣ�");
                    }

                }

            }
        });
        btnNewButton_9.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_9.setBounds(763, 220, 111, 30);
        frame.getContentPane().add(btnNewButton_9);

        JButton btnNewButton_10 = new JButton("\u9001\u8FBE");
        btnNewButton_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String neworderstatus = "���������";
                for (int i = 0; i < table_1.getRowCount(); i++) {
                    String getvalue = table_1.getValueAt(i, 8).toString();
                    String ordernum = table_1.getValueAt(i, 0).toString();
                    String orderstatus = table_1.getValueAt(i, 7).toString();
                    if (getvalue == "true") {
                        if (orderstatus.equals("������")) {
                            Userorder.updateOrderstatus(ordernum, neworderstatus);
                            JOptionPane.showMessageDialog(null, "��������ɣ�");
                            List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                            refreshUserorderTable(userorders, dtm);
                        } else
                            JOptionPane.showMessageDialog(null, "��Ч������");
                    }
                }
            }
        });
        btnNewButton_10.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_10.setBounds(762, 288, 112, 30);
        frame.getContentPane().add(btnNewButton_10);

        JButton btnNewButton = new JButton("\u9000\u6B3E");
        btnNewButton.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton.setBounds(764, 358, 110, 30);
        frame.getContentPane().add(btnNewButton);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("��������(C)");
        mnNewMenu_1.setMnemonic(KeyEvent.VK_C);
		/*mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Userorder>userorders=Userorder.getUserorder(store_id);
				refreshUserorderTable(userorders,dtm);
			}
		});*/
        mnNewMenu_1.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);

        JMenu mnNewMenu = new JMenu("\u5168\u90E8");
        mnNewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mnNewMenu_1.setMnemonic(KeyEvent.VK_A);
        mnNewMenu.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_1.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("ȫ��         ", 'A');
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_6.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_6);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("δ�ӵ�         ", 'Y');
        mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�ȴ��̼ҽӵ�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("�ѽӵ�         ");
        mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�̼��ѽӵ�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("������         ", 'D');
        mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "������";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�����         ", 'F');
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "���������";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke('F', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem_3.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem = new JMenuItem("�����˿�         ", 'L');
        mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke('L', ActionEvent.CTRL_MASK));//��ݼ�
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderstatus = "�����˿�";
                List<Userorder> userorders = Userorder.getStoreOrder(store_id, "orderstatus", orderstatus);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem tadayorder = new JMenuItem("���ն���      ", 'T');
        tadayorder.setAccelerator(KeyStroke.getKeyStroke('T'));//��ݼ�
        tadayorder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOneDayOrder(store_id);
                refreshUserorderTable(userorders, dtm);
            }
        });
        tadayorder.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_1.add(tadayorder);

        JMenu mnNewMenu_5 = new JMenu("\u6392\u5E8F\uFF08S\uFF09");
        mnNewMenu_5.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_5);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6309\u65E5\u671F\u4F18\u5148\u6392\u5E8F");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrderSortByData(store_id);
                refreshUserorderTable(userorders, dtm);
            }
        });
        mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 14));
        mnNewMenu_5.add(mntmNewMenuItem_5);


        JMenu mnNewMenu_4 = new JMenu("\u5237\u65B0\uFF08R\uFF09");
        mnNewMenu_4.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                List<Userorder> userorders = Userorder.getStoreOrder(store_id);
                refreshUserorderTable(userorders, dtm);
            }
        });

        mnNewMenu_4.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_4);

        JMenu mnNewMenu_3 = new JMenu("\u9000\u51FA\uFF08Q\uFF09");
        mnNewMenu_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
        mnNewMenu_3.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_3);
    }


    public void refreshUserorderTable(List<Userorder> userorders, DefaultTableModel dtm) {
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"������", "�ͻ���", "�ͻ��绰", "סַ", "������Ʒ", "�µ�ʱ��", "��ע", "����״̬", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < userorders.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(userorders.get(i).ordernum);
            v.add(userorders.get(i).contact);
            v.add(userorders.get(i).phonenum);
            v.add(userorders.get(i).address);
            v.add("");
            v.add(userorders.get(i).buytime);
            v.add(userorders.get(i).note);
            v.add(userorders.get(i).orderstatus);
            v.add(false);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        TableColumnModel tcm = table_1.getColumnModel();
        tcm.getColumn(4).setCellEditor(new JBoxTestCell(table_1));
        tcm.getColumn(8).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tcm.getColumn(8).setCellRenderer(new TestTableCellRenderer());
        tcm.getColumn(8).setPreferredWidth(80);
        tcm.getColumn(8).setWidth(80);
        tcm.getColumn(5).setMaxWidth(55);
        tcm.getColumn(7).setMaxWidth(80);
        tcm.getColumn(8).setMaxWidth(50);
    }
}
