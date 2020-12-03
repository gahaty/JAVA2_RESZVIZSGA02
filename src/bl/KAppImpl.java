package bl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import interfaces.KApp;
import klinika.Betegek;
import klinika.Kezelok;
import klinika.Orvosok;
import klinika.Vizit;
import repository.Repository;

public class KAppImpl implements KApp {
	Scanner sc = new Scanner(System.in);

//	public static String orvos = null;

	@Override
	public void ujOrvosFelvetele() {
		Repository repo = new Repository();

		sc = new Scanner(System.in);
		System.out.println("K�rem adja meg a Szakrendel�st,melyre felk�v�nja venni az orvost!");
		Integer szakr_id = sc.nextInt();
		sc.nextLine();
		sc = new Scanner(System.in);
		System.out.println("Adja meg az orvos nev�t!");
		String orvos = sc.nextLine();

		System.out.println(orvos);
		Orvosok orvosok = new Orvosok(szakr_id, orvos);
		boolean ellenorzes = repo.ellenorzes("orvosok", "nev", orvos);
//		System.out.println(ellenorzes);
		if (ellenorzes == false) {
			repo.ujOrvos(orvosok);
			System.out.println("Adatb�zisba mentve.");
		} else {
			System.out.println("M�r benne van.");
		}
		repo.closeConnection();
	}

