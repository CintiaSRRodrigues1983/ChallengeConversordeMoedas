# 💱 Challenge: Conversor de Moedas em Java

Este projeto é parte de um desafio de aprendizado em Java, cujo objetivo é desenvolver um **conversor de moedas funcional**, utilizando uma API de câmbio em tempo real. 
O foco principal é aprender a consumir APIs externas, manipular dados em formato JSON e estruturar o código de forma modular e reutilizável.

---

## 📚 Sobre o projeto

O **Conversor de Moedas** é uma aplicação em Java que permite ao usuário obter a taxa de câmbio entre duas moedas (como USD para BRL) e converter valores com base na cotação atual. 
A aplicação realiza uma requisição HTTP para a **[ExchangeRate-API](https://www.exchangerate-api.com/)**, que retorna as informações de câmbio em tempo real.  

Este projeto foi criado com o intuito de:

- Praticar consumo de APIs REST com `HttpClient`
- Aprender a trabalhar com JSON usando a biblioteca `Gson`
- Criar uma base sólida para evoluir para uma aplicação gráfica no futuro
- Familiarizar-se com versionamento no GitHub

---

## 🛠️ Tecnologias e bibliotecas utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| `Java 11+` | Linguagem principal do projeto |
| `HttpClient` | Cliente HTTP moderno introduzido no Java 11 |
| `Gson` | Biblioteca da Google para leitura e escrita de JSON |
| `ExchangeRate-API` | API externa para consulta de taxas de câmbio |

---

## 📦 Estrutura do projeto

ChallengeConversordeMoedas/
├── ConversorMoedas.java # Classe principal com a lógica da conversão
├── README.md # Documentação do projeto
└── gson-2.10.1.jar # Biblioteca para manipulação de JSON (caso não use Maven)

---

## 📁 Descrição da classe principal

### 🧩 `ConversorMoedas.java`

Classe responsável por:

- Realizar a requisição HTTP à API de câmbio
- Interpretar a resposta JSON e extrair a taxa de conversão
- Multiplicar o valor informado pela taxa
- Retornar o resultado ao usuário

#### Principais métodos:

```java

public static double obterTaxa(String moedaOrigem, String moedaDestino)
Este método acessa a ExchangeRate-API e retorna a taxa de conversão entre as moedas informadas.

public static double converter(double valor, double taxa)
Realiza a conversão do valor original com base na taxa de câmbio retornada.


▶️ Como executar o projeto

*Clone o repositório:

git clone https://github.com/CintiaSRRodrigues1983/ChallengeConversordeMoedas.git
Abra o projeto no IntelliJ IDEA (ou outra IDE Java)

*Adicione a biblioteca Gson ao projeto:

Faça o download do .jar: Gson.

*Execute a classe principal com o método main() para testar:

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONVERSOR DE MOEDAS ===");

        while (true) {
            System.out.println("\nEscolha a moeda de ORIGEM:");
            exibirOpcoes();
            String origem = MOEDAS[scanner.nextInt() - 1];

            System.out.println("Escolha a moeda de DESTINO:");
            exibirOpcoes();
            String destino = MOEDAS[scanner.nextInt() - 1];

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            try {
                double taxa = ConversorMoedas.obterTaxa(origem, destino);
                double resultado = ConversorMoedas.converter(valor, taxa);

                System.out.printf("\n%.2f %s = %.2f %s\n", valor, origem, resultado, destino);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("\nDeseja fazer outra conversão? Responda apenas sim ou não: ");
            String continuar = scanner.next().toLowerCase();
            if (!continuar.equals("sim")) {
                System.out.println("Encerrando o programa.");
                break;
            }
        }

        scanner.close();
    }

    private static void exibirOpcoes() {
        for (int i = 0; i < MOEDAS.length; i++) {
            System.out.println((i + 1) + " - " + MOEDAS[i]);
        }
        System.out.print("Digite a opção: ");
    }
}


💡 Exemplo de resposta da API:

=== CONVERSOR DE MOEDAS ===

Escolha a moeda de ORIGEM:
1 - USD
2 - BRL
3 - ARS
4 - COP
5 - CLP
6 - BOB
Digite a opção: 1
Escolha a moeda de DESTINO:
1 - USD
2 - BRL
3 - ARS
4 - COP
5 - CLP
6 - BOB
Digite a opção: 2
Digite o valor a ser convertido: 100

100,00 USD = 552,18 BRL

Deseja fazer outra conversão? Responda apenas sim ou não: não
Encerrando o programa.

Process finished with exit code 0


🔐 Sobre a chave da API
Este projeto usa uma chave gratuita fornecida pela ExchangeRate-API:
Você pode criar sua própria chave acessando:
🔗 https://www.exchangerate-api.com/


📈 Possíveis melhorias futuras
Criar interface gráfica com Swing ou JavaFX

Permitir entrada interativa via terminal

Adicionar menu para converter várias moedas (escolher uma moeda e ele me devolver a conversão de várias moedas ao mesmo tempo).

Exibir mais detalhes como data da taxa, símbolo da moeda, etc.

Salvar histórico de conversões em .txt ou .csv

👩‍💻 Autora
Cíntia Silveira Rosa Rodrigues
Desenvolvedora em formação | Apaixonada por aprendizado contínuo

🔗 GitHub

📄 Licença
Este projeto está licenciado sob a licença MIT.
Sinta-se à vontade para usar, modificar e compartilhar. 😄

---
