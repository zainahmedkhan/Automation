package serializatonDeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class  Test implements Serializable
{
	int i=10, j=20;
}

public class SerializationAndDeserialization {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Test t1 = new Test();		//object - t1 is object
		
		//Serialization - we will convert object t1 into text file
		
		FileOutputStream fos = new FileOutputStream("test.txt"); // file creation
		
		// Now we need to convert our object into text file
		
		ObjectOutputStream oos = new ObjectOutputStream(fos); // converting object related data into file
		
		oos.writeObject(t1);   // convert object into file
		
		//deserialization
		
		FileInputStream fis = new FileInputStream("E:\\Api Automation\\RestAssured\\test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Test t2 = (Test) ois.readObject();   // convert file into object
		
		System.out.println(t2.i+"  "+t2.j);
		
		
		
	}
	

}
