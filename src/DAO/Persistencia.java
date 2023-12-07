package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	private volatile static Persistencia instance;
	/**
	 * persistencia com direito a escalabilidade multi-threading
	 * 
	 * com checagem duas etapas
	 * 
	 * padrao Singleton implementado
	 * 
	 * */
	public static Persistencia getInstance() {
		if(instance == null) {
			 synchronized(Persistencia.class) {
				 if(instance == null) {
					 instance = new Persistencia();
				 }
			 }
		}
		return instance;
	}
    private XStream xstream = new XStream(new DomDriver());
    private File arquivo;
    private Persistencia(){
        xstream.addPermission(AnyTypePermission.ANY);
    }
    public void salvarCentral(CentralDeInformacoes banco, String caminho){
        String xml = xstream.toXML(banco);
        arquivo = new File(caminho);
            try {
                if(!arquivo.exists())
                    arquivo.createNewFile();
                PrintWriter gravar = new PrintWriter(arquivo);
                gravar.println(xml);
                gravar.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public CentralDeInformacoes recuperarCentral(String caminho){
        arquivo = new File(caminho);
            try {
                if(arquivo.exists()) {
                    FileInputStream fis = new FileInputStream(arquivo);
                    return (CentralDeInformacoes) xstream.fromXML(fis);
                }

            } catch (FileNotFoundException e) {
                 e.printStackTrace();
            }

        return new CentralDeInformacoes();
    }
}