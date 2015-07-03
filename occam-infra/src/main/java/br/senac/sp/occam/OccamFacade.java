package br.senac.sp.occam;

import java.net.URL;
import java.util.Map;

import br.senac.sp.occam.converter.engine.BeanDependencyEngine;
import br.senac.sp.occam.exception.InvalidOperationException;
import br.senac.sp.occam.exception.NoNavigationFoundException;
import br.senac.sp.occam.executor.beans.ResultBean;
import br.senac.sp.occam.executor.engine.ExecutorEngine;
import br.senac.sp.occam.locator.OccamServiceLocator;

public class OccamFacade {
	private OccamServiceLocator locator;
	
	public OccamFacade() {
		locator = OccamServiceLocator.getInstance();
	}
	
	public Object getOperation(URL operationFile, String operationName) throws InvalidOperationException {
		return locator.getOperationInstance(operationFile, operationName);
	}
	
	public Object resolveBeans(Object instance, Map<String, String> values) {
		BeanDependencyEngine beanEngine = new BeanDependencyEngine(instance, values); 
		
		return beanEngine.resolve();
	}
	
	public ResultBean runMethod(Object instance, String methodName) throws NoNavigationFoundException {
		ExecutorEngine engine = new ExecutorEngine(instance, methodName);
		
		String urlToGo = engine.execute();
		Object methodReturn = engine.getReturn();
		
		ResultBean result = new ResultBean(urlToGo, methodReturn);
		
		return result;
	}
}
