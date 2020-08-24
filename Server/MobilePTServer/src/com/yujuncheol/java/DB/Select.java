package com.yujuncheol.java.DB;

import com.yujuncheol.android.mobilept.model.Resource;
import com.yujuncheol.android.mobilept.model.User;

public class Select extends DBConnection implements Resource{
	
	public boolean CheckUser(User user) {
		String sql ="SELECT * FROM user";
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(user.getUser_id().equals(rs.getString("user_id"))) {
					this.user.setUser_id(rs.getString("user_id"));
					this.user.setUser_pk(rs.getString("user_pk"));
					this.user.setUser_pw(rs.getString("user_pw"));
					this.user.setUser_name(rs.getString("user_name"));
					
					return true;
				}
			}
			return false;
			//System.out.println("X");
		}catch(Exception e) {
			System.out.println("(!)Select.Checkuser : ");
			e.printStackTrace();
		}
		return false;
	}

}