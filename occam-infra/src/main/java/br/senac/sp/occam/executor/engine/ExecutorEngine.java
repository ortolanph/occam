package br.senac.sp.occam.executor.engine;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import br.senac.sp.occam.annotation.NavigationCase;
import br.senac.sp.occam.annotation.NavigationCases;
import br.senac.sp.occam.enums.NavigationStatus;
import br.senac.sp.occam.exception.NoNavigationFoundException;
import br.senac.sp.occam.executor.IExecutionStrategy;
import br.senac.sp.occam.executor.implementation.DefaultMethodExecutor;
import br.senac.sp.occam.executor.implementation.ReturningMethodExecutor;

public class ExecutorEngine {
	private Object instance;
	private String methodName;
	private Map<NavigationStatus, String> navigation;
	private IExecutionStrategy strategy;
	
	public ExecutorEngine(Object instance, String methodName) {
		this.instance = instance;
		this.methodName = methodName;
		navigation = new HashMap<NavigationStatus, String>();
	}
	
	public String execute() throws NoNavigationFoundException{
		Method method;

		try {
			method = instance.getClass().getMethod(methodName);
			
			boolean navigationPresent = method.isAnnotationPresent(NavigationCases.class);
			
			if(!navigationPresent) {
				throw new NoNavigationFoundException(methodName);
			}
	
			NavigationCases navigationCases = (NavigationCases) method
					.getAnnotation(NavigationCases.class);
			
			loadNavigation(navigationCases);
			
			if(method.getReturnType() == Void.class || method.getReturnType() == void.class) {
				this.strategy = new DefaultMethodExecutor();
			} else {
				this.strategy = new ReturningMethodExecutor();
			}
			
			strategy.executeMethod(method, instance);
			
			return navigation.get(NavigationStatus.SUCCESS);
		} catch (Exception e) {
			return navigation.get(NavigationStatus.FAIL);
		}
	}
	
	public Object getReturn() {
		return strategy.getReturn();
	}
	
	private void loadNavigation(NavigationCases navigationCases) {
		for(NavigationCase navigationCase : navigationCases.value()) {
			navigation.put(navigationCase.status(), navigationCase.url());
		}
	}
}
