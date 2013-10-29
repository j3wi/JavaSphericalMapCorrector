package es.mobdroid.javaSphericalMapCorrector.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

public class Picture {

	private BufferedImage mapImage;
	private int[] mapPixels;

    public Picture(String filename) {
    	mapImage = null;
        try {
            // Load image from file: 
            mapImage = ImageIO.read(new File(filename));
            loadMapPixels();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMapPixels() {
        int w = mapImage.getWidth();
        int h = mapImage.getHeight();
        mapPixels = new int[w * h];
        PixelGrabber pg = new PixelGrabber(mapImage, 0, 0, w, h, mapPixels, 0, w);
        try {
            // Puts the image pixels into the given mapPixels-Array. 
            pg.grabPixels();
        } catch (InterruptedException e) {
            System.err.println("interrupted waiting for pixels!");
            return;
        }
        if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
            System.err.println("image fetch aborted or errored");
            return;
        }
    }
    
    public int getPixel(int x, int y) {
        int w = mapImage.getWidth();
        int pixel = mapPixels[y * w + x];
        return pixel;
    }
    
    public int getWidth() {
        return mapImage.getWidth();
    }

    public int getHeight() {
        return mapImage.getHeight();
    }

    public BufferedImage getImage() {
        return mapImage;
    }
}
