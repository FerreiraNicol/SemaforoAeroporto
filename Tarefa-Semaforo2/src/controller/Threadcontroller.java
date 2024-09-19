package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	private Semaphore semaforo, semaforofases = new Semaphore(1);
	private int tid, tempo;
	private static int[] pista = new int[12], p = new int[2];
	
	public ThreadCarro(int tid, Semaphore semaforo) {
		this.tid = tid;
		this.semaforo = semaforo;
	}

	@Override
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
	
	private void decolar() {
		if(p[0] == 0) {
			pista[tid - 1] = 1;
			p[0] = 1;
		}else {
			pista[tid - 1] = 2;
		}
		System.out.println("O avião "+tid+" está começando a decolar na pista "+pista[tid - 1]+".");
		try {
			semaforofases.acquire();
			fasemanobra();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			semaforofases.release();
		}
		
		try {
			semaforofases.acquire();
			fasetaxiamento();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			semaforofases.release();
		}
		
		try {
			semaforofases.acquire();
			fasedecola();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			semaforofases.release();
		}
		
		try {
			semaforofases.acquire();
			faseafasta();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			semaforofases.release();
		}
		
		System.out.println("O avião "+tid+" saiu da pista "+pista[tid - 1]+".");
		if(pista[tid - 1] == 1) {
			p[0] = 0;
		}
	}
	
	private void fasemanobra() {
		System.out.println("O avião "+tid+" está começando a manobrar na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 401) + 300);
		try {
			sleep(tempo);
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void fasetaxiamento() {
		System.out.println("O avião "+tid+" está começando a fazer o taxiamento na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 501) + 500);
		try {
			sleep(tempo);
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void fasedecola() {
		System.out.println("O avião "+tid+" está começando a fazer a decolagem na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 201)+ 600);
		try {
			sleep(tempo);
		}catch(Exception e3) {
			e3.printStackTrace();
		}
	}
	
	private void faseafasta(){
		System.out.println("O avião "+tid+" está começando a fazer o afastamento na pista "+pista[tid - 1]+".");
		tempo = (int)((Math.random() * 201)+ 600);
		try {
			sleep(tempo);
		}catch(Exception e4) {
			e4.printStackTrace();
		}
	}
}
