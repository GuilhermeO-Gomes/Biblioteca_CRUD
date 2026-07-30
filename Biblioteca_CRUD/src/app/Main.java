package app;

import javax.swing.SwingUtilities;


import view.TelaLivros;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaLivros tela = new TelaLivros();
                tela.setVisible(true);
            }
        });
    }
}
