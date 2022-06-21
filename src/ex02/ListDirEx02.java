package ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ListDirEx02 {

	public static void main(String[] args) {
		

		listDir(getArguments( args))	;
		
	
	}
	
	/*
	 * MÈTODE QUE LLISTA UN DIRECTORI
	 * POT FER-HO RECURSIVAMENT SI L'ATRIBUT listRecurs DE LA CLASSE Arguments es true
	 * 
	 */
	static void listDir(Arguments arguments) {
		int i;
		boolean param;
		
		
		param= arguments.getListRecurs();
		try {	
			//instancia objecte file					
			File[] dir=arguments.getFile().listFiles(); 
			if (dir!=null) { //Comproba que existeixi
				Arrays.sort(dir); //ordena
				for(i=0;i<dir.length;i++) {
					Date date=new Date(dir[i].lastModified());
					if(dir[i].isFile()) {
						System.out.println(dir[i].getName()+"  "+date+"  F");	
					}
					else {
						System.out.println(dir[i].getName()+"  "+date+"  D");
						if (param) {
							Arguments arg =new Arguments(dir[i],param);
							listDir(arg);
						}
					}
				}
			}
			else { 
				System.out.println("El directori no existeix"); 
			}
			
		}catch (Exception e) {
			e.getMessage();
		}

	}
	

	/*
	 *MÉTODE PER GESTIONAR ELS ARGUMENTS QUE VENEN PER LA LÍNEA DE COMANDES
	 * String [] args. Paràmetre d'entrada array de Strings que correspondria als paràmetres 
	 * rebuts per main
	 * Retorna un objecte de classe Arguments
	 */

	
	static Arguments getArguments(String [] args){
		String fileName=".";
		boolean recurs=false;
		int i;
		
	if (args.length ==0) fileName=".";
	else {
		for (i=0; i<args.length;++i) {
			switch(i) {
				case 0:
					if (args[0].equals("/s")) {
						recurs=true;
						fileName=".";
					}
					else {
						fileName=args[0];
					}
					break;
				case 1:
					if (args[1].equals("/s")) {
						recurs=true;
					}
					break;
				default:
				}
			}
		}
		File directori=new File(fileName);
		Arguments arguments =new Arguments(directori,recurs);
		return arguments;
	}
	
	
}


