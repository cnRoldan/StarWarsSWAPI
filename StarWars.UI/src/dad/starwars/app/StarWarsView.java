package dad.starwars.app;

import dad.starwars.api.client.items.PeopleListItem;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StarWarsView extends HBox {
	private SplitPane izquierdaSplit;
	private VBox left;
	private HBox derechaBox;
	private GridPane derecha;
	private TextField buscadorField;
	private ListView<PeopleListItem> personajesList;
	private Button lupaButton, leftButton, rightButton;
	private Label paginasLabel;
	private ImageView lupaIV, arrowLeftIV, arrowRightIV;
	// -------------------------------------------//
	private Label nombreLabel, alturaLabel, pesoLabel, fechaLabel, planetaLabel, generoLabel, ojosLabel, peloLabel, pielLabel;
	private Label nombreLabelI, alturaLabelI, pesoLabelI, fechaLabelI, planetaLabelI, generoLabelI, ojosLabelI, peloLabelI, pielLabelI;
	


	public StarWarsView() {
		
		// izquierda ------------------------------------------------------------->
		buscadorField = new TextField();
		buscadorField.setPrefWidth(1000);
		
		lupaButton = new Button();
		lupaIV = new ImageView();
		lupaIV.setFitHeight(18);
		lupaIV.setFitWidth(20);
		lupaIV.setImage(new Image("file:lupa.png"));
		lupaButton.setGraphic(lupaIV);
		
		HBox busquedaBox = new HBox();
		busquedaBox.getChildren().addAll(buscadorField, lupaButton);
		busquedaBox.setSpacing(10);
		
		personajesList = new ListView<PeopleListItem>();
		personajesList.setPrefHeight(3000);

		leftButton = new Button();
		arrowLeftIV = new ImageView();
		arrowLeftIV.setFitHeight(20);
		arrowLeftIV.setFitWidth(20);
		arrowLeftIV.setImage(new Image("file:arrowleft.png"));
		leftButton.setGraphic(arrowLeftIV);
		
		rightButton = new Button();
		arrowRightIV = new ImageView();
		arrowRightIV.setFitHeight(20);
		arrowRightIV.setFitWidth(20);
		arrowRightIV.setImage(new Image("file:arrowright.png"));
		rightButton.setGraphic(arrowRightIV);
		
		paginasLabel = new Label("");
		paginasLabel.setPrefWidth(160);
		paginasLabel.setAlignment(Pos.CENTER);
		
		HBox navegadorBox = new HBox();
		navegadorBox.getChildren().addAll(leftButton,paginasLabel,rightButton);
		navegadorBox.setSpacing(20);
		navegadorBox.setAlignment(Pos.CENTER);

		
		left = new VBox();
		left.getChildren().addAll(busquedaBox,personajesList,navegadorBox);
		left.setSpacing(10);
		left.setPadding(new Insets(0,2,0,0));
		left.setPrefWidth(230);
		
		
		// derecha ------------------------------------------>
		derecha = new GridPane();
		
		derecha.addRow(0, nombreLabel = new Label("Nombre: "), nombreLabelI = new Label());
		derecha.addRow(1, alturaLabel = new Label("Altura: "), alturaLabelI = new Label());
		derecha.addRow(2, pesoLabel = new Label("Peso: "), pesoLabelI = new Label());
		derecha.addRow(3, fechaLabel = new Label("Año nacimiento: "), fechaLabelI = new Label());
		derecha.addRow(4, planetaLabel = new Label("Planeta origen: "), planetaLabelI = new Label());
		derecha.addRow(5, generoLabel = new Label("Género: "), generoLabelI = new Label());
		derecha.addRow(6, ojosLabel = new Label("Color de ojos: "), ojosLabelI = new Label());
		derecha.addRow(7, peloLabel = new Label("Color de pelo: "), peloLabelI = new Label());
		derecha.addRow(8, pielLabel = new Label("Color de piel: "), pielLabelI = new Label());
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
			};
			cols[0].setHalignment(HPos.RIGHT);


		derecha.getColumnConstraints().setAll(cols);
		derecha.setVgap(20);
		derecha.setPadding(new Insets(30,0,30,90));
		derecha.setMaxHeight(600);
		derecha.setAlignment(Pos.CENTER_LEFT);
		derecha.setId("CajaDerecha");
		
		derechaBox = new HBox();
		derechaBox.getChildren().addAll(derecha);
		derechaBox.setPadding(new Insets(40,0,0,90));
		derecha.setPrefHeight(600);
		
		

		izquierdaSplit = new SplitPane();
		izquierdaSplit.setOrientation(Orientation.HORIZONTAL);
		izquierdaSplit.getItems().setAll(left,derechaBox);
		izquierdaSplit.setBackground(null);
		izquierdaSplit.setDividerPositions(0.2f);
		
		
		this.getChildren().addAll(izquierdaSplit);
		this.setPadding(new Insets(20,10,10,20));
		this.setId("CajaPadre");
	}


	public SplitPane getIzquierdaSplit() {
		return izquierdaSplit;
	}


	public HBox getDerechaBox() {
		return derechaBox;
	}

	public VBox getLeft() {
		return left;
	}


	public GridPane getDerecha() {
		return derecha;
	}


	public TextField getBuscadorField() {
		return buscadorField;
	}


	public ListView<PeopleListItem> getPersonajesList() {
		return personajesList;
	}


	public Button getLupaButton() {
		return lupaButton;
	}


	public Button getLeftButton() {
		return leftButton;
	}


	public Button getRightButton() {
		return rightButton;
	}


	public Label getPaginasLabel() {
		return paginasLabel;
	}


	public ImageView getLupaIV() {
		return lupaIV;
	}


	public ImageView getArrowLeftIV() {
		return arrowLeftIV;
	}


	public ImageView getArrowRightIV() {
		return arrowRightIV;
	}


	public Label getNombreLabel() {
		return nombreLabel;
	}


	public Label getAlturaLabel() {
		return alturaLabel;
	}


	public Label getPesoLabel() {
		return pesoLabel;
	}


	public Label getFechaLabel() {
		return fechaLabel;
	}


	public Label getPlanetaLabel() {
		return planetaLabel;
	}


	public Label getGeneroLabel() {
		return generoLabel;
	}


	public Label getOjosLabel() {
		return ojosLabel;
	}


	public Label getPeloLabel() {
		return peloLabel;
	}


	public Label getPielLabel() {
		return pielLabel;
	}


	public Label getNombreLabelI() {
		return nombreLabelI;
	}


	public Label getAlturaLabelI() {
		return alturaLabelI;
	}


	public Label getPesoLabelI() {
		return pesoLabelI;
	}


	public Label getFechaLabelI() {
		return fechaLabelI;
	}


	public Label getPlanetaLabelI() {
		return planetaLabelI;
	}


	public Label getGeneroLabelI() {
		return generoLabelI;
	}


	public Label getOjosLabelI() {
		return ojosLabelI;
	}


	public Label getPeloLabelI() {
		return peloLabelI;
	}


	public Label getPielLabelI() {
		return pielLabelI;
	}
	
	

}


