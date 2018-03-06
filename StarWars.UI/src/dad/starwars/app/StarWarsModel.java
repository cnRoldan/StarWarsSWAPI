package dad.starwars.app;

import dad.starwars.api.client.items.PeopleItem;
import dad.starwars.api.client.items.PeopleListItem;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StarWarsModel {
	private StringProperty buscador, nombre, altura, planeta, genero, colorOjos, colorPelo, colorPiel;
	private StringProperty paginas;
	private StringProperty peso;
	private StringProperty fecha;
	private ListProperty<PeopleListItem> personas;
	private ObjectProperty<PeopleListItem> seleccionado;
	private StringProperty next , previous;

	public StarWarsModel() {
		buscador = new SimpleStringProperty(this, "buscador");
		personas = new SimpleListProperty<>(this, "personas", FXCollections.observableArrayList());
		seleccionado = new SimpleObjectProperty<>(this, "seleccionado");
		nombre = new SimpleStringProperty(this, "nombre");
		altura = new SimpleStringProperty(this, "altura");
		peso = new SimpleStringProperty(this, "peso");
		fecha = new SimpleStringProperty(this, "fecha");
		planeta = new SimpleStringProperty(this, "planeta");
		genero = new SimpleStringProperty(this, "genero");
		colorOjos = new SimpleStringProperty(this, "colorOjos");
		colorPelo = new SimpleStringProperty(this, "colorPelo");
		colorPiel = new SimpleStringProperty(this, "colorPiel");
		paginas = new SimpleStringProperty(this, "paginas");
		next = new SimpleStringProperty(this, "next");
		previous = new SimpleStringProperty(this, "previous");
	}
	public StringProperty buscadorProperty() {
		return this.buscador;
	}

	public String getBuscador() {
		return this.buscadorProperty().get();
	}

	public void setBuscador(final String buscador) {
		this.buscadorProperty().set(buscador);
	}

	public ListProperty<PeopleListItem> personasProperty() {
		return this.personas;
	}

	public ObservableList<PeopleListItem> getPersonas() {
		return this.personasProperty().get();
	}

	public void setPersonas(final ObservableList<PeopleListItem> personas) {
		this.personasProperty().set(personas);
	}

	public ObjectProperty<PeopleListItem> seleccionadoProperty() {
		return this.seleccionado;
	}

	public PeopleListItem getSeleccionado() {
		return this.seleccionadoProperty().get();
	}

	public void setSeleccionado(final PeopleItem seleccionado) {
		this.seleccionadoProperty().set(seleccionado);
	}

	public StringProperty nombreProperty() {
		return this.nombre;
	}

	public String getNombre() {
		return this.nombreProperty().get();
	}

	public void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}

	public StringProperty alturaProperty() {
		return this.altura;
	}

	public String getAltura() {
		return this.alturaProperty().get();
	}

	public void setAltura(final String altura) {
		this.alturaProperty().set(altura);
	}

	public StringProperty pesoProperty() {
		return this.peso;
	}

	public String getPeso() {
		return this.pesoProperty().get();
	}

	public void setPeso(final String peso) {
		this.pesoProperty().set(peso);
	}

	public StringProperty fechaProperty() {
		return this.fecha;
	}

	public String getFecha() {
		return this.fechaProperty().get();
	}

	public void setFecha(final String fecha) {
		this.fechaProperty().set(fecha);
	}

	public StringProperty planetaProperty() {
		return this.planeta;
	}

	public String getPlaneta() {
		return this.planetaProperty().get();
	}

	public void setPlaneta(final String planeta) {
		this.planetaProperty().set(planeta);
	}

	public StringProperty generoProperty() {
		return this.genero;
	}

	public String getGenero() {
		return this.generoProperty().get();
	}

	public void setGenero(final String genero) {
		this.generoProperty().set(genero);
	}

	public StringProperty colorOjosProperty() {
		return this.colorOjos;
	}

	public String getColorOjos() {
		return this.colorOjosProperty().get();
	}

	public void setColorOjos(final String colorOjos) {
		this.colorOjosProperty().set(colorOjos);
	}

	public StringProperty colorPeloProperty() {
		return this.colorPelo;
	}

	public String getColorPelo() {
		return this.colorPeloProperty().get();
	}

	public void setColorPelo(final String colorPelo) {
		this.colorPeloProperty().set(colorPelo);
	}

	public StringProperty colorPielProperty() {
		return this.colorPiel;
	}

	public String getColorPiel() {
		return this.colorPielProperty().get();
	}

	public void setColorPiel(final String colorPiel) {
		this.colorPielProperty().set(colorPiel);
	}
	public StringProperty paginasProperty() {
		return this.paginas;
	}
	
	public String getPaginas() {
		return this.paginasProperty().get();
	}
	
	public void setPaginas(final String paginas) {
		this.paginasProperty().set(paginas);
	}
	public StringProperty nextProperty() {
		return this.next;
	}
	
	public String getNext() {
		return this.nextProperty().get();
	}
	
	public void setNext(final String next) {
		this.nextProperty().set(next);
	}
	public StringProperty previousProperty() {
		return this.previous;
	}
	
	public String getPrevious() {
		return this.previousProperty().get();
	}
	
	public void setPrevious(final String previous) {
		this.previousProperty().set(previous);
	}
	
	
}
