package br.senac.sp.occam.executor.engine;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.senac.sp.occam.example.control.CadastroAluno;
import br.senac.sp.occam.exception.NoNavigationFoundException;

public class ExecutorEngineTest {
	private CadastroAluno cadastroAluno;
	
	private static final String METHOD_SUCCESS = "inserir";
	private static final String METHOD_FAIL = "update";
	private static final String METHOD_RETURN = "delete";
	private static final String METHOD_WONT_RUN = "wontRunThisMethod";
	
	private static final String PAGE_SUCCESS_EXPECTED = "sucess.jsp";
	private static final String PAGE_FAIL_EXPECTED = "fail.jsp";
	
	@Before
	public void setup() {
		cadastroAluno = new CadastroAluno();
	}
	
	@Test
	public void testExecuteSuccess() throws Exception {
		ExecutorEngine executor = new ExecutorEngine(cadastroAluno, METHOD_SUCCESS);
		
		String actualPage = executor.execute();
		
		Assert.assertEquals(PAGE_SUCCESS_EXPECTED, actualPage);
	}

	@Test
	public void testExecuteFail() throws Exception {
		ExecutorEngine executor = new ExecutorEngine(cadastroAluno, METHOD_FAIL);
		
		String actualPage = executor.execute();
		
		Assert.assertEquals(PAGE_FAIL_EXPECTED, actualPage);
	}
	
	@Test
	public void testExecuteReturn() throws Exception {
		ExecutorEngine executor = new ExecutorEngine(cadastroAluno, METHOD_RETURN);
		
		String actualPage = executor.execute();
		Boolean actualReturn = (Boolean)executor.getReturn();
		
		Assert.assertEquals(PAGE_SUCCESS_EXPECTED, actualPage);
		Assert.assertNotNull(actualReturn);
		Assert.assertEquals(Boolean.TRUE, actualReturn);
	}
	
	@Test
	public void testWontExecuteMethod() {
		ExecutorEngine executor = new ExecutorEngine(cadastroAluno, METHOD_WONT_RUN);
		
		try {
			executor.execute();
		} catch (NoNavigationFoundException e) {
			e.printStackTrace();
		}
	}

}
