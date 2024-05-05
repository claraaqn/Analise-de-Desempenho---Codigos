import java.io.BufferedReader;
import java.io.FileReader;

import linked.ListaLigada;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada(); 
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mclar\\Documents\\Analise de Desempenho - Codigos\\atv 1\\src\\arq1.txt")); // só mudar o arquivo aqui
            String linha;
            int contagemLinhas = 0;

            while ((linha = reader.readLine()) != null) {
                contagemLinhas++;
                if (contagemLinhas == 1) { 
                    String[] valores = linha.split(" ");
                    for (String valor : valores) {
                        lista.insereElemento(Integer.parseInt(valor)); 
                    }
                } else if (contagemLinhas >= 3) { 
                    String[] partes = linha.split(" ");
                    char acao = partes[0].charAt(0);
                    if (acao == 'P') {
                       System.out.println("Lista atual: " + lista.toString()); 
                        break; 
                    } else if (acao == 'A') {
                        int numero = Integer.parseInt(partes[1]);
                        int posicao = Integer.parseInt(partes[2]);
                        lista.insereElementoPosicao(numero, posicao); 
                    } else if (acao == 'R'){
                        int posicao = Integer.parseInt(partes[1]);
                        lista.removeIndice(posicao); 
                    }                       
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

