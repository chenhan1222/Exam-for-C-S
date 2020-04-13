package �û�����;

import classpackage.Goods;
import classpackage.Store;
import classpackage.User;
import ��½����.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

//�˿ͽ���
public class Customerframe {
    public static int store_id;//������¼ѡ�е��̵��
    public JFrame customerframe;
    private JTable table_001;
    private JTable table;
    private JTextField textField;

    /**
     * Create the application.
     */
    public Customerframe() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customerframe window = new Customerframe();
                    window.customerframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setCenter(JFrame frame) {
        int windowWidth = frame.getWidth();                     //��ô��ڿ�
        int windowHeight = frame.getHeight();                   //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        customerframe = new JFrame();
        customerframe.getContentPane().setFont(new Font("����", Font.BOLD, 16));
        customerframe.setBounds(100, 100, 942, 558);
        customerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerframe.getContentPane().setLayout(null);

        int windowWidth = customerframe.getWidth();             //��ô��ڿ�
        int windowHeight = customerframe.getHeight();           //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        customerframe.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ

        table = new JTable();
        //table.setBounds(10, 148, 613, 414);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(704, 363);
        scrollPane.setLocation(10, 58);
        customerframe.getContentPane().add(scrollPane);
        refreshStoresTable(Store.getstores(), dtm);
        //�������
        JButton btnNewButton_1 = new JButton("\u8FDB\u5165");//����
        btnNewButton_1.setIcon(new ImageIcon("src/images/����.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getRowCount(); i++) {
                    String value = table.getValueAt(i, 4).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                    int store_id = Integer.valueOf(table.getValueAt(i, 0).toString());
                    if (value == "true") {
                        Customerframe.store_id = store_id;
                        //����ѡ���̵��Ĵ���
                        goodframe window = new goodframe();
                        window.frame3.setVisible(true);
                        Customerframe.setCenter(window.frame3);
                    }
                }
            }
        });
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 16));
        btnNewButton_1.setBounds(738, 234, 100, 34);
        customerframe.getContentPane().add(btnNewButton_1);
        //����Ϊ�����˵���������
        JMenuBar menuBar = new JMenuBar();
        customerframe.setJMenuBar(menuBar);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u641C\u7D22\uFF08Search\uFF09");//����
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String storename = textField.getText();
                List<Store> stores = Store.getstores(storename);
                refreshStoresTable(stores, dtm);
            }
        });

        JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5546\u5BB6\u540D:");//�������̼���
        menuBar.add(lblNewLabel);
        lblNewLabel.setFont(new Font("����", Font.BOLD, 16));

        textField = new JTextField();
        menuBar.add(textField);
        textField.setFont(new Font("����", Font.BOLD, 16));
        textField.setColumns(10);
        mntmNewMenuItem_2.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mntmNewMenuItem_2);

        JMenu mnNewMenu = new JMenu("\u6392\u5E8F\uFF08Sort\uFF09");//����
        mnNewMenu.setBounds(10, 0, 100, 100);
        menuBar.add(mnNewMenu);
        mnNewMenu.setFont(new Font("����", Font.BOLD, 16));

        JMenuItem mntmNewMenuItem = new JMenuItem("\u6309\u8BC4\u5206\u6392\u5E8F");//����������
        mntmNewMenuItem.setFont(new Font("����", Font.BOLD, 16));
        mntmNewMenuItem.addActionListener(new ActionListener() {//����������
            public void actionPerformed(ActionEvent e) {
                refreshStoresTable(Store.sqlSortByGrade(), dtm);
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6309\u9500\u91CF\u6392\u5E8F");//����������
        mntmNewMenuItem_1.setFont(new Font("����", Font.BOLD, 16));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    //������������
                refreshStoresTable(Store.sqlSortByMonthsale(), dtm);
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("\u7528\u6237\u7BA1\u7406\uFF08Manage\uFF09");//�û�����
        mnNewMenu_1.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u6211\u7684\u4E2A\u4EBA\u4FE1\u606F");//�ҵĸ�����Ϣ
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Personal_information_frame window = new Personal_information_frame();
                window.frame.setVisible(true);
            }
        });
        mntmNewMenuItem_6.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_1.add(mntmNewMenuItem_6);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6211\u7684\u6536\u8D27\u4FE1\u606F");//�ҵ��ջ���Ϣ
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MyReceivinginformationframe window = new MyReceivinginformationframe();
                window.frame.setVisible(true);
                Customerframe.setCenter(window.frame);

            }
        });
        mntmNewMenuItem_4.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u6211\u7684\u5173\u6CE8");//�ҵĹ�ע
        mnNewMenu_1.add(mntmNewMenuItem_3);
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Store> stores = User.getYourFollwStores(Login.usernum);
                refreshStoresTable(stores, dtm);
            }
        });
        mntmNewMenuItem_3.setFont(new Font("����", mntmNewMenuItem_3.getFont().getStyle() | Font.BOLD, mntmNewMenuItem_3.getFont().getSize() + 4));

        JMenuItem menuItem = new JMenuItem("\u6211\u7684\u8BA2\u5355");//�ҵĶ���
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Myorderframe window = new Myorderframe();
                window.orderframe.setVisible(true);
                Customerframe.setCenter(window.orderframe);
            }
        });
        menuItem.setFont(new Font("����", Font.BOLD, 16));
        mnNewMenu_1.add(menuItem);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5237\u65B0\uFF08Refresh\uFF09");//ˢ��
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//ˢ��
                refreshStoresTable(Store.getstores(), dtm);
            }
        });
        mntmNewMenuItem_5.setFont(new Font("����", Font.BOLD, 16));
        menuBar.add(mntmNewMenuItem_5);
    }

    //ˢ����Ʒ��Ϣ�ĺ���
    public void refreshGoodsTable(List<Goods> goods, DefaultTableModel dtm) {
        dtm.setRowCount(0);//����б�
        String[] tableHeads = new String[]{"���", "����", "����", "�۸�", "������", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < goods.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(goods.get(i).good_id);
            v.add(goods.get(i).name);
            v.add(goods.get(i).type);
            v.add(goods.get(i).price);
            v.add(goods.get(i).salesnum);
            v.add(false);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        TableColumnModel tcm = table_001.getColumnModel();
        tcm.getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tcm.getColumn(5).setCellRenderer(new TestTableCellRenderer());
        tcm.getColumn(5).setPreferredWidth(80);
        tcm.getColumn(5).setWidth(80);
        tcm.getColumn(5).setMaxWidth(80);
    }

    //ˢ�µ�����Ϣ�ĺ���
    public void refreshStoresTable(List<Store> stores, DefaultTableModel dtm) {
        dtm.setRowCount(0);//����б�
        //int num=1;
        String[] tableHeads = new String[]{"���", "����", "����", "������", "�Ƿ�ѡ��"};
        dtm.setColumnIdentifiers(tableHeads);
        //����JTable�ı����
        for (int i = 0; i < stores.size(); i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(stores.get(i).store_id);
            v.add(stores.get(i).name);
            v.add(stores.get(i).grade);
            v.add(stores.get(i).salesnum);
            v.add(false);
            // JButton button =new JButton();
            //.add(button);
            dtm.addRow(v);
        }
        /*****����table����ģ��****/
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tcm.getColumn(4).setCellRenderer(new TestTableCellRenderer());
        tcm.getColumn(4).setPreferredWidth(80);
        tcm.getColumn(4).setWidth(80);
        tcm.getColumn(4).setMaxWidth(80);
    }

}

