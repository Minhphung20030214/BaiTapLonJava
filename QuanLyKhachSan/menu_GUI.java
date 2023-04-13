package QuanLyKhachSan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GUI.khachhang_GUI;
import GUI.DichVu_GUI;
import GUI.NhanVien_Frm;
import GUI.PhongForm;
import GUI.hoadon_GUI;


public class menu_GUI extends JFrame implements ActionListener{
	private JPanel pnBorder, top, center;
	private JButton btnKH, btnHD, btnNV, btnDV, btnPH;
	
	public menu_GUI() {
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("MENU");
		gui();
	}
	
	public void gui() {
		pnBorder = new JPanel();
		top = new JPanel();
		center = new JPanel();
		
		JLabel lbtl = new JLabel("MENU");
		lbtl.setForeground(Color.BLUE);
		Font ft = new Font("Arial", Font.BOLD, 25);
		lbtl.setFont(ft);
		
		top.setBackground(Color.LIGHT_GRAY);
		top.add(lbtl);
		
		pnBorder.add(top);
		add(top, BorderLayout.NORTH);
		
		//
		center.add(btnKH = new JButton("KHACH HANG"));
//		btnKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cust.png")));
		center.add(btnHD= new JButton("HOA DON"));
		center.add(btnDV = new JButton("DICH VU"));
		center.add(btnNV = new JButton("NHAN VIEN"));
		center.add(btnPH = new JButton("PHONG"));
		
		btnHD.addActionListener(this);
		btnKH.addActionListener(this);
		btnDV.addActionListener(this);
		btnNV.addActionListener(this);
		btnPH.addActionListener(this);
		center.setBackground(Color.LIGHT_GRAY);
		pnBorder.add(center);
		add(center, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnKH)) {
			khachhang_GUI khg= new khachhang_GUI();
	        khg.setVisible(true);
	        khg.pack();
	        khg.setLocationRelativeTo(null);
	        khg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		else if(e.getSource().equals(btnHD)) {
				hoadon_GUI hdg = new hoadon_GUI();
				hdg.setVisible(true);
				hdg.pack();
				hdg.setLocationRelativeTo(null);
				hdg.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else if(e.getSource().equals(btnDV)) {
			DichVu_GUI dvg = new DichVu_GUI();
			dvg.setVisible(true);
			dvg.pack();
			dvg.setLocationRelativeTo(null);
			dvg.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else if(e.getSource().equals(btnNV)) {
			NhanVien_Frm nvg = new NhanVien_Frm();
			nvg.setVisible(true);
			nvg.pack();
			nvg.setLocationRelativeTo(null);
			nvg.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else if(e.getSource().equals(btnPH)) {
			PhongForm pg = new PhongForm();
			pg.setVisible(true);
			pg.setSize(700,550);
			pg.setLocationRelativeTo(null);
			pg.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	public static void main(String[] args) {
		new menu_GUI().setVisible(true);
	}
	
}
