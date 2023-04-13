package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import QuanLyKhachSan.hoadon;
import QuanLyKhachSan.khachhang;

public class khachhang_GUI extends JFrame implements ActionListener{
	private JPanel pnBorder, top , center, bottom;
	private JLabel lbmaKH, lbtenKH, lbsocancuoc, lbsdt, lbdiachiKH;
	private JTextField txtmaKH, txttenKH, txtsocancuoc, txtsdt, txtdiachiKH;
	private JButton btnthem, btnxoatrang, btnxoa, btnsua, btnthoat;
	DefaultTableModel model;
	private JTable table;
	private ArrayList<khachhang> ls;
	private dskhachhang ds = new dskhachhang();
	
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
		center = new JPanel();
		bottom  = new JPanel();
		//
//		top.setBackground(Color.cyan);
//		center.setBackground(Color.cyan);
//		bottom.setBackground(Color.cyan);
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

		pnBorder.add(center);
		
		taobang();
		add(center, BorderLayout.CENTER);
		
		//

		bottom.add(btnthem = new JButton("Thêm"));
		bottom.add(btnsua = new JButton("Sửa"));
		bottom.add(btnxoatrang = new JButton("Xóa Trắng"));
		bottom.add(btnxoa = new JButton("Xóa"));
		bottom.add(btnthoat = new JButton("Thoát"));
		
		pnBorder.add(bottom);
		add(bottom, BorderLayout.SOUTH);
		
		btnthem.addActionListener(this);
		btnsua.addActionListener(this);
		btnxoatrang.addActionListener(this);
		btnxoa.addActionListener(this);
		btnthoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnthoat)) {
			System.exit(1);
		}
		
		else if(e.getSource().equals(btnthem))
		{
			if(txtmaKH.getText().equals("") || txttenKH.getText().equals("") || txtdiachiKH.getText().equals("") ||
					txtsdt.getText().equals("") || txtsocancuoc.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn phải nhập đầy đủ thông tin!");
			}else {
				try {
					them();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		else if(e.getSource().equals(btnxoa)) {
			delete();
		}
		else if(e.getSource().equals(btnxoatrang)) {
			txtmaKH.setText("");
			txttenKH.setText("");
			txtdiachiKH.setText("");
			txtsocancuoc.setText("");
			txtsdt.setText("");
		}
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
	
	public void them() throws Exception{
		String makh = txtmaKH.getText();
		String tenkh = txttenKH.getText();
		String diachiKH = txtdiachiKH.getText();
		String socancuoc = txtsocancuoc.getText();
		String sdt = txtsdt.getText();
		
		khachhang kh = new khachhang(makh, tenkh, diachiKH, socancuoc, sdt);
		if(ds.them(kh)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công!");
			String [] row = {makh, tenkh, diachiKH, socancuoc, sdt};
			model.addRow(row);
		}else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại");
			txtmaKH.requestFocus();
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
	
	
	
	public class dskhachhang implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private ArrayList<khachhang> ls;
		public dskhachhang(){
			ls = new ArrayList<>();
		}
		//them 
				public boolean them(khachhang kh) {
					for(int i = 0; i < ls.size(); i++)
						if(ls.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH()))
							return false;
					ls.add(kh);
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
				 public boolean suaKH(String maKH, String tenKH, String diachiKH, String sdt, String socancuoc) throws Exception{
				        khachhang kh = new khachhang(maKH, tenKH, diachiKH, sdt, socancuoc);
				        if(ls.contains(kh)){
				            kh.setDiachikhachhang(diachiKH);
				            kh.setMaKH(maKH);
				            kh.setSdt(sdt);
				            kh.setSoCanCuoc(socancuoc);
				            kh.setTenKH(tenKH);
				            return true;
				        }
				        else
				            return false;
				    }
				
	}
}
