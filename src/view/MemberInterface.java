package view;

import java.util.Optional;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MemberInterface extends Stage {
	public MemberInterface() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(30, 30, 30, 30));
		grid.setHgap(15);
		grid.setVgap(15);
		//grid.getStyleClass().add("scene");
		grid.setStyle("-fx-background-color : #B0E2FF;\n");

		Image imageHome = new Image(getClass().getResourceAsStream("/home.png"));
		Label home = new Label();
		home.setText("HOME PAGE");
		home.setGraphic(new ImageView(imageHome));
		home.setGraphicTextGap(5);
		home.setFont(Font.font(null, FontWeight.BOLD, 12));
		home.setMaxWidth(Double.MAX_VALUE);
		home.setLayoutX(100);
		home.setLayoutY(250);
		home.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				close();
				Stage a=new Stage();
				Stage MainC=new Main(a);
				MainC.show();
			
			}
		});

		Image imageProfile = new Image(getClass().getResourceAsStream("/profile.png"));
		Label profile = new Label();
		profile.setText("MY PROFILE");
		profile.setGraphic(new ImageView(imageProfile));
		profile.setGraphicTextGap(5);
		profile.setFont(Font.font(null, FontWeight.BOLD, 12));
		profile.setMaxWidth(Double.MAX_VALUE);
		profile.setLayoutX(100);
		profile.setLayoutY(250);
		profile.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
			
				Stage employeeDetailStage = new ProfileDetailView();
				employeeDetailStage.showAndWait();
			
			}
		});

		Label symbol = new Label("|");

		Image imageLogout = new Image(getClass().getResourceAsStream("/logout.png"));
		Label logout = new Label();
		logout.setText("LOGOUT");
		logout.setGraphic(new ImageView(imageLogout));
		logout.setGraphicTextGap(5);
		logout.setFont(Font.font(null, FontWeight.BOLD, 12));
		logout.setMaxWidth(Double.MAX_VALUE);
		logout.setLayoutX(100);
		logout.setLayoutY(250);
		
		logout.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				close();
				Stage a=new Stage();
				Stage MainC=new Main(a);
				MainC.show();
			
			}
		});

		Image imageMember = new Image(getClass().getResourceAsStream("/member.png"));
		Label member = new Label();
		member.setText("VIEW LIST OF MEMBER");
		member.setGraphic(new ImageView(imageMember));
		member.setGraphicTextGap(5);
		member.setFont(Font.font(null, FontWeight.BOLD, 12));
		member.setMaxWidth(Double.MAX_VALUE);
		member.setLayoutX(100);
		member.setLayoutY(250);
		member.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {

				Stage member = new TeamMemberForm();
				member.show();

			}
		});


		Image imageProject = new Image(getClass().getResourceAsStream("/project.png"));
		Label project = new Label();
		project.setText("VIEW LIST OF PROJECT");
		project.setGraphic(new ImageView(imageProject));
		project.setGraphicTextGap(5);
		project.setFont(Font.font(null, FontWeight.BOLD, 12));
		project.setMaxWidth(Double.MAX_VALUE);
		project.setLayoutX(100);
		project.setLayoutY(250);
		project.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
			
				Stage projectForm = new ProjectForm();
				projectForm.showAndWait();
			
			}
		});

		Label leader = new Label();
		leader.setText("WELCOME TO MEMBER PAGE");
		leader.getStyleClass().add("leader");
		leader.setAlignment(Pos.CENTER);
		GridPane.setConstraints(leader, 0, 1, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(leader, 0, 1);

		String str = "                You are a member. You can see information about the\n"
				+ "                staff and projects being implemented\n"
				+ "                Click on the above functions to view information and fix if necessary\n"
				+ "                Inside there is all the necessary information for you";
		Label message = new Label(str);
		message.setFont(new Font("Times New Roman", 15));
		message.setFont(Font.font(null, FontWeight.BOLD, 15));
		message.setAlignment(Pos.BOTTOM_CENTER);

		GridPane.setConstraints(message, 0, 2, 3, 1, HPos.CENTER, VPos.CENTER);
		grid.add(message, 0, 2);

		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		hbox2.setSpacing(5);
		hbox2.getChildren().addAll(profile, symbol, logout);

		
		hbox1.getChildren().addAll(home, member, project, hbox2);
		hbox1.setSpacing(20);
		grid.add(hbox1, 0, 0);

		Image imageForm = new Image(getClass().getResourceAsStream("/member.png"));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add("application.css");
		this.setTitle("Member Form");
		this.getIcons().add(imageForm);
		this.setScene(scene);
		this.show();
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Do you want to close the application?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					Stage a= new Stage();
					new Main(a);
				} else {
					windowEvent.consume();
				}
			}

		});

	}

	
}
