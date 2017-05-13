package prg;

import jdk.nashorn.internal.scripts.JO;

import java.util.Scanner;

import javax.swing.*;

public class Reservas
{

public static void main(String[] args)
{
	/*String [] MainOptions={"Usuarios","Vehiculos","Reservas","Salir"};
	JComboBox mainMenu = new JComboBox(MainOptions);
	mainMenu.setSelectedIndex(0);
	mainMenu.addActionListener(this); */


	CUsuarios users= new CUsuarios();
	CVehiculos vehicles= new CVehiculos();
	boolean exit=false;

while (!exit){

	switch(Integer.parseInt(JOptionPane.showInputDialog(null,"1Usuarios 2Vehiculos 3Reservas 4Salir"))){
	case 1:
	    String toPrint="";
		for(int i=1; i<users.numero();i++){
		    toPrint+="Codigo: "+users.get(i).getCodigo()+" Nombre: "+users.get(i).getNombre()+"\n";
			}
        JOptionPane.showMessageDialog(null,toPrint);
		break;
	case 2:
		for(int i=1; i<vehicles.numero();i++){
			JOptionPane.showMessageDialog(null,"Marca: "+vehicles.get(i).getMarca()+" Modelo: "+vehicles.get(i).getModelo()+" Matricula: "+vehicles.get(i).getMatricula());}

		break;
	case 3:
	    boolean noExit=true;
        while(noExit){
            //JOptionPane.showInputDialog("1 Todas las reservas 2 Reservas de usuarios 3 Reservas de un vehiculo 4 Reservar 5 Cancelar 0 Salir");
            noExit=menuReservas(vehicles);
        }

        }
		}}




	public static boolean menuReservas(CVehiculos vehicles){
        //System.out.println("1 Todas las reservas 2 Reservas de usuarios 3 Reservas de un vehiculo 4 Reservar 5 Cancelar 0 Salir");
        //Scanner keyb2 = new Scanner(System.in);
       // JOptionPane.showInputDialog("1 Todas las reservas 2 Reservas de usuarios 3 Reservas de un vehiculo 4 Reservar 5 Cancelar 0 Salir");
        String option= JOptionPane.showInputDialog("1 Todas las reservas 2 Reservas de usuarios 3 Reservas de un vehiculo 4 Reservar 5 Cancelar 0 Salir");
        switch (Integer.parseInt(option)) {

            case 1:
                //for recorriendo todos los coches

                for (int j = 0; j < vehicles.numero(); j++) {
                    //comprobamos si el coche en el que estamos tiene reservas
                    //System.out.println(j+" "+vehicles.numero()+" "+vehicles.get(j).getReservas());
                    if (vehicles.get(j).getReservas() > 0) {
                        for (int i = 0; i < 31; i++) {
                            if (!vehicles.get(j).checkDay(i).isDummie())
                               JOptionPane.showMessageDialog(null,vehicles.get(j).getMarca() + " " + vehicles.get(j).getModelo() + "\n------------------------------\n User: " + vehicles.get(j).checkDay(i).getNombre() + "\n Code: " + vehicles.get(j).checkDay(i).getCodigo() + "\n Day: " + (i + 1) + "\n------------------------------");
                        }
                    }
                    //System.out.println("Marca: "+vehicles.get(j).getMarca()+" Modelo: "+vehicles.get(j).getModelo()+" Matricula: "+vehicles.get(j).getMatricula()+"\nDia:"+"Codigo de usuarios: ");}
                }
                return true;
            case 2:
                //Tengo un codigo y busco reservas del usuario de todos los coches y dias
                vehicles.reservas(JOptionPane.showInputDialog(null,"Dame un codigo de usuario"));
                return true;
            case 3:
                // Nos dan una matricula y mostramos datos de vehiculo + dias y usuarios de sus reservas
                String matricula = JOptionPane.showInputDialog("Dime una matricula");
                Vehiculo vehicle = vehicles.buscar(matricula);
                vehicle.printReservas();
               /*try {

               }catch (exeption e){
                   JOptionPane.showMessageDialog(null, "Matricula no valida");
               }*/
                return true;
            case 4:
                vehicles.reserveDay(Integer.parseInt(JOptionPane.showInputDialog(null,"Dime un dia para reservar")));
                return true;
            case 5:
                String user = JOptionPane.showInputDialog(null, "Dime el codigo de reservas a consultar");
                vehicles.reservas(user);
                JOptionPane.showMessageDialog(null,"Qué dia quieres cancelar la reserva?");
                return true;
            case 0:
                return false;

            default:
                return true;
    }


}}

// Empresa
