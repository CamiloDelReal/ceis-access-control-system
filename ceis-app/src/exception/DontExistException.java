package exception;

public class DontExistException extends Exception {
	private static final long serialVersionUID = 456549248088225162L;

	public DontExistException(){
		super("Valor a buscar fuera de rango\n" +
				"Posiblemente ocasionado por la no existencia de los valores comprometidos");
	}
	
	public DontExistException(String message){
		super(message);
	}
}
