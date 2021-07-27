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
import model.Leader;

public class LeaderDetailView extends Stage{

			public LeaderDetailView(Leader leader) {

				GridPane grid = new GridPane();
				grid.setHgap(12);
				grid.setVgap(12);
				grid.setPadding(new Insets(12, 10, 15, 10));
				grid.setStyle("-fx-background-color : #B0E2FF;\n");


				Label leaderDetail = new Label("Leader Detail");
				leaderDetail.setFont(new Font("verdana", 23));
				leaderDetail.setTextFill(Color.DARKRED);
				leaderDetail.setFont(Font.font(null, FontWeight.BOLD, 23));
				grid.add(leaderDetail, 0, 0, 2, 1);
				leaderDetail.setAlignment(Pos.CENTER);

				Label lbID = new Label("ID");
				grid.add(lbID, 0, 1);
				lbID.setFont(new Font("verdana", 12));


				TextField txID = new TextField(String.valueOf(leader.getId()));
				txID.setPrefWidth(230);
				grid.add(txID, 1, 1);
				txID.setFont(new Font("verdana", 12));


				
				Label lbLName = new Label("Last Name");
				grid.add(lbLName, 0, 2);
				lbLName.setFont(new Font("verdana", 12));


				TextField txLastName = new TextField(leader.getLastName());
				grid.add(txLastName, 1, 2);
				txLastName.setFont(new Font("verdana", 12));

				Label lbFName = new Label("First Name");
				grid.add(lbFName, 0, 3);
				lbFName.setFont(new Font("verdana", 12));


				TextField txFName = new TextField(leader.getFirstName());
				grid.add(txFName, 1, 3);
				txFName.setFont(new Font("verdana", 12));

				
				Label lbDate = new Label("Date of birth");
				grid.add(lbDate, 0, 4);
				lbDate.setFont(new Font("verdana", 12));

				TextField txDate = new TextField(leader.getDateOfBirth());
				grid.add(txDate, 1, 4);
				txDate.setFont(new Font("verdana", 12));

				Label lbEmail = new Label("Email");
				grid.add(lbEmail, 0, 5);
				lbEmail.setFont(new Font("verdana", 12));


				TextField txEmail = new TextField(leader.getEmail());
				grid.add(txEmail, 1, 5);
				txEmail.setFont(new Font("verdana", 12));

				Label lbAddress = new Label("Address");
				grid.add(lbAddress, 0, 6);
				lbAddress.setFont(new Font("verdana", 12));


				TextField txAddress = new TextField(leader.getAddress());
				grid.add(txAddress, 1, 6);
				txAddress.setFont(new Font("verdana", 12));

				Label lbPhone = new Label("Phone");
				grid.add(lbPhone, 0, 7);
				lbPhone.setFont(new Font("verdana", 12));


				TextField txPhone = new TextField(leader.getPhone());
				grid.add(txPhone, 1, 7);
				txPhone.setFont(new Font("verdana", 12));

				Label lbGender = new Label("Gender");
				grid.add(lbGender, 0, 8);
				lbGender.setFont(new Font("verdana", 12));


				TextField txGender = new TextField(leader.getGender());
				grid.add(txGender, 1, 8);
				txGender.setFont(new Font("verdana", 12));

				Scene scene = new Scene(grid);

				this.setTitle("Leader Detail");
				this.setScene(scene);
			}
		}





