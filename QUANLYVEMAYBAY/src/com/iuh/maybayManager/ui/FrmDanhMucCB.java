package com.iuh.maybayManager.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.iuh.maybayManager.db.Database;
import com.iuh.maybayManager.entity.CB;
import com.iuh.maybayManager.manager.DanhSach;;

public class FrmDanhMucCB extends JFrame implements ActionListener  {

	private static final long serialVersionUID = -1692862201945148614L;
	private static final String FILENAME = "data/DuLieu.txt";
	private JTextField txtSoCB;
	private JTextField txtSanBay;
	private JTextField txtChangBay;
	private JTextField txtNgayBay;
	private JTextField txtNhaGa;
	private JTextField txtSoGhe;
	private JTextField txtQuay;
	private JTextField txtTinhTrang;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboSoCB;
	private JTable table;
	private JTextField txtMess;
	private DefaultComboBoxModel<String> myComboboxModel;
	private JButton btnXoaRong;
	private DanhSach danhSach;
	private CBTableModel tableModel;

	public FrmDanhMucCB() {
		setTitle("Quản lý chuyến bay");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {
		
		//Phần North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); //Absolute layout
		
		JLabel lblSoCb, lblSanBay, lblChangBay, lblNgayBay, lblNhaGa, lblSoGhe, lblQuay, lblTinhTrang;
		pnlNorth.add(lblSoCb = new JLabel("Mã chuyến bay: "));
		pnlNorth.add(lblSanBay = new JLabel("Sân bay: "));
		pnlNorth.add(lblChangBay = new JLabel("Chặng bay: "));
		pnlNorth.add(lblNgayBay = new JLabel("Ngày bay: "));
		pnlNorth.add(lblNhaGa = new JLabel("Nhà ga: "));
		pnlNorth.add(lblSoGhe = new JLabel("Số ghế: "));
		pnlNorth.add(lblQuay = new JLabel("Quầy: "));
		pnlNorth.add(lblTinhTrang = new JLabel("Tình trạng: "));
		
		pnlNorth.add(txtSoCB = new JTextField());
		pnlNorth.add(txtSanBay = new JTextField());
		pnlNorth.add(txtChangBay = new JTextField());
		pnlNorth.add(txtNgayBay = new JTextField());
		pnlNorth.add(txtNhaGa = new JTextField());
		pnlNorth.add(txtSoGhe = new JTextField());
		pnlNorth.add(txtQuay = new JTextField());
		pnlNorth.add(txtTinhTrang = new JTextField());
		
		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblSoCb.setBounds(20, 20, w1, h); txtSoCB.setBounds(120, 20, w2, h);
		
		lblSanBay.setBounds(20, 45, w1, h); txtSanBay.setBounds(120, 45, w2, h);
		lblQuay.setBounds(450, 20, w1, h); txtQuay.setBounds(570, 20, w2, h);
		lblChangBay.setBounds(450, 45, w1, h); txtChangBay.setBounds(570, 45, w2, h);
		
		lblNgayBay.setBounds(20, 70, w1, h); txtNgayBay.setBounds(120, 70, w2, h);
		lblNhaGa.setBounds(450, 70, w1, h); txtNhaGa.setBounds(570, 70, w2, h);
		
		lblSoGhe.setBounds(20, 95, w1, h); txtSoGhe.setBounds(120, 95, w2, h);
		lblTinhTrang.setBounds(450, 95, w1, h); txtTinhTrang.setBounds(570, 95, w2, h);
		
		
		txtMess.setBounds(20, 145, 550, 20);

		//Phần Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm")); 
		pnlCenter.add(btnXoaRong = new JButton("Xóa rỗng"));
		pnlCenter.add(btnXoa = new JButton("Xóa"));
		pnlCenter.add(btnSua = new JButton("Sửa"));
		pnlCenter.add(btnLuu = new JButton("Lưu"));
		pnlCenter.add(new JLabel("Tìm theo mã CB: "));
		pnlCenter.add(cboSoCB = new JComboBox<String>());
		cboSoCB.setPreferredSize(new Dimension(100, 25));
		
		//Phần South
		JScrollPane scroll;
		add(scroll = new JScrollPane(table = new JTable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các chuyến bay"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
		
		//Xử lý
		
		danhSach = new DanhSach();
		danhSach.napDuLieuTuFile();
		
		updateTableData();  //Cập nhật dữ liệu cho table
		updateComboboxData(); //Cập nhật dữ liệu cho Combobox
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); //Lấy dòng được chọn
				fillForm(row); //Hiển thị trên các components
			}
		});
		
