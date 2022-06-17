package ex02;
import java.io.File;
public class Arguments {
	//Atributes
	private File file;
	private boolean listRecurs;

	
	public Arguments(File file, boolean listRecurs ) {
		this.file =file;
		this.listRecurs= listRecurs;
	
	}
	public File getFile() {
		return file;
		
	}
	
	public boolean getListRecurs() {
		return listRecurs;
	}
}
