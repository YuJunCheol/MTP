package com.yujuncheol.java.server;

import com.yujuncheol.android.mobilept.model.User;
import com.yujuncheol.java.DB.Select;

public class Login {

	public Login() {
		
	}
	
	public boolean Login(User user) {
		Select select = new Select();
		if(select.CheckUser(user)) {
			//System.out.println("���� ����" + user.getUser_name());
			return true;
		}
		//System.out.println("���� ����");
		return false;
	}
}