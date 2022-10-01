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
			System.out.println("Erro! Data saida precisa ser superior a data de entrada");

		}else {
			Reserva  reserva = new Reserva (quarto,entrada,saida);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Atualização de Reserva: ");
			
			System.out.println("Data de entrada (dd/MM/yyyy):   ");
			entrada = sd.parse(sc.next());
			
			System.out.println("Data de saida (dd/MM/yyyy):  ");
			saida = sd.parse(sc.next());
			
			reserva.atualizacao(entrada, saida);
			System.out.println(reserva);


		}
		
		
		
		
		
		sc.close();
	}

}
