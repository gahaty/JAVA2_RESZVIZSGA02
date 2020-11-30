import bl.KAppImpl;
import interfaces.KApp;

public class Main {

	public static void main(String[] args) {
		
		KApp KApp = new KAppImpl();
		
		/*/
		 * A fõmenüben 3 menüpont volna,amikor majd megírjuk,hogy az adott menüpont mit csinál,
		 * akkor ott íratjuk ki:
		 * 
		 * 1.Új doktor
		 * 2.Új beteg
		 * 3.Új szakrendelés(kezelõ)
		 * 4.Kezelés lemondás
		 * 
		 *  Amit az adott menponton belül választ egy Scanner-rel,akkor azt behívja, és utána történik az adatfelvitel
		 */

		
		//		Scanner scanner;
//		int status = 0;
//		while (status != 3) {
//			System.out.println("\n----------Üdvözöljük Klinikánkon!----------");
//			System.out.println("#################### MENÜ ####################");
//			System.out.println("1.- Új esemény rögzítése");
//			System.out.println("2.- Keresés");
//			System.out.println("3.- Kilépés");
//
//			scanner = new Scanner(System.in);
//			try {
//				status = scanner.nextInt();
//			} catch (InputMismatchException e) {
//				System.err.println("Nem jó karaktert adtál meg!");
//				continue;
//			}
//			try {
//				switch (status) {
//				case 1:
//					break;
//				case 2:
//					break;
//				case 3:
//					break;
//
//				}
//			} catch (Exception e) {
//				System.out.println("Hiba a végrehajtásban!");
//			}
//
//		}

//		Integer szakrendeles = 2;
//		String orvos = "Lapási Pál";
//		KApp.ujOrvosFelvetele(szakrendeles, orvos);
		
//		KApp.szakrendelesListaz();
//		KApp.datumMentes();
		KApp.betegFelvetel();

	
		
	}
}
