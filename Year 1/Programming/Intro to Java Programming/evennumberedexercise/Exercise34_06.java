import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Exercise34_06 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    
    Pane pane = new Pane();
    
    Ellipse ellipse = new Ellipse(100, 40, 150, 60);
    Circle c1 = new Circle(50, 25, 25);
    Circle c2 = new Circle(150, 25, 25);
    c1.setFill(Color.WHITE);
    c2.setFill(Color.WHITE);
    
    pane.getChildren().addAll(ellipse, c1, c2);
    pane.setTranslateX(60);
    pane.setTranslateY(40);
        
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("Exercise34_06"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
} 
