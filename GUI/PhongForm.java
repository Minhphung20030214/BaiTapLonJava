package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.khachhang_GUI.dskhachhang;
import QuanLyKhachSan.khachhang;
import QuanLyKhachSan.phong;

public class PhongForm extends JFrame implements ActionListener,MouseListener{
	JTextField txtMa, txtTen, txtLoai, txtTinhTrang, txtChuThich,txtTim;
	JLabel lbMa, lbTen, lbLoai, lbTinhTrang, lbChuThich,lbTim;
	JButton btThem, btXoa, btSua, btXoaTrang, btThoat, btTim;
	private ArrayList<phong> hs;
	private dsPhong hs1 = new dsPhong();
	JPanel pncenter;
	JTable table;
	private DefaultTableModel TableModel;
	public PhongForm() {
		setTitle("PHÒNG");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnnorth = new JPanel();
		pnnorth.setLayout(null);
		pnnorth.setPreferredSize(new Dimension(0, 160));
		pnnorth.setBorder(BorderFactory.createTitledBorder("THÔNG TIN PHÒNG"));
		add(pnnorth,BorderLayout.NORTH);
		pnnorth.add(lbMa = new JLabel("MÃ PHÒNG:"));
		pnnorth.add(lbTen = new JLabel("TÊN PHÒNG:"));
		pnnorth.add(lbLoai = new JLabel("LOẠI PHÒNG:"));
		pnnorth.add(lbTinhTrang = new JLabel("TÌNH TRẠNG:"));
		pnnorth.add(lbChuThich = new JLabel("CHÚ THÍCH:"));
		
		pnnorth.add(txtMa = new JTextField());
		pnnorth.add(txtTen = new JTextField());
		pnnorth.add(txtLoai = new JTextField());
		pnnorth.add(txtTinhTrang = new JTextField());
		pnnorth.add(txtChuThich = new JTextField());
		
		lbMa.setBounds(310, 20, 100, 20);
		lbTen.setBounds(310, 40, 100, 20);
		lbLoai.setBounds(310, 60, 100, 20);
		lbTinhTrang.setBounds(310, 80, 100, 20);
		lbChuThich.setBounds(310, 100, 100, 20);
		
		txtMa.setBounds(420, 20, 200, 20);
		txtTen.setBounds(420, 40, 200, 20);
		txtLoai.setBounds(420, 60, 200, 20);
		txtTinhTrang.setBounds(420, 80, 200, 20);
		txtChuThich.setBounds(420, 100, 200, 20);
		
		pncenter = new JPanel();
		add(pncenter,BorderLayout.CENTER);
		pncenter.add(btThem = new JButton("THÊM"));
		pncenter.add(btXoa = new JButton("XÓA"));
		pncenter.add(btSua = new JButton("SỬA"));
		pncenter.add(btXoaTrang = new JButton("XÓA TRẮNG"));
		pncenter.add(btTim = new JButton("TÌM KIẾM"));
		pncenter.add(lbTim= new JLabel("NHẬP MÃ PHÒNG"));
		pncenter.add(txtTim =new JTextField(10));
		pncenter.add(btThoat = new JButton("THOÁT"));
//		
//		JScrollPane scroll;
//		String [] tieuDe = "MÃ PHÒNG; TÊN PHÒNG; LOẠI PHÒNG; TÌNH TRẠNG; CHÚ THÍCH".split(";");
//		TableModel = new DefaultTableModel(tieuDe, 0);
//		
//		JTable table;
//		add(scroll = new JScrollPane(table = new JTable(TableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
//		scroll.setBorder(BorderFactory.createTitledBorder(""));
//		table.setRowHeight(20);
//		scroll.setPreferredSize(new Dimension(0, 350));
		taobang();
		
		btThem.addActionListener(this);
		btXoa.addActionListener(this);
		btSua.addActionListener(this);
		btXoaTrang.addActionListener(this);
		btTim.addActionListener(this);
		btThoat.addActionListener(this);
	}
	
	public void taobang() {
		TableModel = new DefaultTableModel();
		table = new JTable(TableModel);
		
		TableModel.addColumn("Mã Phòng");
		TableModel.addColumn("TÊN PHÒNG");
		TableModel.addColumn("LOẠI PHÒNG");
		
		TableModel.addColumn("TÌNH TRẠNG");
		TableModel.addColumn("CHÚ THÍCH");

		
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(650, 250));
		pncenter.add(sp);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btThoat)) {
			System.exit(1);
		}
		else if(e.getSource().equals(btXoaTrang)) {
			txtMa.setText("");
			txtTen.setText("");
			txtLoai.setText("");
			txtTinhTrang.setText("");
			txtChuThich.setText("");
		}
		else if(e.getSource().equals(btXoa)) {
			delete();
		}
		else if(e.getSource().equals(btThem)) {
			try {
				them();
				txtMa.setText("");
				txtTen.setText("");
				txtLoai.setText("");
				txtTinhTrang.setText("");
				txtChuThich.setText("");
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(btTim)) {
			int sear = hs1.search(this.txtTim.getText());
			if(sear == -1) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy Phòng!");
			}
			else {
				table.setRowSelectionInterval(sear, sear);
			}
		}
	}
		public void them() throws Exception{
			String Ma = txtMa.getText();
			String Ten = txtTen.getText();
			String Loai = txtLoai.getText();			
			String TinhNang = txtTinhTrang.getText();
			String GhiChu = txtChuThich.getText();
			
			phong ph = new phong(Ma, Ten, Loai, TinhNang, GhiChu);
			if(hs1.them(ph)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
				String [] row = {Ma, Ten, Loai, TinhNang, GhiChu};
				TableModel.addRow(row);
			}else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại");
				txtMa.requestFocus();
			}
		}
	public void delete() {
		
		
		int r = table.getSelectedRow();
		if(r != -1) {
			int tb = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?", "Delete", JOptionPane.YES_NO_OPTION);
			if(tb == JOptionPane.YES_OPTION) {
				hs1.xoavitri(r);
				TableModel.removeRow(r);
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng muốn xóa");
		}
	}
	
	
	public static void main(String[] args) {
		new PhongForm().setVisible(true);
	}
	public class dsPhong implements Serializable{
		private static final long serialVersionUID = 1L;
		private ArrayList<phong> hs;
		public dsPhong(){
			hs = new ArrayList<>();
		}
			//them 
				public boolean them(phong ph) {
					for(int i = 0; i < hs.size(); i++)
						if(hs.get(i).getMa().equalsIgnoreCase(ph.getMa()))
							return false;
					hs.add(ph);
					return true;
				}
				//xoavitri
				public boolean xoavitri(int index) {
					if(index >= 0 && index <= hs.size()-1) {
						hs.remove(index);
						return true;
					}
					return false;	
				}
				//suathongtin
				 public boolean suaphong(String ma, String ten, String loai, String ghiChu, String tinhNang) throws Exception{
				        phong ph = new phong(ma, ten, loai, ghiChu, tinhNang);
				        if(hs.contains(ph)){       
				            ph.setMa(ma);
				            ph.setTen(ten);
				            ph.setLoai(loai);
				            ph.setGhiChu(ghiChu);
				            ph.setTinhNang(tinhNang);
				            return true;
				        }
				        else
				            return false;
				    }
				 
				 public int search(String maPhong) {
						for(int i = 0; i < hs.size(); i++) {
							if(hs.get(i).getMa().equalsIgnoreCase(maPhong))
								return i;
							}
						return -1;
					}
	}
}