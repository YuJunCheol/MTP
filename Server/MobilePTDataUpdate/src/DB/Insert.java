package DB;

import Data.food;

public class Insert extends DBConnection{
	
	public Insert() {
		
	}
	
	public Insert(food food) {
		String val = "'"+food.getFOOD_CD()+ "','"+food.getDESC_KOR()+ "',"+food.getSERVING_SIZE()+ ","+food.getNUTR_CONT1()+","
				+food.getNUTR_CONT2()+","+food.getNUTR_CONT3()+","+food.getNUTR_CONT4();
		String sql = "INSERT INTO food VALUES ("+val+");";
		try {
			r = st.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println("(!)[insert.User]: " + e.getMessage());
		}
	}
}
