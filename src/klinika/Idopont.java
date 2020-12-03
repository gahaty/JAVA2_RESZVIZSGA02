package klinika;

public class Idopont {

	
	Integer id;
	String idopont;
	
	public Idopont() {
	}
	
	public Idopont(Integer id, String idopont) {
		
		this.id = id;
		this.idopont = idopont;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdopont() {
		return idopont;
	}

	public void setIdopont(String idopont) {
		this.idopont = idopont;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idopont == null) ? 0 : idopont.hashCode());
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
		Idopont other = (Idopont) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return this.id +" -> "+ this.idopont;
	}
}
