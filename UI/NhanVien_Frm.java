package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVien_Frm extends JFrame implements ActionListener,MouseListener{
	JLabel lbMa, lbTen, lbChuc, lbTim, lbLuong, lbGioiTinh, lbNamSinh;
	JTextField txtMa, txtTen, txtChuc, txtTim, txtGioiTinh, txtLuong, txtNamSinh;
	JButton btThem, btXoa, btSua, btXoaTrang, btThoat, btTim;
	public NhanVien_Frm() {
		setTitle("NHÂN VIÊN");
		setSize(900, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel pnnorth = new JPanel();
		add(pnnorth,BorderLayout.NORTH);
		pnnorth.setLayout(null);
		pnnorth.setPreferredSize(new Dimension(0,160));
		pnnorth.setBorder(BorderFactory.createTitledBorder("NHÂN VIÊN"));
		
		pnnorth.add(lbMa = new JLabel("MÃ NHÂN VIÊN:")); 
		pnnorth.add(lbTen = new JLabel("TÊN NHÂN VIÊN:"));
		pnnorth.add(lbChuc = new JLabel("CHỨC VỤ:"));
		pnnorth.add(lbLuong = new JLabel("LƯƠNG:"));
		pnnorth.add(lbGioiTinh = new JLabel("GIỚI TÍNH:"));
		pnnorth.add(lbNamSinh = new JLabel("NĂM SINH:"));
		
		pnnorth.add(txtMa = new JTextField());
		pnnorth.add(txtTen = new JTextField());
		pnnorth.add(txtChuc = new JTextField());
		pnnorth.add(txtLuong = new JTextField());
		pnnorth.add(txtGioiTinh= new JTextField());
		pnnorth.add(txtNamSinh = new JTextField());
		
		lbMa.setBounds(300, 20, 100, 20);
		lbTen.setBounds(300, 40, 100, 20);
		lbChuc.setBounds(300, 60, 100, 20);
		lbLuong.setBounds(300, 80, 100, 20);
		lbGioiTinh.setBounds(300, 100, 100, 20);
		lbNamSinh.setBounds(300, 120, 100, 20);
		
		txtMa.setBounds(420, 20, 300, 20);
		txtTen.setBounds(420, 40, 300, 20);
		txtChuc.setBounds(420, 60, 300, 20);
		txtLuong.setBounds(420, 80, 300, 20);
		txtGioiTinh.setBounds(420, 100, 300, 20);
		txtNamSinh.setBounds(420, 120, 300, 20);
		
		JPanel pncenter = new JPanel();
		add(pncenter,BorderLayout.CENTER);
		pncenter.add(btThem = new JButton("THÊM"));
		pncenter.add(btXoa = new JButton("XÓA"));
		pncenter.add(btSua = new JButton("SỬA"));
		pncenter.add(btXoaTrang = new JButton("XÓA TRẮNG"));
		pncenter.add(btTim = new JButton("TÌM KIẾM"));
		pncenter.add(lbTim= new JLabel("NHẬP MÃ PHÒNG"));
		pncenter.add(txtTim =new JTextField(10));
		pncenter.add(btThoat = new JButton("THOÁT"));
		
		JScrollPane scroll;
		String [] tieuDe = "MÃ NHÂN VIÊN; TÊN NHÂN VIÊN; CHỨC VỤ; LƯƠNG; GIỚI TÍNH; NĂM SINH".split(";");
		DefaultTableModel TableModel = new DefaultTableModel(tieuDe, 10);
		
		JTable table;
		add(scroll = new JScrollPane(table = new JTable(TableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder(""));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
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
		
	}
	public static void main(String[] args) {
		new NhanVien_Frm().setVisible(true);
	}
}