	@Override
	public void betegFelvetel() {
		Repository repo = new Repository();
		repo.idopontTablaMegjelenitBeallitAlapertelmezettre();

		Scanner sc = new Scanner(System.in);

		Integer szakrendelesId = null;
		boolean result;

		do {
			result = false;
			try {
				repo.szakrendelesekLekerdezes();
				System.out.println();
				System.out.println("Melyik oszt�lyra k�r id�pontot?");
				szakrendelesId = sc.nextInt();
				if (szakrendelesId >= 1 && szakrendelesId <= 10) {
					result = true;
				} else {
					System.out.println("hib�s adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				// System.err.println("Nem j� karaktert adt�l meg!");
			}
		} while (result != true);

		boolean ellenorzes1 = repo.ellenorzes("kezelok", "szakr_id", String.valueOf(szakrendelesId));
		boolean ellenorzes2 = repo.ellenorzes("orvosok", "szakr_id", String.valueOf(szakrendelesId));

		if (ellenorzes1 || ellenorzes2) {

			Boolean vanSzabadIdopont = false;
			Integer datumId = 0;
			do {
				System.out.println("Melyik napra k�r id�pontot? (pl.: 2020.12.08.)");

				String bekertDatum = sc.next();

				datumId = repo.datumIdLekerdezes(bekertDatum);

				if (datumId == 0) {
					repo.ujDatum(bekertDatum);
					datumId = repo.datumIdLekerdezes(bekertDatum);
				}

				List<Boolean> idopontBeGyujt = new ArrayList<>();
				idopontBeGyujt.add(false);

				for (int idopont = 1; idopont < 10; idopont++) {
					Boolean idopontVizsgalat = repo.idopontVizsgalat(szakrendelesId, datumId, idopont);
					idopontBeGyujt.add(idopontVizsgalat);
				}
				vanSzabadIdopont = repo.szabadIdopontEllenorzes(vanSzabadIdopont, idopontBeGyujt);
				repo.idopontTablaMegjelenitBeallit(idopontBeGyujt);
				
			} while (!vanSzabadIdopont);
			//betegekAvizitTablaba(repo, sc, szakrendelesId, datumId);
			Integer idopontId = null;
			Integer kezelokId = null;
			Integer orvosokId = null;

			repo.idopontTablaLekerdezes();
			System.out.println("K�rek egy id�pont id-t!");
			idopontId = sc.nextInt();
			System.out.println(idopontId);
			repo.kezelokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
			System.out.println("K�rek egy kezel� id-t!");
			
			kezelokId = sc.nextInt();
			System.out.println(kezelokId);
			repo.orvosokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
			System.out.println("K�rek egy orvos id-t!");
			orvosokId = sc.nextInt();
			System.out.println(orvosokId);
			sc.nextLine();

			System.out.println("K�rem a beteg nev�t!");
			String betegNeve = sc.nextLine();
			System.out.println(betegNeve);
			System.out.println("K�rem a beteg c�m�t!");
			String betegCime = sc.nextLine();
			System.out.println(betegCime);
			System.out.println("K�rem a beteg telefonsz�m�t!");
			Integer betegTelSzama = sc.nextInt();
			System.out.println(betegTelSzama);
			sc.nextLine();
			System.out.println("K�rem a beteg e-mail c�m�t!");
			
			String betegEmail = sc.next();
			 sc.nextLine();
			System.out.println(betegEmail);
			
			System.out.println("K�rem a hozz�tartoz� nev�t!");
			String hozzatartozoNeve = sc.nextLine();
			System.out.println(hozzatartozoNeve);
			System.out.println("K�rem a hozz�tartoz� c�m�t!");
			String hozzatartozoCime = sc.nextLine();
			System.out.println(hozzatartozoCime);
			System.out.println("K�rem a hozz�tartoz� telefonsz�m�t!");
			Integer hozzatartozoTelSzama = sc.nextInt();
			System.out.println(hozzatartozoTelSzama);
			sc.nextLine();
			System.out.println("K�rem a hozz�tartoz� e-mail c�m�t!");
			String hozzatartozoEmail = sc.nextLine();
			System.out.println(hozzatartozoEmail);

			
			Betegek beteg = new Betegek(betegNeve, betegCime, betegTelSzama, betegEmail, hozzatartozoNeve, hozzatartozoCime,
					hozzatartozoTelSzama, hozzatartozoEmail);
			
			System.out.println(beteg);
			
//			boolean ellenorzes = repo.ellenorzes("betegek", "nev", betegNeve);
//			if (ellenorzes == false) {
//				
//				System.out.println("A beteg adatb�zisba mentve.");
//			} else {
//				// System.out.println("M�r benne van.");
//			}
			repo.ujBeteg(beteg);

			Integer betegekId = repo.betegLekerdezes(betegNeve);

			Vizit vizit = new Vizit(szakrendelesId, orvosokId, kezelokId, datumId, idopontId, betegekId);
			System.out.println(vizit);
			repo.betegVizit(vizit);
			System.out.println("A beteg vizitre el�jegyezve.");
			repo.closeConnection();
		}
		else {
			System.out.println("Nincs az adott oszt�lyon kezel� �s/vagy orvos!");
		}
	}

//	private void betegekAvizitTablaba(Repository repo, Scanner sc, Integer szakrendelesId, Integer datumId) {
//		
//		Integer idopontId = null;
//		Integer kezelokId = null;
//		Integer orvosokId = null;
//
//		repo.idopontTablaLekerdezes();
//		System.out.println("K�rek egy id�pont id-t!");
//		idopontId = sc.nextInt();
//		System.out.println(idopontId);
//		repo.kezelokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
//		System.out.println("K�rek egy kezel� id-t!");
//		
//		kezelokId = sc.nextInt();
//		System.out.println(kezelokId);
//		repo.orvosokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
//		System.out.println("K�rek egy orvos id-t!");
//		orvosokId = sc.nextInt();
//		System.out.println(orvosokId);
//		sc.nextLine();
//
//		System.out.println("K�rem a beteg nev�t!");
//		String betegNeve = sc.nextLine();
//		System.out.println(betegNeve);
//		System.out.println("K�rem a beteg c�m�t!");
//		String betegCime = sc.nextLine();
//		System.out.println(betegCime);
//		System.out.println("K�rem a beteg telefonsz�m�t!");
//		Integer betegTelSzama = sc.nextInt();
//		System.out.println(betegTelSzama);
//		sc.nextLine();
//		System.out.println("K�rem a beteg e-mail c�m�t!");
//		
//		String betegEmail = sc.next();
//		 sc.nextLine();
//		System.out.println(betegEmail);
//		
//		System.out.println("K�rem a hozz�tartoz� nev�t!");
//		String hozzatartozoNeve = sc.nextLine();
//		System.out.println(hozzatartozoNeve);
//		System.out.println("K�rem a hozz�tartoz� c�m�t!");
//		String hozzatartozoCime = sc.nextLine();
//		System.out.println(hozzatartozoCime);
//		System.out.println("K�rem a hozz�tartoz� telefonsz�m�t!");
//		Integer hozzatartozoTelSzama = sc.nextInt();
//		System.out.println(hozzatartozoTelSzama);
//		sc.nextLine();
//		System.out.println("K�rem a hozz�tartoz� e-mail c�m�t!");
//		String hozzatartozoEmail = sc.nextLine();
//		System.out.println(hozzatartozoEmail);
//
//		
//		Betegek beteg = new Betegek(betegNeve, betegCime, betegTelSzama, betegEmail, hozzatartozoNeve, hozzatartozoCime,
//				hozzatartozoTelSzama, hozzatartozoEmail);
//		
//		System.out.println(beteg);
//		
////		boolean ellenorzes = repo.ellenorzes("betegek", "nev", betegNeve);
////		if (ellenorzes == false) {
////			
////			System.out.println("A beteg adatb�zisba mentve.");
////		} else {
////			// System.out.println("M�r benne van.");
////		}
//		repo.ujBeteg(beteg);
//
//		Integer betegekId = repo.betegLekerdezes(betegNeve);
//
//		Vizit vizit = new Vizit(szakrendelesId, orvosokId, kezelokId, datumId, idopontId, betegekId);
//		System.out.println(vizit);
//		repo.betegVizit(vizit);
//		System.out.println("A beteg vizitre el�jegyezve.");
//		//sc.close();
//		repo.closeConnection();
//	}

	@Override
	public void ujEsemeny() {
		System.out.println("�j esem�ny r�gz�t�se:");
		System.out.println("1. �j orvos felv�tele");
		System.out.println("2. �j beteg felv�tele");
		System.out.println("3. �j kezel� felv�tele");
		System.out.println("4. Kezel�s lemond�sa");// n�v alapj�n
		System.out.println("0. Visszal�p�s az el�z� men�be");
		
	}

	@Override
	public void Kereses() {
		System.out.println("Keres�s:");
		System.out.println("1. Szakrendel�sek list�z�sa");
		System.out.println("2. Betegek list�z�sa");
		System.out.println("3. Orvosok list�z�sa");
		//System.out.println("4. Szakrendel�k list�z�sa");
		System.out.println("0. Visszal�p�s az el�z� men�be");
		
	}

	@Override
	public void ujKezeloFelvetel() {
		Repository repo = new Repository();

		sc = new Scanner(System.in);
		System.out.println("K�rem adja meg az oszt�lyt,melyhez hozz� szeretn� rendelni a kezel�t!");
		Integer szakr_id = sc.nextInt();
		sc.nextLine();
		sc = new Scanner(System.in);
		System.out.println("Adja meg a kezel�t!");
		String rendelo = sc.nextLine();
		sc = new Scanner(System.in);
		System.out.println("Milyen kezel�sek legyenek benne?");
		String kezeles = sc.nextLine();

		Kezelok kezelo = new Kezelok(szakr_id, rendelo, kezeles);
		//boolean ellenorzes = repo.ellenorzes("kezelok", "rendelo",);
		//System.out.println(ellenorzes);
		//if (ellenorzes == false) {
			repo.ujKezelo(kezelo);
		//	System.out.println("Adatb�zisba mentve.");
		//} else {
		//	System.out.println("M�r benne van.");
		//}
		repo.closeConnection();
		
	}

	@Override
	public void kezelesLemondasa() {
		Repository repo = new Repository();
		String nev = null;
//		Scanner sc = new Scanner(System.in);

		System.out.println("Add meg a kezel�shez tartoz� nevet!");
		nev = sc.nextLine();
		Integer id = repo.betegLekerdezes(nev);
		if (id != null) {
			repo.kezelesLemondasa(id);
		}
		repo.closeConnection();
		
	}

	@Override
	public void szakrendelesLekerdezes() {
		Repository repo = new Repository();
		repo.szakrendelesekLekerdezes();
		repo.closeConnection();
		
	}

	@Override
	public void vizitBetegekLekerdezes() {
		Repository repo = new Repository();
		repo.vizitBetegekLekerdezes();
		repo.closeConnection();
		
	}

	@Override
	public void orvosLekerdezes() {
		Repository repo = new Repository();
		repo.orvosLekerdezes();
		repo.closeConnection();
		
	}
}
