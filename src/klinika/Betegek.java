package klinika;

public class Betegek {

	private String nev;
	private String cim;
	private Integer tel;
	private String email;
	private String ht_nev;
	private String ht_cim;
	private Integer ht_tel;
	private String ht_email;

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHt_nev() {
		return ht_nev;
	}

	public void setHt_nev(String ht_nev) {
		this.ht_nev = ht_nev;
	}

	public String getHt_cim() {
		return ht_cim;
	}

	public void setHt_cim(String ht_cim) {
		this.ht_cim = ht_cim;
	}

	public Integer getHt_tel() {
		return ht_tel;
	}

	public void setHt_tel(Integer ht_tel) {
		this.ht_tel = ht_tel;
	}

	public String getHt_email() {
		return ht_email;
	}

	public void setHt_email(String ht_email) {
		this.ht_email = ht_email;
	}

	public Betegek(String nev, String cim, Integer tel, String email, String ht_nev, String ht_cim, Integer ht_tel,
			String ht_email) {
		this.nev = nev;
		this.cim = cim;
		this.tel = tel;
		this.email = email;
		this.ht_nev = ht_nev;
		this.ht_cim = ht_cim;
		this.ht_tel = ht_tel;
		this.ht_email = ht_email;
	}

	public Betegek() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cim == null) ? 0 : cim.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ht_cim == null) ? 0 : ht_cim.hashCode());
		result = prime * result + ((ht_email == null) ? 0 : ht_email.hashCode());
		result = prime * result + ((ht_nev == null) ? 0 : ht_nev.hashCode());
		result = prime * result + ((ht_tel == null) ? 0 : ht_tel.hashCode());
		result = prime * result + ((nev == null) ? 0 : nev.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Betegek other = (Betegek) obj;
		if (cim == null) {
			if (other.cim != null)
				return false;
		} else if (!cim.equals(other.cim))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ht_cim == null) {
			if (other.ht_cim != null)
				return false;
		} else if (!ht_cim.equals(other.ht_cim))
			return false;
		if (ht_email == null) {
			if (other.ht_email != null)
				return false;
		} else if (!ht_email.equals(other.ht_email))
			return false;
		if (ht_nev == null) {
			if (other.ht_nev != null)
				return false;
		} else if (!ht_nev.equals(other.ht_nev))
			return false;
		if (ht_tel == null) {
			if (other.ht_tel != null)
				return false;
		} else if (!ht_tel.equals(other.ht_tel))
			return false;
		if (nev == null) {
			if (other.nev != null)
				return false;
		} else if (!nev.equals(other.nev))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Betegek [nev=" + nev + ", cim=" + cim + ", tel=" + tel + ", email=" + email + ", ht_nev=" + ht_nev
				+ ", ht_cim=" + ht_cim + ", ht_tel=" + ht_tel + ", ht_email=" + ht_email + "]";
	}
}
