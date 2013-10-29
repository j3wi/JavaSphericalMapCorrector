package es.mobdroid.javaSphericalMapCorrector.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import es.mobdroid.javaSphericalMapCorrector.model.Picture;
import es.mobdroid.javaSphericalMapCorrector.model.SphericalMapCorrection;
import es.mobdroid.javaSphericalMapCorrector.utils.ImageUtils;
import es.mobdroid.javaSphericalMapCorrector.view.View;

public class Controller implements MouseListener{

	View view;
	private SphericalMapCorrection sphericalMapCorrector;
	
	public Controller(){
		this.sphericalMapCorrector = new SphericalMapCorrection();
	}
	public void setView(View view) {
		this.view = view;
	}
	
	public void openImage(String fileName){
		Picture picture = new Picture(fileName);
		view.setOriginalImage(picture.getImage());
		sphericalMapCorrector.setImage(picture.getImage());
		processImage();
	}
	
	private void processImage() {
		sphericalMapCorrector.algorithm();
		view.setProcessedImage(sphericalMapCorrector.getImage());
	}
	
	public BufferedImage getProcesedImage(){
		return sphericalMapCorrector.getImage();
	}
	
	public void saveImage(String filename) {
		ImageUtils.saveImage(filename, sphericalMapCorrector.getImage());
	}

	/********************************************
	 *            MOUSE LISTENER                * 
	 ********************************************/

	public void mousePressed(MouseEvent me) {
		view.showOriginalImage();
    }

    public void mouseReleased(MouseEvent me) {
    	view.showProcessedImage();
    }
    
    public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}
}
