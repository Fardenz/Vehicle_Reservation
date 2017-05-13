package prg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class CUsuarios
{
	Usuario [] users= new Usuario [100];
	int elements=0;
	
	public CUsuarios(){
		try {
			Scanner in = new Scanner(new FileReader("usuarios.txt"));
			
			for(int i=0;in.hasNextLine();i++){
				String line = in.nextLine();
				users[i]=new Usuario(line.substring(0,3),line.substring(4));
				elements++;
										//Debuging 2m.out.println(s.substring(0,3)+","+s.substring(4));
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Usuario buscar(String codigo){
		for(int i=0; i<elements;i++){
			if(users[i].getCodigo().equals(codigo)){
				return users[i];}
		}
		return null;
	}
	
	public Usuario get(int i){
		//Comprobamos que el numero introducido esta en nuestro rango de posibilidades
		if(i>0 && i<=elements){
			return users[i-1];
		}
		//Si no es valido devuelve un null
		else return null;
	}
	
	public int numero(){
		return elements;
	}
} // CUsuarios
