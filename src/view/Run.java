
package view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application {
	
	
	
	

public static void main(String[] args) {
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	// TODO Auto-generated method stub
	Stage run =new Main(primaryStage);
	run.show();
	
	
}

}
