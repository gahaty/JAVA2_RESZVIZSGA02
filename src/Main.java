import bl.KAppImpl;
import interfaces.KApp;

public class Main {

	public static void main(String[] args) {
		
		KApp KApp = new KAppImpl();
		
		/*/
		 * A f�men�ben 3 men�pont volna,amikor majd meg�rjuk,hogy az adott men�pont mit csin�l,
		 * akkor ott �ratjuk ki:
		 * 
		 * 1.�j doktor
		 * 2.�j beteg
		 * 3.�j szakrendel�s(kezel�)
		 * 4.Kezel�s lemond�s
		 * 
		 *  Amit az adott menponton bel�l v�laszt egy Scanner-rel,akkor azt beh�vja, �s ut�na t�rt�nik az adatfelvitel
		 */

		
		//		Scanner scanner;
//		int status = 0;
//		while (status != 3) {
//			System.out.println("\n----------�dv�z�lj�k Klinik�nkon!----------");
//			System.out.println("#################### MEN� ####################");
//			System.out.println("1.- �j esem�ny r�gz�t�se");
//			System.out.println("2.- Keres�s");
//			System.out.println("3.- Kil�p�s");
//
//			scanner = new Scanner(System.in);
//			try {
//				status = scanner.nextInt();
//			} catch (InputMismatchException e) {
//				System.err.println("Nem j� karaktert adt�l meg!");
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
//				System.out.println("Hiba a v�grehajt�sban!");
//			}
//
//		}

//		Integer szakrendeles = 2;
//		String orvos = "Lap�si P�l";
//		KApp.ujOrvosFelvetele(szakrendeles, orvos);
		
//		KApp.szakrendelesListaz();
//		KApp.datumMentes();
		KApp.betegFelvetel();

	
		
	}
}
