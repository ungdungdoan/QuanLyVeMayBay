package com.iuh.maybayManager.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.iuh.maybayManager.entity.CB;

public class Database {
	private static final String FILENAME = "data/DATA.txt";



	public static void ghiXuongFile(ArrayList<CB> dsCB, String fileName) {
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(FILENAME));
			//Ghi dòng tiêu đề cột
			bw.write("SoCB;SanBay;ChangBay;NgayBay;NhaGa;SoGhe;Quay;TinhTrang\n");
			//Ghi lần lượt từng cuốn sách cho đến khi hết
			for(CB s : dsCB){
				bw.write(s.toString() + "\n");
			}
			bw.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	public static ArrayList<CB> docTuFile() {
		ArrayList<CB> dsCB = new ArrayList<CB>(10);
		BufferedReader br = null;
		try{
			if(new File(FILENAME).exists()){
				br  = new BufferedReader(new FileReader(FILENAME));
				//Bỏ qua dòng tiêu đề cột
				br.readLine();
				//Đọc từng line, xử lý chuỗi và chuyển thành cuốn sách
				while(br.ready()){
					String line = br.readLine();
					if(line != null && !line.trim().equals("")){
						String[] a = line.split(";");
						CB s = new CB(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), Double.parseDouble(a[6]), a[7]);
						dsCB.add(s);
					}
				}
				br.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dsCB;
	}
}