package br.com.dcria.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import br.com.dcria.repo.PublishRepo;
import br.com.dcria.util.JsonUtil;

@Path("/streaming")
public class StreamingService {

	@GET
	@Produces(MediaType.APPLICATION_JSON )
	public Object getStreamings() throws JAXBException {		
		
		return JsonUtil.toUTF8(PublishRepo.getInstance().get().toString());
	}
}
