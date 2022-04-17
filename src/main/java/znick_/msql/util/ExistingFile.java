package znick_.msql.util;

import java.io.File;
import java.io.IOException;

/**
 * A file that is guaranteed to exist and be a file xor directory, depending on which is specified.
 * If the file or directory does not exist, it will be created in the constructor.
 * 
 * @author zNick_
 */
public class ExistingFile extends File {

	/**
	 * Creates a new {@code ExistingFile} with the given parent file and child name.
	 * 
	 * @param parent The parent directory
	 * @param child The name of the child directory
	 * @param isDirectory Whether or not this {@code ExistingFile} represents a folder instead of a file.
	 */
	public ExistingFile(File parent, String child, boolean isDirectory) {
		super(parent, child);
		this.init(isDirectory);
	}
	
	/**
	 * Creates a new {@code ExistingFile} with the given parent file and child name.
	 * 
	 * @param string The file name
	 * @param isDirectory Whether or not this {@code ExistingFile} represents a folder instead of a file.
	 */
	public ExistingFile(String string, boolean isDirectory) {
		super(string);
		this.init(isDirectory);
	}
	
	/**
	 * Initializes the {@code ExistingFile}. Searches for the file and checks if it exists. If it doesn't,
	 * creates all parent directories leading to the file location and then creates the {@code ExistingFile}.
	 * 
	 * @param isDirectory Whether or not the {@code ExistingFile} represents a folder instead of a file.
	 */
	private void init(boolean isDirectory) {
		try {
			if (isDirectory && !(this.exists() && this.isDirectory())) this.mkdirs();
			else if (!isDirectory && !(this.exists() && this.isFile())) {
				this.getParentFile().mkdirs();
				this.createNewFile();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
