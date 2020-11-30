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
		boolean ellenorzes = repo.ellenorzes("orvosok","nev","T�th Andor");
		System.out.println(ellenorzes);
		if (ellenorzes == false) {
		repo.ujOrvos(orvosok);

		System.out.println("Adatb�zisba mentve.");
		}
		else{
			System.out.println("M�r benne van.");
		}
	}
	
	@Override
	public void betegFelvetel() {
		Repository repo = new Repository();
		repo.idopontTablaMegjelenitAlapertelmezett();
		Scanner sc = new Scanner(System.in);
	
		// 1. Melyik oszt�lyra k�r id�pontot? //Glob�lis v�ltoz�
		System.out.println("Melyk oszt�lyra k�r id�pontot?\n");
		
		
		repo.szakrendelesekLekerdezes();
		Integer szakrendelesId = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		// 2. Melyik d�tumra?
		System.out.println("Melyik napra k�r id�pontot? (pl.: 2020.12.08.)");
		
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
		//Ha datumLekerdezes = 0 akkor nincs ilyen d�tum a rendszerben.
		//Felvessz�k a d�tumot.
		System.out.println(datumId+"\n");
		
		//3. id�pont vizsglat
		//minden id�ponra k�sz�t�nk egy lek�rdez�st 
		//repo.idopontTablaMegjelenit();
		//vizsg�ljuk(COUNT(*)): kezelok, orvosok HA b�rmelyik 0, id�pont kih�z
		//adatb�zisban idopont t�bla -> megjelenit oszlop be�ll�t
		
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
		
		
		//4. Itt m�r csak a v�laszthat� id�pontra k�sz�t�nk lek�rdez�st
		
		System.out.println("Kiir lista");
		for (Integer integer : idopontBeGyujt) {
			System.out.println(integer);
		}

		repo.idopontTablaMegjelenitBeallit(idopontBeGyujt);
		repo.idopontTablaLekerdezes();
		}
		
		System.out.println("K�rek egy id�pont id-t!");
		
		
		Integer idopontId = sc.nextInt();
		
		// vizsg�ljuk(t�bla�sszehasonl�t�ssal): kezelok, orvosok
		// lek�rdez�sek (List): kezelok, orvosok -> visszaadja amik jel�lhet�k a szabad helyek f�ggv�ny�ben.
		repo.kezelokLekerdezes(szakrendelesId, datumId, idopontId);
		
		System.out.println("K�rek egy kezel� id-t!");
		Integer kezelokId = sc.nextInt();
		
		repo.orvosokLekerdezes(szakrendelesId, datumId, idopontId);
		System.out.println("K�rek egy orvos id-t!");
		Integer orvosokId = sc.nextInt();
		sc.nextLine();
		//5. beteg adatainak bek�r�se,
		System.out.println("K�rem a beteg nev�t!");
		String betegNeve = sc.nextLine();
		System.out.println("K�rem a beteg c�m�t!");
		String betegCime = sc.nextLine();
		System.out.println("K�rem a beteg telefonsz�m�t!");
		Integer betegTelSzama = sc.nextInt();
		System.out.println("K�rem a beteg e-mail c�m�t!");
		String betegEmail = sc.next();
		sc.nextLine();
		System.out.println("K�rem a hozz�tartoz� nev�t!");
		String hozzatartozoNeve = sc.nextLine();
		System.out.println("K�rem a hozz�tartoz� c�m�t!");
		String hozzatartozoCime = sc.nextLine();
		System.out.println("K�rem a hozz�tartoz� telefonsz�m�t!");
		Integer hozzatartozoTelSzama = sc.nextInt();
		System.out.println("K�rem a hozz�tartoz� e-mail c�m�t!");
		String hozzatartozoEmail = sc.next();
		
		Betegek beteg = new Betegek(betegNeve, betegCime, betegTelSzama, betegEmail, hozzatartozoNeve, hozzatartozoCime, hozzatartozoTelSzama, hozzatartozoEmail);
		boolean ellenorzes = repo.ellenorzes("betegek","nev",betegNeve);
		//System.out.println(ellenorzes);
		if (ellenorzes == false) {
		repo.ujBeteg(beteg);
		System.out.println("Adatb�zisba mentve.");
		}
		else{
			System.out.println("M�r benne van.");
		}
		
		//6. hozz�ad�sa a vizit t�bl�hoz 
		Integer betegekId = repo.betegLekerdezes(betegNeve);
//		System.out.println(betegekId);
		
		Vizit vizit = new Vizit(szakrendelesId, orvosokId, kezelokId, datumId, idopontId, betegekId);
		repo.betegVizit(vizit);
		sc.close();
		repo.closeConnection();
	}
}
