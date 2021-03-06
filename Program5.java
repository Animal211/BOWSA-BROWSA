/**
 * @TITLE Program5
 * @COURSE CS 1121 Introduction to Programming
 * @AUTHOR
 * @CREATED 
 * @DESCRIPTION 
 */

/**
 * MODIFICATION HISTORY
 * @CREATED
 * @UPDATED
 */

// IMPORTS
// These are some classes that may be useful for completing the project.
// You may have to add others.
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.concurrent.Worker.State;
import javafx.concurrent.Worker;

import java.io.*;

import sun.audio.*;

/**
 * The main class for Program5. Program5 constructs the JavaFX window and
 * handles interactions with the dynamic components contained therein.
 */
public class Program5 extends Application {
	// INSTANCE VARIABLES
	// These variables are included to get you started.
	private Stage mystage = null;
	private WebView browser = null;
	private WebEngine webEngine = null;
	private TextField statusbar = null;

	// HELPER METHODS
	/**
	 * Retrieves the value of a command line argument specified by the index.
	 * 
	 * @param index - position of the argument in the args list.
	 * @return The value of the command line argument.
	 */
	private String getParameter( int index ) {
		Parameters params = getParameters();
		List<String> parameters = params.getRaw();
		return !parameters.isEmpty() ? parameters.get(0) : "";
	}

	/**
	 * Creates a WebView which handles mouse and some keyboard events, and 
	 * manages scrolling automatically, so there's no need to put it into a ScrollPane.
	 * The associated WebEngine is created automatically at construction time.
	 * 
	 * @return browser - a WebView container for the WebEngine. 
	 */
	private WebView makeHtmlBrowser( ) {
		browser = new WebView();
		webEngine = browser.getEngine();
		return browser;
	}
	
	/**
	 * Generates the status bar layout and text field.
	 * 
	 * @return statusbarPane - the HBox layout that contains the statusbar.
	 */
	private HBox makeStatusBar( ) {
		HBox statusbarPane = new HBox();
		statusbarPane.setPadding(new Insets(5, 4, 5, 4));
		statusbarPane.setSpacing(10);
		statusbarPane.setStyle("-fx-background-color: #336699;");
		statusbar = new TextField();
		HBox.setHgrow(statusbar, Priority.ALWAYS);
		statusbarPane.getChildren().addAll(statusbar);
		return statusbarPane;
	}

	// REQUIRED METHODS
	/**
	 * The main entry point for all JavaFX applications. The start method is
	 * called after the init method has returned, and after the system is ready
	 * for the application to begin running.
	 * 
	 * NOTE: This method is called on the JavaFX Application Thread.
	 * 
	 * @param primaryStage - the primary stage for this application, onto which 
	 * the application scene can be set. 
	 */
	@Override
	public void start(Stage stage) {
		// Build your window here.
		try {
			MARIO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stage.setTitle("BROWSA");
        Button btn = new Button();
        Button btn2 = new Button();
        btn.setText("Google Search");
        btn2.setText("I'm feeling lucky");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                System.out.println("No");
            }
        });
        
        
        StackPane bar = new StackPane();
        StackPane pages = new StackPane();
        
        
        
        
        
        bar.getChildren().add(btn);
        bar.getChildren().add(btn2);
        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load("http://www.google.com");
        bar.getChildren().add(view);
        //stage.setScene(new Scene(root, 100, 500));
        stage.setScene(new Scene(bar, 500, 100));
        //stage.setScene(new Scene(pages, 300, 500));
        // apply CSS style
        // show stage
        stage.show();
	}

	/**
	 * The main( ) method is ignored in JavaFX applications.
	 * main( ) serves only as fallback in case the application is launched
	 * as a regular Java application, e.g., in IDEs with limited FX
	 * support.
	 *
	 * @param args the command line arguments
	 */
	
	/*public static void topPane() {
		 HBox top = new HBox();
		 Button bOne = new Button("Button One");
		 Button bTwo = new Button("Button Two");
		 Button bThree = new Button("Button Three");
		 top.getChildren().addAll(bOne,bTwo,bThree);
		 top.setBorder(Border.EMPTY);
		 border.setTop(top);
		 top.setStyle(borderBox);
		 top.setPadding(new Insets(10, 5, 10, 5));
		 
		 }
		 */
	public void MARIO() throws Exception{
		String gongFile = "http:/66.90.91.26/ost/super-mario-3d-world-soundtrack/vslnsgania/bowser-battle-castle-1.mp3";
	    InputStream in = new FileInputStream(gongFile);
	 
	    // create an audiostream from the inputstream
	    AudioStream audioStream = new AudioStream(in);
	 
	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}