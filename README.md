
# Campo Minado - Processador de Campo

## 📖 Descrição

Este projeto é uma implementação em Python de um processador de campos do jogo **Campo Minado** (Minesweeper). O programa recebe como entrada diversos campos com minas (`*`) e espaços livres (`.`), e retorna cada campo com dicas numéricas indicando a quantidade de minas adjacentes a cada posição livre.

## 🎮 Exemplo

### Entrada:

```
4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0
```

### Saída:

```
Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100
```

## ⚙️ Funcionamento

1. O programa lê repetidamente campos de diferentes tamanhos até que seja inserido `0 0`, que encerra a entrada.
2. Para cada campo, percorre todas as posições:
   - Se for uma mina (`*`), mantém o caractere.
   - Se for um espaço livre (`.`), conta quantas minas existem ao seu redor (máximo de 8 posições adjacentes).
3. Exibe o resultado formatado, indicando o número do campo processado.

## 🗂️ Estrutura do Código

- `solve_field(field)`: Função principal que processa o campo, substituindo espaços livres pelo número de minas adjacentes.
- `is_valid(x, y)`: Função auxiliar que valida se a posição `(x, y)` está dentro dos limites do campo.
- `main()`: Função que realiza a leitura das entradas, chama o processamento e imprime a saída no formato especificado.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Python 3
- **Bibliotecas:** Apenas bibliotecas padrão do Python (não há dependências externas).

## ▶️ Como Executar

1. **Pré-requisito:** Ter o Python 3 instalado na máquina.
2. Salve o código em um arquivo chamado `campo_minado.py`.
3. No terminal, navegue até o diretório onde o arquivo está salvo.
4. Execute o programa com o comando:

```bash
python campo_minado.py
```

5. Digite as entradas conforme o formato especificado e pressione `Enter` após cada linha. Para encerrar a entrada, insira `0 0`.

## 📝 Observações

- O programa utiliza `input()` para ler as entradas diretamente do terminal.
- Caso queira testar rapidamente, pode redirecionar a entrada a partir de um arquivo de texto contendo os campos.
- Implementação eficiente e legível, utilizando listas e laços aninhados para verificar as posições adjacentes.

## 🚀 Melhorias Futuras

- Adicionar suporte à leitura e escrita de arquivos.
- Criar uma interface gráfica para tornar o uso mais intuitivo.
- Implementar testes automatizados para validar diferentes cenários de entrada.

## 👨‍💻 Autor

Projeto desenvolvido por [Seu Nome].
