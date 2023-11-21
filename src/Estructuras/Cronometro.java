/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JLabel;

/**
 *
 * @author Antonella
 */
public class Cronometro {
    boolean cronometroActivo;
    JLabel tiempo;
    Thread hilo;
    
    public Cronometro(JLabel tiempo){
        this.tiempo= tiempo;
    }
    
    public void run() throws InterruptedException{
        Integer minutos=0, segundos=0,milesimas=0;
        String min="",seg="",mil="";
        
        try{
            while (cronometroActivo){
                Thread.sleep(4);
                milesimas +=4;
                
                //cuando las mil llega a mil los seg aumentan a 1 y las mil vuelven a cero
                if (milesimas ==1000){ 
                    milesimas=0;
                    segundos +=1;
                    
                    //cuando los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos pasan a 0
                    if(segundos==60){
                        segundos=0;
                        minutos++;
                    }
                }
                //formato 00:00:000
                if (minutos<10) min="0"+minutos;
                else min=minutos.toString();
                if (segundos <10) seg="0"+segundos;
                else seg=segundos.toString();
                if(milesimas <10) mil= "00"+milesimas;
                else if (milesimas <100) mil="0"+milesimas;
                else mil= milesimas.toString();
                
                 if (tiempo != null) {
                    tiempo.setText(min+":"+seg+":"+mil);
                }
            }
        }catch (Exception e){}
    }
    
    public void iniciarCronometro(){
        cronometroActivo= true;
        hilo=new Thread( (Runnable) this);
        hilo.start();
    }
    
    public void pararCronometro(){
        cronometroActivo=false;
    }
}
