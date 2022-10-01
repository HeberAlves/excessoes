package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer nquarto;
	private Date entrada;
	private Date saida;
	
	public static SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yy");
	
	public Reserva(Integer nquarto, Date entrada, Date saida){
		if (!entrada.after(saida)) {
			throw new DomainException ("Data saida precisa ser superior a data de entrada");
		}
		this.nquarto = nquarto;
		this.entrada = entrada;
		this.saida = saida;
		
	}

	public Integer getNquarto() {
		return nquarto;
	}

	public void setNquarto(Integer nquarto) {
		this.nquarto = nquarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao () {
		long diff  = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacao (Date entrada, Date saida) {
		Date now = new Date();
		if (entrada.before(now) || saida.before(now)) {
			throw new DomainException ("Reserva data de atualizacao precisa ser futura");

		}if (!entrada.after(saida)) {
			throw new DomainException ("Data saida precisa ser superior a data de entrada");
		}
		
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Quarto "
				+ nquarto
				+ " Entrada: "
				+ sd.format(entrada)
				+ " Saída: "
				+ sd.format(saida)
				+ ", "
				+ duracao()
				+ " Noites";
				
	}		
	
	
	

	
	
	
}
