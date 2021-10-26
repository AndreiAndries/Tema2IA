import java.util.ArrayList;
import java.util.List;

public class Regiune {

    private String nume;
    private Culoare culoare;
    private List<Culoare> culriPosibile;
    private List<String> vecini;

    public Regiune() {
        this.nume = "";
        this.culoare = Culoare.NECOLORAT;
        culriPosibile = new ArrayList<>();
        vecini = new ArrayList<>();
    }

    public Regiune(String nume) {
        this.nume = nume;
        this.culoare = Culoare.NECOLORAT;
        culriPosibile = new ArrayList<>();
        vecini = new ArrayList<>();
    }

    public Regiune(String nume, Culoare culoare) {
        this.nume = nume;
        this.culoare = culoare;
    }

    public Regiune(Regiune regiune){
        this.nume = regiune.getNume();
        this.culoare = regiune.getCuloare();
        this.culriPosibile = new ArrayList<>(regiune.getCulriPosibile());
        this.vecini = new ArrayList<>(regiune.getVecini());
    }

    public List<String> getVecini() {
        return vecini;
    }



    public void setVecini(List<String> vecini) {
        this.vecini = new ArrayList<>(vecini);
    }

    public List<Culoare> getCulriPosibile() {
        return culriPosibile;
    }

    public void setCulriPosibile(List<Culoare> culriPosibile) {
        this.culriPosibile = new ArrayList<>(culriPosibile);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Culoare getCuloare() {
        return culoare;
    }

    public void setCuloare(Culoare culoare) {
        this.culoare = culoare;
    }

    public void eliminaCuloare(Culoare culoare){
        culriPosibile.remove(culoare);
    }

    public void afisareParametri(){
        System.out.println("Regiunea: " + this.nume + " e vecina cu regiunile " + this.vecini + " poate fi colorata cu " + this.culriPosibile);
    }

    @Override
    public String toString() {
        return "Regiunea(" +nume + ")->Culoarea(" + culoare +");";
    }
}
