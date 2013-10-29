package es.mobdroid.javaSphericalMapCorrector.view;

import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class View extends JFrame {

	private BufferedImage originalImage;
	private BufferedImage processedImage;
	
	ImagePanel imagePanel;

	public View() {
		setLocation(200, 100);
		setSize(1150, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addMouseListener(MouseListener mouseListener) {
		System.out.println("Adding mouse listener");
    	super.addMouseListener(mouseListener);
    }

	public void setOriginalImage(BufferedImage image) {
		this.originalImage = image;
		showOriginalImage();
	}

	public void setProcessedImage(BufferedImage image) {
		this.processedImage = image;
		showProcessedImage();
	}

	public void showOriginalImage() {
		showImage(originalImage);
	}

	public void showProcessedImage() {
		showImage(processedImage);
	}
	
	public void showImage(BufferedImage image) {
		deletePanel();
		imagePanel = new ImagePanel(image);
		add(imagePanel);
		pack();
		repaint();
	}
	
	private void deletePanel(){
		if (imagePanel != null){
			remove(imagePanel);
		}
	}
	

}
