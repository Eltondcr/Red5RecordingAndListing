package br.com.dcria.recording;

import java.net.InetAddress;
import java.util.Calendar;

import org.red5.server.adapter.ApplicationAdapter;
import org.red5.server.api.IClient;
import org.red5.server.api.IConnection;
import org.red5.server.api.scope.IScope;
import org.red5.server.api.stream.IBroadcastStream;



import br.com.dcria.bean.PublishInformationData;
import br.com.dcria.repo.PublishRepo;

public class Application extends ApplicationAdapter {

	// executed when client disconnects
	public synchronized void disconnect(IConnection conn, IScope scope) {
		super.disconnect(conn, scope);
	}

	// executed when application starts
	public synchronized boolean appStart(IScope app) {
		scope = app;
		return super.appStart(app);
	}

	// executed when client connects
	public synchronized boolean connect(IConnection conn, IScope scope,	Object[] params) {
		return super.connect(conn, scope, params);
	}

	// executed when application stops
	public synchronized void appStop(IScope app) {
		super.appStop(app);
	}

	// executed when client connects to application
	public synchronized boolean appConnect(IConnection conn, Object[] params) {
		return super.appConnect(conn, params);
	}

	// executed when client disconnects from application
	public synchronized void appDisconnect(IConnection conn) {
		super.appDisconnect(conn);
	}

	// executed when client starts publishing a stream to application (live /
	// record)
	public synchronized void streamPublishStart(IBroadcastStream stream) {
		super.streamPublishStart(stream);
		try { 
			//String recordName = stream.getPublishedName().toUpperCase() + "_"+ Calendar.getInstance().getTime().getTime();
			//stream.saveAs(recordName, false); 
			PublishInformationData data = new PublishInformationData();
			data.setPublishName(stream.getPublishedName());
			//data.setRecordName(recordName+".flv");
			data.setRecordName("NO RECORDING");
			InetAddress addr= InetAddress.getLocalHost(); 
			data.setPublishURL("rtmp://"+addr.getHostAddress()+"/"+this.getName()+"/"+ stream.getScope().getName());
			data.setStartService(Calendar.getInstance());			
			PublishRepo repo = PublishRepo.getInstance();
			repo.add(data);

		} catch (Exception e) { 
			e.printStackTrace(); 
		} 	
	}

	// executed when client starts publishing a stream to application in record
	// mode
	public synchronized void streamRecordStart(IBroadcastStream stream) {
		super.streamRecordStart(stream);
	}
		
	@Override
	public void streamBroadcastClose(IBroadcastStream stream) {
		PublishRepo repo = PublishRepo.getInstance();
		repo.remove(stream.getPublishedName());
		super.streamRecordStop(stream);
	}
	
	@Override
	public boolean join(IClient client, IScope scope) {
		// TODO Auto-generated method stub
		return true;
	}
}