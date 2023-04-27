package QuanLyKhachSan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DangNhap extends JFrame implements ActionListener{
	
	private JPanel pnBorder, top, center, west;
	private JLabel lbuser, lbpassword, lbiconsuer, lbiconpass;
	private JTextField txtuser, txtpassword;
	private JButton btnlogin;
	
	public DangNhap() {
		setTitle("Dang Nhap");
		setSize(650, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		gui();
	}
	public void gui() {
		pnBorder = new JPanel();
		top = new JPanel();
		center = new JPanel();
		west = new JPanel();
		
		
		pnBorder.add(top);
		pnBorder.add(center);
		
		center.setBackground(Color.CYAN);
		west.setBackground(Color.cyan);
		top.setBackground(Color.cyan);
		
		JLabel lbtitle = new JLabel("DANG NHAP");
		lbtitle.setForeground(Color.BLUE);
		Font ft = new Font("Arial", Font.BOLD, 25);
		lbtitle.setFont(ft);
		top.add(lbtitle);
		
		
		
		Box a = Box.createVerticalBox();
		Box a1, a2, a3;
		lbiconsuer = new JLabel();
		lbiconpass =  new JLabel();
		lbiconsuer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acc.png")));
		lbiconpass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/padlock.png")));
		a.add(a1 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a1.add(lbiconsuer);
		a1.add(lbuser = new JLabel("Account"));
		a1.add(txtuser = new JTextField(20));
		
		a.add(a2 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a2.add(lbiconpass);
		a2.add(lbpassword = new JLabel("Password"));
		a2.add(txtpassword = new JTextField(20));
		
		a.add(a3 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a3.add(btnlogin = new JButton("LOGIN"));
		
		btnlogin.addActionListener(this);
		
		center.add(a);
		
		lbuser.setPreferredSize(lbpassword.getPreferredSize());
		
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		JLabel lbicon = new JLabel();
		lbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.png")));
		west.add(lbicon);
		pnBorder.add(west);
		add(west, BorderLayout.WEST);
	}
	public static void main(String[] args) {
		new DangNhap().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnlogin)) {
			if(txtuser.getText().equals("")){
	            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập tài khoản");
	        } else if(txtpassword.getText().equals("")){
	            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập mật khẩu");
	        } else if(txtuser.getText().equals("BTL")){
	                if(txtpassword.getText().equals("BTL")){
	                        JOptionPane.showMessageDialog(this, "đăng nhập thành công");
	                        menu_GUI mng =new menu_GUI();
	                        mng.setVisible(true);
	                        this.setVisible(false);
	                }
	                else{
	                    JOptionPane.showMessageDialog(this, "sai mật khẩu");
	                }
	        }else{
	            JOptionPane.showMessageDialog(this, "đăng nhập thất bại");
	        }
		}
	}
	
}
