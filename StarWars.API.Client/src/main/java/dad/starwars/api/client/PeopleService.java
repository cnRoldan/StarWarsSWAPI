package dad.starwars.api.client;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ws.rs.core.Response;
import dad.restapi.client.QueryParam;
import dad.restapi.client.RestClient;
import dad.starwars.api.client.items.PeopleItem;
import dad.starwars.api.client.items.PeopleListItem;
import dad.starwars.api.client.items.SearchResultItem;
import dad.starwars.api.client.json.People;
import dad.starwars.api.client.json.Planets;
import dad.starwars.api.client.json.SearchResultJSON;
import javafx.concurrent.Task;

public class PeopleService {
	private Task<SearchResultItem> search;
	private Task <PeopleItem> findById;
	RestClient client = new RestClient("https://swapi.co/api");

	public SearchResultItem search(String name, Integer page) throws InterruptedException, ExecutionException {

		search = new Task<SearchResultItem>() {
			@Override
			protected SearchResultItem call() throws Exception {
				Response response = client.get("/people/", new QueryParam("format", "json"),
						new QueryParam("search", name), new QueryParam("page", page));
				SearchResultJSON busqueda = response.readEntity(SearchResultJSON.class);
				SearchResultItem resultado = new SearchResultItem();
				if (busqueda.getNext() == null) {
					resultado.setNext(null);
				} else {
					String sig = busqueda.getNext();
					Pattern patronSig = Pattern.compile("(\\d+)");
					Matcher resultadoSig = patronSig.matcher(sig);
					if (resultadoSig.find()) {
						resultado.setNext(Integer.parseInt(resultadoSig.group(1)));
					}
				}
				if (busqueda.getPrevious() == null) {
					resultado.setPrevious(null);
				} else {
					String ant = busqueda.getPrevious();
					Pattern patronAnt = Pattern.compile("(\\d+)");
					Matcher resultadoAnt = patronAnt.matcher(ant);
					if (resultadoAnt.find()) {
						resultado.setPrevious(Integer.parseInt(resultadoAnt.group(1)));
					}
				}
				resultado.setCount(busqueda.getCount());

				ArrayList<PeopleListItem> lista = new ArrayList<>();

				for (int i = 0; i < busqueda.getResults().size(); i++) {
					PeopleListItem dato = new PeopleListItem();
					dato.setName(busqueda.getResults().get(i).getName());
					String URL = busqueda.getResults().get(i).getUrl();
					Pattern patronURL = Pattern.compile("(\\d+)");
					Matcher resultadoURL = patronURL.matcher(URL);
					if (resultadoURL.find()) {
						dato.setId(Integer.parseInt(resultadoURL.group(1)));
					}
					lista.add(dato);
				}
				resultado.setResult(lista);				
				return resultado;
			}
		};
		new Thread(search).start();

		return search.get();

	}

	public PeopleItem finById(Integer id) throws InterruptedException, ExecutionException {
		
		findById = new Task<PeopleItem>() {			
			@Override
			protected PeopleItem call() throws Exception {
				RestClient client = new RestClient("https://swapi.co/api");
				Response response = client.get("/people/" + id, new QueryParam("format", "json"));

				People people = response.readEntity(People.class);
				PeopleItem item = new PeopleItem();
				item.setName(people.getName());
				item.setHeight(Integer.parseInt(people.getHeight()));
				item.setMass(people.getMass());
				item.setHairColor(people.getHair_color());
				item.setSkinColor(people.getSkin_color());
				item.setEyeColor(people.getEye_color());
				String fechaBBY = people.getBirth_year();
				Pattern patronFecha = Pattern.compile("(\\d+)");
				Matcher resultadoFecha = patronFecha.matcher(fechaBBY);
				if (resultadoFecha.find()) {
					item.setBirthYear(Double.parseDouble(resultadoFecha.group(1)));
				}

				item.setGender(people.getGender());

				String URLP = people.getHomeworld();
				Pattern patronURLP = Pattern.compile("(\\d+)");
				Matcher resultadoURLP = patronURLP.matcher(URLP);
				String idP = null;
				if (resultadoURLP.find())
					idP = resultadoURLP.group(1);

				Response responsePlaneta = client.get("/planets/" + idP, new QueryParam("format", "json"));
				Planets planeta = responsePlaneta.readEntity(Planets.class);

				item.setHomeworld(planeta.getName());
				item.setCreated(LocalDateTime.ofInstant(people.getCreated().toInstant(), ZoneId.systemDefault()));
				item.setEdited(LocalDateTime.ofInstant(people.getEdited().toInstant(), ZoneId.systemDefault()));

				String URL = people.getUrl();
				Pattern patronURL = Pattern.compile("(\\d+)");
				Matcher resultadoURL = patronURL.matcher(URL);
				if (resultadoURL.find()) {
					item.setId(Integer.parseInt(resultadoURL.group(1)));
				}
				return item;
			}
		};
		
		findById.setOnRunning(e -> {
			System.out.println("Buscando personaje...");
		});
		new Thread(findById).start();
		return findById.get();
	}
}
