
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import com.panayotis.gnuplot.JavaPlot;	

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		/* CREACION DEL ARCHIVO DE TEXTO Y EL BUFFER */
		File burbuja = new File("Burbuja.txt");
		burbuja.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(burbuja));
		/* PEDIMOS EL NUMERO DE DATOS */
		System.out.println("Digite un número");
		int num = scan.nextInt();
		/* HALLAMOS LOS TIEMPOS CON Y LO COLOCAMOS DENTRO DEL TXT */
		for (int i = 0; i <= num; i++) {
			int [] array = createArray(i);	// CREACION DEL ARREGLO
			double tiempoInicio = System.nanoTime();
			bubbleSort(array);
			double tiempoFinal = System.nanoTime()-tiempoInicio;
			bw.write(i+"\t"+tiempoFinal+"\n");	 // COLOCANDO LOS TIEMPOS EN EL TXT
			System.out.println("n="+i+" se demora "+(tiempoFinal)+" nanosegundos");
		}
		
		bw.close(); 
		
		Desktop.getDesktop().open(burbuja);	// MUESTRA EL ARCHIVO "Burbuja.txt" 
		
		/* DIBUJAMOS LA FUNCION */
		JavaPlot p = new JavaPlot();
		p.setTitle("Burbuja");
		p.addPlot("\"Burbuja.txt\"with lines"); 
		p.plot();
	}
	/* ORDENACION BURBUJA */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}
		}

	}
	/* CREACION DEL ARREGLO */
	public static int[] createArray(int num) {
		Random random = new Random();
		int[] array = new int[num];
		for (int i = 0; i < array.length; i++) 
			array[i] = random.nextInt(array.length*3) + 1;	
		return array;
	}
	/* IMPRIME UN ARREGLO */
	public static void printArray(int array[]) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ",");
		}
		System.out.println("]");
	}
}
