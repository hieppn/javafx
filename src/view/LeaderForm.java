package view;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

import bll.ILeaderManagement;
import bll.IUserManagement;
import bll.LeaderManagerImpl;
import bll.UserManagementImpl;
import dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Leader;
public class LeaderForm extends Stage {

	private ILeaderManagement leaderManager = new LeaderManagerImpl();

	@SuppressWarnings("unchecked")
	
	public LeaderForm() {
		BorderPane borderPane = new BorderPane();
	

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(30, 30, 30, 30));
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setStyle("-fx-background-color : #B0E2FF;\n");

		/*********************************************************/

		Label caption = new Label("LIST OF LEADER");
		caption.setTextFill(Color.DARKRED);
		caption.setAlignment(Pos.CENTER);
		caption.setFont(Font.font("verdana", FontWeight.BOLD, 30));
		GridPane.setConstraints(caption, 0, 0, 4, 1, HPos.CENTER, VPos.CENTER);
		gridPane.add(caption, 1, 0);
		gridPane.setAlignment(Pos.TOP_CENTER);

		Label lbID = new Label("ID");
		gridPane.add(lbID, 0, 1);
		lbID.setFont(new Font("verdana", 12));


		TextField txID = new TextField();
		txID.setDisable(true);
		txID.setPromptText("Enter ID");
		gridPane.add(txID, 1, 1);
		txID.setPrefWidth(200);

		Label lbEmail = new Label("Email");
		gridPane.add(lbEmail, 2, 1);
		lbEmail.setFont(new Font("verdana", 12));


		TextField txEmail = new TextField();
		txEmail.setPromptText("Enter Email");
		gridPane.add(txEmail, 3, 1);
		txEmail.setPrefWidth(200);

		Label lbLName = new Label("Last Name");
		gridPane.add(lbLName, 0, 2);
		lbLName.setFont(new Font("verdana", 12));


		TextField txLName = new TextField();
		txLName.setPromptText("Enter last name");
		txLName.setPrefWidth(200);
		gridPane.add(txLName, 1, 2);

		Label lbAddress = new Label("Address");
		gridPane.add(lbAddress, 2, 2);
		lbAddress.setFont(new Font("verdana", 12));


		TextField txAddress = new TextField();
		txAddress.setPromptText("Enter address");
		txAddress.setPrefWidth(200);

		gridPane.add(txAddress, 3, 2);

		Label lbFName = new Label("First Name");
		gridPane.add(lbFName, 0, 3);
		lbFName.setFont(new Font("verdana", 12));


		TextField txFName = new TextField();
		txFName.setPromptText("Enter first name");
		txFName.setPrefWidth(200);
		gridPane.add(txFName, 1, 3);

		Label lbPhone = new Label("Phone");
		gridPane.add(lbPhone, 2, 3);
		lbPhone.setFont(new Font("verdana", 12));


		TextField txPhone = new TextField();
		txPhone.setPromptText("Enter phone");
		txPhone.setPrefWidth(200);
		gridPane.add(txPhone, 3, 3);

		Label lbDate = new Label("Date Of Birth");
		gridPane.add(lbDate, 0, 4);
		lbDate.setFont(new Font("verdana", 12));


		DatePicker DatePicker = new DatePicker();
		DatePicker.setPrefWidth(200);
		DatePicker.setPromptText("20/06/2000");

		gridPane.add(DatePicker, 1, 4);

		Label lblGender = new Label("Gender");
		gridPane.add(lblGender, 2, 4);
		lblGender.setFont(new Font("verdana", 12));

		ToggleGroup toggleGroup = new ToggleGroup();

		RadioButton male = new RadioButton("Male");
		male.requestFocus();
		male.setSelected(true);
		male.setToggleGroup(toggleGroup);

		RadioButton female = new RadioButton("Female");
		female.requestFocus();
		female.setToggleGroup(toggleGroup);

		HBox hBGender = new HBox();
		hBGender.setSpacing(10);
		hBGender.getChildren().addAll(male, female);
		gridPane.add(hBGender, 3, 4);
		GridPane.setConstraints(hBGender, 3, 4, 1, 1, HPos.LEFT, VPos.BOTTOM);

		HBox hBButton = new HBox();
		gridPane.add(hBButton, 0, 6);
		hBButton.setSpacing(30);
		Button btAdd = new Button("Add");
		btAdd.getStyleClass().add("button4");
		Image iAdd = new Image(getClass().getResourceAsStream("/add1.png"));
		btAdd.setGraphic(new ImageView(iAdd));
		
		
		Button btDelete = new Button("Delete");
		btDelete.getStyleClass().add("button4");
		Image iDelete = new Image(getClass().getResourceAsStream("/delete.png"));
		btDelete.setGraphic(new ImageView(iDelete));
		
		
		Button btDetail = new Button("Detail");
		btDetail.getStyleClass().add("button4");
		Image iEdit = new Image(getClass().getResourceAsStream("/edit.png"));
		btDetail.setGraphic(new ImageView(iEdit));
		
		
		Button btClear = new Button("Clear");
		btClear.getStyleClass().add("button4");
		Image iCancel = new Image(getClass().getResourceAsStream("/cancel.png"));
		btClear.setGraphic(new ImageView(iCancel));
		
		
		hBButton.getChildren().addAll(btAdd, btDelete, btDetail, btClear);
		hBButton.setSpacing(5);
		hBButton.setAlignment(Pos.CENTER);
		

		GridPane.setConstraints(hBButton, 0, 6, 4, 1);

