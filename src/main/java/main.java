import Telas.TelaPrincipal;

/**
 *
 * @author Arthur Felipe MS
 */
public class main {

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
