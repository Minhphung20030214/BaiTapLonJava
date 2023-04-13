package QuanLyKhachSan;

public class dichvu {
	private String maDichVu;
	private String tenDichVu;
	private double giaDichVu;
	
	public dichvu(String maDichVu, String tenDichVu, double giaDichVu) {
		setGiaDichVu(getGiaDichVu());
		setMaDichVu(maDichVu);
		setTenDichVu(tenDichVu);
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		if(!maDichVu.trim().equals(""))
			this.maDichVu = "Ma Dich Vu Khong duoc rong!";
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		if(!tenDichVu.trim().equals(""))
			this.tenDichVu = "Ten Dich Vu Khong duoc rong!";
		this.tenDichVu = tenDichVu;
	}

	public double getGiaDichVu() {
		return giaDichVu;
	}

	public void setGiaDichVu(double giaDichVu) {
		if(giaDichVu < 0 )
			this.giaDichVu = 0;
		this.giaDichVu = giaDichVu;
	}

	@Override
	public String toString() {
		return "dichvu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaDichVu=" + giaDichVu + "]";
	}
	
}
