package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.KApp;
import klinika.Betegek;
import klinika.Orvosok;
import klinika.Vizit;
import repository.Repository;

public class KAppImpl implements KApp{
	

	@Override
	public void ujOrvosFelvetele(int szakr_id, String orvos) {
		Repository repo = new Repository();
		
		Orvosok orvosok = new Orvosok(szakr_id, orvos);
		boolean ellenorzes = repo.ellenorzes("orvosok","nev","Tóth Andor");
		System.out.println(ellenorzes);
		if (ellenorzes == false) {
		repo.ujOrvos(orvosok);

		System.out.println("Adatbázisba mentve.");
		}
		else{
			System.out.println("Már benne van.");
		}
	}
	
	@Override
	public void betegFelvetel() {
		Repository repo = new Repository();
		repo.idopontTablaMegjelenitAlapertelmezett();
		Scanner sc = new Scanner(System.in);
	
		// 1. Melyik osztályra kér idõpontot? //Globális változó
		System.out.println("Melyk osztályra kér idõpontot?\n");
		
		
		repo.szakrendelesekLekerdezes();
		Integer szakrendelesId = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		// 2. Melyik dátumra?
		System.out.println("Melyik napra kér idõpontot? (pl.: 2020.12.08.)");
		
		String bekertDatum = sc.next();
		
		Integer datumId = 0;
		datumId = repo.datumIdLekerdezes(bekertDatum);
		
		List<Integer> idopontBeGyujt = new ArrayList<>();
		idopontBeGyujt.add(0);
		
		if (datumId == 0) {
			repo.ujDatum(bekertDatum);
			datumId = repo.datumIdLekerdezes(bekertDatum);
			repo.idopontTablaMegjelenitAlapertelmezett();
			repo.idopontTablaLekerdezes();
		}
		else {
		//Ha datumLekerdezes = 0 akkor nincs ilyen dátum a rendszerben.
		//Felvesszük a dátumot.
		System.out.println(datumId+"\n");
		
		//3. idõpont vizsglat
		//minden idõponra készítünk egy lekérdezést 
		//repo.idopontTablaMegjelenit();
		//vizsgáljuk(COUNT(*)): kezelok, orvosok HA bármelyik 0, idõpont kihúz
		//adatbázisban idopont tábla -> megjelenit oszlop beállít
		
//		List<Integer> idopontBeGyujt = new ArrayList<>();
//		idopontBeGyujt.add(0);
			
		Integer idopont1 = 1;
		Integer idopontVizsgalat1 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont1);
		//System.out.println(idopontVizsgalat1);
		idopontBeGyujt.add(idopontVizsgalat1);

		Integer idopont2 = 2;
		Integer idopontVizsgalat2 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont2);
		//System.out.println(idopontVizsgalat2);
		idopontBeGyujt.add(idopontVizsgalat2);


		Integer idopont3 = 3;
		Integer idopontVizsgalat3 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont3);
		//System.out.println(idopontVizsgalat3);
		idopontBeGyujt.add(idopontVizsgalat3);

		
		Integer idopont4 = 4;
		Integer idopontVizsgalat4 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont4);
		//System.out.println(idopontVizsgalat4);
		idopontBeGyujt.add(idopontVizsgalat4);


		Integer idopont5 = 5;
		Integer idopontVizsgalat5 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont5);
		//System.out.println(idopontVizsgalat5);
		idopontBeGyujt.add(idopontVizsgalat5);


		Integer idopont6 = 6;
		Integer idopontVizsgalat6 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont6);
		//System.out.println(idopontVizsgalat6);
		idopontBeGyujt.add(idopontVizsgalat6);

		
		Integer idopont7 = 7;
		Integer idopontVizsgalat7 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont7);
		//System.out.println(idopontVizsgalat7);
		idopontBeGyujt.add(idopontVizsgalat7);

		
		Integer idopont8 = 8;
		Integer idopontVizsgalat8 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont8);
		//System.out.println(idopontVizsgalat8);
		idopontBeGyujt.add(idopontVizsgalat8);

		
		Integer idopont9 = 9;
		Integer idopontVizsgalat9 = repo.idopontVizsgalat(szakrendelesId, datumId, idopont9);
		//System.out.println(idopontVizsgalat9);
		idopontBeGyujt.add(idopontVizsgalat9);
		
		
		//4. Itt már csak a választható idõpontra készítünk lekérdezést
		
		System.out.println("Kiir lista");
		for (Integer integer : idopontBeGyujt) {
			System.out.println(integer);
		}

		repo.idopontTablaMegjelenitBeallit(idopontBeGyujt);
		repo.idopontTablaLekerdezes();
		}
		
		System.out.println("Kérek egy idõpont id-t!");
		
		
		Integer idopontId = sc.nextInt();
		
		// vizsgáljuk(táblaösszehasonlítással): kezelok, orvosok
		// lekérdezések (List): kezelok, orvosok -> visszaadja amik jelölhetõk a szabad helyek függvényében.
		repo.kezelokLekerdezes(szakrendelesId, datumId, idopontId);
		
		System.out.println("Kérek egy kezelõ id-t!");
		Integer kezelokId = sc.nextInt();
		
		repo.orvosokLekerdezes(szakrendelesId, datumId, idopontId);
		System.out.println("Kérek egy orvos id-t!");
		Integer orvosokId = sc.nextInt();
		sc.nextLine();
		//5. beteg adatainak bekérése,
		System.out.println("Kérem a beteg nevét!");
		String betegNeve = sc.nextLine();
		System.out.println("Kérem a beteg címét!");
		String betegCime = sc.nextLine();
		System.out.println("Kérem a beteg telefonszámát!");
		Integer betegTelSzama = sc.nextInt();
		System.out.println("Kérem a beteg e-mail címét!");
		String betegEmail = sc.next();
		sc.nextLine();
		System.out.println("Kérem a hozzátartozó nevét!");
		String hozzatartozoNeve = sc.nextLine();
		System.out.println("Kérem a hozzátartozó címét!");
		String hozzatartozoCime = sc.nextLine();
		System.out.println("Kérem a hozzátartozó telefonszámát!");
		Integer hozzatartozoTelSzama = sc.nextInt();
		System.out.println("Kérem a hozzátartozó e-mail címét!");
		String hozzatartozoEmail = sc.next();
		
		Betegek beteg = new Betegek(betegNeve, betegCime, betegTelSzama, betegEmail, hozzatartozoNeve, hozzatartozoCime, hozzatartozoTelSzama, hozzatartozoEmail);
		boolean ellenorzes = repo.ellenorzes("betegek","nev",betegNeve);
		//System.out.println(ellenorzes);
		if (ellenorzes == false) {
		repo.ujBeteg(beteg);
		System.out.println("Adatbázisba mentve.");
		}
		else{
			System.out.println("Már benne van.");
		}
		
		//6. hozzáadása a vizit táblához 
		Integer betegekId = repo.betegLekerdezes(betegNeve);
//		System.out.println(betegekId);
		
		Vizit vizit = new Vizit(szakrendelesId, orvosokId, kezelokId, datumId, idopontId, betegekId);
		repo.betegVizit(vizit);
		sc.close();
		repo.closeConnection();
	}
}
