package pe.jaav.sistemas.general.service.test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.general.service.EncriptacionService;
import pe.jaav.sistemas.general.service.UsuarioService;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

/**
 * @author JAAV
 *
 */
public class UsuarioServiceTest extends ServiceTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EncriptacionService encriptacionService;
	
	
	@Test
	public void testSeguridadUsuario(){
		System.out.println("[***** TEST INIT ******]");
		System.out.println("[***** TEST FECHA ******] ::"+UtilesCommons.printDate("yyyy-MM-dd", new Date()));
		//listarUsuario();
		//guardarUsuario();
		cifrarClave();
		//validarLogin();
		//actualizarUsuario();
		
		System.out.println("[***** TEST FIN ******]");
	}
	
	public void listarUsuario(){
		List<SysUsuario> lista =  usuarioService.listar(new SysUsuario(), false);
		if(UtilesCommons.noEsVacio(lista)){
			lista.forEach(u -> {
				System.out.println("[TEST::]"+u.getUsuaNombre());
				});	
		}
		
		
	}

	public void cifrarClave(){
		String original = "1234";
		System.out.println("[TEST:::original:]"+original);
		String cifrado = encriptacionService.getCifrado(original);
		System.out.println("[TEST:::cifrado:]"+cifrado);
		boolean match = encriptacionService.isMatchDescifrado(cifrado, original);
		System.out.println("[TEST:::match:]"+match);
	}
	
	public void validarLogin(){
		SysUsuario result =  usuarioService.obtenerLogin("USER_YY", "1234");
		if(result!=null){
			System.out.println("[TEST: VALIDO:]");
			UtilesCommons.showObjeto(result);	
		}else{
			System.out.println("[TEST:NO VALIDO:]");
		}
			
		
	}
	
	public void guardarUsuario(){
		try{
			SysUsuario objSave = new SysUsuario();
			objSave.setUsuaId(null);
			objSave.setUsuaNombre("USAURIO TEST XX");
			objSave.setUsuaClave("");
			objSave.setUsuaUsuario("USER_XX");
			objSave.setUsuaEstado(UtilesCommons.ACTIVO_db);
			
			int result =  usuarioService.guardar(objSave);		
			
			System.out.println("[TEST:result:]"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void actualizarUsuario(){
		try{
			SysUsuario objSave = new SysUsuario();
			objSave.setUsuaId(18);
			objSave.setUsuaNombre("USAURIO TEST YYYY");
			objSave.setUsuaClave("1234");
			objSave.setUsuaUsuario("USER_YY");
			objSave.setUsuaEstado(UtilesCommons.ACTIVO_db);
			
			int result =  usuarioService.actualizar(objSave,
					usuarioService.detectarCambioClaveUsuario(objSave.getUsuaId(), objSave.getUsuaClave()));		
			
			System.out.println("[TEST:result:]"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
