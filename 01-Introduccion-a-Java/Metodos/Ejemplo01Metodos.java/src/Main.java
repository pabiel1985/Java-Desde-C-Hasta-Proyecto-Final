import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String nombre;
		int primerNumero;
		int segundoNumero;
		int resultado;
		boolean paridad;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese nombre: ");
		nombre = teclado.nextLine();
		saludar(nombre);

		System.out.print("Escriba primer numero a sumar: ");
		primerNumero = teclado.nextInt();
		System.out.print("Escriba segundo numero a sumar: ");
		segundoNumero = teclado.nextInt();
		resultado = sumar(primerNumero, segundoNumero);
		System.out.println("La suma es " + resultado);
		paridad = esPar(resultado);
		System.out.println("El resultado es par? " + paridad);

		teclado.close();

	}

	public static void saludar(String nombre) {
		System.out.println("Hola " + nombre);
	}

	public static int sumar(int a, int b) {
		return a + b;
	}

	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}
}
