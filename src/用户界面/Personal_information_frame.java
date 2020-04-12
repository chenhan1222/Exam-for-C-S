package �û�����;

import classpackage.ImageDemo;
import classpackage.User;
import ��½����.Login;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Personal_information_frame {

    public JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private ImageIcon image;
    private JLabel lblNewLabel_1;

    /**
     * Create the application.
     */
    public Personal_information_frame() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Personal_information_frame window = new Personal_information_frame();
                    window.frame.setVisible(true);
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
        frame = new JFrame();
        frame.setFont(new Font("����", Font.BOLD, 16));
        frame.setTitle("\u6211\u7684\u4FE1\u606F");
        frame.setBounds(100, 100, 374, 398);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        int windowWidth = frame.getWidth();                     //��ô��ڿ�
        int windowHeight = frame.getHeight();                   //��ô��ڸ�
        Toolkit kit = Toolkit.getDefaultToolkit();              //���幤�߰�
        Dimension screenSize = kit.getScreenSize();             //��ȡ��Ļ�ĳߴ�
        int screenWidth = screenSize.width;                     //��ȡ��Ļ�Ŀ�
        int screenHeight = screenSize.height;                   //��ȡ��Ļ�ĸ�
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//���ô��ھ�����ʾ


        JLabel lblNewLabel = new JLabel("\u5934\u50CF\uFF1A");
        lblNewLabel.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel.setBounds(34, 49, 54, 19);
        frame.getContentPane().add(lblNewLabel);

        lblNewLabel_1 = new JLabel("");
        //int x=98,y=10;
        int width = 100, height = 100;
        image = ImageDemo.readDB2Image(Login.usernum);
        image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        lblNewLabel_1.setIcon(image);
        lblNewLabel_1.setBounds(98, 10, 100, 100);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u6635\u79F0\uFF1A");
        lblNewLabel_2.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel_2.setBounds(34, 140, 54, 19);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
        lblNewLabel_3.setFont(new Font("����", Font.BOLD, 14));
        lblNewLabel_3.setBounds(34, 209, 77, 18);
        frame.getContentPane().add(lblNewLabel_3);

        textField = new JTextField(User.getNickname(Login.usernum));
        textField.setBounds(98, 139, 100, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField(User.getPhonenum(Login.usernum));
        textField_1.setBounds(120, 208, 119, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("�޸�");
        btnNewButton.setIcon(new ImageIcon("src/images/�޸�.png"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Image icon = ((ImageIcon) lblNewLabel_1.getIcon()).getImage();
                    String nickname = textField.getText();
                    String phonenum = textField_1.getText();
                    User.updatePersonalInformation(Login.usernum, phonenum, nickname, icon);
                    JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);
                } catch (Exception e2) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(null, "�޸�ʧ��", "��ʾ��", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });
        btnNewButton.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton.setBounds(120, 277, 100, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("�����ϴ�");
        btnNewButton_1.setFont(new Font("����", Font.BOLD, 14));
        btnNewButton_1.setIcon(new ImageIcon("src/images/�ύ.png"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_addImgActionPerformed(e);
            }
        });

        btnNewButton_1.setBounds(221, 47, 110, 23);
        frame.getContentPane().add(btnNewButton_1);
    }

    private void btn_addImgActionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg,gif,bmp,png", "jpg", "gif", "png", "gif");
        fileChooser.setFileFilter(filter);
        try {
            fileChooser.showOpenDialog(null);

        } catch (HeadlessException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }
        try {
            File f = fileChooser.getSelectedFile();
            //int x=91,y=10;
            int width = 100, height = 100;
            image = new ImageIcon(f.getPath());
            image.setImage(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
            lblNewLabel_1.setIcon(image);
        } catch (Exception e2) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "���ͼƬʧ�ܣ�");
            return;
        }

    }


}
