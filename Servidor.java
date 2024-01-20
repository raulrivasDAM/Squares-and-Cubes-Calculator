package numeros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int puerto = 6000;

		try {
			ServerSocket servidor = new ServerSocket(puerto);
			System.out.println("Servidor esperando conexiones...");

			while (true) {
				try (Socket cliente = servidor.accept()) {
					System.out.println("Aceptando cliente desde " + cliente.getInetAddress());

					conectarClientes(cliente);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void conectarClientes(Socket cliente) {
		try (ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream())) {

			while (true) {
				Numeros num = (Numeros) flujoEntrada.readObject();

				if (num.getNumero() <= 0) {
					break;
				}

				num.setNumero(num.getNumero());
				num.calcularCuadrado(num.getNumero());
				num.calcularCubo(num.getNumero());
				flujoSalida.writeObject(num);
			}

			System.out.println("Cliente desconectado desde " + cliente.getInetAddress());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
