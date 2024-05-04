import java.io.BufferedReader;
import java.io.FileReader;

import linked.ListaLigada;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada(); 
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt")); 
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
                    int numero = Integer.parseInt(partes[1]);
                    int posicao = Integer.parseInt(partes[2]);
                    
                    switch (acao) {
                        case 'A':
                            lista.insereElementoPosicao(numero, posicao); 
                            break;
                        case 'R':
                            lista.removeIndice(posicao); 
                            break;
                        case 'P':
                            System.out.println("Lista atual: " + lista.toString()); 
                            break;
                        default:
                            System.out.println("Ação inválida: " + acao);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

