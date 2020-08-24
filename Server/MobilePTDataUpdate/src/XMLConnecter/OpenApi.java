package XMLConnecter;

import java.io.IOException;
import java.net.URLEncoder;

public class OpenApi {
	private StringBuilder urlBuilder = new StringBuilder("http://openapi.foodsafetykorea.go.kr/api");
	
	public OpenApi() {}
	
	public void OpenApi(String service) {
		try {
			this.urlBuilder.append("/" + URLEncoder.encode("","UTF-8") + "6a77c9ae0e0d44388de7"); /*Service Key*/
			this.urlBuilder.append("/" + service + "/xml/");
		}catch(IOException e) {
			System.out.println("(Error)OpenApi.OpenApi : ");
			e.printStackTrace();
		}
	}
	
	
	public StringBuilder geturlBuilder() {
		return this.urlBuilder;
	}
}

// http://openapi.foodsafetykorea.go.kr/api / 6a77c9ae0e0d44388de7 / I2790 /xml/1/10/ 			DESC_KOR=%EC%84%A4%ED%83%95 식품 DB
// http://openapi.foodsafetykorea.go.kr/api / 6a77c9ae0e0d44388de7 / COOKRCP01 /xml/1/5  		레시피DB