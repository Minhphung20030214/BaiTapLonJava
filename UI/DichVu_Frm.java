package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import QuanLyKhachSan.dichvu;

public class DichVu_Frm extends JFrame implements ActionListener{
	private JPanel pnBorder, top , center, bottom;
	private JLabel lbmaDV, lbtenDV, lbgiaDV;
	private JTextField txtmaDV, txttenDV, txtgiaDV;
	private JButton btThem, btXoa, btSua, btXoaTrang, btThoat, btTim;
	DefaultTableModel model;
	JTable table;
	private dsDichVu ds = new dsDichVu();
	
	
	public DichVu_Frm() {
		setSize(700, 550);
		setTitle("Dịch Vụ");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		gui();
	}
	
	public void gui() {
		pnBorder = new JPanel();
		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		
		JLabel lbtitle = new JLabel("DỊCH VỤ");
		lbtitle.setForeground(Color.BLUE);
		Font ft = new Font("Arial", Font.BOLD, 25);
		lbtitle.setFont(ft);
		top.add(lbtitle);
		
		pnBorder.add(top);
		add(top, BorderLayout.NORTH);
		top.setBackground(Color.LIGHT_GRAY);
		center.setBackground(Color.LIGHT_GRAY);
		bottom.setBackground(Color.LIGHT_GRAY);
		//
		Box a = Box.createVerticalBox();
		Box a1, a2, a3;
		
		a.add(a1 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a1.add(lbmaDV = new JLabel("Mã Dịch Vụ: "));
		a1.add(txtmaDV = new JTextField(30));
		
		a.add(a2 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a2.add(lbtenDV = new JLabel("Tên Dịch Vụ: "));
		a2.add(txttenDV = new JTextField(30));

		a.add(a3 = Box.createHorizontalBox());
		a.add(Box.createVerticalStrut(10));
		a3.add(lbgiaDV = new JLabel("Giá Dịch Vụ : "));
		a3.add(txtgiaDV = new JTextField(30));
		
		lbmaDV.setPreferredSize(lbtenDV.getPreferredSize());
		lbgiaDV.setPreferredSize(lbtenDV.getPreferredSize());
		
		center.add(a);
		taobang();
		pnBorder.add(center);
		add(center, BorderLayout.CENTER);
		
		bottom.add(btThem = new JButton("Thêm"));
		bottom.add(btSua = new JButton("Sửa"));
		bottom.add(btXoaTrang = new JButton("Xóa Trắng"));
		bottom.add(btXoa = new JButton("Xóa"));
		bottom.add(btThoat = new JButton("Thoát"));
		
		pnBorder.add(bottom);
		add(bottom, BorderLayout.SOUTH);
		
		btThem.addActionListener(this);
		btSua.addActionListener(this);
		btXoaTrang.addActionListener(this);
		btXoa.addActionListener(this);
		btThoat.addActionListener(this);
		
	}
	
	public void taobang() {
		model = new DefaultTableModel();
		table = new JTable(model);
		
		model.addColumn("Mã Dịch Vụ");
		model.addColumn("Tên Dịch Vụ");
		model.addColumn("Giá Dịch Vụ");
		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(650, 250));
		center.add(sp);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btThoat)) {
			System.exit(1);
		}
		
		else if(e.getSource().equals(btThem))
		{
			if(txtmaDV.getText().equals("") || txttenDV.getText().equals("") || txtgiaDV.getText().equals("")){
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
		else if(e.getSource().equals(btXoa)) {
			delete();
		}
		else if(e.getSource().equals(btXoaTrang)) {
			txtmaDV.setText("");
			txttenDV.setText("");
			txtgiaDV.setText("");
		}
		
	}
	
	public void them() {
		String ma = txtmaDV.getText();
		String ten = txttenDV.getText();
		String gia = txtgiaDV.getText();
		
		dichvu dv = new dichvu(ma, ten, Double.parseDouble(gia));
		if(ds.them(dv)) {
			String [] row = {ma, ten, gia};
			model.addRow(row);
			JOptionPane.showInternalMessageDialog(null, "Thêm Thành Công!");
		}
		else {
			JOptionPane.showInternalMessageDialog(null, "Thêm Thất Bại!");
			txtmaDV.requestFocus();
			txttenDV.requestFocus();
		}	
	}
	
	
	public void delete() {
		int r = table.getSelectedRow();
		if(r != -1) {
			int tb = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this line?", "Delete", JOptionPane.YES_NO_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				model.removeRow(r);
				ds.xoavitri(r);
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Select the line you want to delete!");
	}
	
	public class dsDichVu {
		public ArrayList<dichvu> ls;
		
		public dsDichVu() {
			ls = new ArrayList<>();
		}
		//themcountry
		public boolean them(dichvu dv) {
			for(int i = 0; i < ls.size(); i++) {
				if(ls.get(i).getMaDichVu().equalsIgnoreCase(dv.getMaDichVu()))
					return false;
			}
			ls.add(dv);
			return true;
		}
		//search
		public int search(String madv, String tendv) {
			for(int i = 0; i < ls.size(); i++)
				if(ls.get(i).getMaDichVu().equalsIgnoreCase(madv))
					return i;
				else if(ls.get(i).getMaDichVu().equalsIgnoreCase(madv))
					return i;
				return -1;
		}
		//xoavitri
		public boolean xoavitri(int p) {
			if(p >= 0 && p <= ls.size()-1)
			{
				ls.remove(p);
				return true;
			}
			return false;
		}
	}
}
