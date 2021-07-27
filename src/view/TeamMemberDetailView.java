package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.TeamMember;

public class TeamMemberDetailView extends Stage{

			public TeamMemberDetailView(TeamMember teamMember) {

				GridPane grid = new GridPane();
				grid.setHgap(12);
				grid.setVgap(12);
				grid.setPadding(new Insets(12, 10, 15, 10));
				grid.setStyle("-fx-background-color : #B0E2FF;\n");


				Label memberDetail = new Label("Team Member Detail");
				memberDetail.setTextFill(Color.DARKRED);
				memberDetail.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
				memberDetail.setAlignment(Pos.CENTER);


				grid.add(memberDetail, 0, 0, 2, 1);

				Label lbID = new Label("ID");
				grid.add(lbID, 0, 1);


				TextField txID = new TextField(String.valueOf(teamMember.getId()));
				txID.setPrefWidth(230);
				grid.add(txID, 1, 1);
				txID.setFont(new Font("verdana", 12));


				
				Label lbLName = new Label("Last Name");
				grid.add(lbLName, 0, 2);

				TextField txLastName = new TextField(teamMember.getLastName());
				grid.add(txLastName, 1, 2);
				txLastName.setFont(new Font("verdana", 12));


				Label lbFName = new Label("First Name");
				grid.add(lbFName, 0, 3);

				TextField txFName = new TextField(teamMember.getFirstName());
				grid.add(txFName, 1, 3);
				
				
				Label lbDate = new Label("Date of birth");
				grid.add(lbDate, 0, 4);

				TextField txDate = new TextField(teamMember.getDateOfBirth());
				grid.add(txDate, 1, 4);
				
				Label lbEmail = new Label("Email");
				grid.add(lbEmail, 0, 5);

				TextField txEmail = new TextField(teamMember.getEmail());
				grid.add(txEmail, 1, 5);
				
				Label lbAddress = new Label("Address");
				grid.add(lbAddress, 0, 6);

				TextField txAddress = new TextField(teamMember.getAddress());
				grid.add(txAddress, 1, 6);
				
				Label lbPhone = new Label("Phone");
				grid.add(lbPhone, 0, 7);

				TextField txPhone = new TextField(teamMember.getPhone());
				grid.add(txPhone, 1, 7);
				
				Label lbGender = new Label("Gender");
				grid.add(lbGender, 0, 8);

				TextField txGender = new TextField(teamMember.getGender());
				grid.add(txGender, 1, 8);
				
				Scene scene = new Scene(grid);

				this.setTitle("Team Member Detail");
				this.setScene(scene);
			}
		}





