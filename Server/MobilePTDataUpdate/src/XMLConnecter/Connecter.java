package XMLConnecter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import DB.Insert;
import Data.food;

public class Connecter extends OpenApi{
	
	String s_1,s_2,s_3;
	double d_1,d_2,d_3,d_4,d_5,d_6,d_7,d_8;
	int i_1,i_2;
	
	//1000 ���� �� 29922��
	OpenApi openapi = new OpenApi();
	public Connecter() {
		
	}
	
	public void setFoodData() {
		int i =1;
		openapi.OpenApi("I2790");
		for(int r = 0; r< 1; r++) {
			String url = openapi.geturlBuilder() + Integer.toString(i) + "/" + Integer.toString(i+10);
			System.out.println(url);
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document xml = dBuilder.parse(url);
				
				Element root = xml.getDocumentElement();
		        NodeList nNodeList = root.getElementsByTagName("row");
		        
		        for(int temp = 0; temp < nNodeList.getLength() ;temp++) {
					Node nNode = nNodeList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element)nNode;
						s_1 = getTagValue("FOOD_CD",eElement).toString();
						s_2 = getTagValue("DESC_KOR",eElement).toString();
						s_3 = getTagValue("GROUP_NAME",eElement).toString();	
						i_1 = Integer.parseInt(getTagValue("SERVING_SIZE",eElement));
						i_2 = Integer.parseInt(getTagValue("RESEARCH_YEAR",eElement));
						d_1 = Double.parseDouble(getTagValue("NUTR_CONT1",eElement));
						d_2 = Double.parseDouble(getTagValue("NUTR_CONT2",eElement));
						d_3 = Double.parseDouble(getTagValue("NUTR_CONT3",eElement));
						d_4 = Double.parseDouble(getTagValue("NUTR_CONT4",eElement));
						d_5 = Double.parseDouble(getTagValue("NUTR_CONT5",eElement));
						d_6 = Double.parseDouble(getTagValue("NUTR_CONT6",eElement));
						d_7 = Double.parseDouble(getTagValue("NUTR_CONT7",eElement));
						d_8 = Double.parseDouble(getTagValue("NUTR_CONT8",eElement));
						food fd = new food(s_1,s_2,s_3,d_1,d_2,d_3,d_4,d_5,d_6,d_7,d_8,i_1,i_2);
						new Insert(fd);
					}
		        }

			}catch(Exception e) {
				System.out.println("(ERROR)setFoodData : ");
				e.printStackTrace();
			}
			
			i = i+ 1001;
		}
		
		
	}
	
	
	
	private static String getTagValue(String sTag, Element eElement) {
		 NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		 Node nValue = (Node)nlList.item(0);
		 if(nValue == null) {
			 return "";
		 }
		 return nValue.getNodeValue();
	}
}
