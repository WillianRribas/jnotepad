import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotepadApp extends JFrame {
    private JTextArea textArea;
    private JLabel statusLabel;
    private boolean isModified;
    private File currentFile;

    public NotepadApp() {
        setTitle("Notepad Simulado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Status Bar
        statusLabel = new JLabel("Caracteres: 0, Modificado: Não");
        add(statusLabel, BorderLayout.SOUTH);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Menu Arquivo
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenuItem abrirItem = new JMenuItem("Abrir");
        JMenuItem salvarItem = new JMenuItem("Salvar");
        JMenuItem sairItem = new JMenuItem("Sair");

        abrirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        salvarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        sairItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        arquivoMenu.add(abrirItem);
        arquivoMenu.add(salvarItem);
        arquivoMenu.add(sairItem);
        menuBar.add(arquivoMenu);

        // Menu Fontes
        JMenu fontesMenu = new JMenu("Fontes");
        JMenuItem arialItem = new JMenuItem("Arial (Tamanho 14)");
        JMenuItem courierItem = new JMenuItem("Courier New (Tamanho 24)");

        arialItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFont("Arial", 14);
            }
        });

        courierItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFont("Courier New", 24);
            }
        });

        fontesMenu.add(arialItem);
        fontesMenu.add(courierItem);
        menuBar.add(fontesMenu);

        // Menu Ajuda
        JMenu ajudaMenu = new JMenu("Ajuda");
        JMenuItem sobreItem = new JMenuItem("Sobre");

        sobreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAbout();
            }
        });

        ajudaMenu.add(sobreItem);
        menuBar.add(ajudaMenu);

        setJMenuBar(menuBar);

        // Text Change Listener
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setModified(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setModified(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setModified(true);
            }
        });
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                textArea.setText(text.toString());
                currentFile = file;
                setModified(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveFile() {
        if (currentFile != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                writer.write(textArea.getText());
                setModified(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(textArea.getText());
                    currentFile = file;
                    setModified(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setFont(String fontName, int fontSize) {
        textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
    }

    private void displayAbout() {
        JOptionPane.showMessageDialog(this, "Aplicativo Notepad Simulado\nDesenvolvido em Java Swing", "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }

    private void setModified(boolean modified) {
        isModified = modified;
        statusLabel.setText("Caracteres: " + textArea.getText().length() + ", Modificado: " + (isModified ? "Sim" : "Não"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadApp notepad = new NotepadApp();
            notepad.setVisible(true);
        });
    }
}
