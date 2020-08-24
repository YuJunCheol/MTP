package com.yujuncheol.java.server;

import java.io.ObjectInputStream;
import java.net.Socket;

import com.yujuncheol.android.mobilept.model.Message;
import com.yujuncheol.android.mobilept.model.User;


public class Recv {
	Socket socket;
	ObjectInputStream inObject;
	
	public Recv(Socket socket) {
		this.socket = socket;
		if(socket == null) {
			System.out.println("(ERROR)Recv");
		}
	}
	
	public Message getMessage() {
		try {
			inObject = new ObjectInputStream(socket.getInputStream());
			Message message = (Message)inObject.readObject();
			return message;
		}catch(Exception e) {
			System.out.println("(ERROR)Recv.getMessage : ");
			e.printStackTrace();
		}
		return null;
	}
	
	public User getUser() {
		try {
		inObject = new ObjectInputStream(socket.getInputStream());
		User user = (User)inObject.readObject();
		return user;
		}catch(Exception e) {
			System.out.println("(ERROR)Recv.getMessage : ");
			e.printStackTrace();
		}
		return null;
	}
}