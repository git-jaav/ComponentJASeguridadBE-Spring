package pe.jaav.sistemas.seguridadgeneral.model.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gen_persona database table.
 * 
 */
@Entity
@Table(name="gen_persona")
@NamedQuery(name="GenPersona.findAll", query="SELECT g FROM GenPersona g")
public class GenPersona extends EntidadSup {
	private static final long serialVersionUID = 1L;
	private Integer persId;
	private String persApellidoMaterno;
	private String persApellidoPaterno;
	private String persCelular;
	private String persCorreoinstitucional;
	private String persCorreopersonal;
	private String persDocumentoFiscal;
	private String persDocumentoIdent;
	private String persEstado;
	private String persEstadoCivil;
	private Date persFechamodif;
	private String persNombreCompleto;
	private String persNombres;
	private String persSexo;
	private String persTelefono;
	private String persTipoPersona;
	private String persUsuariomodif;
	private GenTipodocumento genTipodocumento;

	public GenPersona() {
	}


	@Id
	@Column(name="PERS_ID")
	public Integer getPersId() {
		return this.persId;
	}

	public void setPersId(Integer persId) {
		this.persId = persId;
	}


	@Column(name="PERS_APELLIDO_MATERNO")
	public String getPersApellidoMaterno() {
		return this.persApellidoMaterno;
	}

	public void setPersApellidoMaterno(String persApellidoMaterno) {
		this.persApellidoMaterno = persApellidoMaterno;
	}


	@Column(name="PERS_APELLIDO_PATERNO")
	public String getPersApellidoPaterno() {
		return this.persApellidoPaterno;
	}

	public void setPersApellidoPaterno(String persApellidoPaterno) {
		this.persApellidoPaterno = persApellidoPaterno;
	}


	@Column(name="PERS_CELULAR")
	public String getPersCelular() {
		return this.persCelular;
	}

	public void setPersCelular(String persCelular) {
		this.persCelular = persCelular;
	}


	@Column(name="PERS_CORREOINSTITUCIONAL")
	public String getPersCorreoinstitucional() {
		return this.persCorreoinstitucional;
	}

	public void setPersCorreoinstitucional(String persCorreoinstitucional) {
		this.persCorreoinstitucional = persCorreoinstitucional;
	}


	@Column(name="PERS_CORREOPERSONAL")
	public String getPersCorreopersonal() {
		return this.persCorreopersonal;
	}

	public void setPersCorreopersonal(String persCorreopersonal) {
		this.persCorreopersonal = persCorreopersonal;
	}


	@Column(name="PERS_DOCUMENTO_FISCAL")
	public String getPersDocumentoFiscal() {
		return this.persDocumentoFiscal;
	}

	public void setPersDocumentoFiscal(String persDocumentoFiscal) {
		this.persDocumentoFiscal = persDocumentoFiscal;
	}


	@Column(name="PERS_DOCUMENTO_IDENT")
	public String getPersDocumentoIdent() {
		return this.persDocumentoIdent;
	}

	public void setPersDocumentoIdent(String persDocumentoIdent) {
		this.persDocumentoIdent = persDocumentoIdent;
	}


	@Column(name="PERS_ESTADO")
	public String getPersEstado() {
		return this.persEstado;
	}

	public void setPersEstado(String persEstado) {
		this.persEstado = persEstado;
	}


	@Column(name="PERS_ESTADO_CIVIL")
	public String getPersEstadoCivil() {
		return this.persEstadoCivil;
	}

	public void setPersEstadoCivil(String persEstadoCivil) {
		this.persEstadoCivil = persEstadoCivil;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PERS_FECHAMODIF")
	public Date getPersFechamodif() {
		return this.persFechamodif;
	}

	public void setPersFechamodif(Date persFechamodif) {
		this.persFechamodif = persFechamodif;
	}


	@Column(name="PERS_NOMBRE_COMPLETO")
	public String getPersNombreCompleto() {
		return this.persNombreCompleto;
	}

	public void setPersNombreCompleto(String persNombreCompleto) {
		this.persNombreCompleto = persNombreCompleto;
	}


	@Column(name="PERS_NOMBRES")
	public String getPersNombres() {
		return this.persNombres;
	}

	public void setPersNombres(String persNombres) {
		this.persNombres = persNombres;
	}


	@Column(name="PERS_SEXO")
	public String getPersSexo() {
		return this.persSexo;
	}

	public void setPersSexo(String persSexo) {
		this.persSexo = persSexo;
	}


	@Column(name="PERS_TELEFONO")
	public String getPersTelefono() {
		return this.persTelefono;
	}

	public void setPersTelefono(String persTelefono) {
		this.persTelefono = persTelefono;
	}


	@Column(name="PERS_TIPO_PERSONA")
	public String getPersTipoPersona() {
		return this.persTipoPersona;
	}

	public void setPersTipoPersona(String persTipoPersona) {
		this.persTipoPersona = persTipoPersona;
	}


	@Column(name="PERS_USUARIOMODIF")
	public String getPersUsuariomodif() {
		return this.persUsuariomodif;
	}

	public void setPersUsuariomodif(String persUsuariomodif) {
		this.persUsuariomodif = persUsuariomodif;
	}


	//bi-directional many-to-one association to GenTipodocumento
	@ManyToOne
	@JoinColumn(name="TDOC_TIPODOCUMENTO_ID")
	public GenTipodocumento getGenTipodocumento() {
		return this.genTipodocumento;
	}

	public void setGenTipodocumento(GenTipodocumento genTipodocumento) {
		this.genTipodocumento = genTipodocumento;
	}

}