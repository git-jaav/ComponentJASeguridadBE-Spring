package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_sesion database table.
 * 
 */
@Entity
@Table(name="sys_sesion")
@NamedQuery(name="SysSesion.findAll", query="SELECT s FROM SysSesion s")
public class SysSesion extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private Integer sesiId;
	private String sesiEstado;
	private Date sesiHoraFinal;
	private Date sesiHoraInicio;
	private String sesiToken;
	
	private Integer fkUsuaId;	

	public SysSesion() {
	}


	@Id
	@GeneratedValue
	@Column(name="sesi_id")
	public Integer getSesiId() {
		return this.sesiId;
	}

	public void setSesiId(Integer sesiId) {
		this.sesiId = sesiId;
	}


	@Column(name="sesi_estado")
	public String getSesiEstado() {
		return this.sesiEstado;
	}

	public void setSesiEstado(String sesiEstado) {
		this.sesiEstado = sesiEstado;
	}

	
	@Column(name="sesi_hora_final")
	public Date getSesiHoraFinal() {
		return this.sesiHoraFinal;
	}

	public void setSesiHoraFinal(Date sesiHoraFinal) {
		this.sesiHoraFinal = sesiHoraFinal;
	}

	
	@Column(name="sesi_hora_inicio")
	public Date getSesiHoraInicio() {
		return this.sesiHoraInicio;
	}

	public void setSesiHoraInicio(Date sesiHoraInicio) {
		this.sesiHoraInicio = sesiHoraInicio;
	}


	@Column(name="sesi_token")
	public String getSesiToken() {
		return this.sesiToken;
	}

	public void setSesiToken(String sesiToken) {
		this.sesiToken = sesiToken;
	}

	
	@Column(name="fk_usua_id")
	public Integer getFkUsuaId() {
		return fkUsuaId;
	}


	public void setFkUsuaId(Integer fkUsuaId) {
		this.fkUsuaId = fkUsuaId;
	}


}