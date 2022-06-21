package ex05;
import java.io.File;
import java.io.Serializable;
/*
 * CLASSE ARGUMENTS
 * Classe per passar arguments
 * file: atribut que indica  el directori a llistar
 * listRecurs: atribut que indica llistar els subdirectoris
 *	dirToFile: true per tala de llistar el directori amb un arxiu
 * fileOut: arxiu on es llistarà el directori en cas de que dirToFile sigui true
 * fileTxtToRead: indica que s'ha de lleixir l'arxiu especificat en fileNameToRead
 * fileToSer: indica que es serialitzará l'objecte de la classe  Arguments
 * fileNameToSer: nom de l'arxiu a on es serielitzarà l'objecte 
 * fileToDeser: indica que hi ha un arxiu a deserialtizar
 * fileNameToDeser: arxiu a deserialitzar
 */
public class Arguments implements Serializable {
	//Atributes
	private File file;
	private boolean listRecurs;
	private boolean dirToFile;
	private String fileOut;
	private boolean fileTxtToRead;
	private String fileNameToRead;
	private boolean fileToSer;
	private String fileNameToSer;
	private boolean fileToDeser;
	private String fileNameToDeser;
	
	public Arguments(File file, boolean listRecurs, boolean dirToFile,String fileOut,
			boolean fileTxtToRead,String fileNameToRead,boolean fileToSer,String fileNameToSer,
			boolean fileToDeser,String fileNameToDeser) {
		this.file =file;
		this.listRecurs= listRecurs;
		this.dirToFile=dirToFile;
		this.fileOut=fileOut;
		this.fileTxtToRead=fileTxtToRead;
		this.fileNameToRead=fileNameToRead;
		this.fileToSer=fileToSer;
		this.fileNameToSer=fileNameToSer;
		this.fileToDeser=fileToDeser;
		this.fileNameToDeser=fileNameToDeser;
	}
	public Arguments(){};
	
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
	public boolean getFileToSer() {
		return fileToSer;
	}	
	public String getFileNameToSer() {
		return fileNameToSer;
	}
	public boolean getFileToDeser() {
		return fileToDeser;
	}	
	public String getFileNameToDeser() {
		return fileNameToDeser;
	}
	
}