		cboSoCB.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
	}

	private void fillForm(int row) {
		if(row != -1){
			CB s = danhSach.getdsCB().get(row);
			txtSoCB.setText(s.getSoCB());
			txtSanBay.setText(s.getSanBay());
			txtChangBay.setText(s.getChangBay());
			txtNgayBay.setText(s.getNgayBay() + "");
			txtNhaGa.setText(s.getNhaGa());
			txtSoGhe.setText(s.getSoGhe() + "");
			txtQuay.setText(s.getQuay() + "");
			txtTinhTrang.setText(s.getTinhTrang());
		}
	}
	
	private void updateComboboxData() {
		int n = danhSach.count(); //Tổng số các cb
		String []items = new String[n];
		int i = 0;
		for(CB s : danhSach.getdsCB()){
			items[i] = s.getSoCB();
			i++;
		}
		cboSoCB.setModel(new DefaultComboBoxModel<String>(items));
	}

	private void updateTableData() {
		tableModel = new CBTableModel(danhSach.getdsCB());
		table.setModel(tableModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)){
			CB s = convertToCB();
			if(danhSach.themSach(s))
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
			
			else
				JOptionPane.showMessageDialog(this, "Trùng mã CB!");
		} 
		else if(o.equals(btnLuu))
			Database.ghiXuongFile(danhSach.getdsCB(), FILENAME);
		if(o.equals(cboSoCB)){
			String maCB = (String) cboSoCB.getSelectedItem();
			CB s = danhSach.timKiem(maCB);
			if(s != null){
				int index = danhSach.getdsCB().indexOf(s);
				fillForm(index);
				table.getSelectionModel().setSelectionInterval(index, index);
				//Giả sử có rất nhiều cb
				table.scrollRectToVisible(table.getCellRect(index, index, true));
			} 
			
		}
	else if (o.equals(btnXoa)){
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION){
					if(danhSach.xoa1CB(row)){
						txtMess.setText("Đã xóa 1 chuyến bay.");
						updateTableData();
						updateComboboxData();
						clearTextfields();
					}
				}
			}else
				txtMess.setText("Bạn phải chọn chuyến bay cần xóa. ");
		}
		else if (o.equals(btnXoaRong)){
				
				int row = table.getSelectedRow();
				if(row != -1){
					clearTextfields();
					txtMess.setText("");
				}else
					txtMess.setText("Bạn phải chọn chuyến bay cần xóa rỗng. ");
				
		}
	
		updateTableData();  //Cập nhật dữ liệu cho table
		updateComboboxData(); //Cập nhật dữ liệu cho Combobox
	}
	
	private CB convertToCB() {
		String SoCB = txtSoCB.getText();
		String SanBay = txtSanBay.getText();
		String ChangBay = txtChangBay.getText();
		int NgayBay = Integer.parseInt(txtNgayBay.getText());
		String NhaGa = txtNhaGa.getText();
		int SoGhe = Integer.parseInt(txtSoGhe.getText());
		double Quay = Double.parseDouble(txtQuay.getText());
		String TinhTrang = txtTinhTrang.getText();
		CB s = new CB(SoCB, SanBay, ChangBay, NgayBay, NhaGa, SoGhe, Quay, TinhTrang);
		return s;
	}

	private void clearTextfields() {
		txtSoCB.setText("");
		txtSanBay.setText("");
		txtChangBay.setText("");
		txtNgayBay.setText("");
		txtNhaGa.setText("");
		txtSoGhe.setText("");
		txtQuay.setText("");
		txtTinhTrang.setText("");
	}
	
}
