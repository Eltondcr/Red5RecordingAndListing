package br.com.dcria.util;

import java.nio.charset.Charset;

public class JsonUtil {
	public static byte[] toUTF8(String json){
		return json.getBytes(Charset.forName("UTF-8"));
	}
}