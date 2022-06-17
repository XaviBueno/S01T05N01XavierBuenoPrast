package ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Date;



public class ListDir {
	public static void main(String[] args) {
		String string;
		String dirName;
		boolean param;
		try {
			//Agafa paràmetre linea comandes entrada el nom del directori
			 string= args[0];
			//Si no s'introdueix res llista el directori actual
		}catch(ArrayIndexOutOfBoundsException e1){ 
			//dirName=".";
			
			string="proves /s";
			dirName=getNameDir(string);
			param=getParam(string);
			File directori=new File(dirName);
			listDir(directori,param);
		}

	}
	
	static String getNameDir(String cadena) {
		String nameDir=cadena;
		
		nameDir=cadena.substring(0,cadena.indexOf('/')).trim();
		
		return nameDir;
		
	}
	static boolean getParam(String cadena) {
		
		
		return cadena.charAt(cadena.indexOf('/')+1)=='s';
	}
	
	static void listDir(File directori,boolean param) {
		int i;
		
		try {	
			//instancia objecte file					
			File[] dir=directori.listFiles(); 
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
							listDir(dir[i],param);
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
	
	
		
}
