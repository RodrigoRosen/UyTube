package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.tree.DefaultMutableTreeNode;

import datatypes.DtComentario;

@Entity
public class Comentario {//TODO agregar la clave compuesta usuario fecha o quizá usuario-video
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String texto;
	private Date fecha;
	@ManyToOne
	private Usuario autor;
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Comentario> respuestas = new HashSet<Comentario>();

	public Comentario() {
		// TODO Auto-generated constructor stub
	}
	

	public Comentario(String texto, Date fecha, Usuario autor) {
		super();
		this.texto = texto;
		this.fecha = fecha;
		this.autor = autor;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public Set<Comentario> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Comentario> respuestas) {
		this.respuestas = respuestas;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public DtComentario getDt() {
		return new DtComentario(id,autor.getNickname(),texto,fecha);
	}
	
	public Comentario ingresarRespuesta(DtComentario respuesta, Usuario autor) {
		Comentario comment = new Comentario(respuesta.getTexto(),respuesta.getFecha(),autor);
		this.respuestas.add(comment);
		return comment;
	} 
	
	public Comentario findComentario(int id) {
		if(this.respuestas.isEmpty()) {
			return null;
		}else {
			for(Comentario c: this.respuestas) {
				if(c.id == id) {
					return c;
				}else {
					Comentario aux = c.findComentario(id);
					if(aux != null) {
						return aux;
					}
				}
			}		
			return null;
		}
	}
	
	public DefaultMutableTreeNode getNodes() {
		DefaultMutableTreeNode nodes = new DefaultMutableTreeNode(this.getDt());			
		if(!(this.respuestas.isEmpty())) {
			for(Comentario aux:this.respuestas) {
				DefaultMutableTreeNode node = aux.getNodes();
				if(node != null) {
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
	
	public void noMoreTrees(ArrayList<DtComentario> com, int nivel){
		for(Comentario c: this.respuestas) {
			DtComentario dtc = c.getDt();
			dtc.setNivel(nivel);
			com.add(dtc);
			c.noMoreTrees(com,nivel+1);
		}		
	}

}

