package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_usuario_asignado database table.
 * 
 */
@Entity
@Table(name="sys_usuario_asignado")
@NamedQuery(name="SysUsuarioAsignado.findAll", query="SELECT s FROM SysUsuarioAsignado s")
public class SysUsuarioAsignado extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private SysUsuarioAsignadoPK id;
	private String usasigEstado;
	private Date usasigFechamodif;
	private String usasigUsuaromodif;
	//private SysRol sysRol;
	//private SysUsuario sysUsuario;

	public SysUsuarioAsignado() {
	}


	@EmbeddedId
	public SysUsuarioAsignadoPK getId() {
		return this.id;
	}

	public void setId(SysUsuarioAsignadoPK id) {
		this.id = id;
	}


	@Column(name="usasig_estado")
	public String getUsasigEstado() {
		return this.usasigEstado;
	}

	public void setUsasigEstado(String usasigEstado) {
		this.usasigEstado = usasigEstado;
	}

	
	@Column(name="usasig_fechamodif")
	public Date getUsasigFechamodif() {
		return this.usasigFechamodif;
	}

	public void setUsasigFechamodif(Date usasigFechamodif) {
		this.usasigFechamodif = usasigFechamodif;
	}


	@Column(name="usasig_usuaromodif")
	public String getUsasigUsuaromodif() {
		return this.usasigUsuaromodif;
	}

	public void setUsasigUsuaromodif(String usasigUsuaromodif) {
		this.usasigUsuaromodif = usasigUsuaromodif;
	}


	//bi-directional many-to-one association to SysRol
//	@ManyToOne
//	@JoinColumn(name="fk_rol_id")
//	public SysRol getSysRol() {
//		return this.sysRol;
//	}
//
//	public void setSysRol(SysRol sysRol) {
//		this.sysRol = sysRol;
//	}
//
//
//	//bi-directional many-to-one association to SysUsuario
//	@ManyToOne
//	@JoinColumn(name="fk_usua_id")
//	public SysUsuario getSysUsuario() {
//		return this.sysUsuario;
//	}
//
//	public void setSysUsuario(SysUsuario sysUsuario) {
//		this.sysUsuario = sysUsuario;
//	}

}