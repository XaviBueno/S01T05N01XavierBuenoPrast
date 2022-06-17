package ex04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class ListDir {
	public static void main(String[] args) {
		String string;
		String dirName;
		boolean param;
		
			//Agafa paràmetre linea comandes entrada el nom del directori
			if (args.length==0) {
				//Si no s'introdueix res llista el directori actual
				//dirName=".";
				dirName="proves /s";
			}else
			
			
			dirName=getNameDir(args);
			param=getParam(string);
			File directori=new File(dirName);
			deleteFile( "salida.txt");
			listDir(directori,param,"salida.txt");
			System.out.println("Fi del llistat");
		}

	}
	
	static  void readFileTxt(String fileName) {
		String output;
		File file =new File(fileName);
		try {
			
			Scanner input= new Scanner(file);
			while(input.hasNextLine()) {
				output=input.nextLine();
				System.out.println(output);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("Arxiu no trobat");
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
	
	//Escriu una linea per pantalla o la desa en un arxiu
	//Si filename es null ho fa per pantalla si no amb un arxiu
	
	static void printDirLine(String fileName, String lineDir) {
			
		if(fileName.isEmpty()){
			System.out.println(lineDir);
		}else {
			try {
				
				FileWriter file=new FileWriter(fileName,true);
				file.write("");
				file.write(lineDir+'\n');
				file.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	static void deleteFile(String fileName) {
		File file =new File( fileName);
		if (file.exists());{
			file.delete();
		}
	}
	static void listDir(File directori,boolean param,String file ) {
		int i;
		String outString;
		
		try {	
			//instancia objecte file					
			File[] dir=directori.listFiles(); 
			if (dir!=null) { //Comproba que existeixi
				Arrays.sort(dir); //ordena
				for(i=0;i<dir.length;i++) {
					Date date=new Date(dir[i].lastModified());
					outString=dir[i].getName()+"  "+date;
					if(dir[i].isFile()) {
						outString+="   F";
					}
					else{
						outString+="  	D";
					}
					printDirLine(file, outString);
					if (param&&!dir[i].isFile()) {
						listDir(dir[i],param,file);
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
