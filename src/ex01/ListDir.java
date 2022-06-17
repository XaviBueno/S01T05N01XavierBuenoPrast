package ex01;
import java.io.File;
import java.util.Arrays;
public class ListDir {
	
	public static void main(String[] args) {
		String dirName;
		
		try {
			//Agafa paràmetre linea comandes entrada el nom del directori
			 dirName= args[0];
			//Si no s'introdueix res llista el directori actual
		}catch(ArrayIndexOutOfBoundsException e1){ 
			dirName=".";
		}
		
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
