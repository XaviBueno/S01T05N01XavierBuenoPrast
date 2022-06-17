package ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ListDirEx02 {

	public static void main(String[] args) {
		String string;
		String dirName;
		boolean param;
		
			
			dirName=args[0];
			dirName=getNameDir(string);
			param=getParam(string);
			File directori=new File(dirName);
		//	listDir(args);
		}


	
	static String getNameDir(String cadena) {
		String nameDir=cadena;
		
		nameDir=cadena.substring(0,cadena.indexOf('/')).trim();
		
		return nameDir;
		
	}
	static boolean getParam(String cadena) {
		
		
		return cadena.charAt(cadena.indexOf('/')+1)=='s';
	}
	/*
	//FUNCIO NOVA
	if (args.length ==0) args[0]=".";
	else {
		for (i=0; i<args.length;++i) {
			switch(i) {
				case 0:
					if (args[0]=="/s") {
						param=true;
						File directori=new File(".");
					}
					else {
						File directori=new File(args[0]);
					}
					break;
				case 1:
					if (args[0]=="/s") {
						param=true;
						
					}
			}
		}*/
	
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
	
	
}


