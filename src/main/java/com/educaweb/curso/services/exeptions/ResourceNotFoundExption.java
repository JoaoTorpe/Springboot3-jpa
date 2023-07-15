package com.educaweb.curso.services.exeptions;

public class ResourceNotFoundExption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExption( Object id ) {
		
		super("Resource not found. Id"+ id);
		
	}
	
	
	
	
}
