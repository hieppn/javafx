package view;

import java.util.Optional;

import bll.IUserManagement;
import bll.UserManagementImpl;
import dto.UserDto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Login extends Stage {

	public static boolean stateLogin = false;

	IUserManagement userManagement = new UserManagementImpl();
	IUserManagement userM = new UserManagementImpl();
	UserDto userdto=new UserDto();
	public static String userNameCheck= null;
	
	public Login() {

		Text txHeadling = new Text("LOGIN");
		txHeadling.setFill(Color.DARKRED);
		txHeadling.getStyleClass().add("caption");

		HBox paneTop = new HBox();
		paneTop.getStyleClass().add("caption");

		paneTop.getChildren().add(txHeadling);

		/**********************************************************************************************/

		Image imageUser = new Image(getClass().getResourceAsStream("/user.png"));
		ImageView imageView = new ImageView();
		imageView.setImage(imageUser);

		HBox paneImageUser = new HBox();
		paneImageUser.getChildren().add(imageView);
		paneImageUser.getStyleClass().add("label");

		/************************************************************************************************/

		Image imageUserName = new Image(getClass().getResourceAsStream("/avatar.png"));

		Label userName = new Label();
		userName.setGraphic(new ImageView(imageUserName));

		userName.getStyleClass().add("label1");

		TextField txUser = new TextField();
		txUser.setPromptText("   Enter user Name");
		txUser.getStyleClass().add("text1");

		HBox paneUser = new HBox(10, userName, txUser);

		Image imagePassword = new Image(getClass().getResourceAsStream("/password.png"));

		Label pass = new Label();
		pass.setGraphic(new ImageView(imagePassword));
		pass.getStyleClass().add("label1");

		PasswordField txPass = new PasswordField();
		txPass.setPromptText("   Enter password");
		txPass.getStyleClass().add("text1");

		HBox panePassword = new HBox(10, pass, txPass);

		VBox paneCenter = new VBox(10, paneImageUser, paneUser, panePassword);
		paneCenter.setPadding(new Insets(15, 20, 10, 10));

		/***********************************************************************************************/

		Button btLogin = new Button("Login");
		btLogin.getStyleClass().add("button1");

		txPass.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
			
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.ENTER) {
					if (txUser.getText().isEmpty() || txPass.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText(null);
						alert.setContentText("Enter all infomation");
						alert.showAndWait();
					} else {
						
						 
						if (userManagement.checkLogin(txUser.getText(), txPass.getText())) {
							userNameCheck = userManagement.checkLogin1(txUser.getText(), txPass.getText());
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText(null);
							alert.setContentText("Logged in successfully");
							alert.showAndWait();
							close();
							if(userManagement.checkLeader(txUser.getText(), txPass.getText())){
								Stage a= new LeaderInterface();
								
								a.show();
							}
							else {
								if(userManagement.checkMember(txUser.getText(), txPass.getText())){
									Stage a= new MemberInterface();
									
									a.show();
								}
								else {
									if(userManagement.checkAdmin(txUser.getText(), txPass.getText())){
										Stage a= new ManagementInterface();
										
										a.show();
									}
								}
							}
								
							
						} 
						else{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setHeaderText(null);
							alert.setContentText("Username or password is incorrect");
							alert.showAndWait();
							Stage a= new Stage();
							new Main(a);
						}
						close();
					}
				}
				
			}
		});
		btLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				if (userManagement.checkLogin(txUser.getText(), txPass.getText())) {
					
					Alert alert1 = new Alert(AlertType.INFORMATION);
					alert1.setHeaderText(null);
					alert1.setContentText("Logged in successfully");
					alert1.showAndWait();
					close();
					if(userManagement.checkLeader(txUser.getText(), txPass.getText())){
						Stage a= new LeaderInterface();
						
						a.show();
					}
					else {
						if (userManagement.checkMember(txUser.getText(), txPass.getText())){
							Stage a= new MemberInterface();
							
							a.show();
						}
						else {
							if(userManagement.checkAdmin(txUser.getText(), txPass.getText())){
								Stage a= new ManagementInterface();
								
								a.show();
							}
						}
					}
					
				}

				else {
					// TODO Auto-generated catch block
					Alert alert1 = new Alert(AlertType.ERROR);
					alert1.setHeaderText(null);
					alert1.setContentText("Username or password is incorrect");
					alert1.showAndWait();
					Stage a= new Stage();
					new Main(a);
				}
				close();
			}

		});

		Text tx = new Text("------------------");

		Button btNewAcount = new Button("Create a new account");
		btNewAcount.getStyleClass().add("button1");
		btNewAcount.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				Stage registerSage = new Register();
				registerSage.show();
			}
		});

		Label lbForgotPass = new Label("Forgot your password?");

		VBox paneBottom = new VBox(5, btLogin, tx, btNewAcount, lbForgotPass);
		paneBottom.setPadding(new Insets(15, 20, 10, 10));
		paneBottom.setAlignment(Pos.CENTER);
		lbForgotPass.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				close();
				new ForgotPass();

			}
		});

		/***********************************************************************************************/

		BorderPane paneMain = new BorderPane();
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		paneMain.setBottom(paneBottom);
		paneMain.setStyle("-fx-background-color : #B0E2FF;\n");
		paneMain.getStyleClass().add("login");

		Scene scene = new Scene(paneMain);
		scene.getStylesheets().add("styleSheet.css");

		Image iconStage = new Image(getClass().getResourceAsStream("/lock.png"));
		this.getIcons().add(iconStage);

		this.setTitle("Login");
	
		this.setScene(scene);
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
