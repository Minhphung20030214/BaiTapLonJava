﻿USE QLKS

-- Bang nhân viên
	CREATE TABLE NhanVien
	(
		MaNV VARCHAR(11)  primary key,
		TenNV VARCHAR(50) NOT NULL,
		LuongNV money,
		NgaySinh Date,
		GioiTinh char(5),
		ChuThich varchar(50)
	)
GO
-- bảng phòng
	CREATE TABLE Phong
	(
		MaPhong VARCHAR(11) NOT NULL primary key,
		TenPhong VARCHAR(50) NOT NULL,
		LoaiPhong VARCHAR(20) NOT NULL,
		GiaPhong int,
		GhiNho varchar(50),
		TinhNang varchar(50),
		MaDV varchar(20),
		MaNV VARCHAR(11) foreign key references NhanVien(MaNV)
	)
GO

-- bảng dịch vụ
	CREATE TABLE DichVu
	(
		MaDV varchar(20) primary key,
		TenDv varchar(50) NOT NULL,
		GiaDV money,
		MaPhong VARCHAR(11) foreign key references Phong(MaPhong)
	)
GO

-- bảng khách hàng
	CREATE TABLE Khachhang
	(
		MaKH varchar(11) NOT NULL primary key,
		TenKH varchar(50) NOT NULL,
		DiaChi varchar(50) NOT NULL,
		Sdt varchar(20),
		MaPhong VARCHAR(11) foreign key references Phong(MaPhong)
	)
GO
-- bảng hóa đơn
	CREATE TABLE HoaDon
	(
		 MaHD VARCHAR(20) NOT NULL primary key,
		 MaNV VARCHAR(11),
		 Ngay Date,
		 GiaHD int,
		 MaPhong VARCHAR(11) foreign key references Phong(MaPhong)
	)
GO