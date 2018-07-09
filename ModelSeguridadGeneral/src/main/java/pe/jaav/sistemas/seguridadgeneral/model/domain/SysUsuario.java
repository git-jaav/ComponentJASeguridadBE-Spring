package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;

import pe.jaav.sistemas.seguridadgeneral.model.utiles.Constant;

import java.util.Date;


/**
 * The persistent class for the sys_usuario database table.
 * 
 */
/**
 * @author JAAV
 *
 */
@Entity
@Table(name="sys_usuario")
@NamedQuery(name="SysUsuario.findAll", query="SELECT s FROM SysUsuario s")
public class SysUsuario extends EntidadSup{
	private static final long serialVersionUID = 1L;
	private Integer usuaId;
	private Integer personaId;
	private String usuaClave;
	private String usuaEstado;
	private Date usuaFechamodif;
	private String usuaNombre;
	private String usuaUsuario;
	private String usuaUsuariomodif;
	
	private String usuaFlagExpirar;
	private Date usuaFechaExpiracion;
	private String usuaFlagIneditable;
	
	private boolean usuaFlagExpirarBool;
	private boolean usuaFlagIneditableBool;
		
	//private List<SysSesion> sysSesions;
	//private List<SysUsuarioAsignado> sysUsuarioAsignados;

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


	@Column(name="persona_id")
	public Integer getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
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

	
	@Column(name="usua_fechamodif")
	public Date getUsuaFechamodif() {
		return this.usuaFechamodif;
	}

	public void setUsuaFechamodif(Date usuaFechamodif) {
		this.usuaFechamodif = usuaFechamodif;
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


	@Column(name="usua_usuariomodif")
	public String getUsuaUsuariomodif() {
		return this.usuaUsuariomodif;
	}

	public void setUsuaUsuariomodif(String usuaUsuariomodif) {
		this.usuaUsuariomodif = usuaUsuariomodif;
	}

	@Column(name="usua_flag_expirar")
	public String getUsuaFlagExpirar() {
		return usuaFlagExpirar;
	}


	public void setUsuaFlagExpirar(String usuaFlagExpirar) {
		this.usuaFlagExpirar = usuaFlagExpirar;
	}

	@Column(name="usua_fechaexpiracion")
	public Date getUsuaFechaExpiracion() {
		return usuaFechaExpiracion;
	}


	public void setUsuaFechaExpiracion(Date usuaFechaExpiracion) {
		this.usuaFechaExpiracion = usuaFechaExpiracion;
	}

	@Column(name="usua_flag_ineditable")
	public String getUsuaFlagIneditable() {
		return usuaFlagIneditable;
	}


	public void setUsuaFlagIneditable(String usuaFlagIneditable) {
		this.usuaFlagIneditable = usuaFlagIneditable;
	}

	@Transient
	public boolean isUsuaFlagExpirarBool() {
		if(Constant.SI_db.equals(usuaFlagExpirar)){
			usuaFlagExpirarBool = true;
		}else{
			usuaFlagExpirarBool = false;
		}
		return usuaFlagExpirarBool;
	}


	public void setUsuaFlagExpirarBool(boolean usuaFlagExpirarBool) {
		if(usuaFlagExpirarBool){
			setUsuaFlagExpirar(Constant.SI_db);
		}else{
			setUsuaFlagExpirar(Constant.NO_db);
		}
		this.usuaFlagExpirarBool = usuaFlagExpirarBool;
	}


	@Transient
	public boolean isUsuaFlagIneditableBool() {
		if(Constant.SI_db.equals(usuaFlagIneditable)){
			usuaFlagIneditableBool = true;
		}else{
			usuaFlagIneditableBool = false;
		}			
		return usuaFlagIneditableBool;
	}


	public void setUsuaFlagIneditableBool(boolean usuaFlagIneditableBool) {
		if(usuaFlagIneditableBool){
			setUsuaFlagIneditable(Constant.SI_db);
		}else{
			setUsuaFlagIneditable(Constant.NO_db);
		}		
		this.usuaFlagIneditableBool = usuaFlagIneditableBool;
	}		
	
	
	//bi-directional many-to-one association to SysSesion
//	@OneToMany(mappedBy="sysUsuario")
//	public List<SysSesion> getSysSesions() {
//		return this.sysSesions;
//	}
//
//	public void setSysSesions(List<SysSesion> sysSesions) {
//		this.sysSesions = sysSesions;
//	}
//
//	public SysSesion addSysSesion(SysSesion sysSesion) {
//		getSysSesions().add(sysSesion);
//		sysSesion.setSysUsuario(this);
//
//		return sysSesion;
//	}
//
//	public SysSesion removeSysSesion(SysSesion sysSesion) {
//		getSysSesions().remove(sysSesion);
//		sysSesion.setSysUsuario(null);
//
//		return sysSesion;
//	}


	//bi-directional many-to-one association to SysUsuarioAsignado
//	@OneToMany(mappedBy="sysUsuario")
//	public List<SysUsuarioAsignado> getSysUsuarioAsignados() {
//		return this.sysUsuarioAsignados;
//	}
//
//	public void setSysUsuarioAsignados(List<SysUsuarioAsignado> sysUsuarioAsignados) {
//		this.sysUsuarioAsignados = sysUsuarioAsignados;
//	}
//
//	public SysUsuarioAsignado addSysUsuarioAsignado(SysUsuarioAsignado sysUsuarioAsignado) {
//		getSysUsuarioAsignados().add(sysUsuarioAsignado);
//		sysUsuarioAsignado.setSysUsuario(this);
//
//		return sysUsuarioAsignado;
//	}
//
//	public SysUsuarioAsignado removeSysUsuarioAsignado(SysUsuarioAsignado sysUsuarioAsignado) {
//		getSysUsuarioAsignados().remove(sysUsuarioAsignado);
//		sysUsuarioAsignado.setSysUsuario(null);
//
//		return sysUsuarioAsignado;
//	}
	
	

}