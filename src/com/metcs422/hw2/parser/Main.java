package com.metcs422.hw2.parser;
//////////////////////////////////////////////////////////////////////
// Author   : Nirajan Pandey									    //
// Prof.    : Reza Rawassizadeh									    //
// TA	    : Dakshin Jawahar										//		
// Deadline : Tuesday, Sept 22nd									//
//																	//
//  This is main class where all the execution of merging and 	    //
//  extracting the data from merged file happens.				    //
//////////////////////////////////////////////////////////////////////

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	// Executes two static method to merge file and extract information from
	// newely created merged file. 
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
	
		MergeFile.mergeFile();
		Parse.parse();
	}
}


