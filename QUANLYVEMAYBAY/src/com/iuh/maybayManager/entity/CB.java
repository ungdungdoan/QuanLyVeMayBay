package com.iuh.maybayManager.entity;

public class CB {
	
	//Data fields
	
	private String SoCB;
	private String SanBay;
	private String ChangBay;
	private int NgayBay;
	private String NhaGa;
	private int SoGhe;
	private double Quay;
	private String TinhTrang;
	
	//Constructors
	


	public CB(String soCB, String sanBay, String changBay, int ngayBay, String nhaGa, int soGhe, double quay,
			String tinhTrang) {
		this.SoCB = soCB;
		this.SanBay = sanBay;
		this.ChangBay = changBay;
		this.NgayBay = ngayBay;
		this.NhaGa = nhaGa;
		this.SoGhe = soGhe;
		this.Quay = quay;
		this.TinhTrang = tinhTrang;
	}
	
	public CB(String SoCB) {
		this(SoCB, "San Bay", "Chang Bay", 0, "Nha Ga", 0, 0.0, "Tinh Trang");
	}


	public String getSoCB() {
		return SoCB;
	}

	public void setSoCB(String soCB) {
		SoCB = soCB;
	}

	public String getSanBay() {
		return SanBay;
	}

	public void setSanBay(String sanBay) {
		SanBay = sanBay;
	}

	public String getChangBay() {
		return ChangBay;
	}

	public void setChangBay(String changBay) {
		ChangBay = changBay;
	}

	public int getNgayBay() {
		return NgayBay;
	}

	public void setNgayBay(int ngayBay) {
		NgayBay = ngayBay;
	}

	public String getNhaGa() {
		return NhaGa;
	}

	public void setNhaGa(String nhaGa) {
		NhaGa = nhaGa;
	}

	public int getSoGhe() {
		return SoGhe;
	}

	public void setSoGhe(int soGhe) {
		SoGhe = soGhe;
	}

	public double getQuay() {
		return Quay;
	}

	public void setQuay(double quay) {
		Quay = quay;
	}

	public String getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		TinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SoCB == null) ? 0 : SoCB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CB other = (CB) obj;
		if (SoCB == null) {
			if (other.SoCB != null)
				return false;
		} else if (!SoCB.equalsIgnoreCase(other.SoCB))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return SoCB + ";" +   SanBay + ";" + ChangBay + ";" + NgayBay
				+ ";" + NhaGa + ";" +  SoGhe + ";" + Quay + ";" + TinhTrang;
	}

}//end class
