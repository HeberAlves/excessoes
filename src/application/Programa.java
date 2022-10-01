package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args)  {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sd = new SimpleDateFormat ("dd/MM/yyyy");
		
		
		try {
			System.out.println("Numero quarto: ");
			int quarto = sc.nextInt();
			System.out.println("Data de entrada (dd/MM/yyyy):   ");
			Date entrada = sd.parse(sc.next());
			System.out.println("Data de saida (dd/MM/yyyy):  ");
			Date saida = sd.parse(sc.next());
			Reserva reserva = new Reserva (quarto,entrada,saida);
			System.out.println(reserva);
			System.out.println();
			System.out.println("Entre com a data entrada atualizacao (dd/MM/yyyy): ");
			entrada = sd.parse(sc.next());
			System.out.println("Entre com a data saida atualizacao (dd/MM/yyyy): ");
			saida = sd.parse(sc.next());
			reserva.atualizacao(entrada,saida);
			
		}
		catch(ParseException e) {
			System.out.println("Formato data invalido");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva ! " + e.getMessage());

		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");

		}
		
		
		sc.close();
	}

}
