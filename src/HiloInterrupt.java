
public class HiloInterrupt implements Runnable{

	
	private Thread miHilo;
	private volatile boolean vivo;//el valor de la propiedad nunca se cachea (garantiza una lectura limpia)
	
	public HiloInterrupt() {
		this.vivo=true;
		miHilo= new Thread(this,"hiloHijo");
		miHilo.start();
	}
	
	//metodo para detener el hilo
	
	public void detener(){
		this.vivo=false;
		//metodo desaconsejado
		//this.miHilo.stop();
	}
	//metodo para interrumpir asegurandose que no apunta a null
	public void interrumpir(){
		if (this.miHilo!=null)
		{
			this.miHilo.interrupt();
		}
	}
	//metodo para ver si esta vivo o no el hilo.
	public boolean vive() {
		//return this.miHilo.isAlive(); //no es optimo puesto que para matarlo con la k hay que hacerlo 2 veces
		return this.vivo;
	}
	
	public void esperar() throws InterruptedException {
		this.miHilo.join();
	}
	
	@Override
	public void run() {

			
		System.out.println("Corriendo el hilo ahora...");
		
		while(this.vivo){
			try {	
			System.out.println("El hilo va a dormir");
				Thread.sleep(2000);	
			} 
			catch (InterruptedException e) {
					System.out.println("El hilo hijo ha sido interrumpido");
			}
			
		}
		
		System.out.println("Hilo finalizado y saliendo de forma ordenada");
		

		
	}

}
