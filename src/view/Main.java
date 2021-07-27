package view;

import java.util.Optional;
import java.util.Stack;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Stage {
	public static Stack<Stage> stages = new Stack<>();

	public Main(Stage stage) {

		Image image = new Image(getClass().getResourceAsStream("/DuAn.jpg"));
		ImageView imageView = new ImageView();
		imageView.setImage(image);

		/*
		 * Button btLogin = new Button("Login"); btLogin.setFont(new Font("verdana",
		 * 12)); btLogin.setPrefSize(100,50);
		 */
		Image imageHome = new Image(getClass().getResourceAsStream("/home.png"));
		Label home = new Label();
		home.setText("HOME PAGE");
		home.setGraphic(new ImageView(imageHome));
		home.setGraphicTextGap(5);
		home.setFont(Font.font(null, FontWeight.BOLD, 16));
		home.setMaxWidth(Double.MAX_VALUE);

		Label us = new Label();
		us.setText("ABOUT US");
		us.setGraphicTextGap(5);
		us.setFont(Font.font(null, FontWeight.BOLD, 16));
		us.setMaxWidth(Double.MAX_VALUE);
		us.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// stage.close();
				Stage aboutSage = new About();
				aboutSage.initModality(Modality.APPLICATION_MODAL);
				aboutSage.initOwner(stage);
				aboutSage.showAndWait();
				close();
			}
		});

		Label lbLogin = new Label("LOGIN");
		lbLogin.setFont(new Font("verdana", 16));
		lbLogin.setFont(Font.font(null, FontWeight.BOLD, 16));
		lbLogin.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// stage.close();
				Stage loginSage = new Login();
				loginSage.initModality(Modality.APPLICATION_MODAL);
				loginSage.initOwner(stage);
				loginSage.showAndWait();
				close();
			}
		});

		/*
		 * Button btRegister = new Button("Register"); btRegister.setFont(new
		 * Font("verdana", 12)); btRegister.setPrefSize(100,50);
		 */

		Label lbRegister = new Label("REGISTER");
		lbRegister.setFont(new Font("verdana", 16));
		lbRegister.setFont(Font.font(null, FontWeight.BOLD, 16));
		lbRegister.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// stage.close();
				Stage registerSage = new Register();
				registerSage.initModality(Modality.APPLICATION_MODAL);
				registerSage.initOwner(stage);
				registerSage.showAndWait();
				close();
			}
		});

		/*
		 * Button btHelp = new Button("Help"); btHelp.setFont(new Font("verdana", 12));
		 * btHelp.setPrefSize(100,50);
		 */

		Label lbHelp = new Label("HELP");
		lbHelp.setFont(new Font("verdana", 16));
		lbHelp.setFont(Font.font(null, FontWeight.BOLD, 16));

		lbHelp.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// stage.close();
				Stage helpSage = new Help();
				helpSage.initModality(Modality.APPLICATION_MODAL);
				helpSage.initOwner(stage);
				helpSage.showAndWait();
				close();
			}
		});

		HBox paneTop = new HBox(15, home, us, lbLogin, lbRegister, lbHelp);
		paneTop.setAlignment(Pos.BASELINE_LEFT);
		paneTop.setPadding(new Insets(30, 10, 10, 10));
		/*********************************************************************/
		Reflection reflection = new Reflection();
		// Sét đặt độ mờ đục (opacity) ở phần cuối của phản xạ
		reflection.setBottomOpacity(0.0);
		// Sét đặt độ mờ đục (opacity) ở phần trên của phản xạ
		reflection.setTopOpacity(0.5);

		// Sét đặt khoảng cách giữa đối tượng và ảnh phản xạ.
		reflection.setTopOffset(5);

		// Sét đặt giá trị cho thuộc tính fraction.
		reflection.setFraction(0.5);

		 DropShadow dropShadow = new DropShadow();
	        dropShadow.setRadius(3.0);
	        dropShadow.setOffsetX(3.0);
	        dropShadow.setOffsetY(3.0);
	        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
	        
		/********************************************************************/

		Label caption = new Label("                    WELCOME TO \nTHE PROJECT MANAGEMENT SYSTEM");
		caption.setFont(new Font("times new roman", 50));
		caption.setTextFill(Color.web("#0076a3"));
		//caption.setEffect(reflection);
		caption.setEffect(dropShadow);

		HBox paneCenter = new HBox(10, caption);
		paneCenter.setPadding(new Insets(50, 20, 20, 10));
		paneCenter.setAlignment(Pos.TOP_CENTER);
		/*****************************************************************/
		
		BorderPane paneMain = new BorderPane();
		paneMain.getChildren().add(imageView);
		paneMain.setTop(paneTop);
		paneMain.setCenter(paneCenter);
		Image imageMain = new Image(getClass().getResourceAsStream("/Main.png"));
		Scene scene = new Scene(paneMain);
		stage.getIcons().add(imageMain);
		setTitle("Interface");
		// stage.setFullScreen(true);
		setScene(scene);
		//stage.setFullScreen(true);
		show();
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

				} else {
					windowEvent.consume();
				}
			}

		});

	}
	
}
