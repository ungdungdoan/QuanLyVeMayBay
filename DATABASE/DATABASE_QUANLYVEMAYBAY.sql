CREATE DATABASE QUANLYVEMAYBAY
ON PRIMARY
( 
	NAME ='QUANLYVEMAYBAY_data',
	FILENAME='D:\DataBase\QUANLYVEMAYBAY.mdf',
	SIZE=5MB,
	MAXSIZE=50MB,
	FILEGROWTH=10%
)
	LOG ON
(
	NAME ='QUANLYVEMAYBAY_log',
	FILENAME='D:\DataBase\QUANLYVEMAYBAY_log.ldf',
	SIZE=5MB,
	MAXSIZE=50MB,
	FILEGROWTH=10%
)

CREATE TABLE SANBAY
(
	MaSanBay varchar(10) not null primary key,
	TenSanBay nvarchar(50) not null
	)
CREATE TABLE MAYBAY
(
	MaMayBay varchar(10) not null primary key,
	TenMayBay nvarchar(50) not null
	
)
CREATE TABLE TUYENBAY
(
	MaTuyenBay varchar(12) primary key not null,
	SanBayDi nvarchar(50) null,
	SanBayDen nvarchar(50) null
)
CREATE TABLE CHUYENBAY
(
	MaChuyenBay varchar(20) primary key not null,
	NgayGio datetime,
	ThoiGianBay datetime,
	SoGheHang1 int,
	SoGheHang2 int, 
	MaMayBay varchar(10),
	MaTuyenBay varchar(12)

)
CREATE TABLE CHITIETCHUYENBAY
(
	MaChiTietChuyenBay varchar(20) primary key not null,
	SanBayTrungTam varchar(20),
	ThoiGianDung datetime,
	GhiChu varchar(200)
	
)
CREATE TABLE VECHUYENBAY
(
	MaVeChuyenBay varchar(12) primary key not null,
	TinhTrangVe nvarchar(20) not null,
	
)
CREATE TABLE KHACHHANG
(
	TenKhachHang varchar(12) primary key not null,
	CMND nvarchar(20) not null,
	DienThoai char(15)
	
)
CREATE TABLE NHANVIEN
(
	MaNhanVien varchar(12) primary key not null,
	TenNhanVien varchar(50),
	DienThoai int
	
)
CREATE TABLE PHIEUDATCHO
(
	MaDatPhieuCho varchar(12) primary key not null,
	NgayDat datetime,
	SoGheDat int,
	MaChuyenBay varchar(20)
	
)
CREATE TABLE DONGIA
(
	MaDonGia varchar(12) primary key not null,
	USD money,
	VNDong money
	
)
CREATE TABLE HANGVE
(
	MaHangVe varchar(12) primary key not null,
	TenHangVe nvarchar(50)
	
)
CREATE TABLE HOADON
(
	MaHoaDon varchar(12) primary key not null,
	TenNhanVien varchar(50),
	DienThoai int
	
)