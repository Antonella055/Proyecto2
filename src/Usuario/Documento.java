/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import Estructuras.ArrayList;
import static MonticuloBinario.Monticulo.selectedFile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonella
 */
public class Documento {
      private String nombreDocumento;
       private int tiempoAlterado;

    public Documento(String nombreDocumento, int tiempoAlterado) {
        this.nombreDocumento = nombreDocumento;
        this.tiempoAlterado = tiempoAlterado;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public int getTiempoAlterado() {
        return tiempoAlterado;
    }

    public void setTiempoAlterado(int tiempoAlterado) {
        this.tiempoAlterado = tiempoAlterado;
    }

  
    
    public ArrayList<Documento> ValidarDoc_Usuario(Documento documento) throws FileNotFoundException, IOException{
        ArrayList<Documento> documentos = new ArrayList<>(new Object[0], 0);
        
        try (BufferedReader br= new BufferedReader(new FileReader(selectedFile))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String usuario = data[0];
                String prioridad = data[1];
        
                // Leer el segundo archivo CSV que contiene la información de los documentos
                try (BufferedReader brDocumentos = new BufferedReader(new FileReader("documentoUsuario.csv"))) {
                    String lineaDocumento;
                    while ((lineaDocumento = brDocumentos.readLine()) != null) {
                        String[] datosDocumento = lineaDocumento.split(",");
                        String usuarioDocumento = datosDocumento[0];
                        String nombreDoc = datosDocumento[1];
                        String tipoDocumento = datosDocumento[3];
                        
                         //validacion de coincidencia con los datos
                           if (usuario.equals(usuarioDocumento)){
                                 try (BufferedReader b = new BufferedReader(new FileReader("documentoCola.csv"))) {
                                        String lineaCola;
                                        while ((lineaCola = b.readLine()) != null) {
                                            String[] datosDoc= lineaCola.split(",");
                                            String nombreImpresion= datosDoc[0];
                                            String prioridadImpresion=datosDoc[1];
                                            String tiempoImpresion=datosDoc[2];
                                            
                                            if (nombreDoc.equals(nombreImpresion)){
                                                 
                                                AlterarEtiqueta(prioridad,prioridadImpresion,tiempoImpresion);
                                                documento.setNombreDocumento(nombreDoc);
                                                Documento doc= new Documento(nombreDoc+"."+tipoDocumento, getTiempoAlterado());
                                                documentos.add(doc);
                                            
                                            }}
                } catch (IOException e) {
            System.out.println("Error al leer el archivo archivoDocumentos.csv");
        }}  
    }
                    }catch (IOException e){
                        JOptionPane.showMessageDialog(null, "No hay registros en cola", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }return documentos;
    }

    public String AlterarEtiqueta(String prioridadUsuario,String prioridadDoc, String tiempoImpresion){
        
        while (prioridadDoc.equals("Prioritario")){
            
              switch (prioridadUsuario) {
                    //asignarle un valor numerico dependiendo de la prioridad del usuario
                        case "prioridad_baja":
                            restarTiempo(tiempoImpresion,5);
                            break;
                        case "prioridad_media": //10 segundos 
                            restarTiempo(tiempoImpresion,10);
                            break;
                        case "prioridad_alta": 
                            restarTiempo(tiempoImpresion,15);
                            break;
              }
              break;
        }
            restarTiempo(tiempoImpresion, 00);
        
        return tiempoImpresion;

    }
        
        
    
    public int restarTiempo(String tiempoactual, int segundosDism){
        // Separar en horas, minutos, segundos y milisegundos
            String[] partes = tiempoactual.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);
            int milisegundos = Integer.parseInt(partes[3]);
            
             // Convertir todo a milisegundos
            int tiempoTotal = (horas * 3600 + minutos * 60 + segundos) * 1000 + milisegundos;

            // Restar los segundos a restar en milisegundos
            tiempoTotal -= segundosDism * 1000;

            // Convertir el tiempo total de vuelta a horas, minutos, segundos y milisegundos
            horas = tiempoTotal / 3600000;
            minutos = (tiempoTotal % 3600000) / 60000;
            segundos = (tiempoTotal % 60000) / 1000;
            milisegundos = tiempoTotal % 1000;

            // Formatear el tiempo resultante
            String tiempoRestado = String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milisegundos);

            // Imprimir el tiempo restado
            System.out.println(tiempoRestado);
            setTiempoAlterado(tiempoTotal);
            return tiempoTotal;
        }

    }



    
    
    
                          
