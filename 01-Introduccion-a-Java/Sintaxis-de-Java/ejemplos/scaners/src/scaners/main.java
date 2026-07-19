package scaners;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int edad;
		String nombre;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe edad: ");
		edad = teclado.nextInt();
		teclado.nextLine();
		System.out.print("Escribe el nombre: ");
		nombre = teclado.nextLine();
		System.out.println(edad);
		System.out.println(nombre);
	}

}
