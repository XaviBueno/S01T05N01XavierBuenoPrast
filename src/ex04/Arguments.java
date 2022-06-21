package ex04;
import java.io.File;

/*
 * CLASSE ARGUMENTS
 * Classe per passar arguments
 * file: atribut que indica  el directori a llistar
 * listRecurs: atribut que indica llistar els subdirectoris
 *	dirToFile: true per tala de llistar el directori amb un arxiu
 * fileOut: arxiu on es llistarà el directori en cas de que dirToFile sigui true
 * fileTxtToRead: indica que s'ha de lleixir l'arxiu especificat en fileNameToRead
 */
public class Arguments {
	//Atributes
	private File file;
	private boolean listRecurs;
	private boolean dirToFile;
	private String fileOut;
	private boolean fileTxtToRead;
	private String fileNameToRead;
	
	public Arguments(File file, boolean listRecurs, boolean dirToFile,String fileOut,
			boolean fileTxtToRead,String fileNameToRead) {
		this.file =file;
		this.listRecurs= listRecurs;
		this.dirToFile=dirToFile;
		this.fileOut=fileOut;
		this.fileTxtToRead=fileTxtToRead;
		this.fileNameToRead=fileNameToRead;
	}
	public File getFile() {
		return file;
		
	}
	public String getFileOut() {
		return fileOut;
		
	}
	
	public boolean getListRecurs() {
		return listRecurs;
	}
	public boolean getDirToFile() {
		return dirToFile;
	}
	public boolean getFileTxtToRead() {
		return fileTxtToRead;
	}	
	public String getFileNameToRead() {
		return fileNameToRead;
	}
	
}
