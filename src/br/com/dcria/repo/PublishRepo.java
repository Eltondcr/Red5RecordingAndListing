package br.com.dcria.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dcria.bean.PublishInformationData;

public class PublishRepo{
	private static PublishRepo instance = null;

	Map<String, PublishInformationData> mapApp = new HashMap<String, PublishInformationData>();
	
	private PublishRepo() {
		// TODO Auto-generated constructor stub
	}
	
	public static PublishRepo getInstance(){
		if(instance == null){
			instance = new PublishRepo();
		}
		return instance;
	}
	
	public void add(PublishInformationData data){
		mapApp.put(data.getPublishName(), data);
	}
	
	public void remove(String key){
		
		mapApp.remove(key);
	}
	public List<PublishInformationData> get(){
		List<PublishInformationData> list = new ArrayList<PublishInformationData>();
		for(String key : mapApp.keySet()){
			list.add(mapApp.get(key));
		}
		return list;
	}

}
