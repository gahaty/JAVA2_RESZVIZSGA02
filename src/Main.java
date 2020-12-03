import java.util.InputMismatchException;
import java.util.Scanner;

import bl.KAppImpl;
import exception.BadCharException;
import interfaces.KApp;

public class Main {

	public static void main(String[] args) {
		
		KApp KApp = new KAppImpl();
		//rp.vizitBetegekLekerdezes();
		//KApp.betegFelvetel();

		/*
		 * / A f�men�ben 3 men�pont volna,amikor majd meg�rjuk,hogy az adott men�pont
		 * mit csin�l, akkor ott �ratjuk ki:
		 * 
		 * 1.�j doktor 2.�j beteg 3.�j szakrendel�s(kezel�) 4.Kezel�s lemond�s
		 * 
		 * Amit az adott menponton bel�l v�laszt egy Scanner-rel,akkor azt beh�vja, �s
		 * ut�na t�rt�nik az adatfelvitel
		 */

		//Scanner sc;// = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int statusMain = 0;
		int statusSub1 = -1;
		int statusSub2 = -1;
		while (statusMain != 3) {
			
			System.out.println("\n----------�dv�z�lj�k Klinik�nkon!----------");
			System.out.println("#################### MEN� ####################");
			System.out.println("1.- �j esem�ny r�gz�t�se");
			System.out.println("2.- Keres�s");
			System.out.println("3.- Kil�p�s");
			try {
				statusMain = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Nem j� karaktert adt�l meg!");
				continue;
			}
			try {
				switch (statusMain) {
				case 1:
					KApp.ujEsemeny();
					while (statusSub1 != 0) {
						sc = new Scanner(System.in);
						try {
							statusSub1 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem j� karaktert adt�l meg!");
							continue;
						}
						try {
							switch (statusSub1) {
							case 1:
								KApp.ujOrvosFelvetele();
								System.out.println();
								KApp.ujEsemeny();
								break;
							case 2:
								KApp.betegFelvetel();
								System.out.println();
								KApp.ujEsemeny();
								break;
							case 3:
								KApp.ujKezeloFelvetel();
								System.out.println();
								KApp.ujEsemeny();
								break;
							case 4:
								KApp.kezelesLemondasa();
								System.out.println();
								KApp.ujEsemeny();
								break;
							case 0:
								break;
							default:
								throw new BadCharException();
							}
						} catch (Exception e) {
							System.err.println(e.getMessage());
							KApp.ujEsemeny();
						}
					}
					statusSub1 = -1;
					break;
				case 2:
					KApp.Kereses();
					while (statusSub2 != 0) {
						sc = new Scanner(System.in);
						try {						
							statusSub2 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem j� karaktert adt�l meg!");
							continue;
						}
						try {
							switch (statusSub2) {
							case 1:
								KApp.szakrendelesLekerdezes();
								KApp.Kereses();
								break;
							case 2:
								KApp.vizitBetegekLekerdezes();
								KApp.Kereses();
								break;
							case 3:
								KApp.orvosLekerdezes();
								KApp.Kereses();
								break;
							case 0:
								break;
							default:
								throw new BadCharException();
							}
						} catch (Exception e) {
							System.err.println(e.getMessage());
							KApp.Kereses();
						}
					}
					statusSub2 = -1;
					break;
				case 3:
					break;
				default:
					throw new BadCharException();
				}
			} catch (Exception e) {
			}
		}
	}
		
}
