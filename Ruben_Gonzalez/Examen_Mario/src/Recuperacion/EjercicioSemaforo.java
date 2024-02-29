package Recuperacion;

import java.util.concurrent.Semaphore;

public class EjercicioSemaforo implements Runnable{
	public static final Semaphore S1 = new Semaphore(1);
	private final String nombre;
	
	public EjercicioSemaforo(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void run() {
		try {
			S1.acquire();
			System.out.println(""+ this.nombre+" amarillo");
			Thread.sleep(5000);
			System.out.println(""+ this.nombre+" rojo");
			S1.release();
			System.out.println(""+ this.nombre+" verde");
			S1.release();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			new Thread(new EjercicioSemaforo("Proceso:"+i)).start();
		}
		
	}
}
