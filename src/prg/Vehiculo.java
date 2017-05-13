package prg;

import java.io.*;
import javax.swing.*;

public class Vehiculo
{
	private String regNum,brand,model;
	private	Usuario [] reservations = new Usuario [31];
	private int reservas=0;
	Usuario dummie = new Usuario("dummie","dummie");

	public Vehiculo(String matricula,String marca,String modelo){
	
		/*FileInputStream inputStream = new FileInputStream("foo.txt");
		try {
			String everything = sun.misc.IOUtils.readFully(inputStream, -1,false);
		    String everything = IOUtils.toString(inputStream);
		} finally {
		    inputStream.close();
		}*/	
		regNum=matricula;
		brand=marca;
		model=modelo;

		for(int i=0; i<31;i++){reservations[i]=dummie;
        }}
	/*public String [] reservas(){
		if(reservas!=0) return reservations[];
	}*/

	public boolean eliminarReserva(int day,Usuario user){

		if(!reservations[day-1].isDummie()){
			reservations[day-1]=dummie;
			reservas--;
			return true;}
		else return false;
	}

	public boolean reservar(int day,Usuario user){

        if(reservations[day-1].isDummie()){
			reservations[day-1]=user;
            reservas++;
			return true;}
		else return false;
	}

	public String getMatricula() {
		
		return regNum;
	}

	public void amIReserved(String codigo){

		for(int i=0;i<31;i++){
			if(reservations[i].getCodigo().equals(codigo)){
				JOptionPane.showMessageDialog(null,codigo+" Ha reservado un "+brand+" "+model+" Con matricula: '"+regNum+"' el dia "+(i+1));

				}
		}

	}

	public void printReservas(){
	    String toPrint="";
		for(int i=0; i<31;i++){
			// if not dummie print
			if(!reservations[i].isDummie()){
			    toPrint+=reservations[i].getNombre()+" ("+reservations[i].getCodigo()+") Day:"+(i+1)+"\n";
			}
		}
		if(!toPrint.equals("")){
        JOptionPane.showMessageDialog(null,(getMarca() + " " + getModelo() + "\n------------------------------------\n"+toPrint));}
        else{
        JOptionPane.showMessageDialog(null,(getMarca() + " " + getModelo() + "\n------------------------------------\nNo tiene niguna reserva"));}

	}


	public String getMarca(){
		return brand;
	}	
	public String getModelo(){
		return model;
	}
	public Usuario checkDay(int day){return reservations[day];}
	public int getReservas(){return reservas;}

	public void writeTo(){
		//assuming that the file already exists, we write all the data needed
		try{
		    PrintWriter writer = new PrintWriter("vehiculos_1.txt", "UTF-8");
		    writer.println(regNum+" "+brand+" "+model);
		    writer.println(reservas);
		    for(int i=0;i<31;i++){
		    	if(reservations[i]!=null){
		    		writer.println((i+1)+" "+reservations[i]);
		    	}
		    }
		    writer.close();
		} catch (IOException e) {
		   JOptionPane.showMessageDialog(null,"error In writing "+regNum+" To a file");
		}
		
	}
} // Vehiculo
