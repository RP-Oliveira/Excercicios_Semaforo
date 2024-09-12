package view; 
import java.util.concurrent.Semaphore;

import controller.SemaforoServidor;
public class ServidorPrincipal {
	
	public static void main (String[]args) {
		
		int permissao =1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int i=1; i<22; i++) {
		SemaforoServidor sema = new SemaforoServidor(semaforo);
		sema.start();
		}
	}

}
