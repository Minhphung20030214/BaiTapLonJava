package QuanLyKhachSan;

import java.sql.Date;

public class hoadon {
	private String mahoadon;
	private String tenkhachhang;
	private String diachikhachhang;
	private String ngaythanhtoan;
	private double trigia;
	
	public hoadon(String mahoadon, String tenkhachhang, String diachikhachhang, String ngaytrigia, double trigia) {
		super();
		setDiachikhachhang(diachikhachhang);
		setMahoadon(mahoadon);
		setNgaythanhtoan(ngaytrigia);
		setTenkhachhang(tenkhachhang);
		try {
			setTrigia(trigia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(String mahoadon) {
		if(!mahoadon.trim().equals(""))
			this.mahoadon = mahoadon;
		this.mahoadon = "Ma Hoa Don Khong Duoc Rong Nha!";
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		if(!tenkhachhang.trim().equals(""))
			this.tenkhachhang = tenkhachhang;
		this.tenkhachhang = "Ten Khach Hang khong duoc rong nhe!";
	}

	public String getDiachikhachhang() {
		return diachikhachhang;
	}

	public void setDiachikhachhang(String diachikhachhang) {
		if(!diachikhachhang.trim().equals(""))
			this.diachikhachhang = diachikhachhang;
		this.diachikhachhang = "Dia Chi khach hang khong duoc rong!";
	}

	public String getNgaythanhtoan() {
		return ngaythanhtoan;
	}

	public void setNgaythanhtoan(String ngaytrigia) {
		this.ngaythanhtoan = ngaytrigia;
	}

	public double getTrigia() {
		return trigia;
	}

	public void setTrigia(double trigia) throws Exception{
		if(trigia > 0)
			this.trigia = trigia;
		this.trigia = 999;
	}

	@Override
	public String toString() {
		return "hoadon [mahoadon=" + mahoadon + ", tenkhachhang=" + tenkhachhang + ", diachikhachhang="
				+ diachikhachhang + ", ngaythanhtoan=" + ngaythanhtoan + ", trigia=" + trigia + "]";
	}
}
