package com.iuh.maybayManager.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.iuh.maybayManager.entity.CB;

public class CBTableModel extends AbstractTableModel{
	

	private static final long serialVersionUID = 1L;
	private static final int SOCB = 0;
	private static final int SANBAY = 1;
	private static final int CHANGBAY = 2;
	private static final int NGAYBAY = 3;
	private static final int NHAGA = 4;
	private static final int SOGHE = 5;
	private static final int QUAY = 6;
	private static final int TINHTRANG = 7;
	private ArrayList<CB> dsCB;
	private String [] headers = "SoCB;SanBay;ChangBay;NgayBay;NhaGa;SoGhe;Quay;TinhTrang".split(";");

	/**
	 * @param dsCB
	 */
	public CBTableModel(ArrayList<CB> dsCB) {
		this.dsCB = dsCB;
	}
	
	@Override
	public int getRowCount() {
		return dsCB.size();
	}
	
	@Override
	public int getColumnCount() {
		return headers .length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CB s = dsCB.get(rowIndex);
		switch (columnIndex) {
		case SOCB:
			return s.getSoCB();
		case SANBAY:
			return s.getSanBay();
		case CHANGBAY:
			return s.getChangBay();
		case NGAYBAY:
			return s.getNgayBay();
		case NHAGA:
			return s.getNhaGa();
		case SOGHE:
			return s.getSoGhe();
		case QUAY:
			return s.getQuay();
		case TINHTRANG:
			return s.getTinhTrang();
		default:
			return s;
		}
	}
	
	//Tieu de cột cho Table
	@Override
	public String getColumnName(int column) {
		return headers[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == SOGHE || columnIndex == NGAYBAY)
			return Integer.class;
		if(columnIndex == QUAY)
			return Double.class;
		return String.class;
	}
}
