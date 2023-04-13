package GUI;

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
import javax.swing.table.TableModel;

public class Phong_frm extends JFrame implements ActionListener,MouseListener{
	JTextField txtMa, txtTen, txtLoai, txtTinhTrang, txtChuThich,txtTim;
	JLabel lbMa, lbTen, lbLoai, lbTinhTrang, lbChuThich,lbTim;
	JButton btThem, btXoa, btSua, btXoaTrang, btThoat, btTim;
	private DefaultTableModel TableModel;
	public Phong_frm() {
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
		String [] tieuDe = "MÃ PHÒNG; TÊN PHÒNG; LOẠI PHÒNG; TÌNH TRẠNG; CHÚ THÍCH".split(";");
		TableModel = new DefaultTableModel(tieuDe, 10);
		
		JTable table;
		add(scroll = new JScrollPane(table = new JTable(TableModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder(""));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
	}
	public static void main(String[] args) {
		new Phong_frm().setVisible(true);
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
}
