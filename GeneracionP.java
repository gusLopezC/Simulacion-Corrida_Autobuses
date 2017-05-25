package paquete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneracionP {

	double hora[] = { 05.15, 06.15, 07.15, 08.15, 09.15, 10.15, 11.15, 12.15, 13.15, 14.15, 15.15, 16.15, 17.15, 18.15,
			19.15,20.15 };

	float AsiOcu = 0;
	float ProbAsiL = 0;
	int arrayBolC[];
	int arrayBolM[];
	int arrayBolI[];
	int arrayDinC[];
	int arrayDinM[];
	int arrayDinI[];
	float arrayPro[];
	int AsiProT = 0;

	public void corrida(String nombreArchivo, int dia, int tretardo, int asientos) {

		File f = new File(nombreArchivo);
		int AsiIna = 0;
		int AsiMed = 0;
		int AsiCom = 0;
		int TAsiIna = 0;
		int TAsiMed = 0;
		int TAsiCom = 0;
		int DinCom = 0, DinMed = 0, DinIna = 0;
		int condia = 1;

		arrayBolC = new int[dia];
		arrayBolM = new int[dia];
		arrayBolI = new int[dia];
		arrayDinC = new int[dia];
		arrayDinM = new int[dia];
		arrayDinI = new int[dia];
		arrayPro = new float[dia];

		try {
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			for (int z = 0; z <= dia - 1; z++) {// dia

				System.out.println("\n\nDia " + condia);
				wr.append("Dia " + condia + "\n");
				condia++;

				System.out.println("Hora  Hora salida   Destino         Capacidad Ocupados Normales Medios INAPAN     Total ");
				wr.append("Hora  Hora salida   Destino         Capacidad Ocupados Normales Medios INAPAN     Total " + "\n");
				for (int i = 0; i < hora.length; i++) {
					float Horafinal = (float) ((Math.random() * tretardo + 1) / 100);
					float horaReal = (float) (hora[i] + Horafinal);
					int AsientosTAle = (int) (Math.random() * asientos + 1);
					AsiProT = AsiProT + AsientosTAle;
					AsiOcu = AsientosTAle;
					

					for (int j = 0; j < AsientosTAle; j++) {
						double AsRandom = (Math.random() * 100);

						if (AsRandom <= 25) {
							AsiIna = AsiIna + 1;
							TAsiIna = TAsiIna + 1;

						}
						if (AsRandom >= 25 && AsRandom <= 30) {
							AsiMed = AsiMed + 1;
							TAsiMed = TAsiMed + 1;

						}
						if (AsRandom > 30) {
							AsiCom = AsiCom + 1;
							TAsiCom = TAsiCom + 1;

						}

						DinCom = (TAsiCom * 127);
						DinMed = (TAsiMed * 63);
						DinIna = (TAsiIna * 32);
						
					}

					int Tdinero = (AsiCom * 56) + (AsiMed * 63) + (AsiIna * 32);
					System.out.println(String.format("%.2f", hora[i]) + "\t" + String.format("%.2f", horaReal)
							+ " \t     Ixmiquilpan      " + asientos + "\t " + AsientosTAle + "\t  " + AsiCom + "\t    "
							+ AsiMed + "\t    " + AsiIna + "\t    $" + Tdinero);
					// --------------------------
					wr.append(String.format("%.2f", hora[i]) + "\t" + String.format("%.2f", horaReal)
							+ " \t     Ixmiquilpan      " + asientos + "\t     " + AsientosTAle + "\t\t    " + AsiCom
							+ "\t   " + AsiMed + "\t\t" + AsiIna + "\t\t$" + Tdinero + "\n");

					AsiIna = 0;
					AsiMed = 0;
					AsiCom = 0;
					Tdinero = 0;

				}

				arrayBolC[z] = TAsiCom;
				arrayBolM[z] = TAsiMed;
				arrayBolI[z] = TAsiIna;

				arrayDinC[z] = DinCom;
				arrayDinM[z] = DinMed;
				arrayDinI[z] = DinIna;

				int SumaAsin = (asientos * hora.length);
				
				//System.out.println(AsiProT);
				//System.out.println(SumaAsin);
				float proba=(float)AsiProT/(float)SumaAsin;
				//System.out.println(proba);
				arrayPro[z] = proba;
				
				TAsiCom = 0;
				TAsiMed = 0;
				TAsiIna = 0;
				AsiProT = 0;
				
			} // end for dia
			

		condia = 1;

		System.out.println("___________________________________________________________________________________");
		
		System.out.println("\n\t Reporte total de  boletos vendidos");
		System.out.println("\tDestino         Normal   Medio    INAPAN");
		wr.write("___________________________________________________________________________________\n");
		wr.write("\n\t Reporte total de  boletos vendidos");
		wr.write("\n\tDestino         Normal   Medio    INAPAN\n");
		for (int i = 0; i <= dia - 1; i++) {
			System.out.print("Dia" + condia);
			wr.write("Dia" + condia+"\n");
			condia++;
			System.out.println("\tPachuca \t   " + arrayBolC[i] + "      " + arrayBolM[i] + "      " + arrayBolI[i]);
			wr.write("\tPachuca \t   " + arrayBolC[i] + "      " + arrayBolM[i] + "      " + arrayBolI[i]+"\n");
		}
		condia = 1;

		System.out.println("___________________________________________________________________________________");
		wr.write("___________________________________________________________________________________\n");
		System.out.println("\n\t Reporte total de dinero generado al dia\n");
		wr.write("\n\t Reporte total de dinero generado al dia\n");
		
		System.out.println("\tDestino          Normal   Medio     INAPAN");
		wr.write("\tDestino          Normal   Medio     INAPAN\n");
		for (int i = 0; i <= dia - 1; i++) {

			System.out.print("Dia" + (condia));
			wr.write("Dia" + (condia)+"\n");
			condia++;

			System.out.println("\tPachuca       $" + arrayDinC[i] + "   $" + arrayDinM[i] + "   \t$" + arrayDinI[i]);
			wr.write("\tPachuca       $" + arrayDinC[i] + "   $" + arrayDinM[i] + "   \t$" + arrayDinI[i]+"\n");
		}
		condia = 1;

		System.out.println("___________________________________________________________________________________");
		System.out.println("\n\t Probabilidad de encontrar boleto libre");
		System.out.println("\t Destino        Probabilidad");
		wr.write("___________________________________________________________________________________\n");
		wr.write("\n\t Probabilidad de encontrar boleto libre\n");
		wr.write("\t Destino                 Probabilidad\n");
		for (int i = 0; i <= dia - 1; i++) {
			System.out.println("Dia" + (condia) + "\tPachuca " + "	  \t" + arrayPro[i]+ "%");
			wr.write("Dia" + (condia) + "\tPachuca " + "	  \t" + arrayPro[i]+ "%\n");
			condia++;

		}
		wr.close();
		bw.close();

	} catch (IOException e) {
		// TODO: handle exception
	} // end try-catch

	}// end metdo

}// end class