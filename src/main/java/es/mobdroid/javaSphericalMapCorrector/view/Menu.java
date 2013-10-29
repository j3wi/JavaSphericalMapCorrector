package es.mobdroid.javaSphericalMapCorrector.view;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import es.mobdroid.javaSphericalMapCorrector.controller.Controller;

public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1L;
    private JMenu fileMenu = null;
    private JMenuItem openItem = null;
    private JMenuItem saveItem = null;
    private JMenuItem exitItem = null;
    private Controller controller;
    
    /**
     * Constructor de la clase
	 * 
	 * @return javax.swing.JMenuBar
	 */
	public Menu() {
		add(getFileMenu());
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * This method initializes MenuArchivo
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getOpenItem());
			fileMenu.add(getSaveItem());
			fileMenu.add(getExitItem());
		}
		return fileMenu;
	}
	
	private JMenuItem getOpenItem() {
		if (openItem == null) {
			openItem = new JMenuItem();
			openItem.setText("Open");
			openItem.setToolTipText("Open an image to process");
			openItem.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser openImage = new JFileChooser();
					openImage.setFileFilter(new FileNameExtensionFilter(
							"Image files", "png", "jpg", "PNG", "JPG", "JPEG",
							"jpeg"));
					int seleccion = openImage.showOpenDialog(openItem);
					if (seleccion == JFileChooser.APPROVE_OPTION) {
						controller.openImage(openImage.getSelectedFile()
								.toString());

					}

				}
			});
		}
		return openItem;
	}

	/*
	 * This method initializes MenuItemGuardarComo
	 * 
	 * @return javax.swing.JMenuItem
	 */

	private JMenuItem getSaveItem() {
		if (saveItem == null) {
			saveItem = new JMenuItem();
			saveItem.setText("Save Image");
			saveItem.setToolTipText("Save actual image as jpg");
			saveItem.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser saveImage = new JFileChooser();
					saveImage.setFileFilter(new FileNameExtensionFilter(
							"Image files", "jpg", "JPG", "JPEG", "jpeg"));
					int seleccion = saveImage.showSaveDialog(saveItem);
					if (seleccion == JFileChooser.APPROVE_OPTION) {
						controller.saveImage(saveImage.getSelectedFile() + ".jpg");
						
					}
				}
			});
		}
		return saveItem;
	}

	/**
	 * This method initializes MenuItemSalir
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitItem() {
		if (exitItem == null) {
			exitItem = new JMenuItem();
			exitItem.setText("Salir");
			exitItem.setToolTipText("Salir de la aplicación");
			exitItem.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitItem;
	}
}
