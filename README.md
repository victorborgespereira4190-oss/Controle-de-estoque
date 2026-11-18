# Controle de Estoque da Cantina

**Aluno:** Victor Gabriel Borges Pereira

**Disciplina:** Desenvolvimento de Sistemas

**Tema escolhido:** Opção A — Controle de Estoque da Cantina

## Descrição
Sistema simples em Java que permite controlar os produtos de uma cantina escolar pelo console. Os dados ficam na memória enquanto o programa está aberto.

## Como executar no IntelliJ IDEA
1. Abra o IntelliJ IDEA e escolha **Open**.
2. Selecione a pasta do projeto.
3. Configure um JDK Java 8 ou superior, se solicitado.
4. Abra `src/Main.java` e clique no botão verde ao lado de `main` para executar.
5. Digite os números do menu no console.

Alternativa pelo terminal, na pasta do projeto:
```bash
javac -d out src/Produto.java src/Main.java
java -cp out Main
```

## Funcionalidades
1. Cadastrar produto (código único, nome, preço e quantidade).
2. Listar produtos cadastrados.
3. Buscar produto pelo código.
4. Registrar venda e reduzir o estoque.
5. Calcular o valor total dos produtos em estoque.
6. Sair do programa.

## Regras e validações
O programa impede códigos repetidos, nomes vazios, preços menores ou iguais a zero, quantidades negativas, vendas com quantidade menor ou igual a zero e vendas superiores ao estoque disponível. Também avisa quando um código não existe e quando a lista está vazia.

## Roteiro dos testes obrigatórios
**Importante:** execute os testes e preencha a coluna de resultado obtido com o que você realmente observou antes da entrega. Reinicie o programa quando precisar de uma lista vazia.

| Teste | Ação e dados utilizados | Resultado esperado | Resultado obtido |
|---|---|---|---|
| Cadastro válido | Cadastrar código 101, nome Suco, preço 5,00, quantidade 10; listar | Suco aparece com 10 unidades | A preencher após execução |
| Código repetido | Cadastrar novamente código 101 | Cadastro recusado | A preencher após execução |
| Informação inválida | Tentar cadastrar preço 0; tentar quantidade -1 | Cadastro recusado | A preencher após execução |
| Busca existente | Buscar código 101 | Exibe Suco | A preencher após execução |
| Busca inexistente | Buscar código 999 | Informa produto não encontrado | A preencher após execução |
| Operação principal | Vender 3 unidades do código 101 | Restam 7; valor total R$ 35,00 (se só houver esse produto) | A preencher após execução |
| Operação não permitida | Tentar vender 8 unidades do código 101 | Venda recusada; permanecem 7 unidades | A preencher após execução |
| Lista vazia | Reiniciar programa e escolher opção 2 | Informa que não há produtos | A preencher após execução |
| Opção inválida | Digitar 9 no menu | Mostra erro e volta ao menu | A preencher após execução |

## Limitações
- Os dados não são salvos após encerrar o programa (permitido pela atividade).
- O sistema funciona somente no console.

## Uso de inteligência artificial
Foi utilizada uma ferramenta de inteligência artificial como apoio na organização inicial do código e na elaboração da documentação. O aluno deve revisar, executar, testar e compreender o programa antes da entrega.

## Entrega
Publique os arquivos no seu repositório GitHub e entregue o link na atividade do Microsoft Teams. Confira se o status final aparece como **Entregue**.
