package paquete;

import java.util.*;

class Main {

	public static void main(String[] args) {
		
		Generacion Gen = new Generacion();
		GeneracionQ GenQ = new GeneracionQ();
		GeneracionP GenP = new GeneracionP();
		GeneracionS GenS = new GeneracionS();
		GeneracionI GenI = new GeneracionI();

		Scanner entrada = new Scanner(System.in);
		

		System.out.println("Seleccione corrida a simular");
		System.out.println("1.Mexico\n2.Queretaro\n3.Pachuca\n4.San Juan del Rio\n5.Ixmiquilpan");
		int opcion = entrada.nextInt();
		
		
		System.out.println("Dias a generar");
		int dia=entrada.nextInt();

		System.out.println("Tiempo maximo de retardo(min)");
		int tretardo = entrada.nextInt();

		System.out.println("Capacidad de asientos de autobus \n45 asientos \n44 asientos \n40 asientos \n35 asientos");
		int asientos = entrada.nextInt();

		switch (opcion) {
		case 1:
				Gen.corrida("archivo.txt",dia,tretardo,asientos);
			break;
		case 2:
			GenQ.corrida("archivo.txt",dia,tretardo,asientos);
			break;
		case 3:
			GenP.corrida("archivo.txt",dia,tretardo,asientos);
			break;
		case 4:
			GenS.corrida("archivo.txt",dia,tretardo,asientos);
			break;
		case 5:
			GenI.corrida("archivo.txt",dia,tretardo,asientos);
			break;
		default:
			System.out.println("Seleccione opcion valida");
			break;
		}

	}// end main

}// end class
