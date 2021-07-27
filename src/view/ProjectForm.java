package view;

import bll.IProjectManagement;
import bll.ProjectManagerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Project;

public class ProjectForm extends Stage {
	private IProjectManagement projectManager = new ProjectManagerImpl();

	@SuppressWarnings("unchecked")
	public ProjectForm() {

		Text txHeadling = new Text("Company Project");
		txHeadling.getStyleClass().add("caption");
		txHeadling.setFill(Color.DARKRED);
	

		txHeadling.setFont(new Font("verdana", 23));

		HBox paneTop = new HBox(10, txHeadling);
		paneTop.getStyleClass().add("caption");
		paneTop.setAlignment(Pos.CENTER);
		/***************************************************/

		Label lbProjectID = new Label("Project ID: ");
		lbProjectID.getStyleClass().add("label2");

		TextField txProjectID = new TextField();
		txProjectID.setDisable(true);
		txProjectID.getStyleClass().add("text2");

		HBox paneProjectID = new HBox(15, lbProjectID, txProjectID);

		/*****************************************************/
		Label lbProjectName = new Label("Project name: ");
		lbProjectName.getStyleClass().add("label2");

		TextField txProjectName = new TextField();
		txProjectName.getStyleClass().add("text2");

		HBox paneProjectName = new HBox(15, lbProjectName, txProjectName);

		/*******************************************************************/
		Label lbLocation = new Label("Project location: ");
		lbLocation.getStyleClass().add("label2");

		TextField txLocation = new TextField();
		txLocation.getStyleClass().add("text2");

		HBox paneLocation = new HBox(15, lbLocation, txLocation);

		/****************************************************************************/

		Button btAdd = new Button("Add");
		btAdd.getStyleClass().add("button2");

		Button btDelete = new Button("Delete");
		btDelete.getStyleClass().add("button2");

		Button btDetail = new Button("Detail");
		btDetail.getStyleClass().add("button2");

		Button btClear = new Button("Clear");
		btClear.getStyleClass().add("button2");

		/**************************************************************************************/

		HBox paneButton = new HBox(10, btAdd, btDelete, btDetail, btClear);
		paneButton.getStyleClass().add("hbox1");

		VBox paneCenter = new VBox(10, paneProjectID, paneProjectName, paneLocation, paneButton);
		paneCenter.getStyleClass().add("vbox1");

		/***************************************************************************************/
		TableView<Project> table = new TableView<Project>();
		table.setEditable(true);

		TableColumn<Project, String> colPrID = new TableColumn<>("Project ID");
		// colPrID.getStyleClass().add("column1");
		colPrID.setPrefWidth(80);
		colPrID.setCellValueFactory(new PropertyValueFactory<>("projectID"));

		TableColumn<Project, String> colPrName = new TableColumn<>("Project Name");
		// colPrName.getStyleClass().add("column1");
		colPrName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
		colPrName.setCellFactory(TextFieldTableCell.forTableColumn());
		colPrName.setOnEditCommit(new EventHandler<CellEditEvent<Project, String>>() {

			@Override
			public void handle(CellEditEvent<Project, String> t) {
				String newValue = t.getNewValue();
				Project project = table.getSelectionModel().getSelectedItem();
				project.setProjectName(newValue);
				projectManager.updateProject(project);
				table.setItems(FXCollections.observableArrayList(projectManager.getAllProjects()));
			}

		});

		TableColumn<Project, String> colPrLocation = new TableColumn<>("Project Location");
		// colPrLocation.getStyleClass().add("column1");
		colPrLocation.setCellValueFactory(new PropertyValueFactory<>("projectLocation"));
		colPrLocation.setCellFactory(TextFieldTableCell.forTableColumn());
		colPrLocation.setOnEditCommit(new EventHandler<CellEditEvent<Project, String>>() {

			@Override
			public void handle(CellEditEvent<Project, String> t) {

				String newValue = t.getNewValue();

				Project project = table.getSelectionModel().getSelectedItem();
				project.setProjectLocation(newValue);
				projectManager.updateProject(project);
				table.setItems(FXCollections.observableArrayList(projectManager.getAllProjects()));
			}

		});

		table.getColumns().addAll(colPrID, colPrName, colPrLocation);

		ObservableList<Project> data = FXCollections.observableArrayList(projectManager.getAllProjects());
		/**********************************************************/
		btDetail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Project project = table.getSelectionModel().getSelectedItem();
				if (project == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Warning");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage projectDetailStage = new ProjectDetailView(project);

					projectDetailStage.initModality(Modality.WINDOW_MODAL);
					// projectDetailStage.initOwner(this);
					projectDetailStage.showAndWait();
				}

			}
		});

		/**********************************************************/
		btAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Project project = table.getSelectionModel().getSelectedItem();
				if (txProjectName.getText().isEmpty() || txLocation.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Warning");
					alert.setContentText("Please complete all information!");
					alert.showAndWait();
				}
				else {
					
				}
			}
		});

		btAdd.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				Project project = new Project(txProjectName.getText(), txLocation.getText());
				projectManager.insertProject(project);

				table.setItems(FXCollections.observableArrayList(projectManager.getAllProjects()));

			}
		});

		btClear.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				txProjectName.setText("");
				txLocation.setText("");
				txProjectID.setText("");
			}
		});

		/**************************************************************/

		btDelete.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Project project = table.getSelectionModel().getSelectedItem();
				if (project == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Project Details");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage projectDetailStage = new ProjectDetailView(project);

					projectDetailStage.initModality(Modality.WINDOW_MODAL);
					// projectDetailStage.initOwner(stage);
					projectDetailStage.showAndWait();
				}

			}
		});

		btDelete.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Project project = table.getSelectionModel().getSelectedItem();
				btDelete.setOnAction(event -> {
					ObservableList<Project> allStrings;
					ObservableList<Project> stringSelected;
					allStrings = table.getItems();
					stringSelected = table.getSelectionModel().getSelectedItems();
					if (stringSelected.isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Please choose the row");
						alert.showAndWait();
					} else {
						stringSelected.forEach(allStrings::remove);
						projectManager.DeleteProject(project.getProjectID());
					}

				});

			}
		});
		/**********************************************************/

		VBox paneBottom = new VBox(table);
		paneBottom.getStyleClass().add("vbox1");

		/**********************************************************/
		BorderPane paneMain = new BorderPane();
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		// paneMain.getStyleClass().add("project");
		paneMain.setStyle("-fx-background-color : #B0E2FF;\n");
		table.setItems(data);
		Scene scene = new Scene(paneMain);
		scene.getStylesheets().add("styleSheet.css");

		Image iconStage = new Image(getClass().getResourceAsStream("/project1.png"));
		this.getIcons().add(iconStage);

		this.setTitle("Project Form");
		this.setScene(scene);

	}

}