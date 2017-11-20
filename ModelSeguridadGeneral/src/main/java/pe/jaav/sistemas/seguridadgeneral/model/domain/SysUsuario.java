package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_usuario database table.
 * 
 */
@Entity
@Table(name="sys_usuario")
public class SysUsuario extends EntidadSup{
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer usuaId;
	
	private Date fechamodif;
	private String usuaClave;
	private String usuaEstado;
	private String usuaNombre;
	private String usuaUsuario;
	private String usuariomodif;

	private Integer personaId;
	
	public SysUsuario() {
	}


	@Id
	@GeneratedValue
	@Column(name="usua_id")
	public Integer getUsuaId() {
		return this.usuaId;
	}

	
	public void setUsuaId(Integer usuaId) {
		this.usuaId = usuaId;
	}



	@Column(name="usua_clave")
	public String getUsuaClave() {
		return this.usuaClave;
	}

	public void setUsuaClave(String usuaClave) {
		this.usuaClave = usuaClave;
	}


	@Column(name="usua_estado")
	public String getUsuaEstado() {
		return this.usuaEstado;
	}

	public void setUsuaEstado(String usuaEstado) {
		this.usuaEstado = usuaEstado;
	}


	@Column(name="usua_nombre")
	public String getUsuaNombre() {
		return this.usuaNombre;
	}

	public void setUsuaNombre(String usuaNombre) {
		this.usuaNombre = usuaNombre;
	}


	@Column(name="usua_usuario")
	public String getUsuaUsuario() {
		return this.usuaUsuario;
	}

	public void setUsuaUsuario(String usuaUsuario) {
		this.usuaUsuario = usuaUsuario;
	}

	@Column(name="fechamodif")
	public Date getFechamodif() {
		return fechamodif;
	}


	public void setFechamodif(Date fechamodif) {
		this.fechamodif = fechamodif;
	}

	@Column(name="usuariomodif")
	public String getUsuariomodif() {
		return usuariomodif;
	}


	public void setUsuariomodif(String usuariomodif) {
		this.usuariomodif = usuariomodif;
	}

	@Column(name="persona_id")
	public Integer getPersonaId() {
		return personaId;
	}


	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}



}