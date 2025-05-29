
# JNotepad - Simulador de Notepad com Java Swing

## Descrição

Este projeto consiste no desenvolvimento de uma aplicação desktop utilizando **Java Swing** para simular o clássico **Notepad** do Windows. O aplicativo oferece funcionalidades básicas de edição de texto, manipulação de arquivos, customização de fontes e exibição de informações sobre o software.

## Funcionalidades

**Menu Arquivo:**
- **Abrir:** permite selecionar um arquivo de texto e carregá-lo no editor.
- **Salvar:** permite salvar o conteúdo editado em um arquivo.
- **Sair:** encerra a aplicação.

**Menu Fontes:**
- **Arial (Tamanho 14):** altera a fonte do conteúdo para Arial, tamanho 14.
- **Courier New (Tamanho 24):** altera a fonte do conteúdo para Courier New, tamanho 24.

**Menu Ajuda:**
- **Sobre:** exibe uma janela modal com informações básicas sobre o aplicativo.

**Editor de Texto:**
- Área central para digitação de texto plano.
- **Barra de Status Inferior:** exibe a contagem de caracteres e um indicador de modificação (Sim/Não) desde a última abertura ou salvamento do arquivo.

## Estrutura do Código

- **Classe `NotepadApp`:** principal componente da aplicação, estende `JFrame`.
- **Componentes:**
  - `JTextArea` para edição de texto.
  - `JLabel` para exibição do status.
  - `JMenuBar` com menus e itens conforme especificado.
- **Funções principais:**
  - `openFile()`: abre arquivos de texto.
  - `saveFile()`: salva o conteúdo editado.
  - `setFont(String, int)`: altera a fonte do texto.
  - `displayAbout()`: exibe informações sobre o aplicativo.
  - `setModified(boolean)`: atualiza o status de modificação e contagem de caracteres.
- **Eventos:**
  - Listeners para ações nos menus.
  - `DocumentListener` para monitorar alterações no texto.

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Bibliotecas:** 
  - `javax.swing` para interface gráfica.
  - `java.io` para manipulação de arquivos.
  - `java.awt.event` para gerenciamento de eventos.

## Como Executar

1. **Pré-requisitos:**
   - JDK (Java Development Kit) instalado.
   - IDE Java (como Eclipse, IntelliJ IDEA) ou editor de texto com terminal.

2. **Compilação:**

```bash
javac NotepadApp.java
```

3. **Execução:**

```bash
java NotepadApp
```

4. **Uso:**
   - Utilize o menu Arquivo para abrir ou salvar arquivos.
   - Altere a fonte via o menu Fontes.
   - Visualize informações na opção Sobre do menu Ajuda.
   - Acompanhe as modificações na barra de status inferior.

## Observações

- A barra de status é atualizada automaticamente conforme alterações são feitas no texto.
- Arquivos podem ser abertos e salvos no mesmo local ou em diretórios diferentes.
- A aplicação simula o comportamento clássico do Notepad de maneira intuitiva.

## Autor

Projeto desenvolvido por Willian dos Santos Ribas.
