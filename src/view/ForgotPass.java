package view;

import java.util.ArrayList;
import java.util.List;

import bll.IUserManagement;
import bll.UserManagementImpl;
import dto.UserDto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPass extends Stage {

	public ForgotPass() {

		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setStyle("-fx-background-color : #B0E2FF;\n");
		g.setPadding(new Insets(20, 40, 20, 40));

		Text tTitle = new Text("Forgot your password?");
		tTitle.setFill(Color.DARKRED);
		tTitle.setFont(new Font("verdana", 23));

		GridPane.setConstraints(tTitle, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(tTitle, 0, 0);

		Label note = new Label("Don't worry! Let tell us the username and the phone number you registered");
		note.setFont(new Font("verdana", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);

		Label lbUsername = new Label("Username(");
		Label star8 = new Label("*");
		star8.setTextFill(Color.RED);
		Label bracket8 = new Label(")");
		HBox hUsername = new HBox();
		hUsername.getChildren().addAll(lbUsername, star8, bracket8);
		g.add(hUsername, 0, 2);

		TextField txUsername = new TextField();
		txUsername.setPromptText("Username");
		txUsername.setPrefHeight(35);
		GridPane.setConstraints(txUsername, 0, 2, 2, 1);
		g.add(txUsername, 1, 2);

		Label lbPhone = new Label("Phone(");
		Label star3 = new Label("*");
		star3.setTextFill(Color.RED);
		Label bracket3 = new Label(")");
		HBox hPhone = new HBox();
		hPhone.getChildren().addAll(lbPhone, star3, bracket3);

		g.add(hPhone, 0, 3);

		TextField txPhone = new TextField();
		txPhone.setPromptText("Your phone number");
		txPhone.setPrefHeight(35);
		txPhone.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				try {
					Double.valueOf(keyEvent.getText());
				} catch (NumberFormatException ex) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("Please input the number!");
					alert.showAndWait();
				}
			}
		});
		GridPane.setConstraints(txPhone, 0, 3, 2, 1);
		g.add(txPhone, 1, 3);

		Button send = new Button("Send");
		send.setStyle("-fx-background-color:#FFCCCC;\n" + " -fx-border-color: rgb(49, 89, 23);" + "\n"
				+ "-fx-border-radius: 5.0;");
		send.setFont(new Font("verdana", 15));
		send.setPrefWidth(100);
		send.setPrefHeight(35);
		GridPane.setConstraints(send, 0, 4, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(send, 0, 4);

		send.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				IUserManagement cus = new UserManagementImpl();
				UserDto dtoSearch = new UserDto();
				dtoSearch.setUsername(txUsername.getText());
				dtoSearch.setPhoneNumber(txPhone.getText());
				List<UserDto> list = new ArrayList<>();
				list = cus.search(dtoSearch);

				if (txPhone.getText().isEmpty() || txUsername.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				} else 
					{
					if (list != null) {
					close();
					new newPass(list.get(0).getId());
				} else {
					
					System.out.println("User and phone number are incorrect !");
				}

			}
			}
		});

		Scene s = new Scene(g, 500, 300);
		this.setScene(s);
		this.setTitle("Fotgot password");
		this.show();

	}

}
