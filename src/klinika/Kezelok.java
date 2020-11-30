package klinika;

public class Kezelok {

	Integer id;
	Integer szakr_id;
	String rendelo;
	
	public Kezelok() {}
	
	public Kezelok(Integer id, Integer szakr_id, String rendelo) {
		
		this.id = id;
		this.szakr_id = szakr_id;
		this.rendelo = rendelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSzakr_id() {
		return szakr_id;
	}

	public void setSzakr_id(Integer szakr_id) {
		this.szakr_id = szakr_id;
	}

	public String getRendelo() {
		return rendelo;
	}

	public void setRendelo(String rendelo) {
		this.rendelo = rendelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rendelo == null) ? 0 : rendelo.hashCode());
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
		Kezelok other = (Kezelok) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rendelo == null) {
			if (other.rendelo != null)
				return false;
		} else if (!rendelo.equals(other.rendelo))
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
		return "Kezelok [id=" + id + ", szakr_id=" + szakr_id + ", rendelo=" + rendelo + "]";
	}
	
	
	

	
}
