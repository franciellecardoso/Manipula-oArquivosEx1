package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqcontrol = new ArquivosController();
		try {
			arqcontrol.readDir("C:\\TEMP\\", "generic_food.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}