package br.com.dcria.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;


public class MarshallUtil {
	

	public static StringWriter marshall(Object obj, boolean includeRoot) throws JAXBException{
		
		StringWriter writer = new StringWriter(  );
		
		// Cria o contexto do jaxb
		JAXBContext jc = JAXBContext.newInstance(obj.getClass());

		// Cria objeto para auxiliar no marshalles usando o contexto criado anteriormente
		Marshaller marshaller = jc.createMarshaller();
		
		// Configura o tipo de saida JSON ou XML
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,	"application/json");

		// Define se o nome da classe vai ou nao aparecer no json cherado
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, includeRoot);
		
		// Define se o json gerado deve ser formatado
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Define o encode de saida "ISO-8859-1" com acentos "UTF-8" sem acentos
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		// Marshal the employee object to JSON and print the output to console
		marshaller.marshal(obj, writer);
		
		return writer;
	} 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object unmarshall(String jsonRead, Class clazz, boolean includeRoot) throws JAXBException {

		// Cria o contexto do jaxb
		JAXBContext jc = JAXBContext.newInstance(clazz);

		// Cria objeto para auxiliar no unmarshalles usando o contexto criado anteriormente
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		// Set the Unmarshaller media type to JSON or XML
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE,	"application/json");

		// Define se o json gerado deve ser formatado
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, includeRoot);

		StreamSource json = new StreamSource(new StringReader(jsonRead));

		// monta o objeto para ser retornado
		
		Object obj = unmarshaller.unmarshal(json, clazz).getValue();

		return obj;
	}
	
}
