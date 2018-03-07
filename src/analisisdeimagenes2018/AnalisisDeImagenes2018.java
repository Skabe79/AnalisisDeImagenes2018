/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import filtrosespaciales.DispersionHistograma;
import filtrosespaciales.ExpansionHistograma;
import filtrosespaciales.FiltroEspacial;
import filtrosespaciales.UmbralAutomatico;
import gui.ImageJFrame;
import java.awt.Image;
import lectura.Grafica;
import lectura.HistogramaFrecuencias;
import lectura.ImageManager;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image aux = FiltroEspacial.generaEscalaGrises(ImageManager.openImage());
        ImageJFrame frame = new ImageJFrame(aux);
      
        // 3 histogramas 
        double hGrises []= HistogramaFrecuencias.calcularHistograma(1, aux);

          
        
        
        Image iEcu = DispersionHistograma.ecualizarHistograma(hGrises, aux);
        ImageJFrame frame2 = new ImageJFrame(iEcu);
       
        double hecu []= HistogramaFrecuencias.calcularHistograma(1,iEcu);

        
        
        Grafica grafica = new Grafica("Tono","Frecuencia","Frecuencias de Color");
        grafica.agregarSerie("Gris", hGrises);
        grafica.agregarSerie("Gris2", hecu);
        
        grafica.crearYmostrarGrafica();
//        int umbral = UmbralAutomatico.metodoIterativo(hGrises);
//       
//        Image bi = FiltroEspacial.umbralizacionSimple(umbral, aux);
//        ImageJFrame frame2 = new ImageJFrame(bi);
//        
        System.out.println();
    }
    
}
