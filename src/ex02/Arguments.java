/*
 * CLASSE ARGUMENTS
 * Classe per passar arguments
 * file: atribut que indica  el directori a llistar
 * listRecurs: atribut que indica llistar els subdirectoris
 */
package ex02;
import java.io.File;
public class Arguments {
	//Atributs
	private File file;
	private boolean listRecurs;
	

	//Constructor
	
	public Arguments(File file, boolean listRecurs ) {
		this.file =file;
		this.listRecurs= listRecurs;
	
	}
	
	//Getters
	
	public File getFile() {
		return file;
		
	}
	
	public boolean getListRecurs() {
		return listRecurs;
	}
}
