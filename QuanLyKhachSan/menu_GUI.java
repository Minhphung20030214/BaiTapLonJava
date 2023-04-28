package QuanLyKhachSan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import UI.DichVu_Frm;
import UI.NhanVien_Frm;
import UI.Phong_Frm;
import UI.hoadon_Frm;
import UI.khachhang_Frm;


public class menu_GUI extends JFrame implements ActionListener{
	private JPanel pnBorder, top, center, west;
	private JButton btnKH, btnHD, btnNV, btnDV, btnPH, btntang, btnDX, btnloaiphong;
	private JLabel lbKH, lbHD, lbNV, lbDV, lbPH, lbtang, lbDX, lbloaiphong;
	public menu_GUI() {
		setSize(1500, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("MENU");
		setResizable(false);
		

		top = new JPanel();
		center = new JPanel();

		JLabel lbtl = new JLabel("MENU");
		
		top = new JPanel();
		top.add(lbtl);
		top.setBackground(new Color(84, 255, 159));
		Font ft = new Font("Arial", Font.BOLD, 25);
//		lbtl.setForeground(Color.white);
		lbtl.setFont(ft);
		lbtl.setBounds(750, 0, 1500, 50);
		add(lbtl);
		top.setLayout(null);
		top.setPreferredSize(new Dimension(0,50));
		add(top, BorderLayout.NORTH);

		//
		//
		lbDV = new JLabel();
		lbDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/24-7.png")));
		lbHD = new JLabel();
		lbHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/analytics.png")));
		lbKH = new JLabel();
		lbKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cust.png")));
		lbNV = new JLabel();
		lbNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employees.png")));
		lbPH = new JLabel();
		lbPH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/room.png")));
		lbtang = new JLabel();
		lbtang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/apartment.png")));
		lbDX = new JLabel();
		lbDX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dx.png")));
		lbloaiphong = new JLabel();
		lbloaiphong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/door.png")));
		
	
//		
		center.setLayout(null);
		center.setBackground(new Color(0, 206, 209));
		center.setPreferredSize(new Dimension(210, 750));
		
		btnPH = new JButton("Phòng");
		btnPH.setBounds(5, 50, 200, 60);
		btnPH.add(lbPH);
		btnPH.setBackground(new Color(0, 206, 209));
		btnPH.setBorder(null);
		add(btnPH);
		center.add(btnPH);
		
		btnloaiphong = new JButton("Loại Phòng");
		btnloaiphong.setBounds(5, 100, 200, 60);
		btnloaiphong.add(lbloaiphong);
		btnloaiphong.setBackground(new Color(0, 206, 209));
		btnloaiphong.setBorder(null);
		add(btnloaiphong);
		center.add(btnloaiphong);
		
		btntang = new JButton("Tầng");
		btntang.setBounds(5, 150, 200, 60);
		btntang.add(lbtang);
		btntang.setBackground(new Color(0, 206, 209));
		btntang.setBorder(null);
		add(btntang);
		center.add(btntang);
		
		btnDV = new JButton("Dịch Vụ");
		btnDV.setBounds(5, 200, 200, 60);
		btnDV.add(lbDV);
		btnDV.setBackground(new Color(0, 206, 209));
		btnDV.setBorder(null);
		add(btnDV);
		center.add(btnDV);
		
		btnHD = new JButton("Hóa Đơn");
		btnHD.setBounds(5, 250, 200, 60);
		btnHD.add(lbHD);
		btnHD.setBackground(new Color(0, 206, 209));
		btnHD.setBorder(null);
		add(btnHD);
		center.add(btnHD);
		
		btnKH = new JButton("Khách Hàng");
		btnKH.setBounds(5, 300, 200, 60);
		btnKH.add(lbKH);
		btnKH.setBackground(new Color(0, 206, 209));
		btnKH.setBorder(null);
		add(btnKH);
		center.add(btnKH);
		
		btnNV = new JButton("Nhân Viên");
		btnNV.setBounds(5, 350, 200, 60);
		btnNV.add(lbNV);
		btnNV.setBackground(new Color(0, 206, 209));
		btnNV.setBorder(null);
		add(btnNV);
		center.add(btnNV);
		
		btnDX = new JButton("Đăng Xuất");
		btnDX.setBounds(5, 400, 200, 60);
		btnDX.add(lbDX);
		btnDX.setBackground(new Color(0, 206, 209));
		btnDX.setBorder(null);
		add(btnDX);
		center.add(btnDX);
		
		btnHD.addActionListener(this);
		btnKH.addActionListener(this);
		btnDV.addActionListener(this);
		btnNV.addActionListener(this);
		btnPH.addActionListener(this);
		btnDX.addActionListener(this);
		btnloaiphong.addActionListener(this);
		btntang.addActionListener(this);
		
		TitledBorder tlSouth = new TitledBorder("Chọn Tác Vụ");
		center.setBorder(tlSouth);
		
		add(center, BorderLayout.WEST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnKH)) {
			khachhang_Frm khg= new khachhang_Frm();
	        khg.setVisible(true);
	        khg.setLocationRelativeTo(null);
		}
		else if(e.getSource().equals(btnHD)) {
				hoadon_Frm hdg = new hoadon_Frm();
				hdg.setVisible(true);
				hdg.setLocationRelativeTo(null);
		}
		else if(e.getSource().equals(btnDV)) {
			DichVu_Frm dvg = new DichVu_Frm();
			dvg.setVisible(true);
			dvg.setLocationRelativeTo(null);
		}
		else if(e.getSource().equals(btnNV)) {
			NhanVien_Frm nvg = new NhanVien_Frm();
			nvg.setVisible(true);
			nvg.setLocationRelativeTo(null);
		}
		else if(e.getSource().equals(btnPH)) {
			Phong_Frm pg = new Phong_Frm();
			pg.setVisible(true);
			pg.setLocationRelativeTo(null);
		}
		else if(e.getSource().equals(btnDX)) {
			DangNhap login = new DangNhap();
			login.setVisible(true);
			login.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new menu_GUI().setVisible(true);
	}
	
}
