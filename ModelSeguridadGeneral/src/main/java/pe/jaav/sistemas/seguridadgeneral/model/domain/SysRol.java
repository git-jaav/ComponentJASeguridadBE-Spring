package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the sys_rol database table.
 * 
 */
@Entity
@Table(name="sys_rol")
@NamedQuery(name="SysRol.findAll", query="SELECT s FROM SysRol s")
public class SysRol extends EntidadSup{
	private static final long serialVersionUID = 1L;
	private Integer rolId;
	private String rolEstado;
	private Date rolFechamodif;
	private String rolNombre;
	private String rolUsuariomodif;
	private String rolCodigo;
	
	private String rolFlagIneditable;	
	
	//private Integer fkOrgmId;
	
	private SysOrgaModulo sysOrgaModulo = new SysOrgaModulo();	

	public SysRol() {
	}


	@Id
	@GeneratedValue
	@Column(name="rol_id")
	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}


	@Column(name="rol_estado")
	public String getRolEstado() {
		return this.rolEstado;
	}

	public void setRolEstado(String rolEstado) {
		this.rolEstado = rolEstado;
	}

	
	@Column(name="rol_fechamodif")
	public Date getRolFechamodif() {
		return this.rolFechamodif;
	}

	public void setRolFechamodif(Date rolFechamodif) {
		this.rolFechamodif = rolFechamodif;
	}


	@Column(name="rol_nombre")
	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}


	@Column(name="rol_usuariomodif")
	public String getRolUsuariomodif() {
		return this.rolUsuariomodif;
	}

	public void setRolUsuariomodif(String rolUsuariomodif) {
		this.rolUsuariomodif = rolUsuariomodif;
	}

	//bi-directional many-to-one association to SysOrgaModulo
	@ManyToOne
	@JoinColumn(name="fk_orgm_id")
	public SysOrgaModulo getSysOrgaModulo() {
		return this.sysOrgaModulo;
	}

	public void setSysOrgaModulo(SysOrgaModulo sysOrgaModulo) {
		this.sysOrgaModulo = sysOrgaModulo;
	}

	@Column(name="rol_codigo")
	public String getRolCodigo() {
		return rolCodigo;
	}


	public void setRolCodigo(String rolCodigo) {
		this.rolCodigo = rolCodigo;
	}

	
	@Column(name="rol_flag_ineditable")
	public String getRolFlagIneditable() {
		return rolFlagIneditable;
	}


	public void setRolFlagIneditable(String rolFlagIneditable) {
		this.rolFlagIneditable = rolFlagIneditable;
	}

	
//	@Column(name="fk_orgm_id")
//	public Integer getFkOrgmId() {
//		return fkOrgmId;
//	}
//
//
//	public void setFkOrgmId(Integer fkOrgmId) {
//		this.fkOrgmId = fkOrgmId;
//	}


}