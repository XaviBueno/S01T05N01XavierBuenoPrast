package ex01;
import java.io.File;
import java.util.Arrays;
public class ListDirEx01 {
	
	public static void main(String[] args) {
		String dirName;
		//Si no s'especifica directori llista l'actual
		if (args.length==0)
			dirName=".";
		else
			dirName=args[0];
		File directori= new File(dirName);
		listDir(directori);
		}
	
	static void listDir(File directori) {
		
		try {	
			//instancia objecte file					
			File[] dir=directori.listFiles(); 
			if (dir!=null) { //Comproba que existeixi
				
				Arrays.sort(dir); //ordena
				for(File arxius: dir) {  //llists
					System.out.println(arxius);
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
