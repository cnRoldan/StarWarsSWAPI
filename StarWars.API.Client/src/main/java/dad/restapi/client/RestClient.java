package dad.restapi.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	
	private WebTarget webTarget;

	public RestClient(String target) { 		//CONSTRUCTOR, RECIBE UN STRING		
		Client client = ClientBuilder.newClient(); /* ---- > Constructor especial */
											//CREAMOS CLIENTE
		webTarget = client.target(target); 	//AL WEBTARGET LE ASIGNAMOS UN 
										 	//CLIENTE CON UN TARGET OBTENIDO POR PARAMETRO
	}

	public Response get(String path, QueryParam...params) { //METODO QUE DEVUELVE RESPUESTA
		WebTarget wt = webTarget.path(path); /*CREAMOS UN NUEVO WEBTARGET, 
											 LE PASAMOS EL CREADO EN EL CONSTRUCTOR*/
		for (QueryParam param : params) {
			wt = wt.queryParam(param.getName(), param.getValue()); /* TODOS LOS 
																	PARAMETROS RECIBIDOS SE 
																	PASAN POR PARAM*/
		}

		return wt.request().accept(MediaType.APPLICATION_JSON).get();
	}


	public static void main(String[] args) {

	}


}
