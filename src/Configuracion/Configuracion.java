package Configuracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Configuracion {

    private static HashMap<String, String> propiedades;

    public static void cargar() {
        propiedades = new HashMap<>();

        // Desde Script
        //String quitar = "Tarea1.jar!/Configuracion/Configuracion.class";
        //String path = Configuracion.class.getResource("/Configuracion/Configuracion.class").getPath().replaceAll(quitar, "conf/configuracion.properties").replaceAll("file:", "").replaceAll("/C:", "C:");
        // Desde NetBeans
        String quitar = "build/classes/Configuracion/Configuracion.class";
        String path = Configuracion.class.getResource("/Configuracion/Configuracion.class").getPath().replaceAll(quitar, "configuracion.properties");

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.isEmpty()) {
                    String[] l = linea.split("=");
                    propiedades.put(l[0], l[1]);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String get(String name) {
        return propiedades.get(name);
    }
}
