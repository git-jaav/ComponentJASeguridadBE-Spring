package pe.jaav.sistemas.general.service.test;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import pe.jaav.common.util.UtilesCommons;
import pe.jaav.sistemas.general.service.UsuarioService;
import pe.jaav.sistemas.seguridadgeneral.model.domain.SysUsuario;

/**
 * @author JAAV
 *
 */
public class UsuarioServiceTest extends ServiceTest {

	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void testSeguridadUsuario(){
		System.out.println("[***** TEST INIT ******]");
		//listarUsuario();
		guardarUsuario();
		System.out.println("[***** TEST FIN ******]");
	}
	
	public void listarUsuario(){
		List<SysUsuario> lista =  usuarioService.listar(new SysUsuario(), false);
			
		lista.forEach(u -> {
				System.out.println("[TEST::]"+u.getUsuaNombre());
				});
		
	}

	public void guardarUsuario(){
		try{
			SysUsuario objSave = new SysUsuario();
			objSave.setUsuaId(null);
			objSave.setUsuaNombre("USAURIO TEST J");
			objSave.setUsuaClave("1234");
			objSave.setUsuaUsuario("USER_J");
			objSave.setUsuaEstado(UtilesCommons.ACTIVO_db);
			
			int result =  usuarioService.guardar(objSave);		
			
			System.out.println("[TEST:result:]"+result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
