package br.sp.senac.casa.lojainformatica.classes;

public class Computador {

    private static String marca = "KaioSilveira";
    private String hd;
    private String processador;

    public Computador(String marca, String hd, String processador) {
        // Aqui deixei o construtor vazio, mas tive que preencher na etapa de criação de objetos.
        this.marca = marca;
        this.hd = hd;
        this.processador = processador;

    }

    //ALT+Insert para chamar os getters e setters. 
    public static String getMarca() {
        return marca;
    }

    public String getHd() {
        return hd;
    }

    public String getProcessador() {
        return processador;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

}
