package prg;
import java.io.*;
import java.util.*;

public class Usuario
{
	String code,name;
	
	public Usuario(String c, String n){
		code=c;
		name=n;				
	}
	 	
	public String getNombre(){
		return name;
	}

	public String getCodigo() {
		return code;
	}

	public boolean isDummie(){
		if(code.equals("dummie"))return true;
		else return false;

	}

} // Usuario
