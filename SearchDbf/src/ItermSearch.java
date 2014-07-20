import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.linuxense.javadbf.*;

public class ItermSearch {
	
	  public static void main( String args[]) {

		    try {

		      // create a DBFReader object
		      //
		      String url = "C:\\Users\\User\\workspace\\Yuming\\SearchDbf\\ITEMS.DBF";
		      InputStream inputStream  = new FileInputStream( url); // take dbf file as program argument
		      DBFReader reader = new DBFReader( inputStream); 

		      // get the field count if you want for some reasons like the following
		      //
		      int numberOfFields = reader.getFieldCount();

		      // use this count to fetch all field information
		      // if required
		      //
		      for( int i=0; i<numberOfFields; i++) {

		        DBFField field = reader.getField( i);

		        // do something with it if you want
		        // refer the JavaDoc API reference for more details
		        //
		        System.out.println( field.getName());
		      }

		      // Now, lets us start reading the rows
		      //
		      Object []rowObjects = reader.nextRecord();

		      while( rowObjects != null) {

		        for( int i=0; i<rowObjects.length; i++) {

		          System.out.println( rowObjects[i]);
		        }
		        rowObjects = reader.nextRecord();
		      }

		      // By now, we have itereated through all of the rows
		      
		      inputStream.close();
		    }
		    catch( DBFException e) {

		      System.out.println( e.getMessage());
		    }
		    catch( IOException e) {

		      System.out.println( e.getMessage());
		    }
		  }  
		}