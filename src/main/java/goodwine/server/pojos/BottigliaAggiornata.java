package goodwine.server.pojos;
import java.io.Serializable;
import javax.persistence.*;

@Entity(name="bottigliaaggiornamenti")
public class BottigliaAggiornata implements Serializable {
	//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html 
	//QUERY CREATION di SPRING
	
	@EmbeddedId
	public BottigliaAggiornataId id;
	
	/*
	 * The @MapsId value correspond to the property name of the 
	 * embedded id object containing the associated entity's identifier.
	 */
	@MapsId("idBottiglia")
	@JoinColumn( name="idbottiglia_fk" )
	@ManyToOne
	public Bottiglia bottiglia;
	
	@Column(name="raggiuv")
	private boolean raggiuv;
	@Column(name="inclinazione")
	private double inclinazione;
	@Column(name="umidita")
	private double umidita;
	@Column(name="temperatura")
	private double temperatura;
	
	//accessors
	
	public boolean isRaggiuv() {
		return raggiuv;
	}
	public void setRaggiuv(boolean raggiuv) {
		this.raggiuv = raggiuv;
	}
	public double getInclinazione() {
		return inclinazione;
	}
	public void setInclinazione(double inclinazione) {
		this.inclinazione = inclinazione;
	}
	public double getUmidita() {
		return umidita;
	}
	public void setUmidita(double umidita) {
		this.umidita = umidita;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}	
	
}
