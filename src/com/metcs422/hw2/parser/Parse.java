package com.metcs422.hw2.parser;
///////////////////////////////////////////////////////////
// This class is used to extract infromation from the    //
// text file with xml extension. Document Object Model   //
// is used to parse the xml file and get the information //
///////////////////////////////////////////////////////////

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
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
	
	// Creates an ArrayList of type Data.
	static ArrayList<Data> dataLog = new ArrayList<>();
	
	public static ArrayList<Data> getDataLog() {
		return dataLog;
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

		
		
		
		Scanner sc = new Scanner(System.in);
		String userChoice = "Y";
		String search =  null;
		
		
		while (userChoice.equalsIgnoreCase("Y")) {
			// LocalTime is an immutable date-time object that represents time. 
			// now() is a static method of LocalTime class which obtains the
			// current time from the system clock in the default time-zone.
			LocalTime currentTime = LocalTime.now();
			
			System.out.print("Enter keyword you want to search: ");
			// this gets the input of search keyword from the user.
			search = sc.next();
			
			// Initialized Data class constructor, which takes keyword
			// user searched and time when it was searched.
			Data data = new Data(search, currentTime);
			
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
					

					
					
					// Checking if there is keyword abstract in the text context of 
					// Abstract tag.
					if (artiTitle.getTextContent().contains(search)) {

						// This gets the text content of ArticleTitle tag in the xml file.
						System.out.println("\nTitle :" + artiTitle.getTextContent());

						// This gets the text content of Year tag in the xml file.
						System.out.println("Year : " + year.getTextContent());
					}
				}
		// Asking user for more information if they would like to 
		// continue or not. 
		System.out.println("\nWould you like to make ANOTHER SEARCH?");
		System.out.println("YES: Enter " + " \"Y\" " + "OR" + " \"y\"");
		
		System.out.println("NO: Enter anyword.");
		System.out.println("------------------------");
		System.out.print("ANOTHER SEARCH: 'Y' OR 'N': ");
		
		// This gets the input of user choice from the user,
		// if they want to continue of stop searching
		userChoice = sc.next();
		
		
		System.out.println("Words you searched previously");
		
		// dataLog is an instance of ArrayList which is refering to
		// the Data. This line adds each search entered by user and 
		// time stamp to the ArrayList.
		dataLog.add(data);
		
		// Printing out the output.
		System.out.println(getDataLog() + "\n");
		
		}
		
		System.out.println("Thank you!!");
	}

}
