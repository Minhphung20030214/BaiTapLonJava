package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import QuanLyKhachSan.khachhang;

public class khachhang_GUI extends JFrame implements ActionListener{
	private JPanel pnBorder, top , center, bottom;
	private JLabel lbmaKH, lbtenKH, lbsocancuoc, lbsdt, lbdiachiKH;
	private JTextField txtmaKH, txttenKH, txtsocancuoc, txtsdt, txtdiachiKH;
	private JButton btnthem, btnxoatrang, btnxoa, btnsua;
	DefaultTableModel model;
	private JTable table;
	private ArrayList<khachhang> ls;
	
	public khachhang_GUI() {
		setSize(700,500);
		setTitle("Khách Hàng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gui();
	}
	
	public void gui() {
		pnBorder = new JPanel();
		top = new JPanel();
		//
		top.setBackground(Color.cyan);
		//
		Box a = Box.createVerticalBox();
		Box a1, a2, a3, a4, a5;
		
		a.add(a1 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a1.add(lbmaKH = new JLabel("Mã Khách Hàng: "));
		a1.add(txtmaKH = new JTextField(30));
		
		a.add(a2 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a2.add(lbtenKH = new JLabel("Tên Khách Hàng: "));
		a2.add(txttenKH = new JTextField(30));

		a.add(a5 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a5.add(lbdiachiKH = new JLabel("Địa chỉ khách hàng: "));
		a5.add(txtdiachiKH = new JTextField(30));
		
		a.add(a3 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a3.add(lbsocancuoc = new JLabel("Số Căn Cước: "));
		a3.add(txtsocancuoc = new JTextField(30));
		
		a.add(a4 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a4.add(lbsdt = new JLabel("Số Điện Thoại: "));
		a4.add(txtsdt = new JTextField(30));
		
		lbmaKH.setPreferredSize(lbdiachiKH.getPreferredSize());
		lbsdt.setPreferredSize(lbdiachiKH.getPreferredSize());
		lbsocancuoc.setPreferredSize(lbdiachiKH.getPreferredSize());
		lbtenKH.setPreferredSize(lbdiachiKH.getPreferredSize());
		
		pnBorder.add(top);
		top.add(a);
		
		add(top, BorderLayout.NORTH);
		
		//
		center = new JPanel();
		pnBorder.add(center);
		
		taobang();
		add(center, BorderLayout.CENTER);
		
		//
		bottom  = new JPanel();
		bottom.add(btnthem = new JButton("Thêm"));
		bottom.add(btnsua = new JButton("Sửa"));
		bottom.add(btnxoatrang = new JButton("Xóa Trắng"));
		bottom.add(btnxoa = new JButton("Xóa"));
		
		pnBorder.add(bottom);
		add(bottom, BorderLayout.SOUTH);
		
		btnthem.addActionListener(this);
		btnsua.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnxoa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void taobang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Số Căn Cước");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Địa Chỉ khách Hàng");
	
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(600, 250));
		center.add(sp);
	}
	
	public static void main(String[] args) {
		new khachhang_GUI().setVisible(true);
	}
}
