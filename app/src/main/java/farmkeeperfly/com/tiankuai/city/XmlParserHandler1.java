package farmkeeperfly.com.tiankuai.city;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class XmlParserHandler1 extends DefaultHandler {

	private int provinceId=100000;
	private int cityId=10000;
	/**
	 * 存储所有的解析对象
	 */

	public XmlParserHandler1() {

	}

	HashMap<String,List<Cityinfo>> cityMap;
	List<Cityinfo> proviceList;
	HashMap<String,List<Cityinfo>> districtMap;

	Cityinfo provinceModel;
	Cityinfo cityModel;
	Cityinfo districtModel;
	@Override
	public void startDocument() throws SAXException {
		// 当读到第一个开始标签的时候，会触发这个方法

		proviceList = new ArrayList<>();

		cityMap = new HashMap<>();

		districtMap = new HashMap<>();
	}



	private List<Cityinfo> cityList;
	private List<Cityinfo> distictList;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 当遇到开始标记的时候，调用这个方法
		if (qName.equals("province")) {
			provinceModel = new Cityinfo();
			provinceModel.setCity_name(attributes.getValue(0));
			provinceModel.setId(provinceId++);
			proviceList.add(provinceModel);
			cityList=new ArrayList<>();
			//provinceModel.setCityList(new ArrayList<CityModel>());
		} else if (qName.equals("city")) {
			cityModel = new Cityinfo();
			cityModel.setCity_name(attributes.getValue(0));
			cityModel.setId(cityId++);
			//cityList.add(cityModel);
			//cityModel.setDistrictList(new ArrayList<DistrictModel>());
			distictList=new ArrayList<>();
		} else if (qName.equals("district")) {
			districtModel = new Cityinfo();
			districtModel.setCity_name(attributes.getValue(0));
			districtModel.setId(attributes.getValue(1));

		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 遇到结束标记的时候，会调用这个方法
		if (qName.equals("district")) {
			//cityModel.getDistrictList().add(districtModel);
			distictList.add(districtModel);
			districtModel=null;
        } else if (qName.equals("city")) {
        	//provinceModel.getCityList().add(cityModel);


			cityList.add(cityModel);
			districtMap.put(cityModel.getId(),distictList);

        } else if (qName.equals("province")) {

			cityMap.put(provinceModel.getId(),cityList);
        }
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
	}

	public List<Cityinfo> getProviceList() {
		return proviceList;
	}

	public HashMap<String, List<Cityinfo>> getCityMap() {
		return cityMap;
	}

	public HashMap<String, List<Cityinfo>> getDistrictMap() {
		return districtMap;
	}
}
