package com.yujuncheol.java.controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.yujuncheol.android.mobilept.model.Message;
import com.yujuncheol.android.mobilept.model.Resource;
import com.yujuncheol.java.DB.Select;
import com.yujuncheol.java.server.Adduser;
import com.yujuncheol.java.server.Login;
import com.yujuncheol.java.server.Recv;
import com.yujuncheol.java.server.Send;

public class ControlMessage implements Runnable, Resource{
	
	private Socket socket;
	private ObjectInputStream inMessage;
	private ObjectOutputStream out;
	
	
	public ControlMessage(Socket socket) {
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		try {
			Recv recv = new Recv(socket);
			Send send = new Send(socket);
			Select select = new Select();
			switch(recv.getMessage()) {
			case Login:
				System.out.println("�α���");
				Login login = new Login();
				if(login.Login(recv.getUser())) {
					send.SendMessage(Message.Yes);
					
					send.SendObject(socket,user);
					System.out.println("���� ���� �̸�: " + user.getUser_name());
				}else {
					send.SendMessage(Message.No);
					System.out.println("���� ����");
				}
				//System.out.println(recv.getUser().getUser_id());
				return;
			case AddUser:
				System.out.println("ȸ������");
				//System.out.println(recv.getUser().getUser_id());
				new Adduser(recv.getUser());
			case Check:
				System.out.println("���� �ߺ� üũ");
				if(select.CheckUser(recv.getUser())) {
					send.SendMessage(Message.No);
				}else {
					send.SendMessage(Message.Yes);
				}
				
			}
		}catch (Exception e) {
			System.out.println("(ERROR)getMessage.run : "+e.getMessage());
		}
		
	}

}