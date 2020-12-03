package klinika;

public class Vizit {

	Integer szakrendeles_id;
	Integer orvosok_id;
	Integer kezelok_id;
	Integer datum_id;
	Integer idopont_id;
	Integer betegek_id;
	Boolean aktiv;

	public Integer getSzakrendeles_id() {
		return szakrendeles_id;
	}

	public void setSzakrendeles_id(Integer szakrendeles_id) {
		this.szakrendeles_id = szakrendeles_id;
	}

	public Integer getOrvosok_id() {
		return orvosok_id;
	}

	public void setOrvosok_id(Integer orvosok_id) {
		this.orvosok_id = orvosok_id;
	}

	public Integer getKezelok_id() {
		return kezelok_id;
	}

	public void setKezelok_id(Integer kezelok_id) {
		this.kezelok_id = kezelok_id;
	}

	public Integer getDatum_id() {
		return datum_id;
	}

	public void setDatum_id(Integer datum_id) {
		this.datum_id = datum_id;
	}

	public Integer getIdopont_id() {
		return idopont_id;
	}

	public void setIdopont_id(Integer idopont_id) {
		this.idopont_id = idopont_id;
	}

	public Integer getBetegek_id() {
		return betegek_id;
	}

	public void setBetegek_id(Integer betegek_id) {
		this.betegek_id = betegek_id;
	}

	public Boolean getAktiv() {
		return aktiv;
	}

	public void setAktiv(Boolean aktiv) {
		this.aktiv = aktiv;
	}

	public Vizit(Integer szakrendeles_id, Integer orvosok_id, Integer kezelok_id, Integer datum_id, Integer idopont_id,
			Integer betegek_id, Boolean aktiv) {

		this.szakrendeles_id = szakrendeles_id;
		this.orvosok_id = orvosok_id;
		this.kezelok_id = kezelok_id;
		this.datum_id = datum_id;
		this.idopont_id = idopont_id;
		this.betegek_id = betegek_id;
		this.aktiv = aktiv;
	}
	
	public Vizit(Integer szakrendeles_id, Integer orvosok_id, Integer kezelok_id, Integer datum_id, Integer idopont_id,
			Integer betegek_id) {

		this.szakrendeles_id = szakrendeles_id;
		this.orvosok_id = orvosok_id;
		this.kezelok_id = kezelok_id;
		this.datum_id = datum_id;
		this.idopont_id = idopont_id;
		this.betegek_id = betegek_id;
	}

	public Vizit() {

	}

	@Override
	public String toString() {
		return "Vizit [szakrendeles_id=" + szakrendeles_id + ", orvosok_id=" + orvosok_id + ", kezelok_id=" + kezelok_id
				+ ", datum_id=" + datum_id + ", idopont_id=" + idopont_id + ", betegek_id=" + betegek_id + ", aktiv="
				+ aktiv + "]";
	}
	
	

}
