package goodwine.server.pojos;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class BottigliaAggiornataId implements Serializable {
	private Long idBottiglia;
	private Long dataRegistrazione;
	
	public Long getIdBottiglia() {
		return idBottiglia;
	}
	public void setIdBottiglia(Long idBottiglia) {
		this.idBottiglia = idBottiglia;
	}
	public Long getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(Long dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRegistrazione == null) ? 0 : dataRegistrazione.hashCode());
		result = prime * result + ((idBottiglia == null) ? 0 : idBottiglia.hashCode());
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
		BottigliaAggiornataId other = (BottigliaAggiornataId) obj;
		if (dataRegistrazione == null) {
			if (other.dataRegistrazione != null)
				return false;
		} else if (!dataRegistrazione.equals(other.dataRegistrazione))
			return false;
		if (idBottiglia == null) {
			if (other.idBottiglia != null)
				return false;
		} else if (!idBottiglia.equals(other.idBottiglia))
			return false;
		return true;
	}
	
	
}
