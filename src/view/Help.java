package view;
import java.util.Optional;

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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Help extends Stage {

	public Help() {
		GridPane grid = new GridPane();

		Text txCaption = new Text("Information you need to know");
		GridPane.setConstraints(txCaption, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(txCaption, 0, 0);
		txCaption.setFill(Color.DARKRED);
		txCaption.getStyleClass().add("caption");

		Text txHelp = new Text(
				"1.All information must be filled" + "\n2.Note" + "\na) Login: Enter the correct username and password"

						+ "\nb) Registration\" + \"\n- Position: Either manager or team member or team leader.\""
						+ "\n- Username: not space, no special characters." + "\n- Password: 6 characters or more.");

		txHelp.setFont(new Font("verdana", 20));
		GridPane.setConstraints(txHelp, 0, 1, 2, 1, HPos.CENTER, VPos.CENTER);
		grid.add(txHelp, 0, 1);

		Button btOK = new Button("Back");
		btOK.setPrefSize(80, 30);
		//btOK.setStyle("-fx-background-color:#FFCCCC");
		//btOK.setStyle("-fx-border-color: rgb(49, 89, 23);");
		
		btOK.setStyle("-fx-background-color:#FFCCCC;\n" + " -fx-border-color: rgb(49, 89, 23);"
				+ "\n" + "-fx-border-radius: 5.0;");
		
		btOK.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("");
				alert.setHeaderText(null);
				alert.setContentText("Did you really understand? ");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					close();
					Stage a= new Stage();
					Stage MainC= new Main(a);
				}
			}

		});

		HBox hb = new HBox(10, btOK);
		GridPane.setConstraints(hb, 0, 2, 2, 1, HPos.RIGHT, VPos.CENTER);
		grid.add(hb, 0, 2);
		hb.setAlignment(Pos.CENTER_RIGHT);
		hb.setPadding(new Insets(15, 20, 10, 10));

		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color : #B0E2FF;\n");

		Scene scene = new Scene(grid, 650, 300);
		scene.getStylesheets().add("styleSheet.css");

		Image iconStage = new Image(getClass().getResourceAsStream("/asking.png"));
		this.getIcons().add(iconStage);
		this.setScene(scene);
		this.setTitle("Help");
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
					Stage MainC= new Main(a);

				} else {
					windowEvent.consume();
				}
			}

		});

	}

}
