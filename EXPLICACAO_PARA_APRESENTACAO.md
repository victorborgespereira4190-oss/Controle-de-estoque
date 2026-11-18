# Explicação do projeto

## O que o programa faz?
É um sistema simples de controle de estoque de uma cantina. Permite cadastrar produtos, consultar os itens, registrar vendas e calcular o valor de tudo que ainda está disponível.

## Como explicar a organização do código?
- **Produto.java** representa cada produto com código, nome, preço e quantidade.
- **Main.java** mostra o menu, lê as respostas digitadas e organiza as operações.
- O **ArrayList<Produto>** guarda os produtos enquanto o programa está aberto.
- O **Scanner** recebe o que a pessoa digita pelo teclado.
- O **do-while** mantém o menu funcionando até escolher a opção 6.
- O **switch** escolhe a operação e os **if/else** fazem as validações.
- Os métodos separam o cadastro, a busca, as vendas e os cálculos.

## Exemplo para demonstrar
1. Cadastre um suco com código 101, preço R$ 5,00 e quantidade 10.
2. Liste os produtos para mostrar o suco cadastrado.
3. Busque pelo código 101.
4. Venda 3 unidades e mostre que restaram 7.
5. Mostre o valor total de R$ 35,00.
6. Tente vender mais 8 unidades: a venda deve ser recusada e o estoque deve continuar com 7.
7. Tente cadastrar outro produto com código 101: o sistema deve impedir o cadastro.

