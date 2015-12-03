/**
 * @TITLE Program5
 * @COURSE CS 1121 Introduction to Programming
 * @AUTHOR Alex Eschenauer
 * @CREATED 12/3/2015
 * @DESCRIPTION For Our Group
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
import javafx.scene.control.ToolBar;
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

import com.sun.corba.se.impl.orbutil.graph.Node;

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
	
	private String getParameter( int index ) {
		Parameters params = getParameters();
		List<String> parameters = params.getRaw();
		return !parameters.isEmpty() ? parameters.get(0) : "";
	}

	
	private WebView makeHtmlBrowser( ) {
		browser = new WebView();
		webEngine = browser.getEngine();
		return browser;
	}
	
	
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

	
	@Override
	public void start(Stage stage) {
		stage.setTitle("BOWSA BROWSA");
		
		
        Button btn = new Button();
        Button btn2 = new Button();      
        btn.setText("Button2 Text");
        btn2.setText("Button2 Text");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
                System.out.println("No");
            }
        });
        
        
        
        StackPane bar = new StackPane();
        
        
        bar.getChildren().add(btn);
        bar.getChildren().add(btn2);
                
        
        WebView view = makeHtmlBrowser();
        WebEngine engine = view.getEngine();
        engine.load("http://www.google.com");
        bar.getChildren().add(view);
        stage.setScene(new Scene(bar, 500, 100));
        makeStatusBar( );
        stage.show();
        
        
	}

	

	
	
	public static void main(String[] args) {
		launch(args);
	}
}