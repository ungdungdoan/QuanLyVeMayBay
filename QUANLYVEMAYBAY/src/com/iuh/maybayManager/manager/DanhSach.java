package com.iuh.maybayManager.manager;

import java.util.ArrayList;

import com.iuh.maybayManager.db.Database;
import com.iuh.maybayManager.entity.CB;

public class DanhSach {
	private ArrayList<CB> dsCB;

	//Khởi tạo danh sách
	public DanhSach() {
		dsCB = new ArrayList<CB>(10);
	}
	
	//Đọc dữ liệu từ file lên
	public void napDuLieuTuFile() {
		dsCB = Database.docTuFile();
	}
	
	//get toàn bộ các cuốn sách có trong tập
	public ArrayList<CB> getdsCB() {
		return dsCB;
	}
	
	//Tổng số các cuốn sách
	public int count() {
		return dsCB.size();
	}
	
	public boolean themSach(CB s) {
		if(dsCB.contains(s))
			return false;
		return dsCB.add(s);
	}
 
	public CB timKiem(String maCB) {
		CB s = new CB(maCB);
		if(dsCB.contains(s))
			return dsCB.get(dsCB.indexOf(s));
		return null;
	}
	

	public boolean xoa1CB(int index) {
		if(index >= 0 && index < dsCB.size()){
			dsCB.remove(index);
			return true;
		}
		return false;
	}

	public ArrayList<CB> get() {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
