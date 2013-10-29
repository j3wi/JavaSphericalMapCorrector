package es.mobdroid.javaSphericalMapCorrector.model;


import java.awt.*;
import java.awt.image.BufferedImage;

public class SphericalMapCorrection {

    final double twoPi = Math.PI * 2.0;
    int index;
    int imageHeight;
    int imageWith;
    double x2, phi, phi2, theta;
    BufferedImage imageIn;
    BufferedImage imageOut;
    Color[] colorBuffer;

    public void setImage(BufferedImage image){
    	this.imageIn = image;
    	imageHeight = image.getHeight();
    	imageWith = image.getWidth();
    	imageOut = new BufferedImage(imageWith,imageHeight, image.getType());
    	
    	colorBuffer = new Color[imageWith * imageHeight];
    }

    public void algorithm () {
        index = 0;
        for (int y = 0; y <= imageHeight -1; y++) {
            theta = Math.PI * ((double)y - (((double)imageHeight-1)/2.0)) / ((double)imageHeight-1);
            for (int x = 0; x <= imageWith-1; x++) {
                phi = twoPi * ((double)x - (double)imageWith/2.0) / (double) imageWith;
                phi2 = phi * Math.cos(theta);
                x2 = phi2 * imageWith / twoPi + imageWith / 2.0;

                if ((x2 < 0 ) || (x2 > imageWith-1)){
                    System.out.println("Error**********************************************************************");
                } else {
                    colorBuffer[index] = calculateColorForPosition(x2, y);;
                }

                index++;

            }
        }
        storeBufferInImageBuffer();
    }

    private Color calculateColorForPositionNoInterpolation(double x, int y){
        return new Color(imageIn.getRGB(round(x), y));
    }

    private Color calculateColorForPosition(double x2, int y) {
        int a = (int) Math.floor(x2);
        int b = (int) Math.ceil(x2);

        double diference = x2 - a;

        Color colorForA = new Color(imageIn.getRGB(a, y));
        Color colorForB = new Color(imageIn.getRGB(b, y));

        int red = (int) Math.round(colorForA.getRed()  + (colorForB.getRed() - colorForA.getRed())* diference);
        int green = (int) Math.round(colorForA.getGreen()  + (colorForB.getGreen() - colorForA.getGreen())* diference);
        int blue = (int) Math.round(colorForA.getBlue()  + (colorForB.getBlue() - colorForA.getBlue())* diference);

        Color finalColor = new Color(red, green, blue);

        return finalColor;
    }

    private void storeBufferInImageBuffer(){
        int index = 0;
        for (int y = 0; y <= imageHeight-1; y++) {
            for (int x = 0; x <= imageWith-1; x++){
                imageOut.setRGB(x, y, colorBuffer[index].getRGB());
                index++;
            }
        }
    }

    public BufferedImage getImage(){
        return imageOut;
    }

    private int round(double d){
        double dAbs = Math.abs(d);
        int i = (int) dAbs;
        double result = dAbs - (double) i;
        if(result<0.5){
            return d<0 ? -i : i;
        }else{
            return d<0 ? -(i+1) : i+1;
        }
    }
}
