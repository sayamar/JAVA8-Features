/**
 * 
 */
package com.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;



/**
 * @author HP
 *
 */
public class FilesWalkTest {
	
	private Path root;
	
	public  Stream<Path> loadAll(String dir) {
		try {
			 this.root = Paths.get(dir);
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}
	
	public static void main(String[] args) {
		FilesWalkTest test = new FilesWalkTest();
		String dir = "C:\\MARUTHI-PERSONALS\\GCP\\text";
		test.loadAll(dir).
		forEach(path -> {
			String fileName = path.getFileName().toString();
			File f = test.load(fileName,dir);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(f));
				String line;  
				while((line=reader.readLine())!=null)  
				{  
					System.out.println(line);    //line feed   
				} 
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
		});
	}
	
	public File load(String filename,String dir) {
		try {
			this.root = Paths.get(dir);
			Path file = this.root.resolve(filename);
			return file.toFile();
			
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

}
