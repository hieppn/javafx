package view;

import bll.IUserManagement;
import bll.UserManagementImpl;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class ProfileDetailView extends Stage {
	IUserManagement user = new UserManagementImpl();
	

	public ProfileDetailView() {
		User profile = user.getUserByUsername(Login.userNameCheck);
		GridPane grid = new GridPane();
		grid.setHgap(12);
		grid.setVgap(12);
		grid.setPadding(new Insets(12, 10, 15, 10));
		grid.setStyle("-fx-background-color : #B0E2FF;\n");


		Label employeeDetail = new Label("Information detail");
		employeeDetail.setTextFill(Color.DARKRED);
		employeeDetail.setFont(Font.font("Verdana", FontWeight.BOLD, 23));


		grid.add(employeeDetail, 0, 0, 2, 1);

		Label lbCode = new Label("Id");
		grid.add(lbCode, 0, 1);
		lbCode.setFont(new Font("verdana", 12));


		TextField txCode = new TextField(profile.getId().toString());
		txCode.setPrefWidth(230);
		grid.add(txCode, 1, 1);
		lbCode.setFont(new Font("verdana", 12));


		Label lbFirstName = new Label("First Name");
		grid.add(lbFirstName, 0, 2);
		lbFirstName.setFont(new Font("verdana", 12));


		TextField txFirstName = new TextField(profile.getFirstName());
		grid.add(txFirstName, 1, 2);
		txFirstName.setFont(new Font("verdana", 12));


		Label lbLastName = new Label("Last Name");
		grid.add(lbLastName, 0, 3);
		lbLastName.setFont(new Font("verdana", 12));


		TextField txLastName = new TextField(profile.getLastName());
		grid.add(txLastName, 1, 3);
		txLastName.setFont(new Font("verdana", 12));


		Label lbMail = new Label("Email");
		grid.add(lbMail, 0, 4);
		lbMail.setFont(new Font("verdana", 12));


		TextField txMail = new TextField(profile.getEmail());
		grid.add(txMail, 1, 4);
		txMail.setFont(new Font("verdana", 12));

		
		Label lbPosition = new Label("Position");
		grid.add(lbPosition, 0, 5);
		lbPosition.setFont(new Font("verdana", 12));


		TextField txPosition = new TextField(profile.getPosition());
		grid.add(txPosition, 1, 5);
		txPosition.setFont(new Font("verdana", 12));

		
		Label lbGender = new Label("Gender");
		grid.add(lbGender, 0, 6);
		lbGender.setFont(new Font("verdana", 12));


		TextField txGender = new TextField(profile.getGender());
		grid.add(txGender, 1, 6);
		txGender.setFont(new Font("verdana", 12));

		
		Label lbUser = new Label("Username");
		grid.add(lbUser, 0, 7);
		lbUser.setFont(new Font("verdana", 12));


		TextField txUser = new TextField(profile.getUserName());
		grid.add(txUser, 1, 7);
		txUser.setFont(new Font("verdana", 12));

		
		Label lbPass = new Label("Passwork");
		grid.add(lbPass, 0, 8);
		lbPass.setFont(new Font("verdana", 12));


		TextField txPass = new TextField(profile.getGender());
		grid.add(txPass, 1, 8);
		txPass.setFont(new Font("verdana", 12));

		
		Label lbBirthday = new Label("Bithday");
		grid.add(lbBirthday, 0, 9);
		lbBirthday.setFont(new Font("verdana", 12));


		TextField txBirthday = new TextField(profile.getDateOfBirth());
		grid.add(txBirthday, 1, 9);
		txBirthday.setFont(new Font("verdana", 12));

		
		Label lbPhone = new Label("Phone Number");
		grid.add(lbPhone, 0, 10);
		lbPhone.setFont(new Font("verdana", 12));


		TextField txPhone = new TextField(profile.getPhoneNumber());
		grid.add(txPhone, 1, 10);
		txPhone.setFont(new Font("verdana", 12));


		Label lbAddress = new Label("Address");
		grid.add(lbAddress, 0, 11);
		lbAddress.setFont(new Font("verdana", 12));


		TextField txAddress = new TextField(profile.getAddress());
		grid.add(txAddress, 1, 11);
		txAddress.setFont(new Font("verdana", 12));


		Scene scene = new Scene(grid);

		this.setTitle("My profile");
		this.setScene(scene);
	}
}
