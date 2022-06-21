package ex04;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class ListDirEx04 {
	public static void main(String[] args) {
		
		
		Arguments arguments= getArguments(args);
		
		//Si hi ha l'oció de llegir un arxiu només admet aquesta opció
		if(arguments.getFileTxtToRead()){
			readFileTxt(arguments.getFileNameToRead());
		}
		else {
			if (arguments.getDirToFile()) {
				//si hi ha un arxiu de sortida	per tal de que no creixi indefinidament
				deleteFile(arguments.getFileOut());
			}
			listDir(arguments);
		}
		
		
	}
	
	/*
	 * MÈTODE QUE LLISTA UN DIRECTORI
	 * LLista recursivaments siistRecurs de la classe Arguments es true
	 * LLista el resultat a un arxiu txt si dirTo File de la classe Arguments es true
	 * fileOut de la classe ha de contenit el nom de l'arxiu
	 */
	static void listDir(Arguments arguments ) {
		int i;
		String outString;
		boolean recurs= arguments.getListRecurs();
		boolean listToFile=arguments.getDirToFile();
		String fileListOut=arguments.getFileOut();
		
		try {	
			//instancia objecte file					
			File[] dir=arguments.getFile().listFiles(); 
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
					
					printDirLine(arguments.getFileOut(), outString);
					if (recurs&&!dir[i].isFile()) {
						Arguments arg =new Arguments(dir[i],recurs,listToFile,fileListOut,false,"");
						listDir(arg);
					}
				}
			}
			else { 
				System.out.println("El directori o l'arxiu no existeix"); 
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

	/*
	 *MÉTODE PER GESTIONAR ELS ARGUMENTS QUE VENEN PER LA LÍNEA DE COMANDES
	 * String [] args. Paràmetre d'entrada array de Strings que correspondria als paràmetres 
	 * rebuts per main
	 * Comprova  si s'han passat els arguments /s, llistar recursivament, o /f llistar a un arxiu
	 * Comprova  si s'han passat els arguments /r, llegir arxiu txt i el nom de l'arxiu a llegir
	 * També comprova el nom del directori a llistar
	 *  Retorna un objecte de classe Arguments
	 */
		static Arguments getArguments(String [] args){
			String fileName=".";
			boolean recursive=false;
			boolean dirToFile=false;
			String fileOut="";
			boolean fileToReadTxt=false;
			String fileNameToRead="";
			int i;
			
				
			if(args.length!=0) {
				for(i=0;i<args.length;++i) {
					switch (args[i]) {
						case "/s":
							recursive=true;
							break;
						case "/f":
							if(i<args.length-1) {
								if((args[i+1]).contains(".txt")) {
									dirToFile=true;
									fileOut=args[i+1];
									++i;
								}
							}
							break;
						case "/r":
							if(i<args.length-1) {
								if((args[i+1]).contains(".txt")) {
									fileToReadTxt=true;
									fileNameToRead=args[i+1];
									++i;
								}
							}
						
						default:
							 fileName=args[i];
							
					}
				}
			}
			File directori=new File(fileName);
			Arguments arguments =new Arguments(directori,recursive,
					dirToFile,fileOut,fileToReadTxt,fileNameToRead);
			return arguments;
		}
	
	/*
	 * MÈTODE PER LLEGIR UN ARXIU
	 * fileName, nom de l'arxiu a llegir
	 * Escriu làrxiu per la consola
	 */
		
	static void readFileTxt(String fileName) {
		try {
			File file=new File(fileName);
			Scanner input= new Scanner(file);
			while(input.hasNext()) {
				System.out.println(input.nextLine());
			}
			input.close();
		}catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
	

	/*
	 * MÈTODE QUE ESCRIU UNA LÍNEA
	 * Si filename es null ho fa per pantalla si no amb un arxiu
	 * 	
	 */
	
	static void printDirLine(String fileName , String lineDir) {
			
		if(fileName.length()==0){
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
	
	/*
	 * ESBORRA UN ARXIU
	 */
	
	static void deleteFile(String fileName) {
		File file =new File( fileName);
		if (file.exists());{
			file.delete();
		}
	}
	
}