class TestTableCellRenderer extends JCheckBox implements TableCellRenderer {//���ø�ѡ��
    private static final long serialVersionUID = 3L;

    public Component getTableCellRendererComponent(JTable tabl, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Boolean b = (Boolean) value;
        this.setSelected(b.booleanValue());
        return this;
    }
}

// ��Ӱ�ť
class MyButtonRender implements TableCellRenderer {
    private JButton button;

    public MyButtonRender() {
        this.initButton();
    }

    private void initButton() {
        this.button = new JButton("+");
        // ���ð�ť�Ĵ�С��λ�á�
        this.button.setBounds(0, 0, 40, 5);
        this.button.setFont(new Font("����", Font.BOLD, 4));
        // ����Ⱦ�������Ӱ�ť���¼��ǲ��ᴥ����
        // this.button.addActionListener(new ActionListener()
        // {
        //
        // public void actionPerformed(ActionEvent e)
        // {
        // // TODO Auto-generated method stub
        // }
        // });
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
                                                   int column) {
        // ֻΪ��ť��ֵ���ɡ�Ҳ������������������汳����
        this.button.setText(value == null ? "" : String.valueOf(value));
        return this.button;
    }
}

class MyButtonEditor extends DefaultCellEditor {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6546334664166791132L;
    private JButton button;

    public MyButtonEditor(JTable table) {
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ������
        super(new JTextField());

        // ���õ�����μ���༭��
        this.setClickCountToStart(1);
        this.initButton(table);
    }

    private void initButton(JTable table) {
        this.button = new JButton("+");
        this.button.setFont(new Font("����", Font.BOLD, 4));
        //  button.setIcon(icon);
        // ���ð�ť�Ĵ�С��λ�á�
        this.button.setBounds(0, 0, 40, 5);
        // ImageIcon icon=new ImageIcon("icon/���.gif");
        // icon.setImage(icon.getImage().getScaledInstance(30,7,Image.SCALE_DEFAULT ));
        // this.button.setIcon(icon);
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ����ȡ���༭���¼����������tableModel��setValue������
                MyButtonEditor.this.fireEditingCanceled();
                // �������������������
                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�
                int i = table.getSelectedRow();//���ѡ����
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int column = model.findColumn("��������");
                int buynum = Integer.valueOf(table.getValueAt(i, column).toString());
                table.setValueAt(buynum + 1, i, column);
                //JOptionPane.showMessageDialog(null, "����û��ע���̵����Ƚ���ע�ᣡ", "��ʾ", JOptionPane.PLAIN_MESSAGE);
            }

        });

    }

    /**
     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ��
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������
        this.button.setText(value == null ? "" : String.valueOf(value));

        return this.button;
    }

    /**
     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ��
     */
    @Override
    public Object getCellEditorValue() {
        return this.button.getText();
    }

    public boolean isCellEditable(int row, int column) {
        // ���а�ť�еĹ����������Ҫ����true��Ȼ��ť���ʱ���ᴥ���༭Ч����Ҳ�Ͳ��ᴥ���¼���
        if (column == 6) {
            return true;
        } else {
            return false;
        }
    }
}