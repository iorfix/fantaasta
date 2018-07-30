import org.fasta.dati.AstaMain;

public class TestAsta {
    public static void main(String args[]) throws Exception {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        AstaMain.main(new String[] {"src/test/resources/fasta_totale.xml"});
    }
}
