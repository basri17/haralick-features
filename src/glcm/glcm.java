/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glcm;

/**
 *
 * @author mangadul
 */

// package de.lmu.dbs.ifi.jfeaturelib.examples;

import de.lmu.ifi.dbs.jfeaturelib.features.Haralick;
import de.lmu.ifi.dbs.utilities.Arrays2;
import ij.process.ColorProcessor;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * This is is a very basic Class that demonstrates the usage of a descriptor
 * with plain Java without the commandline exctractor.
 *
 * @author Franz
 */
public class glcm {
    float[] convertToFloat;

    public static void main(String[] args) throws IOException, URISyntaxException {
        // load the image
        //System.out.println(glcm.class.getResource("/test.jpg").toString());
        DB ndb = new DB();
        int a;
        try {
            String floc = "D:\\kerjaan\\khaeruddin\\jfeaturelib.demo\\src\\main\\resources\\test.jpg";
            File f = new File(floc);
            ColorProcessor image = new ColorProcessor(ImageIO.read(f));                
            // initialize the descriptor
            Haralick descriptor = new Haralick();
            // run the descriptor and extract the features
            descriptor.run(image);
            // obtain the features
            List<double[]> features = descriptor.getFeatures();            
            /*
            double[] target = new double[features.size()];
            for (int i = 0; i < target.length; i++) {
               target[i] = features.get(i);
            } 
            */
            String desc = descriptor.getDescription();
            String[] lines = desc.toString().split(", ");
            for(String s: lines){
                System.out.println("Content = " + s);
            }            
            // print the features to system out
            features.stream().forEach((double[] feature) -> {                      
                float[] arr = Arrays2.convertToFloat(feature);
                System.out.println(Arrays2.join(feature, ", ", "%.5f"));
                /*Arrays2.join(feature, ", ", "%.5f")*/    
                // System.out.println(Arrays.toString(desc.split(",")) +" -- "+ Arrays.toString(feature));
            });            
        } catch (IOException e) {
            System.out.println(e.getMessage() + " :: "+ Arrays.toString(e.getStackTrace()));
        }
    }
        
}