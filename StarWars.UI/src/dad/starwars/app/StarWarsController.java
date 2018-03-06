package dad.starwars.app;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import dad.starwars.api.client.PeopleService;
import dad.starwars.api.client.items.SearchResultItem;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StarWarsController implements Initializable {
	StarWarsView vista;
	StarWarsModel modelo;
	PeopleService servicio;

	// KIT DE NAVEGACIÓN
	private static SearchResultItem mySearch = new SearchResultItem();
	private static int paginaActual;
	private static int totalPaginas;
	/*----------------*/

	public StarWarsController() {
		vista = new StarWarsView();
		modelo = new StarWarsModel();
		servicio = new PeopleService();
		initialize(null, null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		modelo.buscadorProperty().bind(vista.getBuscadorField().textProperty());

		vista.getPersonajesList().itemsProperty().bind(modelo.personasProperty());
		modelo.seleccionadoProperty().bind(vista.getPersonajesList().getSelectionModel().selectedItemProperty());

		vista.getPaginasLabel().textProperty().bind(modelo.paginasProperty());

		vista.getRightButton().disableProperty().bind(modelo.nextProperty().isNull());
		vista.getLeftButton().disableProperty().bind(modelo.previousProperty().isNull());

		vista.getNombreLabelI().textProperty().bind(modelo.nombreProperty());
		vista.getAlturaLabelI().textProperty().bind(modelo.alturaProperty());
		vista.getPesoLabelI().textProperty().bind(modelo.pesoProperty());
		vista.getFechaLabelI().textProperty().bind(modelo.fechaProperty());
		vista.getPlanetaLabelI().textProperty().bind(modelo.planetaProperty());
		vista.getGeneroLabelI().textProperty().bind(modelo.generoProperty());
		vista.getOjosLabelI().textProperty().bind(modelo.colorOjosProperty());
		vista.getPeloLabelI().textProperty().bind(modelo.colorPeloProperty());
		vista.getPielLabelI().textProperty().bind(modelo.colorPielProperty());

		vista.getPersonajesList().setOnMouseClicked(e -> {
			try {
				onMouseClicked(e);
			} catch (InterruptedException | ExecutionException e4) {
				e4.printStackTrace();
			}
		});
		vista.getLupaButton().setOnAction(e -> {
			try {
				onLupaButton(e);
			} catch (InterruptedException | ExecutionException e3) {
				e3.printStackTrace();
			}
		});
		vista.getLeftButton().setOnAction(e -> {
			try {
				onLeftButton(e);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			} catch (ExecutionException e2) {
				e2.printStackTrace();
			}
		});
		vista.getRightButton().setOnAction(e -> {
			try {
				onRightButton(e);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		});
		vista.getBuscadorField().setOnAction(e -> {
			try {
				onBuscadorAction(e);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
		});

	}

	private void onBuscadorAction(ActionEvent e) throws InterruptedException, ExecutionException {
		onLupaButton(e);
	}

	private void onRightButton(ActionEvent e) throws InterruptedException, ExecutionException {
		paginaActual++;
		mySearch = servicio.search(modelo.getBuscador(), paginaActual);
		modelo.getPersonas().setAll(mySearch.getResults());
		modelo.setPaginas(paginaActual + "/" + String.valueOf(totalPaginas));
		modelo.setPrevious(mySearch.getPrevious().toString());
		if (paginaActual == totalPaginas)
			modelo.setNext(null);
		else
			modelo.setNext(mySearch.getNext().toString());
	}

	private void onLeftButton(ActionEvent e) throws InterruptedException, ExecutionException {
		paginaActual--;
		mySearch = servicio.search(modelo.getBuscador(), paginaActual);
		modelo.getPersonas().setAll(mySearch.getResults());
		modelo.setPaginas(paginaActual + "/" + String.valueOf(totalPaginas));
		modelo.setNext(mySearch.getNext().toString());
		if (paginaActual == 1)
			modelo.setPrevious(null);
		else
			modelo.setPrevious(mySearch.getPrevious().toString());
	}

	private void onMouseClicked(MouseEvent e) throws InterruptedException, ExecutionException {
		if(modelo.getPersonas().isEmpty()) {
			Alert errorBusqueda = new Alert(AlertType.INFORMATION);
			errorBusqueda.setTitle("Error en la búsqueda");
			errorBusqueda.setHeaderText("¡No existen personajes!");
			errorBusqueda.setContentText("No ha buscado ningun personaje");
			Stage stage = (Stage) errorBusqueda.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("File:information.png"));
			ImageView darthVader = new ImageView(new Image("File:information2.png"));
			darthVader.setFitHeight(140);
			darthVader.setFitWidth(80);
			errorBusqueda.setGraphic(darthVader);
			errorBusqueda.show();
		}else {
			modelo.setNombre(modelo.seleccionadoProperty().get().getName());
			modelo.setAltura(servicio.finById(modelo.seleccionadoProperty().get().getId()).getHeight().toString() + "cm");
			modelo.setPeso(servicio.finById(modelo.seleccionadoProperty().get().getId()).getMass().toString()+ "kg");
			modelo.setFecha(servicio.finById(modelo.getSeleccionado().getId()).getBirthYear().toString() + "BBY");
			modelo.setPlaneta(servicio.finById(modelo.getSeleccionado().getId()).getHomeworld());
			modelo.setGenero(servicio.finById(modelo.getSeleccionado().getId()).getGender());
			modelo.setColorOjos(servicio.finById(modelo.getSeleccionado().getId()).getEyeColor());
			modelo.setColorPelo(servicio.finById(modelo.getSeleccionado().getId()).getHairColor());
			modelo.setColorPiel(servicio.finById(modelo.getSeleccionado().getId()).getSkinColor());

		}
			
		
	}

	private void onLupaButton(ActionEvent e) throws InterruptedException, ExecutionException {
		mySearch = servicio.search(modelo.getBuscador(), null);
		paginaActual = 1;
		if (mySearch.getCount() == 0) {
			modelo.setPaginas("0/0");
			Alert errorBusqueda = new Alert(AlertType.INFORMATION);
			errorBusqueda.setTitle("Error en la búsqueda");
			errorBusqueda.setHeaderText("¡No existen personajes!");
			errorBusqueda.setContentText("El personaje de Star Wars que ha intentado buscar no existe");
			Stage stage = (Stage) errorBusqueda.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("File:information.png"));
			ImageView darthVader = new ImageView(new Image("File:information2.png"));
			darthVader.setFitHeight(140);
			darthVader.setFitWidth(80);
			errorBusqueda.setGraphic(darthVader);
			errorBusqueda.show();
		} else {
			double aux = (Double.valueOf(mySearch.getCount()) / 10);
			totalPaginas = (int) Math.ceil(aux);
			modelo.getPersonas().setAll(mySearch.getResults());
			modelo.setPaginas(paginaActual + "/" + String.valueOf(totalPaginas));
			if (mySearch.getNext()==null)
				mySearch.setNext(null);
			else
			modelo.setNext(mySearch.getNext().toString());
		}
	}

	public StarWarsView getView() {
		return vista;
	}

}
