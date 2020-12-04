import java.util.InputMismatchException;
import java.util.Scanner;

import bl.KAppImpl;
import exception.BadCharException;
import interfaces.KApp;
import repository.Repository;

public class Main {

	public static void main(String[] args) {
		
		KApp KApp = new KAppImpl();
		Repository repo = new Repository();

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
						try {
							statusSub1 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem jó karaktert adtál meg!");
						}
						try {
							switch (statusSub1) {
							case 1:
								repo.szakrendelesekLekerdezesAmenuhoz();
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
						try {
							statusSub2 = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("Nem jó karaktert adtál meg!");
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
					System.out.println("Viszontlátásra!");
					break;
				default:
					throw new BadCharException();
				}
			} catch (Exception e) {
			}
		}
		sc.close();
	}		
}
