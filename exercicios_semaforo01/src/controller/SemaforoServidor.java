package controller;

import java.util.concurrent.Semaphore;

public class SemaforoServidor extends Thread {
	private Semaphore semaforo;
	
	public SemaforoServidor(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	public void run() {
		seletor();	   
	}

	private void seletor() {
		int threadId = (int)threadId();
		   		   
		   if (threadId%3 == 1) {
			   for (int i=0; i<3;i++);{
			   		calculando((int)(Math.random()*1001)+200);
			   		bancoDados(1000);
		   		}
			}
		   
			if (threadId%3 == 2) {
				for (int j=0; j<4;j++) {
					calculando((int)(Math.random()*1501)+500);
					bancoDados(1500);
				}
			}
			
			if (threadId%3 == 0) {
				for (int z=0; z<4;z++) {
					calculando((int) ((Math.random()*2001)+1000));
					bancoDados(1500);
				}
				
			}
	}

	public void calculando(int t) {
		double tempo = (double)t;
		try {
			System.out.println(threadId()+"# Calculando por "+(tempo/1000)+" segundos.");
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println(e);
		}
	
		
		
	}
	
	public void bancoDados(int t) {
		double tempo = (double)t;
		try {
			semaforo.acquire();
			System.out.println(threadId()+"# Iniciou Transação de DB de "+(tempo/1000)+" segundos.");
			Thread.sleep(t);
			System.out.println(threadId()+"# Encerrou Transação de DB.");
			semaforo.release();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
			System.err.println(e1);
		}
	}
	
}
