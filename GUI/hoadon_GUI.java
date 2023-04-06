package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import QuanLyKhachSan.hoadon;
import ct.sach;

public class hoadon_GUI extends JFrame implements ActionListener{
	
	private JPanel pnBorder, top, center, bottom;
	private JLabel lbmahoadon, lbtenkhachhang, lbdiachikhachhang, lbngaythanhtoan, lbtrigia;
	private JTextField txtmahoadon, txttenkhachhang, txtdiachikhachhang, txtngaythanhtoan, txttrigia;
	private JButton btnthem, btnxoatrang, btnxoa, btnsua;
	DefaultTableModel model;
	private JTable table;
	private ArrayList<hoadon> ls;
	private dsHoaDon ds = new dsHoaDon();
	public hoadon_GUI() {
		setTitle("Hóa Đơn");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gui();
	}
	
	public void gui() {
		pnBorder = new JPanel();
		top = new JPanel();
		
		Box a = Box.createVerticalBox();
		Box a1, a2, a3, a4, a5;
		
		a.add(a1 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a1.add(lbmahoadon = new JLabel("Mã Hóa Đơn: "));
		a1.add(txtmahoadon = new JTextField(30));
		
		a.add(a2 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a2.add(lbtenkhachhang = new JLabel("Tên Khách Hàng: "));
		a2.add(txttenkhachhang = new JTextField(30));

		a.add(a3 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a3.add(lbdiachikhachhang = new JLabel("Địa chỉ khách hàng: "));
		a3.add(txtdiachikhachhang = new JTextField(30));
		
		a.add(a4 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a4.add(lbngaythanhtoan = new JLabel("Ngày Thanh Toán: "));
		a4.add(txtngaythanhtoan = new JTextField(30));
		
		a.add(a5 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a5.add(lbtrigia = new JLabel("Trị Giá: "));
		a5.add(txttrigia = new JTextField(30));
		
		lbmahoadon.setPreferredSize(lbdiachikhachhang.getPreferredSize());
		lbngaythanhtoan.setPreferredSize(lbdiachikhachhang.getPreferredSize());
		lbtenkhachhang.setPreferredSize(lbdiachikhachhang.getPreferredSize());
		lbtrigia.setPreferredSize(lbdiachikhachhang.getPreferredSize());
		
		top.add(a);
		pnBorder.add(top);
		
		add(top, BorderLayout.NORTH);
		//table
		center = new JPanel();
		taobang();
		pnBorder.add(center);
		
		add(center, BorderLayout.CENTER);
		
		//button
		bottom = new JPanel();
		
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
		if(e.getSource().equals(btnthem))
		{
			try {
				them();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void taobang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Mã Hóa Đơn");
		model.addColumn("Tên Khách Hàng");
		model.addColumn("Địa Chỉ khách Hàng");
		model.addColumn("Ngày Thanh Toán");
		model.addColumn("Trị Giá");
	
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(600, 250));
		center.add(sp);
	}
	
	public void them() throws Exception{
		String mahd = txtmahoadon.getText();
		String tenkh = txttenkhachhang.getText();
		String diachiKH = txtdiachikhachhang.getText();
		String ngaythanhtoan = txtngaythanhtoan.getText();
		String trigia = txttrigia.getText();
		
		hoadon hd = new hoadon(mahd, tenkh, diachiKH, ngaythanhtoan, Double.parseDouble(trigia));
		if(ds.them(hd)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
			String [] row = {mahd, tenkh, diachiKH, ngaythanhtoan, trigia};
			model.addColumn(row);
		}else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại");
			txtmahoadon.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new hoadon_GUI().setVisible(true);
	}
	public class dsHoaDon implements Serializable{
		public void dsHoaDon () {
			ls = new ArrayList<>();
		}
		
		public boolean them(hoadon hd) {
			for(int i = 0; i < ls.size(); i++)
				if(ls.get(i).getMahoadon().equalsIgnoreCase(hd.getMahoadon()))
					return false;
			return true;
		}
	}
	
}
