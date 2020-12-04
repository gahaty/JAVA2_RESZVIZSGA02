package klinika;

public class Orvosok {

	private Integer id;
	private String nev;
	private Integer szakr_id;

	public Orvosok() {
	}

	public Orvosok(String nev) {
		this.nev = nev;
	}

	public Orvosok(String nev, Integer id) {
		this.id = id;
		this.nev = nev;
	}

	public Orvosok(Integer szakr_id, String nev) {
		this.szakr_id = szakr_id;
		this.nev = nev;
	}

	public Orvosok(Integer id, String nev, Integer szakr_id) {
		this.id = id;
		this.nev = nev;
		this.szakr_id = szakr_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public Integer getSzakr_id() {
		return szakr_id;
	}

	public void setSzakr_id(Integer szakr_id) {
		this.szakr_id = szakr_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nev == null) ? 0 : nev.hashCode());
		result = prime * result + ((szakr_id == null) ? 0 : szakr_id.hashCode());
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
		Orvosok other = (Orvosok) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nev == null) {
			if (other.nev != null)
				return false;
		} else if (!nev.equals(other.nev))
			return false;
		if (szakr_id == null) {
			if (other.szakr_id != null)
				return false;
		} else if (!szakr_id.equals(other.szakr_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + this.id + " -> " + this.nev + "";
	}
}
