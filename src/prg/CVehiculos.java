package prg;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class CVehiculos
{
	Vehiculo [] vehiculos= new Vehiculo[100];
	int elements = 0;

	
	public CVehiculos(){
		try {
			Scanner in = new Scanner(new FileReader("vehiculos.txt"));
			boolean brand=true;

			for(int i=0;in.hasNextLine();i++){
							
				String s = in.nextLine();
				

				//teniendo en cuenta que el codigo tiene 3 caracteres, como mucho habr? 6 car?cteres en una linea que no est? declarando el modelo/marca que si tendr?a m?s
				if(s.length()>6){
					String[] matr=s.split(" ", 3);
					vehiculos[i]=new Vehiculo (matr[0],matr[1],matr[2]);
					brand=true;
					elements++;
				}
				else{
					if(brand){
						i--;
						brand=false;
						//"s" en este caso es el n?mero de reservas totales
					}else{//"s" en este caso es una reserva concreta
						i--;
						CUsuarios users=new CUsuarios();
						String [] matr=s.split(" ");
						vehiculos[i].reservar(Integer.parseInt(matr[0]), users.buscar(matr[1]));


						
					}
				}
				
				
				}	
			in.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int numero(){
		return elements;
	}

	public void reservas(String codigo){

		for(int i=0;i<elements;i++){
			 vehiculos[i].amIReserved(codigo);

		}


	}

	public void reserveDay(int day){
		for(int i=0;i<elements;i++){
			if(vehiculos[i].checkDay(day).isDummie())
				JOptionPane.showMessageDialog(null,vehiculos[i].getMarca()+" "+vehiculos[i].getModelo()+" "+vehiculos[i].getMatricula()+" - Disponible!");
		}


		String matricula = JOptionPane.showInputDialog(null,"Dime la matricula del coche que quieras reservar");
		CUsuarios user= new CUsuarios();
		String codigo =JOptionPane.showInputDialog(null,"Dime el codigo de usuario de la reserva");
		if(buscar(matricula).checkDay(day).isDummie()){
			buscar(matricula).reservar(day,user.buscar(codigo));
			JOptionPane.showMessageDialog(null,"Reserva completada exitosamente!");
		}
		else JOptionPane.showMessageDialog(null,"Error al relaizar la reserva, porfavor compruebe los datos introducidos");


	}

	public Vehiculo get(int i){
		//Comprobamos que el numero introducido est? en nuestro rango de posibilidades
		if(i>-1 && i<=elements){
			return vehiculos[i];
		}
		//Si no es valido devuelve un null
		else return null;
	}
	
	public Vehiculo buscar(String matricula){
		for(int i=0; i<elements;i++){
			if(vehiculos[i].getMatricula().equals(matricula)){
				return vehiculos[i];}
		}
		return null;
	}
	
	public void guardar(){
		//bucle for llamando a cada vehiculo para que se garde
		for(int i=0;i<elements;i++){
			vehiculos[i].writeTo();
		}
	}

} // CVehiculos
