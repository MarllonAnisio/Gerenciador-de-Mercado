package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * persistencia que fará com que tenhamos sobContole a nossa Central
 * 
 */
public class Persistencia {
	/**
	 * XStream que será criado e armazenará nossa central
	 * */
	XStream xstream = new XStream(new DomDriver());
	/**
	 * arquivo que por sua vez será o caminho unico pois já é definido na criação
	 * */
	public File arquivo;
	/**
	 * construtor da persistencia que define o caminho que a mesma 
	 * */
	public Persistencia() {
		xstream.addPermission(AnyTypePermission.ANY);
		arquivo = new File("Central");
	
	}
	/**
	 * metodo que salvará nosso nossa central.XML
	 * */
	public void salvarCentral(CentralDeInformacoes banco, String caminho) {
		try {
			String xml = xstream.toXML(banco);
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.println(xml);
			gravar.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * metodo utilizado para recuperarmos nossa central esse recuperar e o proprio Salvar so vão ser utilizados
	 * pelo nosso padrao Singleton que é nossa Central de informações
	 * */
	public CentralDeInformacoes recuperarCentral(String caminho) {
		try {
			if (arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				CentralDeInformacoes p = (CentralDeInformacoes) xstream.fromXML(fis);
				return p;
			}

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}