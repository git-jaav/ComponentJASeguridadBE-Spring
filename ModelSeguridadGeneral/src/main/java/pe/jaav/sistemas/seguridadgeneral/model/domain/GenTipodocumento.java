package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;


/**
 * The persistent class for the gen_tipodocumento database table.
 * 
 */
@Entity
@Table(name="gen_tipodocumento")
@NamedQuery(name="GenTipodocumento.findAll", query="SELECT g FROM GenTipodocumento g")
public class GenTipodocumento extends EntidadSup{
	private static final long serialVersionUID = 1L;
	private Integer tdocTipodocumentoId;
	private Integer tdocCantCaracter;
	private String tdocClasificacion;
	private String tdocDescripcion;
	private String tdocEstado;
	private String tdocFechamodif;
	private String tdocNombre;
	private String tdocUsuariomodif;	

	public GenTipodocumento() {
	}


	@Id
	@GeneratedValue
	@Column(name="TDOC_TIPODOCUMENTO_ID")
	public Integer getTdocTipodocumentoId() {
		return this.tdocTipodocumentoId;
	}

	public void setTdocTipodocumentoId(Integer tdocTipodocumentoId) {
		this.tdocTipodocumentoId = tdocTipodocumentoId;
	}


	@Column(name="TDOC_CANT_CARACTER")
	public Integer getTdocCantCaracter() {
		return this.tdocCantCaracter;
	}

	public void setTdocCantCaracter(Integer tdocCantCaracter) {
		this.tdocCantCaracter = tdocCantCaracter;
	}


	@Column(name="TDOC_CLASIFICACION")
	public String getTdocClasificacion() {
		return this.tdocClasificacion;
	}

	public void setTdocClasificacion(String tdocClasificacion) {
		this.tdocClasificacion = tdocClasificacion;
	}


	@Column(name="TDOC_DESCRIPCION")
	public String getTdocDescripcion() {
		return this.tdocDescripcion;
	}

	public void setTdocDescripcion(String tdocDescripcion) {
		this.tdocDescripcion = tdocDescripcion;
	}


	@Column(name="TDOC_ESTADO")
	public String getTdocEstado() {
		return this.tdocEstado;
	}

	public void setTdocEstado(String tdocEstado) {
		this.tdocEstado = tdocEstado;
	}


	@Column(name="TDOC_FECHAMODIF")
	public String getTdocFechamodif() {
		return this.tdocFechamodif;
	}

	public void setTdocFechamodif(String tdocFechamodif) {
		this.tdocFechamodif = tdocFechamodif;
	}


	@Column(name="TDOC_NOMBRE")
	public String getTdocNombre() {
		return this.tdocNombre;
	}

	public void setTdocNombre(String tdocNombre) {
		this.tdocNombre = tdocNombre;
	}


	@Column(name="TDOC_USUARIOMODIF")
	public String getTdocUsuariomodif() {
		return this.tdocUsuariomodif;
	}

	public void setTdocUsuariomodif(String tdocUsuariomodif) {
		this.tdocUsuariomodif = tdocUsuariomodif;
	}

}