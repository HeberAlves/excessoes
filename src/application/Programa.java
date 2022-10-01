package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sd = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Numero quarto: ");
		int quarto = sc.nextInt();
		
		System.out.println("Data de entrada (dd/MM/yyyy):   ");
		Date entrada = sd.parse(sc.next());
		
		System.out.println("Data de saida (dd/MM/yyyy):  ");
		Date saida = sd.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro: Reserva, saida deve ser superior a data de entrada");
		}else {
			Reserva reserva = new Reserva (quarto,entrada,saida);
			System.out.println(reserva);
			System.out.println();
			System.out.println("Entre com a data entrada atualizacao (dd/MM/yyyy): ");
			entrada = sd.parse(sc.next());
			System.out.println("Entre com a data saida atualizacao (dd/MM/yyyy): ");
			saida = sd.parse(sc.next());
			
			String erro = reserva.atualizacao(saida,entrada);
		
		if (erro != null) {
			System.out.println("Erro reserva: "+erro);
		}else {
			System.out.println("Reserva: "+reserva);

			}
		}
		
		
		sc.close();
	}

}
