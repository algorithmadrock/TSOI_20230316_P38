/*
RESUMO      : Exercicio da pg.38, Simulação de um cruzamento de pessoas
PROGRAMADORA: Luiza Felix
DATA        : 29/03/2023
 */

package view;

import controller.Pessoa;

public class Principal {

	public static void main(String[] args) {
		String[] nomes = { "Ashton Irwin", "Luke Hemmings", "Michael Clifford", "Calum Hood" };
		for (int i = 0; i < 4; i++) {
			Thread persona = new Pessoa(i, nomes[i]); 
			persona.start();
		}

	}
}
