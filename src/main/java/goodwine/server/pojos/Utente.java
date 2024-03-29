package goodwine.server.pojos;

import javax.persistence.*;
import java.util.Collection;
import java.io.Serializable;

@Entity(name="utenti")
public class Utente implements Serializable{

	@Id
	@Column(name="username")
	private String username;
	
	@ManyToMany
	Collection<BottigliaAggiornata> storico;
	
	@Column(name="password")
	private String password;
	
	//informazioni utente memorizzate
	@Column(name="nome")
	private String nome;
	@Column(name="cognome")
	private String cognome;
	@Column(name="email")
	private String email;
	@Column(name="indirizzo")
	private String indirizzo;
	@Column(name="telefono")
	private String telefono;
	@Column(name="tipoutente")
	private String tipoUtente;//COMMERCIANTE, RISTORATORE, ALBERGATORE etc.
	@Column(name="datanascita")
	private long dataNascita;
	@Column(name="isenologo")
	private boolean isEnologo;
	
	
	//accessors
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoUtente() {
		return tipoUtente;
	}
	public void setTipoUtente(String tipoUtente) {
		this.tipoUtente = tipoUtente;
	}
	public long getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(long dataNascita) {
		this.dataNascita = dataNascita;
	}
	public boolean isEnologo() {
		return isEnologo;
	}
	public void setEnologo(boolean isEnologo) {
		this.isEnologo = isEnologo;
	}
	
	
}
