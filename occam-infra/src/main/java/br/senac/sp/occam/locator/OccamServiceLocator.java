package br.senac.sp.occam.locator;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import br.senac.sp.occam.annotation.Operation;
import br.senac.sp.occam.enums.InstanceStrategy;
import br.senac.sp.occam.exception.InvalidOperationException;
import br.senac.sp.occam.parser.IOccamConfiguration;
import br.senac.sp.occam.parser.implementation.ConfigurationProxy;
import br.senac.sp.occam.resolver.AbstractDependencyResolver;
import br.senac.sp.occam.resolver.implementation.DependencyResolver;

public class OccamServiceLocator {
	private static final OccamServiceLocator INSTANCE = new OccamServiceLocator();
	private AbstractDependencyResolver dependencyResolver;
	
	private Map<String, Object> cache;
	
	private OccamServiceLocator() {
		cache = new HashMap<String, Object>();
	}
	
	public static OccamServiceLocator getInstance() {
		return INSTANCE;
	}
	
	public void setDependencyResolver(AbstractDependencyResolver dependencyResolver) {
		this.dependencyResolver = dependencyResolver;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getOperationInstance(URL operationFile, String operationName) throws InvalidOperationException {
		IOccamConfiguration config = new ConfigurationProxy(operationFile);
		
		Object instance = null;
		
		// configuration parser obtém a classe
		String className = config.getOperationClass(operationName);
		
		// obter a estratégia de instância 
		try {
			Class operationClass = Class.forName(className);
			
			// verificar qual a estratégia de instância
			if(operationClass.isAnnotationPresent(Operation.class)) {
				Operation op = (Operation) operationClass.getAnnotation(Operation.class);
				
				if(op.value() == InstanceStrategy.PROTOTYPE) {
					// se for PROTOTYPE retornar instancia
					instance = operationClass.newInstance();
				} else {
					// se for SINGLETON, procurar no cache
					instance = cache.get(operationName);
					
					if(instance == null) {
						// se não tiver, cria uma nova instancia e cadastra no cache
						instance = operationClass.newInstance();
						
						cache.put(operationName, instance);
					}
				}
			} else {
				throw new InvalidOperationException(operationName);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		dependencyResolver = new DependencyResolver(instance); 
		instance = dependencyResolver.resolve();

		return instance;
	}
}
