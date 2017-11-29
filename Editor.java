
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Editor {

    private JTextArea area;

    public JTextArea getArea() {
        return area;
    }

    public void setArea(JTextArea area) {
        this.area = area;
    }

    public void novo(JInternalFrame janela) {
        area.setText("");
        janela.setVisible(true);
    }

    public void abrir(JFrame janela, JInternalFrame janelaI) {

        JFileChooser abrir = new JFileChooser("c:/ meus documentos");
        int retorno = abrir.showOpenDialog(janela);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            try {
                FileReader file = new FileReader(abrir.getSelectedFile());
                BufferedReader input = new BufferedReader(file);
                String linha, saida = "";
                while ((linha = input.readLine()) != null) {
                    saida = saida + linha + "\n";
                }
                input.close();
                area.setText(saida);
            } catch (IOException e) {
                e.printStackTrace();
            }
            janelaI.setVisible(true);
        }
    }

    public void salvar(JFrame janela, JInternalFrame janelaI) {
        JFileChooser salvar = new JFileChooser("c:/meus documentos");
        int retorno = salvar.showSaveDialog(janela);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter file = new FileWriter(salvar.getSelectedFile());
                BufferedWriter output = new BufferedWriter(file);
                output.write(area.getText());
                output.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void configurarFonte(String nome) {
        area.setFont(new Font(
                nome,
                area.getFont().getStyle(),
                area.getFont().getSize()));

    }

    public void configurarCor(Color c) {
        area.setForeground(c);

    }

    public void configurarTamanho(int i) {
        area.setFont(new Font(area.getFont().getName(), 
                area.getFont().getStyle(), 
                i));
    }

    public void copiar() {
        area.copy();
    }

    public void recortar() {
        area.cut();
    }

    public void colar() {
        area.paste();
    }

    public void selecionar() {
        area.selectAll();
    }

    public void sobre(JFrame janela) {
        JOptionPane.showMessageDialog(janela, "Java Edit versão 1.0, feito por Fernanda Umberto");
    }

    public void sair() {
        System.exit(0);
    }
}
