package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String symbols = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft()1{}[]?-_+~i!lI;:,^";
        File file = new File("text.txt");
        file.createNewFile();
        BufferedImage image = ImageIO.read(new File(args[0]));
        FileWriter writer = new FileWriter("text.txt");

        for(int y = 0; y < image.getHeight();y+=1.5){
            for(int x = 0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x,y);
                int red =   (rgb & 0x00ff0000) >> 16;
                int green = (rgb & 0x0000ff00) >> 8;
                int blue =   rgb & 0x000000ff;

                int gray = (red + green + blue)/3;


                int stage = 255/symbols.length();
                int index = gray/stage;
                if(index > symbols.length()-1){
                    //System.out.println(gray + " " + stage);
                    writer.write(symbols.charAt(symbols.length()-1));
                }else{
                    writer.write(symbols.charAt(index));
                }
            }
            writer.write(System.getProperty( "line.separator" ));
        }
    }
}
