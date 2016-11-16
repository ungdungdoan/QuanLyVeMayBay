package com.iuh.maybayManager.ui;

import javax.swing.SwingUtilities;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrmDanhMucCB frm = new FrmDanhMucCB();
				frm.setVisible(true);
			}
		});
	}
}
