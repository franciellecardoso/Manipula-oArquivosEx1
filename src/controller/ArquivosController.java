package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController implements IArquivosController {

	@Override
	public void readDir(String path, String arquivo) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, arquivo);
			if (arq.exists()) {
				readFile(path, arquivo);
			} else {
				throw new IOException("Arquivo Válido!");
			}
		} else {
			throw new IOException("Diretório Inválido!");
		}
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		FileInputStream fluxo = new FileInputStream(arq);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		while (linha != null) {
			if (linha.contains("Fruits")) {
				for (String aux : linha.split(",", 4)) {
					if (!aux.contains("Fruits")) {
						System.out.print(aux + "	");
					}
				}
				System.out.println(" \n \n");
			}
			linha = buffer.readLine();
		}
		leitor.close();
		fluxo.close();
		System.out.println("\n Fim do Arquivo");
	}
}