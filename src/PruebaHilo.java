import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaHilo {

	public static void main(String[] args) {
		HiloInterrupt hiloInterrupt= new HiloInterrupt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//lectura de la entrada estandar del sistema
		
		String tecla;
		try{
			while (hiloInterrupt.vive()){
				System.out.println("Hilo vivo, [i]interrumpe, [k] matar");
				tecla=br.readLine();
				if(tecla.equals("i")){
					hiloInterrupt.interrumpir();
				}
				if(tecla.equals("k")){
					hiloInterrupt.detener();
				}
			}
			hiloInterrupt.esperar();
			System.out.println("Hilo principal finalizado");
		}
		catch(IOException | InterruptedException e){}
		
	}
}
