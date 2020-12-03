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
		 * / A fõmenüben 3 menüpont volna,amikor majd megírjuk,hogy az adott menüpont
		 * mit csinál, akkor ott íratjuk ki:
		 * 
		 * 1.Új doktor 2.Új beteg 3.Új szakrendelés(kezelõ) 4.Kezelés lemondás
		 * 
		 * Amit az adott menponton belül választ egy Scanner-rel,akkor azt behívja, és
		 * utána történik az adatfelvitel
		 */

		//Scanner sc;// = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int statusMain = 0;
		int statusSub1 = -1;
		int statusSub2 = -1;
		while (statusMain != 3) {
			
			System.out.println("\n----------Üdvözöljük Klinikánkon!----------");
			System.out.println("#################### MENÜ ####################");
			System.out.println("1.- Új esemény rögzítése");
			System.out.println("2.- Keresés");
			System.out.println("3.- Kilépés");
			try {
				statusMain = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Nem jó karaktert adtál meg!");
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
							System.err.println("Nem jó karaktert adtál meg!");
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
							System.err.println("Nem jó karaktert adtál meg!");
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
