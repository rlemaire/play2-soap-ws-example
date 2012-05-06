package ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TheWS {

	public String hello(String message) {
		return "hello " + message;
	}

	public static void main(String[] args) {
		// Publishing the service (to have the wsdl)
		Endpoint.publish("http://localhost:8081/TheWS", new TheWS());
	}
}
