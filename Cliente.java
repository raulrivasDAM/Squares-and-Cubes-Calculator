package numeros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int puerto = 6000;
		Socket cliente;
		InetAddress ip = InetAddress.getByName(host);
		// cliente=new Socket(ip, puerto);
		

		// Flujo de salida al servidor-> escribe

		Scanner s = new Scanner(System.in);
		int num = 1000;
		try {
			cliente = new Socket(host, puerto);
			ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
			do {
				System.out.println("Dime un número");
				num = s.nextInt();
				Numeros n = new Numeros();
				n.setNumero(num);

				flujoSalida.writeObject(n);
				if (num > 0) {
					Numeros objetoRecibido;

					objetoRecibido = (Numeros) flujoEntrada.readObject();
					System.out.println(
							"Cuadrado: " + objetoRecibido.getCuadrado() + ", Cubo: " + objetoRecibido.getCubo());

				}

				

			} while (num > 0);
			flujoSalida.close();
			flujoEntrada.close();
		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}
	}
}
