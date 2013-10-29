package es.mobdroid.javaSphericalMapCorrector;

import es.mobdroid.javaSphericalMapCorrector.controller.Controller;
import es.mobdroid.javaSphericalMapCorrector.view.Menu;
import es.mobdroid.javaSphericalMapCorrector.view.View;

/**
 * Hello world!
 *
 */
public class App 
{
	static View view;
	static Menu menu = new Menu();
	static Controller controller = new Controller();
	
    public static void main( String[] args ) {
    	startView();
    }

	private static void startView() {
		view = new View();
		view.setJMenuBar(menu);
		menu.setController(controller);
		controller.setView(view);
		view.setVisible(true);
		view.addMouseListener(controller);
	}
}
