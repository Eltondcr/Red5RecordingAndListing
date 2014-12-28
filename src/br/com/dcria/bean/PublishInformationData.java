package br.com.dcria.bean;

import java.io.Writer;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.dcria.util.MarshallUtil;

@XmlRootElement
public class PublishInformationData {

	@XmlElement(name="publish_url")
	private String publishURL;
	
	@XmlElement(name="publish_name")
	private String publishName;
	
	@XmlElement(name="record_name")
	private String recordName;
	
	@XmlElement(name="start_service")
	private Calendar startService;

	public String getPublishURL() {
		return publishURL;
	}
	public void setPublishURL(String publishURL) {
		this.publishURL = publishURL;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public Calendar getStartService() {
		return startService;
	}
	public void setStartService(Calendar startService) {
		this.startService = startService;
	}

	@Override
	public String toString() {
		Writer w = null;
		try {
			w = MarshallUtil.marshall(this, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return w.toString();
	}	
}
