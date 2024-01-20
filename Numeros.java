package numeros;

import java.io.Serializable;

public class Numeros implements Serializable{
	 //Crea una clase Java llamada Números que defina 3 atributos, uno de ellos entero y los otros dos de tipo long 
	//(int número, long cuadrado y long cubo). 
	
	private int numero;
	private long cuadrado;
	private long cubo;
	
	
	
	public Numeros(int numero, long cuadrado, long cubo) {
		super();
		this.numero = numero;
		this.cuadrado = cuadrado;
		this.cubo = cubo;
	}
	
	public Numeros() {
		
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public long getCuadrado() {
		return cuadrado;
	}
	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}
	public long getCubo() {
		return cubo;
	}
	public void setCubo(long cubo) {
		this.cubo = cubo;
	}
	public long calcularCuadrado(long numero) {
        cuadrado = (long) numero * numero;
        
        
        return cuadrado;
    }
	public long calcularCubo(long numero) {
        
        cubo = (long) numero * numero * numero;
        
        return cubo;
    }
	
	
}
