package controller;

import java.util.concurrent.Semaphore;

public class Threadcontroller extends Thread{
	private Semaphore semaforo;
	private int tid, tempo;
	private static int[] pista = new int[12], p = new int[2];
	
	public Threadcontroller(int tid, Semaphore semaforo) {
		this.tid = tid;
		this.semaforo = semaforo;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			decolar();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	public void decolar() {
		if(p[0] == 0) {
			pista[tid - 1] = 1;
			p[0] = 1;
		}else {
			pista[tid - 1] = 2;
		}
		System.out.println("O avião "+tid+" está começando a decolar na pista "+pista[tid - 1]+".");
		System.out.println("O avião "+tid+" está começando a fazer a manobra na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 401) + 300);
		try {
			sleep(tempo);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		System.out.println("O avião "+tid+" está começando a fazer o taxiamento na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 501) + 500);
		try {
			sleep(tempo);
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("O avião "+tid+" está começando a fazer a decolagem na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 201)+ 600);
		try {
			sleep(tempo);
		}catch(Exception e3) {
			e3.printStackTrace();
		}
		System.out.println("O avião "+tid+" está começando a fazer o afastamento na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 501)+ 300);
		try {
			sleep(tempo);
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		System.out.println("O avião "+tid+" saiu da pista "+pista[tid - 1]+".");
		if(pista[tid - 1] == 1) {
			p[0] = 0;
		}
	}
}
