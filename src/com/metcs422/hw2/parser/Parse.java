package com.metcs422.hw2.parser;
///////////////////////////////////////////////////////////
// This class is used to extract infromation from the    //
// text file with xml extension. Document Object Model   //
// is used to parse the xml file and get the information //
///////////////////////////////////////////////////////////

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parse {
	
	public Parse () {
	}
	
	private static ArrayList<String> searchList = new ArrayList<String>();
	
	private static LocalTime time = LocalTime.now();
	
		
	public static LocalTime getTime() {
		return time;
	}


	public static void setTime(LocalTime time) {
		Parse.time = time;
	}


	public static ArrayList<String> getSearchList() {
		return Parse.searchList;
	}


	public static void setSearchList(ArrayList<String> searchList) {
		Parse.searchList = searchList;
	}
	
	public static void parse() throws ParserConfigurationException, SAXException, IOException {
		String fileName = "filesCopy.xml";
		
		// object of file type which will allow us to 
		// read the xml document.
		File xmlFile = new File(fileName);

		// This is a factory class that allows us to create a
		// DocumentBuilder object. newInstance() is a static
		// method which returns DocumentBuilderFactory object.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// the DocumentBuilderFactory instance is used to create 
		// a DocumentBuilder instance. This class is used to 
		// obtain a Document from xml
		DocumentBuilder db = dbf.newDocumentBuilder();

		// DocumentBuilder is used to parse the file to xml standard,  
		// and assigned to Document interface. 
		Document doc = db.parse(xmlFile);


		// This line is basically locating the root and giving back its name.
		// getDocumentElement() locates the root and getNodeName() gives the
		// name. 
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		// It creates an array of ArticleTitle element and record it in
		// NodeList object called articleTitle.
		NodeList articleTitle = doc.getElementsByTagName("ArticleTitle");

		// It creates an array of Year element and record it in
		// NodeList object called yearList.
		NodeList yearList = doc.getElementsByTagName("Year");

		// It creates an array of Abstract element and record it in
		// NodeList object called abstractText.
		NodeList abstractText = doc.getElementsByTagName("Abstract");
		
		
		Scanner sc = new Scanner(System.in);
		String userChoice = "Y";
		String search =  null;
		
		
		while (userChoice.equalsIgnoreCase("Y")) {
			System.out.println("Enter keyword you want to search: ");
			search = sc.next();
		// This for loop is iterating through as many abstractText 
		// element as there are in the filesCopy.xml 
				for (int itr = 0; itr<articleTitle.getLength(); itr++) {

					// articleTitle is an instance of NodeList. Since NodeList,
					// has created array of all the ArticleTitle tags which is 
					// referenced to articleTitle, here we are taking one object 
					// of that array each iteration. Similar, process with other
					// instances of Node i.e. year and abstractTextt
					Node artiTitle = articleTitle.item(itr);
					Node year = yearList.item(itr);
					Node abstractTextt = abstractText.item(itr);

					
					
					// Checking if there is keyword abstract in the text context of 
					// Abstract tag.
					if (artiTitle.getTextContent().contains(search)) {

						// This gets the text content of ArticleTitle tag in the xml file.
						System.out.println("\nTitle :" + artiTitle.getTextContent());

						// This gets the text content of Year tag in the xml file.
						System.out.println("Year : " + year.getTextContent());
					}
				}
		
		System.out.println("\nWould you like to make ANOTHER SEARCH?");
		System.out.println("YES: Enter " + " \"Y\" " + "OR" + " \"y\"");
		
		System.out.println("NO: Enter anyword.");
		System.out.println("Words you searched initially");
		System.out.print(search + Parse.getSearchList());
		System.out.println("Local Time " + Parse.getTime());
		userChoice = sc.next();
		searchList.add(search);
		
		
		}
		
		System.out.println("Thank you!!");
		
		
		
		
	}

}
