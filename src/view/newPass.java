package view;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class newPass extends Stage {

	public newPass(int i) {
		GridPane g = new GridPane();
		g.setVgap(10);
		g.setHgap(10);
		g.setStyle("-fx-background-color : #B0E2FF;\n");
		g.setPadding(new Insets(20, 40, 20, 40));
		
		
		Text tTitle = new Text("Reset your password");
		tTitle.setFill(Color.DARKRED);
		tTitle.setFont(new Font("Times New Roman", 23));
		GridPane.setConstraints(tTitle, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(tTitle, 0, 0);

		Label note = new Label("You have successfully reset your password. " + "Please create a new password");
		note.setFont(new Font("Times New Roman", 15));
		note.setWrapText(true);
		GridPane.setConstraints(note, 0, 1, 2, 1);
		g.add(note, 0, 1);

		Label newPassword = new Label("New password");
		g.add(newPassword, 0, 2);
		
		TextField txNewpass = new TextField();
		txNewpass.setPromptText("Enter new password");
		txNewpass.setPrefHeight(35);
		GridPane.setConstraints(txNewpass, 1, 2, 2, 1);
		g.add(txNewpass, 1, 2);

		Label confirmNewPassword = new Label("Confirm new password");
		g.add(confirmNewPassword, 0, 3);
		
		TextField txRenewpass = new TextField();
		txRenewpass.setPromptText("Enter re-new password");
		txRenewpass.setPrefHeight(35);
		GridPane.setConstraints(txRenewpass, 1, 3, 2, 1);
		g.add(txRenewpass, 1, 3);


		Button ok = new Button("OK");
		ok.setStyle("-fx-background-color:#FFCCCC;\n" + " -fx-border-color: rgb(49, 89, 23);"
				+ "\n" + "-fx-border-radius: 5.0;");
		ok.setFont(new Font("Times New Roman", 15));
		ok.setPrefWidth(100);
		ok.setPrefHeight(35);
		GridPane.setConstraints(ok, 1, 4, 2, 1, HPos.CENTER, VPos.CENTER);
		g.add(ok, 1, 4);

		ok.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				IUserManagement cus = new UserManagementImpl();
				UserDto user2 = cus.getUserById(i);
				if (txNewpass.getText().isEmpty() || txRenewpass.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Enter all infomation");
					alert.showAndWait();
				} else if (txNewpass.getText().equals(txRenewpass.getText())) {
					if (user2 != null) {
						user2.setPassword(txNewpass.getText());
						cus.updateUser(user2);
					}
					close();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setContentText("Successful");
					alert.showAndWait();
					Stage a = new Stage();
					Stage lo = new Main(a);
					lo.show();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Your password is not the equal");
					alert.showAndWait();
				}
			}
		});

		Scene scene = new Scene(g);
		this.setScene(scene);
		this.setTitle("Reset password");
		this.show();

	}
}
