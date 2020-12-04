package bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import interfaces.KApp;
import klinika.Betegek;
import klinika.Kezelok;
import klinika.Orvosok;
import klinika.Vizit;
import klinika.vizitLekerdez;
import repository.Repository;

public class KAppImpl implements KApp {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void ujOrvosFelvetele() {
		Repository repo = new Repository();

		System.out.println("Kérem adja meg a Szakrendelést,melyre felkívánja venni az orvost!");
		Integer szakr_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Adja meg az orvos nevét!");
		String orvos = sc.nextLine();
		System.out.println(orvos);
		Orvosok orvosok = new Orvosok(szakr_id, orvos);
		boolean ellenorzes = repo.ellenorzes("orvosok", "nev", orvos);
		if (ellenorzes == false) {
			repo.ujOrvos(orvosok);
			System.out.println("Adatbázisba mentve.");
		} else {
			System.out.println("Már benne van.");
		}
		repo.closeConnection();
	}

	@Override
	public void betegFelvetel() {
		Repository repo = new Repository();
		repo.idopontTablaMegjelenitBeallitAlapertelmezettre();

		Integer szakrendelesId = null;
		boolean result;

		do {
			result = false;
			try {
				repo.szakrendelesekLekerdezesAmenuhoz();
				System.out.println();
				System.out.println("Melyik osztályra kér idõpontot?");
				szakrendelesId = sc.nextInt();
				if (szakrendelesId >= 1 && szakrendelesId <= 10) {
					result = true;
				} else {
					System.out.println("hibás adatbevitel!");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		} while (result != true);

		boolean kezelokEllenorzese = repo.ellenorzes("kezelok", "szakr_id", String.valueOf(szakrendelesId));
		boolean orvosokEllenorzese = repo.ellenorzes("orvosok", "szakr_id", String.valueOf(szakrendelesId));

		if (kezelokEllenorzese || orvosokEllenorzese) {

			Boolean vanSzabadIdopont = false;
			Integer datumId = 0;
			do {
				System.out.println("Melyik napra kér idõpontot? (pl.: 2020.12.08.)");

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

			Integer idopontId = null;
			Integer kezelokId = null;
			Integer orvosokId = null;

			repo.idopontTablaLekerdezes();
			System.out.println("Kérek egy idõpont id-t!");
			idopontId = sc.nextInt();
			repo.kezelokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
			System.out.println("Kérek egy kezelõ id-t!");
			kezelokId = sc.nextInt();
			repo.orvosokLekerdezeseAvizitTablaAlapjan(szakrendelesId, datumId, idopontId);
			System.out.println("Kérek egy orvos id-t!");
			orvosokId = sc.nextInt();
			sc.nextLine();
			System.out.println("Kérem a beteg nevét!");
			String betegNeve = sc.nextLine();
			System.out.println("Kérem a beteg címét!");
			String betegCime = sc.nextLine();
			System.out.println("Kérem a beteg telefonszámát!");
			Integer betegTelSzama = sc.nextInt();
			sc.nextLine();
			System.out.println("Kérem a beteg e-mail címét!");
			String betegEmail = sc.next();
			sc.nextLine();
			System.out.println("Kérem a hozzátartozó nevét!");
			String hozzatartozoNeve = sc.nextLine();
			System.out.println("Kérem a hozzátartozó címét!");
			String hozzatartozoCime = sc.nextLine();
			System.out.println("Kérem a hozzátartozó telefonszámát!");
			Integer hozzatartozoTelSzama = sc.nextInt();
			sc.nextLine();
			System.out.println("Kérem a hozzátartozó e-mail címét!");
			String hozzatartozoEmail = sc.nextLine();
			
			Betegek beteg = new Betegek(betegNeve, betegCime, betegTelSzama, betegEmail, hozzatartozoNeve, hozzatartozoCime,
					hozzatartozoTelSzama, hozzatartozoEmail);
			
			repo.ujBeteg(beteg);

			Integer betegekId = repo.betegLekerdezes(betegNeve);

			Vizit vizit = new Vizit(szakrendelesId, orvosokId, kezelokId, datumId, idopontId, betegekId);
			repo.betegVizit(vizit);
			System.out.println("A beteg vizitre elõjegyezve.");
			repo.closeConnection();
		}
		else {
			System.out.println("Nincs az adott osztályon kezelõ és/vagy orvos!");
		}
	}

	@Override
	public void ujEsemeny() {
		System.out.println("Új esemény rögzítése:");
		System.out.println("1. Új orvos felvétele");
		System.out.println("2. Új beteg felvétele");
		System.out.println("3. Új kezelõ felvétele");
		System.out.println("4. Kezelés lemondása");
		System.out.println("0. Visszalépés az elõzõ menübe");
	}

	@Override
	public void Kereses() {
		System.out.println("Keresés:");
		System.out.println("1. Szakrendelések listázása");
		System.out.println("2. Betegek listázása");
		System.out.println("3. Orvosok listázása");
		System.out.println("0. Visszalépés az elõzõ menübe");	
	}

	@Override
	public void ujKezeloFelvetel() {
		Repository repo = new Repository();
		
		repo.szakrendelesekLekerdezesAmenuhoz();
		System.out.println("Kérem adja meg az osztályt,melyhez hozzá szeretné rendelni a kezelõt!");
		Integer szakr_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Meglévõ kezelõk listázása:\n");
		repo.kezelokLekerdezeseAmenuhoz();
		System.out.println("Adjon meg egy új kezelõt (Ne a listából)!");
		String rendelo = sc.nextLine();
		System.out.println("Milyen kezelések legyenek benne?");
		String kezeles = sc.nextLine();

		Kezelok kezelo = new Kezelok(szakr_id, rendelo, kezeles);

			repo.ujKezelo(kezelo);
		repo.closeConnection();
	}

	@Override
	public void szakrendelesLekerdezes() {
		Repository repo = new Repository();
		repo.szakrendelesekLekerdezesAmenuhoz();
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
		repo.orvosokLekerdezeseAmenuhoz();
		repo.closeConnection();
		
	}

	@Override
	public void kezelesLemondasa() {
		Repository repo = new Repository();
		repo.vizitBetegekLekerdezes();
		Integer betegId = 0;
		System.out.println("\nAdd meg a páciens nevét!");
		String nev = sc.nextLine();
		betegId = repo.betegLekerdezes(nev);
		
		if (betegId != 0) {
			vizitLekerdez kezelesLemondasa = repo.kezelesLemondasahozLekerdezes(betegId);
			String datumkiolvas = kezelesLemondasa.getDatum();
			String idoKiolvas = kezelesLemondasa.getIdopont();
			
			String osszefuzKiolvasottAdatok = datumkiolvas.concat(" ").concat(idoKiolvas); 
			
			//System.out.println(datumkiolvas);
			//System.out.println(idoKiolvas);
			
			LocalDate maiDatumLekerdez = LocalDate.now();
			String maiDatum = maiDatumLekerdez.toString();
			//System.out.println("maiDatum: " + maiDatum);
			
			DateTimeFormatter idoFormazo = DateTimeFormatter.ofPattern("hh:mm:ss");
			LocalTime pontosIdoLekerdez = LocalTime.now();
			String formazottIdo = idoFormazo.format(pontosIdoLekerdez);
			String pontosIdo = formazottIdo.toString();
			
			String osszefuzPillanatnyiAdatok = maiDatum.concat(" ").concat(pontosIdo);
			//System.out.println(osszefuzPillanatnyiAdatok);
			
			Long kiolvasottMilliSec = null;
			Long pillanatnyiMilliSec = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-DD hh:mm:ss");
			try {
				Date kiolvasottKonvertal = sdf.parse(osszefuzKiolvasottAdatok);
				Date pillanatnyiKonvertal = sdf.parse(osszefuzPillanatnyiAdatok);
				
				kiolvasottMilliSec = kiolvasottKonvertal.getTime();
				pillanatnyiMilliSec = pillanatnyiKonvertal.getTime();
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Long kiolvasottPilanatyniKulombseg = kiolvasottMilliSec - pillanatnyiMilliSec;
			Long ora24 = (24 * 60 * 60 * 1000L);
			
			//System.out.println(kiolvasottPilanatyniKulombseg);
			if (kiolvasottPilanatyniKulombseg > ora24) {
				repo.kezelesLemondasa(betegId);
				System.out.println(nev + " nevû páciens kezelése lemondva");
			}
			else {
				System.out.println("Idõpontlemondásra már nincs lehetõség!");
			}
		}
		else {
			System.out.println("Nincs ilyen nevû páciens!");
		}
		repo.closeConnection();
	}
}
