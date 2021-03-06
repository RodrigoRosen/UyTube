package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtComentario {
	private int id;
	private String nick;	
	private String texto;	
	private Date fecha;
	private int nivel;

	public DtComentario() {
		super();
	}

	public DtComentario(int id, String nick, String texto, Date fecha) {
		super();
		this.id = id;
		this.nick = nick;
		this.texto = texto;
		this.fecha = fecha;
		this.nivel = 0;
	}
	
	public DtComentario(String nick, String texto, Date fecha) {
		this.nick = nick;
		this.texto = texto;
		this.fecha = fecha;
		this.nivel = 0;
	}
	
	@Override
	public String toString() {
		String aux = this.fecha.toString();
		String date[]= aux.split(" ", 2);
		return String.format(this.nick + ": " + this.texto + " " + date[0]);
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtComentario other = (DtComentario) obj;
		if (id != other.id)
			return false;
		else 
			return true;
	}

}
