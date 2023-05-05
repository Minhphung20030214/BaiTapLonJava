package UI;

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

public class hoadon_Frm extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnBorder, top, center, bottom;
	private JLabel lbmahoadon, lbtenkhachhang, lbdiachikhachhang, lbngaythanhtoan, lbtrigia;
	private JTextField txtmahoadon, txttenkhachhang, txtdiachikhachhang, txtngaythanhtoan, txttrigia;
	private JButton btnthem, btnxoatrang, btnxoa, btnsua;
	DefaultTableModel model;
	JTable table;
	private dsHoaDon ds = new dsHoaDon();
	public hoadon_Frm() {
		setTitle("Hóa Đơn");
		setSize(700,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
			if(txtmahoadon.getText().equals("") || txtngaythanhtoan.getText().equals("") || txtdiachikhachhang.getText().equals("") ||
					txttenkhachhang.getText().equals("") || txttrigia.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn phải nhập đầy đủ thông tin!");
			}else {
					them();
					txtmahoadon.requestFocus();
				}
		}
		if(e.getSource().equals(btnxoa)) {
			delete();
		}
		if(e.getSource().equals(btnxoatrang)) {
			txtdiachikhachhang.setText("");
			txtmahoadon.setText("");
			txtngaythanhtoan.setText("");
			txttenkhachhang.setText("");
			txttrigia.setText("");
		}
		if(e.getSource().equals(btnsua)) {

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
	
	public void them(){
		String mahd = txtmahoadon.getText();
		String tenkh = txttenkhachhang.getText();
		String diachiKH = txtdiachikhachhang.getText();
		String ngaythanhtoan = txtngaythanhtoan.getText();
		String trigia = txttrigia.getText();
		
		hoadon hd = new hoadon(mahd, tenkh, diachiKH, ngaythanhtoan, Double.parseDouble(trigia));
		if(ds.them(hd)) {			
			String [] row = {mahd, tenkh, diachiKH, ngaythanhtoan, trigia};
			model.addRow(row);
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
		else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại");
			txtmahoadon.requestFocus();
		}
	}
	public void delete() {
		int r = table.getSelectedRow();
		if(r != -1) {
			int tb = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Delete", JOptionPane.YES_NO_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				ds.xoavitri(r);
				model.removeRow(r);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
		}
	}
	
	public class dsHoaDon implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8574225001915849257L;
		private ArrayList<hoadon> ls;
		public dsHoaDon () {
			ls = new ArrayList<>();
		}
		
		//them hoa don
		public boolean them(hoadon hd) {
			for(int i = 0; i < ls.size(); i++) {
				if(ls.get(i).getMahoadon().equalsIgnoreCase(hd.getMahoadon())) 
					return false;}
			ls.add(hd);
			return true;
		}
		//xoavitri
		public boolean xoavitri(int index) {
			if(index >= 0 && index <= ls.size()-1) {
				ls.remove(index);
				return true;
			}
			return false;	
		}
		//suathongtin
		 public boolean suaHD(String maHD, String tenKH, String diachiKH, String ngaythanhtoan, double trigia) throws Exception{
		        hoadon hd = new hoadon(maHD, tenKH, diachiKH, ngaythanhtoan, trigia);
		        if(ls.contains(hd)){
		            hd.setDiachikhachhang(diachiKH);
		            hd.setMahoadon(maHD);
		            hd.setNgaythanhtoan(ngaythanhtoan);
		            hd.setTenkhachhang(tenKH);
		            hd.setTrigia(trigia);
		            return true;
		        }
		        else
		            return false;
		    }
		
	}
	
}
