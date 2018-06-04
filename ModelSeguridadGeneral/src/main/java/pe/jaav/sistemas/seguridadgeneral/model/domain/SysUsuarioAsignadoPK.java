package pe.jaav.sistemas.seguridadgeneral.model.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sys_usuario_asignado database table.
 * 
 */
@Embeddable
public class SysUsuarioAsignadoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer fkRolId;
	private Integer fkUsuaId;

	public SysUsuarioAsignadoPK() {
	}

	@Column(name="fk_rol_id", insertable=false, updatable=false)
	public Integer getFkRolId() {
		return this.fkRolId;
	}
	public void setFkRolId(Integer fkRolId) {
		this.fkRolId = fkRolId;
	}

	@Column(name="fk_usua_id", insertable=false, updatable=false)
	public Integer getFkUsuaId() {
		return this.fkUsuaId;
	}
	public void setFkUsuaId(Integer fkUsuaId) {
		this.fkUsuaId = fkUsuaId;
	}

}