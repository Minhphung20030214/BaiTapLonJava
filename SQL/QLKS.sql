use master
go
Create database QuanLyKhachSan
go
use QuanLyKhachSan
go

 Create table tbl_ChucVu
 (
	MACHUCVU varchar (7) primary key,
	TENCHUCVU nvarchar (30)
 )

 Create table tbl_KhachHang
 (
	MAKHACHHANG varchar (5) primary key,
	TENKHACHHANG nvarchar (30),
	DIACHI nvarchar (50),
	GIOITINH nvarchar (5),
	CMND varchar (15),
	SDT char (12),
	QUOCTICH nvarchar (20)
 )

 Create table tbl_LoaiPhong 
 (	
	MALOAIPHONG nvarchar (10) primary key,
	TENLOAIPHONG nvarchar (30),
	TRANGBI nvarchar (100)
 )

 Create table tbl_NhanVien
 (
	MANHANVIEN varchar (5) primary key,
	TENNHANVIEN nvarchar (30),
	MACHUCVU varchar (7),
	GIOITINH nvarchar (5),
	NGAYSINH smalldatetime,
	DIACHI nvarchar (50),
	SDT char (12),
	CONSTRAINT fk_tbl_NhanVien_tbl_ChucVu foreign key(MACHUCVU) references tbl_ChucVu(MACHUCVU)
 )

 Create table tbl_Phong
 (
	MAPHONG varchar (6) primary key,
	TENPHONG nvarchar (20),
	TINHTRANG nvarchar (15),
	MALOAIPHONG nvarchar (10),
	GIAPHONG int,
	CONSTRAINT fk_tbl_Phong_tbl_LoaiPhong foreign key(MALOAIPHONG) references tbl_LoaiPhong(MALOAIPHONG)
 )
 
 Create table tbl_HoaDon
 (
	MAHOADON varchar (5) primary key,
	NGAYTHANHTOAN smalldatetime,
	SOTIENDATTRUOC int,
	NGAYTHUE date,
	MANHANVIEN varchar (5),
	CONSTRAINT fk_tbl_HoaDon_tbl_NhanVien foreign key(MANHANVIEN) references tbl_NhanVien (MANHANVIEN)
 )

 Create table tbl_PhieuDangKy
 (
	MAPHIEUDANGKY varchar (5) primary key,
	MAKHACHHANG varchar (5),
	MANHANVIEN varchar (5),
	NGAYLAP smalldatetime,
	NGAYDI smalldatetime,
	MAPHONG varchar (6),
	TRATRUOC int,
	MAPHIEUDICHVU varchar (5),
	CONSTRAINT fk_tbl_PhieuDangKy_tbl_KhachHang foreign key(MAKHACHHANG) references tbl_KhachHang (MAKHACHHANG),
	CONSTRAINT fk_tbl_PhieuDangKy_tbl_NhanVien foreign key(MANHANVIEN) references tbl_NhanVien (MANHANVIEN),
	CONSTRAINT fk_tbl_PhieuDangKy_tbl_Phong foreign key(MAPHONG) references tbl_Phong (MAPHONG)
 )
 
 Create table tbl_PhieuDichVu
 (
	MAPHIEUDICHVU varchar (5) primary key,
	MAPHIEUDANGKY varchar (5),
	TENDICHVU nvarchar (30),
	GIADICHVU int,
	CONSTRAINT fk_tbl_PhieuDichVu_tbl_PhieuDangKy foreign key(MAPHIEUDANGKY) references tbl_PhieuDangKy(MAPHIEUDANGKY)
 )
