Este repositório contém uma classe Java chamada "Computador", que faz parte de um projeto de uma loja de informática.
Esta classe representa um computador e contém informações sobre a marca, o disco rígido (HD) e o processador.

Pacote
O arquivo fonte da classe está localizado no seguinte pacote:

go
Copiar código
package br.sp.senac.casa.lojainformatica.classes;
Atributos
marca (estático): Representa a marca do computador.
hd: Representa o disco rígido do computador.
processador: Representa o processador do computador.
Construtor
A classe possui um construtor que permite a inicialização dos atributos durante a criação do objeto. O construtor tem a seguinte assinatura:

java
Copiar código
public Computador(String marca, String hd, String processador) {
    // Inicialização dos atributos
    this.marca = marca;
    this.hd = hd;
    this.processador = processador;
}
Métodos
A classe possui os seguintes métodos:

getMarca(): Retorna a marca do computador.
getHd(): Retorna o disco rígido do computador.
getProcessador(): Retorna o processador do computador.
setMarca(String marca): Define a marca do computador.
setHd(String hd): Define o disco rígido do computador.
setProcessador(String processador): Define o processador do computador.
O getter de marca é estático.

Uso
Para utilizar a classe Computador em seu projeto, basta incluir o arquivo fonte no pacote correspondente e instanciar objetos conforme necessário.

Exemplo de uso:

java
Copiar código
// Criando um objeto Computador
Computador meuComputador = new Computador("BrunoCruz", "500GB", "Intel Core i7");

// Acessando os atributos
String marca = meuComputador.getMarca();
String hd = meuComputador.getHd();
String processador = meuComputador.getProcessador();
Você pode adicionar ou modificar informações conforme necessário.
