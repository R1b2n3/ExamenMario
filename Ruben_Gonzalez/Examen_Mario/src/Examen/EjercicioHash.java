package Examen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EjercicioHash {

	public static void main(String[] args) {
		try {
			FileOutputStream fileout = new FileOutputStream("QUIJOTE_HASH.DAT");
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA");
			String datos = "Don Quijote de la Mancha.\n"
					+"En un lugar de la Mancha de cuyo nombre no quiero acordarme,\n"
					+"no ha mucho tiempo que vivia un hidalgo de los de lanza en\n"
					+"astillero, adarga antigua, rocin flaco y galdo correddor. Una olla\n"
					+"de algo mas vaca que carnero, salpicon las mas noches, duelos y quebrantos\n"
					+"los sabados, lantejas los viernes, algun palomino de añadidura\n"
					+"los domingos, consumian las tres partes de su hacienda. El resto della\n"
					+"concluian sayo de velarte, calzas de velludo para las fiestas con\n"
					+"sus pantuflos de los mismo, y los dias de entresemana se honraba con su\n"
					+"vellori de los mas fino ";
			byte dataBytes[]=datos.getBytes();
			md.update(dataBytes);
			byte resumen[] = md.digest();
			dataOS.writeObject(datos);
			dataOS.writeObject(resumen);
			dataOS.close();
			fileout.close();
			System.out.println("Datos:" + datos);
			System.out.println("\nResumen creado con exito");
		}catch (IOException e) {e.printStackTrace();
	}catch(NoSuchAlgorithmException e) {e.printStackTrace();}
	
	}
}
