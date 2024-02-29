package Examen;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;

public class VerificarHash {

	public static void main(String[] args) {
		try {
			FileInputStream fileout = new FileInputStream("QUIJOTE_HASH.DAT");
			ObjectInputStream dataOS = new ObjectInputStream(fileout);
			Object o = dataOS.readObject();
			String datos = (String) o;
			System.out.println("Datos: "+ datos);
			o = dataOS.readObject();
			byte resumenOriginal[] =(byte[]) o;
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(datos.getBytes());
			byte resumenActual[] = md.digest();
			if (MessageDigest.isEqual(resumenActual, resumenOriginal))
				System.out.println("\nDATOS VALIDOS");
			else
				System.out.println("\nDATOS NO VALIDOS");
			dataOS.close();
			fileout.close();
		}catch(Exception e) {e.printStackTrace();}
			
	}

}
