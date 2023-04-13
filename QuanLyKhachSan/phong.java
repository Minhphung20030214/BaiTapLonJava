package QuanLyKhachSan;

public class phong {
	private String Ma;
	private String Ten;
	private String Loai;
	private String GhiChu;
	private String TinhNang;
	
	public phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public phong(String ma, String ten, String loai, String ghiChu, String tinhNang) {
		super();
		Ma = ma;
		Ten = ten;
		Loai = loai;
		GhiChu = ghiChu;
		TinhNang = tinhNang;
	}
	public String getMa() {
		return Ma;
	}
	public void setMa(String ma) {
		Ma = ma;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getLoai() {
		return Loai;
	}
	public void setLoai(String loai) {
		Loai = loai;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getTinhNang() {
		return TinhNang;
	}
	public void setTinhNang(String tinhNang) {
		TinhNang = tinhNang;
	}
	@Override
	public String toString() {
		return "phong [Ma=" + Ma + ", Ten=" + Ten + ", Loai=" + Loai + ", GhiChu=" + GhiChu + ", TinhNang=" + TinhNang
				+ "]";
	}
	
}
