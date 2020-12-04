package klinika;

public class vizitLekerdez {

	private Integer id;
	private String osztaly;
	private String orvos;
	private Integer rendelo;
	private String datum;
	private String idopont;
	private String betegNev;

	public vizitLekerdez() {
	}

	public vizitLekerdez(Integer id, String osztaly) {
		this.id = id;
		this.osztaly = osztaly;
	}

	public vizitLekerdez(Integer id, String osztaly, String orvos, Integer rendelo, String datum, String idopont,
			String betegNev) {
	
		this.id = id;
		this.osztaly = osztaly;
		this.orvos = orvos;
		this.rendelo = rendelo;
		this.datum = datum;
		this.idopont = idopont;
		this.betegNev = betegNev;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOsztaly() {
		return osztaly;
	}

	public void setOsztaly(String osztaly) {
		this.osztaly = osztaly;
	}

	public String getOrvos() {
		return orvos;
	}

	public void setOrvos(String orvos) {
		this.orvos = orvos;
	}

	public Integer getRendelo() {
		return rendelo;
	}

	public void setRendelo(Integer rendelo) {
		this.rendelo = rendelo;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getIdopont() {
		return idopont;
	}

	public void setIdopont(String idopont) {
		this.idopont = idopont;
	}

	public String getBetegNev() {
		return betegNev;
	}

	public void setBetegNev(String betegNev) {
		this.betegNev = betegNev;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((betegNev == null) ? 0 : betegNev.hashCode());
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idopont == null) ? 0 : idopont.hashCode());
		result = prime * result + ((orvos == null) ? 0 : orvos.hashCode());
		result = prime * result + ((osztaly == null) ? 0 : osztaly.hashCode());
		result = prime * result + ((rendelo == null) ? 0 : rendelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vizitLekerdez other = (vizitLekerdez) obj;
		if (betegNev == null) {
			if (other.betegNev != null)
				return false;
		} else if (!betegNev.equals(other.betegNev))
			return false;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idopont == null) {
			if (other.idopont != null)
				return false;
		} else if (!idopont.equals(other.idopont))
			return false;
		if (orvos == null) {
			if (other.orvos != null)
				return false;
		} else if (!orvos.equals(other.orvos))
			return false;
		if (osztaly == null) {
			if (other.osztaly != null)
				return false;
		} else if (!osztaly.equals(other.osztaly))
			return false;
		if (rendelo == null) {
			if (other.rendelo != null)
				return false;
		} else if (!rendelo.equals(other.rendelo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + "\t" + osztaly + "\t" + orvos + "\t" + rendelo + "\t" + datum + "\t" + idopont + "\t" + betegNev;
	}
}
