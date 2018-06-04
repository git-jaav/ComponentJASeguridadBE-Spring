package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_orga_modulo database table.
 * 
 */
@Entity
@Table(name="sys_orga_modulo")
@NamedQuery(name="SysOrgaModulo.findAll", query="SELECT s FROM SysOrgaModulo s")
public class SysOrgaModulo extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private Integer orgmId;
	private String orgmCode;
	private String orgmEstado;
	private Date orgmFechaModif;
	private String orgmNombre;
	private String orgmUsuarioModif;
	//private List<SysRol> sysRols;

	public SysOrgaModulo() {
	}


	@Id
	@Column(name="orgm_id")
	public Integer getOrgmId() {
		return this.orgmId;
	}

	public void setOrgmId(Integer orgmId) {
		this.orgmId = orgmId;
	}


	@Column(name="orgm_code")
	public String getOrgmCode() {
		return this.orgmCode;
	}

	public void setOrgmCode(String orgmCode) {
		this.orgmCode = orgmCode;
	}


	@Column(name="orgm_estado")
	public String getOrgmEstado() {
		return this.orgmEstado;
	}

	public void setOrgmEstado(String orgmEstado) {
		this.orgmEstado = orgmEstado;
	}
	
	@Column(name="orgm_fecha_modif")
	public Date getOrgmFechaModif() {
		return this.orgmFechaModif;
	}

	public void setOrgmFechaModif(Date orgmFechaModif) {
		this.orgmFechaModif = orgmFechaModif;
	}


	@Column(name="orgm_nombre")
	public String getOrgmNombre() {
		return this.orgmNombre;
	}

	public void setOrgmNombre(String orgmNombre) {
		this.orgmNombre = orgmNombre;
	}


	@Column(name="orgm_usuario_modif")
	public String getOrgmUsuarioModif() {
		return this.orgmUsuarioModif;
	}

	public void setOrgmUsuarioModif(String orgmUsuarioModif) {
		this.orgmUsuarioModif = orgmUsuarioModif;
	}


//	//bi-directional many-to-one association to SysRol
//	@OneToMany(mappedBy="sysOrgaModulo")
//	public List<SysRol> getSysRols() {
//		return this.sysRols;
//	}
//
//	public void setSysRols(List<SysRol> sysRols) {
//		this.sysRols = sysRols;
//	}
//
//	public SysRol addSysRol(SysRol sysRol) {
//		getSysRols().add(sysRol);
//		sysRol.setSysOrgaModulo(this);
//
//		return sysRol;
//	}
//
//	public SysRol removeSysRol(SysRol sysRol) {
//		getSysRols().remove(sysRol);
//		sysRol.setSysOrgaModulo(null);
//
//		return sysRol;
//	}

}