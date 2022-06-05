
import java.util.ArrayList;
public class Ejercicio1 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add( 0 );
		a.add( 1 );
		a.add( 2 );
		a.add( 3 );	
		a.add( 4 );
		a.add( 5 );
		a.add( 6 );
		a.add( 7 );
		a.add( 8 );
		a.add( 9 );
		System.out.println( "Array inicial:" );
		System.out.println( a );	
		ArrayList<ArrayList<Integer>> resultado = encontrarPer(a);
		System.out.println("*******************************************************************");
		System.out.println( "Resultado:" );	
		for(ArrayList<Integer> x : resultado ){
			System.out.println( x );
		}
		System.out.println("*******************************************************************");
		System.out.println("RESULTADO: ");
		encontrarParesYComparar(resultado, 24);//CASO PRUEBA
	}//FIN DEL MAIN
	

	/*
	 * Se crea un m�todo �encontrarParesYComparar�. Este m�todo se crea con el fin de, 
	 * despu�s de encontrar todas las permutaciones con el m�todo �encontrarPer�, dividir cada valor del 
	 * ArrayList de dos dimensiones en dos partes de 5 d�gitos teniendo en cuenta que cada n�mero tiene un 
	 * d�gito diferente y que no se repite. Luego de esto, encontrar la divisi�n del primer n�mero de 5 d�gitos con 
	 * el segundo n�mero de 5 d�gitos, con el objetivo de encontrar todos los pares que sean igual a un entero 2<= N >= 79. 
	 * Este entero se coloca necesariamente para encontrar todos los pares posibles.
	 */
	public static void encontrarParesYComparar (ArrayList<ArrayList<Integer>> permute, int numero) {	
		int suma1 = 0, suma2=0, division = 0;
		int unidad, decena, centena, unidadM, decenaM, unidad2, decena2, centena2, unidadM2, decenaM2;
		for(int i = 0; i < permute.size(); i++) {
			decenaM=permute.get(i).get(0)*10000;
			unidadM=permute.get(i).get(1)*1000;	
			centena=permute.get(i).get(2)*100;	
			decena=permute.get(i).get(3)*10;
			unidad=permute.get(i).get(4);
			suma1 = unidad + decena+centena+unidadM+decenaM;	
			decenaM2=permute.get(i).get(5)*10000;
			unidadM2=permute.get(i).get(6)*1000;
			centena2=permute.get(i).get(7)*100;
			decena2=permute.get(i).get(8)*10;	
			unidad2=permute.get(i).get(9);
			suma2 = unidad2 + decena2+centena2+unidadM2+decenaM2;
			if(suma1%suma2 == 0) {
				division = suma1 / suma2;
				if(division == numero) {	
					if(contarCifras(suma1)==4) {
						System.out.println("0"+suma1+" / "+suma2+" = "+division);
					}else if(contarCifras(suma2)==4){
						System.out.println(suma1+" / 0"+suma2+" = "+division);
					}else {
						System.out.println(suma1+" / "+suma2+" = "+division);
					}
				}//FIN DEL IF INTERNO
			}//FIN DEL IF
		}//FIN DEL FOR
	}//FIN DEL M�TODO

	/*
	 * Se crea el m�todo �contarCifras� con el objetivo de saber si el n�mero tiene 4 d�gitos. 
	 * Si es verdad este caso, entonces se le agrega un cero a la izquierda (DM: decenas de mil) del n�mero para especificar 
	 * que son 5 d�gitos. En realidad no afecta en nada, pero nos sirve para visualizar mejor los n�meros de 5 d�gitos.
	 */
	public static int contarCifras(int n) {
		int cifras= 0;
        while(n!=0){
                n = n/10;
               cifras++;
        }
        return cifras;
	}
	
	/*
	 * Ahora, se va a dar la resoluci�n del ejercicio 1. Pero antes, debemos decir que es el mismo m�todo  
	 * �encontrarPermutaciones�, pero sin especificar cada paso que est� haciendo el m�todo.
	 */
	public static ArrayList<ArrayList<Integer>> encontrarPer(ArrayList<Integer> argumento) {	
		ArrayList<ArrayList<Integer>> arrayPrincipal = new ArrayList<ArrayList<Integer>>();	
		if( argumento.size() == 1 ){//CASO BASE	
			arrayPrincipal.add( new ArrayList<Integer>(argumento) );	
			return arrayPrincipal;	
		}

		for( int i = 0 ; i < argumento.size(); i++ ){//CASO RECURSIVO	
			int guardarValor = argumento.get( i );
			ArrayList<Integer> arrayListAlmcaenado = new ArrayList<Integer>(argumento);	
			arrayListAlmcaenado.remove( i );
			ArrayList<ArrayList<Integer>> recursividad = encontrarPer(arrayListAlmcaenado);//RECURSIVIDAD	
			for( int j = 0 ; j < recursividad.size() ; j++ ){//JUNTA LOS VALORES EN EL ARRAYLIST PRINCIPAL
				ArrayList<Integer> arrayListJuntar = new ArrayList<Integer>();		
				arrayListJuntar.add( guardarValor );	
				arrayListJuntar.addAll( recursividad.get( j ) );
				arrayPrincipal.add( arrayListJuntar );
			}
		}
		return arrayPrincipal;//DEVUELVE LOS VALORES DEL ARRAYLIST PRINCIPAL	
	}//FIN DEL M�TODO ENCONTRARPER
	
	/*
	 * Primero creamos un m�todo �encontrarPermutaciones� que nos devuelve un ArrayList de dos dimensiones. 
	 * Este m�todo averigua todos los casos posibles de permutaciones de los valores enteros de un ArrayList 
	 * de una dimensi�n sin que se repita ning�n valor. 
	 * En este m�todo se est� especificando cada paso que est� haciendo el m�todo.
	 */
	public static ArrayList<ArrayList<Integer>> encontrarPermutaciones(ArrayList<Integer> argumento) {	
		System.out.println("*******************************************************************");
		ArrayList<ArrayList<Integer>> arrayPrincipal = new ArrayList<ArrayList<Integer>>();	

		System.out.println("Array principal: "+arrayPrincipal);
		System.out.println("Tama�o del argumento: "+argumento.size());
		
		if( argumento.size() == 1 ){//CASO BASE	
			arrayPrincipal.add( new ArrayList<Integer>(argumento) );	
			System.out.println("Entra a caso base: "+arrayPrincipal);
			return arrayPrincipal;	
		}
		for( int i = 0 ; i < argumento.size(); i++ ){//CASO RECURSIVO	
			int guardarValor = argumento.get( i );
			System.out.println("Valor guardado: "+guardarValor);
			System.out.println("Tama�o del argumento: "+argumento.size());
			
			ArrayList<Integer> arrayListAlmcaenado = new ArrayList<Integer>(argumento);	
			
			System.out.println("Valores en ArrayList almacenado: "+arrayListAlmcaenado);
			
			int valorRemover = arrayListAlmcaenado.remove( i );
			
			System.out.println("Valor removido: "+valorRemover);
			System.out.println("Valores que quedan en ArrayList almacenado: "+arrayListAlmcaenado);
			
			ArrayList<ArrayList<Integer>> recursividad = encontrarPermutaciones(arrayListAlmcaenado);//RECURSIVIDAD	

			System.out.println("Valores que hay en ArrayList recursividad: "+recursividad);
			
			for( int j = 0 ; j < recursividad.size() ; j++ ){//JUNTA LOS VALORES EN EL ARRAYLIST PRINCIPAL
				ArrayList<Integer> arrayListJuntar = new ArrayList<Integer>();		
				System.out.println("Nuevo valor en la variable guardarValor: "+guardarValor);
				arrayListJuntar.add( guardarValor );	
				arrayListJuntar.addAll( recursividad.get( j ) );
				System.out.println("Valores que hay en ArrayList juntar: "+arrayListJuntar);		
				arrayPrincipal.add( arrayListJuntar );
				System.out.println("Los nuevos valores que hay en ArrayList principal: "+arrayPrincipal);
				System.out.println("NUEVO ARGUMENTO.SIZE(): "+argumento.size());
			}
		}
		System.out.println("final: "+arrayPrincipal);
		return arrayPrincipal;//DEVUELVE LOS VALORES DEL ARRAYLIST PRINCIPAL	
	}//FIN DEL M�TODO ENCONTRAR PERMUTACIONES
}//FIN DE LA CLASE
