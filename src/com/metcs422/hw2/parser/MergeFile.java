package com.metcs422.hw2.parser;
/////////////////////////////////////////////////////////////////////
// Three text file with .xml extension are merged into a new file. //
// PrintWriter, BufferedReader, FileReader classes are used to     //
// merge these files.											   //
/////////////////////////////////////////////////////////////////////

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeFile {
	private static String line = null;

	private static PrintWriter pw = null;
	
	private static BufferedReader br = null;
	
	public MergeFile() {
	}
	
	@SuppressWarnings("resource")
	public static void mergeFile() throws IOException {
		// PrintWriter object lets you write in filesCopy.xml
		pw = new PrintWriter("filesCopy.xml");

		// opening the root tag of filesCopy.xml file.
		pw.println("<PubmedArticleSet>");

		// BufferReader object for 1st xml file that needs to be read. 
		// FileReader makes it possible to read the contents of a file
		br = new BufferedReader(new FileReader("pubmed20n1020.xml"));

		line = br.readLine();

		// loop to copy each line of pubmed20n1020.xml to 
		// filesCopy.xml
		loop();
		
		// BufferedReader object for 2nd xml file that needs to be read
		br = new BufferedReader (new FileReader ("pubmed20n1023.xml"));
		line = br.readLine();

		// loop to copy each line of pubmed20n1023.xml to
		// filesCopy.xml
		loop();

		// BufferedReader object for 3rd file that needs to be read
		br = new BufferedReader (new FileReader ("pubmed20n1032.xml"));
		line = br.readLine();

		// loop to copy each line of pubmed20n1032.xml to
		// filesCopy.xml
		loop();

		// closing the root tag of files.xml file
		pw.println("</PubmedArticleSet>");
		pw.flush();
		// closing resources
		br.close();
		pw.close();

		System.out.println("Merged.");

	}
	
	private static void loop () throws IOException {
		while (line != null) {
			if (!line.equals("<PubmedArticleSet>") && !line.equals("</PubmedArticleSet>")
					&& !line.contains("<?") && !line.contains("<!")) {
				// whatever is appended to the String line will be sent to the
				// filesCopy.xml
				pw.println(line);
			}
			// readLine() method is used to read data line by line.
			// This line is reading the line of text from text file
			// and assigning the value read to the line variable. 
			line = br.readLine();	
		}
	}


}
