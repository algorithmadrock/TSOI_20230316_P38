/*
RESUMO      : Exercicio da pg.38, Simulação de um cruzamento de pessoas
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package controller;

import java.util.concurrent.Semaphore;

public class Pessoa extends Thread{
	
	private int corredor;
	private String nome;
	private Semaphore semaforo = new Semaphore(1);
	
	public Pessoa(int corredor, String nome) {
		this.nome = nome;
		this.corredor = corredor;
	}

	@Override
	public void run() {		
		andar();		
		try {
			semaforo.acquire();
			cruzarporta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void andar() {
		int andado = 0;
		while (andado<200) {
			andado+= (int) (Math.random()*3 + 4);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(nome + ", do corredor " + corredor +" chegou ate a porta!");
	}

	private void cruzarporta() {
		int tempo = (int) (Math.random()*1001 + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println(nome + ", do corredor " + corredor + " abriu e passou pela porta.");
		
		
	}

	
}
