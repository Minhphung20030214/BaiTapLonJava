package QuanLyKhachSan;

public class khachhang {
	private String maKH;
	private String tenKH;
	private String soCanCuoc;
	private String sdt;
	private String diachikhachhang;
	
	public khachhang(String maKH, String tenKH, String soCanCuoc, String sdt, String diachikhachhang) {
		super();
		setMaKH(maKH);
		setSoCanCuoc(soCanCuoc);
		setSdt(sdt);
		setTenKH(tenKH);
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		if(!maKH.trim().equals(""))
			this.maKH = maKH;
		this.maKH = "Ma khach hang khong duoc rong!";
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		if(!tenKH.trim().equals(""))
			this.tenKH = tenKH;
		this.tenKH = "Ten Khach Hang Khong duoc rong!";
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		if(!sdt.trim().equals(sdt))
			this.sdt = sdt;
		this.sdt = "SDT Khong duoc rong!";
	}

	public String getSoCanCuoc() {
		return soCanCuoc;
	}

	public void setSoCanCuoc(String soCanCuoc) {
		if(!soCanCuoc.trim().equals(""))
			this.soCanCuoc = soCanCuoc;
		this.soCanCuoc  = "So Can Cuoc khong duoc rong!";
	}

	public String getDiachikhachhang() {
		return diachikhachhang;
	}

	public void setDiachikhachhang(String diachikhachhang) {
		if(!diachikhachhang.trim().equals(""))
			this.diachikhachhang = diachikhachhang;
		this.diachikhachhang = "Dia chi khach hang khong duoc rong!";
	}

	@Override
	public String toString() {
		return "khachhang [maKH=" + maKH + ", tenKH=" + tenKH + ", soCanCuoc=" + soCanCuoc + ", sdt=" + sdt
				+ ", diachikhachhang=" + diachikhachhang + "]";
	}
	
	
}
