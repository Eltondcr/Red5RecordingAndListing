package br.com.dcria.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListPublishData {

	@XmlElement(name="list_element_publish_data")
	private List<PublishInformationData> publishDatas = new ArrayList<PublishInformationData>();

	public List<PublishInformationData> getPublishDatas() {
		return publishDatas;
	}

	public void setPublishDatas(List<PublishInformationData> publishDatas) {
		this.publishDatas = publishDatas;
	}
	
}
