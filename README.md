# Desafio Técnico - Prothera Tecnologia

## Proposta do Desafio

O desafio consiste em desenvolver uma aplicação Java para gerenciar uma lista de funcionários de uma indústria. A aplicação deve permitir a inserção, remoção, modificação e consulta dos dados dos funcionários, além de outras funcionalidades específicas, como agrupamento por função e cálculo de salários.

## Estrutura da minha solução

A minha solução foi estruturado de forma a seguir as boas práticas de programação e os princípios da Orientação a Objetos e SOLID. Abaixo, segue uma descrição detalhada da estrutura de pastas e classes da solução:

```
src/
├── main/
│   ├── java/
│   │   └── com/empresa/
│   │       ├── Main.java
│   │       ├── model/
│   │       │   ├── Pessoa.java
│   │       │   └── Funcionario.java
│   │       ├── service/
│   │       │   └── FuncionarioService.java
│   │       └── utils/
│   │           ├── DateUtils.java
│   │           └── NumberUtils.java
│   └── resources/
└── test/
```

### Classes

#### `com.empresa.Main`

A classe principal que executa todas as ações solicitadas no desafio. Ela cria e manipula a lista de funcionários, chamando os métodos do serviço correspondente.

#### `com.empresa.model.Pessoa`

Classe que representa uma pessoa, contendo os atributos `nome` (String) e `dataNascimento` (LocalDate) como solicitado na descrição do desafio.

#### `com.empresa.model.Funcionario`

Classe que estende a `Pessoa`, adicionando os atributos `salario` (BigDecimal) e `funcao` (String) como solicitado na descrição do desafio.

#### `com.empresa.service.FuncionarioService`

Classe responsável pela lógica de negócios relacionada aos funcionários. Contém métodos para inserção, remoção, atualização e consulta dos dados dos funcionários.

#### `com.empresa.utils.DateUtils`

Classe para formatação de datas no formato `dd/MM/yyyy` como requisito solicitado de resposta.

#### `com.empresa.utils.NumberUtils`

Classe para formatação de números com separador de milhar como ponto e decimal como vírgula, ja que foi um dos requisitos solicitado.

## Princípios Aplicados na solução

- **(SRP)**: Cada classe tem uma única responsabilidade. Por exemplo, `DateUtils` é responsável apenas pela formatação de datas, e `FuncionarioService` pela lógica de negócios dos funcionários.
- **(OCP)**: A estrutura permite que eu adicione novas funcionalidades sem a necessidade de modificar o código existente.
- **(LSP)**: As subclasses (`Funcionario`) podem ser utilizadas no lugar das superclasses (`Pessoa`) sem alterar a funcionalidade do programa.
- **(ISP)**: Na verdade não apliquei diretamente aqui, mas a lógica de serviços e utils estão separadas para evitar a criação de interfaces "gordas".
- **(DIP)**: Este também não está diretamente visível, mas a separação de lógica em serviços facilita a injeção de dependências futuras, caso eu queira.

## Funcionalidades Implementadas

1. **Inserção dos Funcionários**: Todos os funcionários são inseridos na lista na mesma ordem e com as mesmas informações fornecidas.
2. **Remoção do Funcionário "João"**: O funcionário com o nome "João" é removido da lista.
3. **Impressão dos Funcionários**: Todos os funcionários são impressos com suas informações formatadas (data de nascimento e salário).
4. **Aumento de Salário**: Todos os funcionários recebem um aumento de 10% no salário.
5. **Agrupamento por Função**: Os funcionários são agrupados por função em um mapa.
6. **Impressão por Função**: Os funcionários são impressos agrupados por função.
7. **Aniversariantes dos Meses 10 e 12**: Funcionários que fazem aniversário nos meses 10 e 12 são impressos.
8. **Funcionário com Maior Idade**: O funcionário com a maior idade é identificado e impresso.
9. **Ordenação Alfabética**: A lista de funcionários é impressa em ordem alfabética.
10. **Total dos Salários**: O total dos salários dos funcionários é calculado e impresso.
11. **Salários Mínimos**: A quantidade de salários mínimos que cada funcionário recebe é calculado e impresso.

## Objetivos Atingidos

Todos os requisitos do desafio foram implementados, seguindo as boas práticas de programação e utilizando os princípios da orientação a objetos e SOLID. A solução está bem estruturada e tomei o cuidado de deixar mais legível possível para quem for ler.

---
