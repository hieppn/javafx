package view;

import bll.ITeamMemberManagement;
import bll.TeamMemberManagerImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Project;
import model.TeamMember;

public class ProjectDetailView extends Stage {

		public ProjectDetailView(Project project) {

			GridPane grid = new GridPane();
			grid.setHgap(12);
			grid.setVgap(12);
			grid.setPadding(new Insets(12, 10, 15, 10));
			grid.setStyle("-fx-background-color : #B0E2FF;\n");


			Label projectDetail = new Label("Project Detail");
			projectDetail.setTextFill(Color.DARKRED);
			projectDetail.setFont(Font.font("Verdana", FontWeight.BOLD, 23));
			projectDetail.setAlignment(Pos.CENTER);


			grid.add(projectDetail, 0, 0, 2, 1);

			Label lbID = new Label("Project ID");
			grid.add(lbID, 0, 1);
			lbID.setFont(new Font("verdana", 12));


			TextField txID = new TextField(String.valueOf(project.getProjectID()));
			txID.setPrefWidth(230);
			grid.add(txID, 1, 1);
			txID.setFont(new Font("verdana", 12));


			Label lbProjectName = new Label("Project Name");
			grid.add(lbProjectName, 0, 2);
			lbProjectName.setFont(new Font("verdana", 12));


			TextField txFirstName = new TextField(project.getProjectName());
			grid.add(txFirstName, 1, 2);
			txFirstName.setFont(new Font("verdana", 12));

			Label lbProjectLocation = new Label("Project Location");
			grid.add(lbProjectLocation, 0, 3);
			lbProjectLocation.setFont(new Font("verdana", 12));


			TextField txProjectLocation = new TextField(project.getProjectLocation());
			grid.add(txProjectLocation, 1, 3);
			txProjectLocation.setFont(new Font("verdana", 12));


/***********************************************************************/
ITeamMemberManagement teamMemberManager = new TeamMemberManagerImpl();
			

			TableView<TeamMember> table = new TableView<TeamMember>();
			table.setEditable(true);

			TableColumn<TeamMember, String> colID = new TableColumn<>("ID");
			colID.setPrefWidth(80);
			colID.setCellValueFactory(new PropertyValueFactory<>("id"));

			TableColumn<TeamMember, String> colLName = new TableColumn<>("Last Name");
			colLName.setMaxWidth(Double.MAX_VALUE);
			colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			colLName.setCellFactory(TextFieldTableCell.forTableColumn());
			colLName.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setLastName(newValue);
				}

			});

			TableColumn<TeamMember, String> colFName = new TableColumn<>("First Name");
			colFName.setMaxWidth(Double.MAX_VALUE);
			colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			colFName.setCellFactory(TextFieldTableCell.forTableColumn());
			colFName.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setFirstName(newValue);
					;
				}

			});

			TableColumn<TeamMember, String> colAddress = new TableColumn<>("Address");
			colAddress.setMaxWidth(Double.MAX_VALUE);
			colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
			colAddress.setCellFactory(TextFieldTableCell.forTableColumn());
			colAddress.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setAddress(newValue);
					;
					;
				}

			});

			TableColumn<TeamMember, String> colPhone = new TableColumn<>("Phone");
			colPhone.setMaxWidth(Double.MAX_VALUE);
			colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
			colPhone.setCellFactory(TextFieldTableCell.forTableColumn());
			colPhone.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setPhone(newValue);
					;
				}

			});

			TableColumn<TeamMember, String> colDate = new TableColumn<>("Date Of Birth");
			colDate.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
			colDate.setCellFactory(TextFieldTableCell.forTableColumn());
			colDate.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setDateOfBirth(newValue);
					;
				}

			});

			TableColumn<TeamMember, String> colGenger = new TableColumn<>("Gender");
			colGenger.setCellValueFactory(new PropertyValueFactory<>("gender"));
			colGenger.setCellFactory(TextFieldTableCell.forTableColumn());
			colGenger.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setGender(newValue);
				}

			});

			TableColumn<TeamMember, String> colEmail = new TableColumn<>("Email");
			colEmail.setMaxWidth(Double.MAX_VALUE);
			colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
			colEmail.setCellFactory(TextFieldTableCell.forTableColumn());
			colEmail.setOnEditCommit(new EventHandler<CellEditEvent<TeamMember, String>>() {

				@Override
				public void handle(CellEditEvent<TeamMember, String> t) {
					// TODO Auto-generated method stub
					String newValue = t.getNewValue();
					int row = t.getTablePosition().getRow();
					t.getTableView().getItems().get(row).setEmail(newValue);
				}

			});

			TableColumn<TeamMember, String> colPosition = new TableColumn<>("Position");
			colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
			colPosition.setCellFactory(TextFieldTableCell.forTableColumn());

			table.getColumns().addAll(colID, colLName, colFName, colDate, colEmail, colAddress, colPhone, colGenger,
					colPosition);
			grid.add(table, 0, 5);
			GridPane.setConstraints(table, 0, 5, 2, 1, HPos.CENTER, VPos.CENTER);
			
			
			ObservableList<TeamMember> data = FXCollections.observableArrayList(teamMemberManager.getAllTeamMembersDoProject(project.getProjectID()));
			table.setItems(data);
			
			
			Label message = new Label("The staff is implementing the project");
			message.setFont(new Font("Times new roman", 20));
			GridPane.setConstraints(message, 0, 4, 2, 1, HPos.CENTER, VPos.CENTER);
			grid.add(message, 0, 4);
			/**********************************************************************************/
			Scene scene = new Scene(grid);

			this.setTitle("Project Detail");
			this.setScene(scene);
		}
	}



