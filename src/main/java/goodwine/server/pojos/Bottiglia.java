package goodwine.server.pojos;

import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;
import java.io.Serializable;

@Entity(name="bottiglie")
public class Bottiglia implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="idbottiglia")
	private Long id;
	
	
	//public Collection<BottigliaAggiornata> getAggiornamenti() { return bottigliaaggiornamenti; }
	//public void setAggiornamenti(Collection<BottigliaAggiornata> valore) { this.bottigliaaggiornamenti = valore; }
	@OneToMany( fetch = FetchType.EAGER, mappedBy="bottiglia" )
	public Collection<BottigliaAggiornata> bottigliaaggiornamenti = new ArrayList<BottigliaAggiornata>();
	
	//bottiglia
	@Column(name="filtrazione")
	private String filtrazione;
	
	@Column(name="tempottimale")
	private double tempOttimale;
	
	@Column(name="umiditaottimale")
	private double umiditaOttimale;
	
	@Column(name="inclinazioneottimale")
	private double inclinazioneOttimale;
	
	@Column(name="luogo")
	private String luogo;
	
	@Column(name="nomecantina")
	private String nomeCantina;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="annoproduzione")
	private int annoProduzione;
	
	@Column(name="prezzo")
	private int prezzo;
	
	@Column(name="gradi")
	private int gradi;
	
	@Column(name="tipologia")
	private String tipologia;

	public String getFiltrazione() {
		return filtrazione;
	}

	public void setFiltrazione(String filtrazione) {
		this.filtrazione = filtrazione;
	}

	public double getTempOttimale() {
		return tempOttimale;
	}

	public void setTempOttimale(double tempOttimale) {
		this.tempOttimale = tempOttimale;
	}

	public double getUmiditaOttimale() {
		return umiditaOttimale;
	}

	public void setUmiditaOttimale(double umiditaOttimale) {
		this.umiditaOttimale = umiditaOttimale;
	}

	public double getInclinazioneOttimale() {
		return inclinazioneOttimale;
	}

	public void setInclinazioneOttimale(double inclinazioneOttimale) {
		this.inclinazioneOttimale = inclinazioneOttimale;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getNomeCantina() {
		return nomeCantina;
	}

	public void setNomeCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnnoProduzione() {
		return annoProduzione;
	}

	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getGradi() {
		return gradi;
	}

	public void setGradi(int gradi) {
		this.gradi = gradi;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
