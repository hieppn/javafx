package view;

import java.sql.Date;
import java.util.Optional;

import bll.IUserManagement;
import bll.UserManagementImpl;
import dto.UserDto;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class Register extends Stage {
	public static boolean stateRegister = false;

	@SuppressWarnings("unchecked")
	public Register
	// TODO Auto-generated constructor stub
	() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(30, 30, 30, 30));
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setStyle("-fx-background-color : #B0E2FF;\n");

		Label caption = new Label("REGISTER");
		caption.setFont(new Font("verdana", 23));
		caption.setTextFill(Color.DARKRED);
		caption.getStyleClass().add("caption");
		
		GridPane.setConstraints(caption, 0, 0, 4, 1, HPos.CENTER, VPos.CENTER);
		grid.add(caption, 0, 0);

		Label lbFName = new Label("First name(");
		Label star1 = new Label("*");
		star1.setTextFill(Color.RED);
		Label bracket1 = new Label(")");
		HBox hFName = new HBox();
		hFName.getChildren().addAll(lbFName, star1, bracket1);

		grid.add(hFName, 0, 1);
		

		TextField txFName = new TextField();
		txFName.setPrefWidth(200);
		grid.add(txFName, 1, 1);

		Label lbLName = new Label("Last name(");
		Label star2 = new Label("*");
		star2.setTextFill(Color.RED);
		Label bracket2 = new Label(")");
		HBox hLName = new HBox();
		hLName.getChildren().addAll(lbLName, star2, bracket2);

		grid.add(hLName, 2, 1);

		TextField txLName = new TextField();
		txLName.setPrefWidth(200);
		grid.add(txLName, 3, 1);

		Label lbDate = new Label("Date of Birth(");
		Label star4 = new Label("*");
		star4.setTextFill(Color.RED);
		Label bracket4 = new Label(")");
		HBox hDate = new HBox();
		hDate.getChildren().addAll(lbDate, star4, bracket4);

		grid.add(hDate, 0, 2);

		DatePicker dateob = new DatePicker();
		dateob.setPrefWidth(220);
		grid.add(dateob, 1, 2);


		Label lbPhone = new Label("Phone(");
		Label star3 = new Label("*");
		star3.setTextFill(Color.RED);
		Label bracket3 = new Label(")");
		HBox hPhone = new HBox();
		hPhone.getChildren().addAll(lbPhone, star3, bracket3);

		grid.add(hPhone, 2, 2);

		TextField txPhone = new TextField();
		txPhone.setPrefWidth(200);
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
		grid.add(txPhone, 3, 2);

		Label lbAddress = new Label("Address(");
		Label star5 = new Label("*");
		star5.setTextFill(Color.RED);
		Label bracket5 = new Label(")");
		HBox hAddress = new HBox();
		hAddress.getChildren().addAll(lbAddress, star5, bracket5);
		grid.add(hAddress, 0, 3);
		
		@SuppressWarnings("rawtypes")
		ComboBox cbCountry = new ComboBox();
		cbCountry.setItems(FXCollections.observableArrayList("An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn",
				"Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau",
				"Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp",
				"Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang",
				"Vĩnh Long", "Vĩnh Phúc", "Yên Bái"));
		cbCountry.setPrefWidth(220);
		cbCountry.getSelectionModel().select(0);
		grid.add(cbCountry, 1, 3);

		Label lbPosition = new Label("Position(");
		Label star6 = new Label("*");
		star6.setTextFill(Color.RED);
		Label bracket6 = new Label(")");
		HBox hPosition = new HBox();
		hPosition.getChildren().addAll(lbPosition, star6, bracket6);
		grid.add(hPosition, 2, 3);

		@SuppressWarnings("rawtypes")
		ChoiceBox cbPosition = new ChoiceBox(FXCollections.observableArrayList("Leader", "Team Member"));
		cbPosition.setPrefWidth(220);
		cbPosition.getSelectionModel().select(1);
		grid.add(cbPosition, 3, 3);
		
		Label lbEmail = new Label("Email");
		Label star7 = new Label("*");
		star7.setTextFill(Color.RED);
		Label bracket7 = new Label(")");
		HBox hEmail = new HBox();
		hEmail.getChildren().addAll(lbEmail, star7, bracket7);
		grid.add(hEmail, 0, 4);

		TextField txEmail = new TextField();
		GridPane.setConstraints(txEmail, 1, 4, 3, 1, HPos.CENTER, VPos.CENTER);
		grid.add(txEmail, 1, 4);

		Label lbMess = new Label("We'll never share your email with anyone else.");
		grid.setPadding(new Insets(5));
		GridPane.setConstraints(lbMess, 1, 5, 3, 1, HPos.LEFT, VPos.CENTER);
		grid.add(lbMess, 1, 5);

		Text lbGender = new Text("Gender");
		grid.add(lbGender, 0, 6);


		/********************************************************************/
		final ToggleGroup toggleGroup = new ToggleGroup();

		RadioButton male = new RadioButton("Male");
		male.setSelected(true);
		male.requestFocus();
		male.setUserData(male);
		male.setToggleGroup(toggleGroup);

		RadioButton female = new RadioButton("Female");
		female.setSelected(true);
		female.requestFocus();
		female.setUserData(female);
		female.setToggleGroup(toggleGroup);

		String gender = male.isSelected() ? "Male" : "Female";

		HBox hbox = new HBox();
		hbox.setSpacing(45);
		hbox.getChildren().addAll(male, female);
		grid.add(hbox, 1, 6);

		Label lbUsername = new Label("Username(");
		Label star8 = new Label("*");
		star8.setTextFill(Color.RED);
		Label bracket8 = new Label(")");
		HBox hUsername = new HBox();
		hUsername.getChildren().addAll(lbUsername, star8, bracket8);
		grid.add(hUsername, 0, 7);

		TextField txUsername = new TextField();
		txUsername.setPrefWidth(220);
		grid.add(txUsername, 1, 7);

		Label lbPass = new Label("Password(");
		Label star9 = new Label("*");
		star9.setTextFill(Color.RED);
		Label bracket9 = new Label(")");
		HBox hPass = new HBox();
		hPass.getChildren().addAll(lbPass, star9, bracket9);
		grid.add(hPass, 0, 8);

		PasswordField passwordField = new PasswordField();
		passwordField.setPrefWidth(220);
		grid.add(passwordField, 1, 8);

		Label lbConfirmPass = new Label("Confirm Password(");
		Label star10 = new Label("*");
		star10.setTextFill(Color.RED);
		Label bracket10 = new Label(")");
		HBox hConfirmPass = new HBox();
		hConfirmPass.getChildren().addAll(lbConfirmPass, star10, bracket10);
		grid.add(hConfirmPass, 2, 8);

		PasswordField txConfirmPass = new PasswordField();
		txConfirmPass.setPrefWidth(220);
		grid.add(txConfirmPass, 3, 8);
		
		Button register = new Button("Register");
		GridPane.setConstraints(register, 1, 9, 3, 1, HPos.CENTER, VPos.CENTER);
		register.setPrefWidth(580);
		register.setAlignment(Pos.CENTER);
		register.setStyle("-fx-background-color:#FFCCCC;;\n");
		register.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		register.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txFName.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter your first name");
					return;
				}
				if (txLName.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter your last name");
					return;
				}

				if (txPhone.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter your phone");
					return;
				}

				if (txEmail.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter your email");
					return;
				}

				if (passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter a password");
					return;
				}

				if (txUsername.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please enter your username");
					return;
				}

				if (!passwordField.getText().equals(txConfirmPass.getText())) {
					showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
							"Please cofirm right your password");
					return;
				} else {
					showAlert(Alert.AlertType.CONFIRMATION, grid.getScene().getWindow(), "Registration Successful!",
							"Welcome " + txFName.getText());
					UserDto emp = new UserDto(txFName.getText(), txLName.getText(), txEmail.getText(),
							txUsername.getText(), txConfirmPass.getText(), cbPosition.getValue().toString(), gender,
							Date.valueOf(dateob.getValue()), txPhone.getText(), cbCountry.getValue().toString());
					IUserManagement cus = new UserManagementImpl();
					cus.insertUser(emp);
					

					close();
					Stage temp= new Stage();
					Stage login =new Main(temp);
					login.show();

				}

			}

			private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
				Alert alert = new Alert(alertType);
				alert.setTitle(title);
				alert.setHeaderText(null);
				alert.setContentText(message);
				alert.initOwner(owner);
				alert.show();

			}
		});

		grid.add(register, 1, 9);

		String str = "By clicking the 'Sign Up' button you confirm that accept our Terms of use and Privacy Policy";

		Label lbHelp = new Label(str);
		GridPane.setConstraints(lbHelp, 1, 10, 4, 1, HPos.CENTER, VPos.CENTER);

		grid.add(lbHelp, 1, 10);

		
		Scene scene = new Scene(grid);
		scene.getStylesheets().add("styleSheet.css");
		this.setTitle("Register Form");
		this.setScene(scene);
		this.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@SuppressWarnings("unused")
			@Override
			public void handle(WindowEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirm");
				alert.setHeaderText(null);
				alert.setContentText("Do you want to close the application?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					Stage a= new Stage();
					Stage MainC= new Main(a);

				} else {
					windowEvent.consume();
				}
			}

		});
	}

}