		/******************************************************************/
		ObservableList<Leader> data = FXCollections.observableArrayList(leaderManager.getAllLeaders());

		TableView<Leader> table = new TableView<Leader>();
		table.setEditable(true);

		TableColumn<Leader, String> colID = new TableColumn<>("ID");
		colID.setPrefWidth(80);
		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		TableColumn<Leader, String> colLName = new TableColumn<>("Last Name");
		colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colLName.setCellFactory(TextFieldTableCell.forTableColumn());
		colLName.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setLastName(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});


		TableColumn<Leader, String> colFName = new TableColumn<>("First Name");
		colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colFName.setCellFactory(TextFieldTableCell.forTableColumn());
		colFName.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setFirstName(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});

		TableColumn<Leader, String> colAddress = new TableColumn<>("Address");
		colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
		colAddress.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setAddress(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});

		TableColumn<Leader, String> colPhone = new TableColumn<>("Phone");
		colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		colPhone.setCellFactory(TextFieldTableCell.forTableColumn());
		colPhone.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setPhone(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});

		TableColumn<Leader, String> colDate = new TableColumn<>("Date Of Birth");
		colDate.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
		colDate.setCellFactory(TextFieldTableCell.forTableColumn());
		colDate.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setDateOfBirth(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});

		TableColumn<Leader, String> colGenger = new TableColumn<>("Gender");
		colGenger.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colGenger.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<Leader, String> colEmail = new TableColumn<>("Email");
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colEmail.setCellFactory(TextFieldTableCell.forTableColumn());
		colEmail.setOnEditCommit(new EventHandler<CellEditEvent<Leader, String>>() {

			@Override
			public void handle(CellEditEvent<Leader, String> t) {
				String newValue = t.getNewValue();
				Leader project = table.getSelectionModel().getSelectedItem();
				project.setEmail(newValue);
				leaderManager.updateLeader(project);
				table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));
			}

		});
		
		TableColumn<Leader, String> colPosition = new TableColumn<>("Position");
		colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
		colPosition.setCellFactory(TextFieldTableCell.forTableColumn());

		table.getColumns().addAll(colID, colLName, colFName,  colDate,colEmail,colAddress, 
				colPhone,colGenger,  colPosition);
		table.setItems(data);

		
		
		gridPane.setAlignment(Pos.CENTER);
		
		
		
		btAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Project project = table.getSelectionModel().getSelectedItem();
				if (txEmail.getText().isEmpty() || txLName.getText().isEmpty() || txAddress.getText().isEmpty()
						|| txFName.getText().isEmpty() || txPhone.getText().isEmpty()
						|| DatePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yy")).equals("")) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Warning");
					alert.setContentText("Please complete all information!");
					alert.showAndWait();
				} else {
					btAdd.setOnMousePressed(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent mouseEvent) {
							String t = "Team Member";
							String gender = male.isSelected() ? "Male" : "Female";

							String user ="leader";
							String password = "123456";
							String position = "Leader";
							
							UserDto emp = new UserDto(txFName.getText(), txLName.getText(), txEmail.getText(),
									user, password, position, gender, Date.valueOf(DatePicker.getValue()), txPhone.getText(),
									txAddress.getText()	);
							
		
							IUserManagement cus = new UserManagementImpl();
							cus.insertUser(emp);

							table.setItems(FXCollections.observableArrayList(leaderManager.getAllLeaders()));

						}
					});
				}
			}
		});
		
		btDelete.setOnMousePressed(new EventHandler<MouseEvent>() { 
			 public void handle(MouseEvent mouseEvent) { 
				 Leader leader = table.getSelectionModel().getSelectedItem();
			  
			 btDelete.setOnAction(event -> {
			 
			 ObservableList<Leader> allStrings; 
			 ObservableList<Leader> stringSelected;
			 allStrings = table.getItems(); 
			 stringSelected = table.getSelectionModel().getSelectedItems(); 
			 if(stringSelected.isEmpty()) 
			 { Alert alert = new Alert(AlertType.ERROR);
			 alert.setHeaderText(null); alert.setContentText("Please choose the row");
			 alert.showAndWait(); 
			 } 
			 else { stringSelected.forEach(allStrings::remove);
			 	leaderManager.DeleteLeader(leader.getId());
			 	}
			  
			 });
			  
			  } });
		
		btClear.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				txEmail.setText("");
				txLName.setText("");
				txAddress.setText("");
				txFName.setText("");
				txPhone.setText("");
				male.setSelected(true);
				DatePicker.setValue(null);
				
			}
		});
		
		btDetail.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Leader leader = table.getSelectionModel().getSelectedItem();
				if (leader == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Warning");
					alert.setContentText("Please select a row in the table");
					alert.showAndWait();
				} else {
					Stage leaderDetailStage = new LeaderDetailView(leader);

					leaderDetailStage.initModality(Modality.WINDOW_MODAL);
					//teamMemberDetailStage.initOwner(stage);
					leaderDetailStage.showAndWait();
				}

			}
		});
			
		/*******************************************************************/
		 Image iconStage = new Image(getClass().getResourceAsStream("/list.png"));

		 this.getIcons().add(iconStage);
		
		
		borderPane.setTop(gridPane);
		borderPane.setBottom(table);
		table.setStyle("-fx-background-color : #B0E2FF;\n");
		table.getStyleClass().add("vbox1");

		Scene scene = new Scene(borderPane);
		scene.getStylesheets().add("styleSheet.css");
		this.setTitle("List of leader");
		this.setScene(scene);
		this.show();
	}

}
