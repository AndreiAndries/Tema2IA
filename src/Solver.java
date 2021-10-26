import java.util.ArrayList;
import java.util.List;

public class Solver {

    private List<Regiune> regiuni;

    public Solver(List<Regiune> regiuni) {
        this.regiuni = new ArrayList<>(regiuni);
    }

    public boolean notOver(){
        for (Regiune regiune : this.regiuni){
            if (regiune.getCuloare() == Culoare.NECOLORAT)
                return true;
        }
        return false;
    }

    public Regiune selecteazaRegiunea(){
        int min = 4;
        int pozitie = 0;
        for(int i = 0 ; i < regiuni.size() ; ++i){
            if(min > this.regiuni.get(i).getCulriPosibile().size() && this.regiuni.get(i).getCuloare() == Culoare.NECOLORAT){
                min = this.regiuni.get(i).getCulriPosibile().size();
                pozitie = i;
            }
        }
        return new Regiune(this.regiuni.get(pozitie));
    }

    public void eliminaCuloare(String nume, Culoare culoare){
        for(Regiune r : this.regiuni){
            if(r.getNume().equals(nume)){
                r.eliminaCuloare(culoare);
            }
        }
    }

    public void colorare(String nume, Culoare culoare){
        for(Regiune regiune : this.regiuni){
            if(regiune.getNume().equals(nume))
                regiune.setCuloare(culoare);
        }
    }

    public List<Regiune> colorare(List<Regiune> regiuni, int culoare ,Regiune regiune){
        List<Regiune> reg = new ArrayList<>(regiuni);
        List<String> vecini = new ArrayList<>(regiune.getVecini());
        Culoare color = regiune.getCulriPosibile().get(culoare);
        for(Regiune r : reg){
            if(r.getNume().equals(regiune.getNume()))
                r.setCuloare(color);
        }
        for(String vec : vecini){
            for(Regiune r : reg){
                if(r.getNume().equals(vec)){
                    if(r.getCuloare() == Culoare.NECOLORAT){
                        r.eliminaCuloare(color);
                    }
                }
            }
        };
        return reg;
    }

    public boolean valid(List<Regiune> regiuni, int culoare,Regiune regiune){
        List<Regiune> reg = new ArrayList<>(regiuni);
        List<String> vecini = new ArrayList<>(regiune.getVecini());
        Culoare color = regiune.getCulriPosibile().get(culoare);
        for(String vec : vecini){
            for(Regiune r : reg){
                if(r.getNume().equals(vec)){
                    if(r.getCuloare() == color){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean notOver(List<Regiune>regiuni){
        for(Regiune regiune : regiuni){
            if(regiune.getCuloare() == Culoare.NECOLORAT)
                return true;
        }
        return false;
    }

    public void forwardCheckingBKT(){
        List<List<Regiune>>stari = new ArrayList<>();
        List<Regiune>stareActuala = new ArrayList<>(regiuni);
        afisare(stareActuala);
        stari.add(regiuni);
        int stare = 1;
        while (notOver(stareActuala)){
            int rand = 0;
            for(int i = 0 ; i < stareActuala.size() ; ++i){
                if(stareActuala.get(i).getCuloare() == Culoare.NECOLORAT)
                    rand = i;
            }
            Regiune regiune = new Regiune(regiuni.get(rand));
            if(regiune.getCulriPosibile().size() > 0){
                for(int i = 0; i< regiune.getCulriPosibile().size() ; ++i){
                    if(valid(stareActuala,i,regiune)){
                        stari.add(colorare(stareActuala,i,regiune));
                    }
                }
            }
            stareActuala = new ArrayList<>(stari.get(stare));
            stare++;
        }
        afisareCulori(stareActuala);
    }

    public void forwardCheckingMVR(){
        boolean areSolutii = true;
        afisare();
        while (notOver() && areSolutii){
            Regiune regiune = new Regiune(selecteazaRegiunea());
            List<String> vecini = new ArrayList<>(regiune.getVecini());
            List<Culoare>culori = new ArrayList<>(regiune.getCulriPosibile());
            boolean ok = true;
            for (String numeVecin : vecini){
                for(Regiune posibilVecin : this.regiuni){
                    if(numeVecin.equals(posibilVecin.getNume())){
                        Regiune vecin = new Regiune(posibilVecin);
                        if(vecin.getCuloare() == Culoare.NECOLORAT){
                            if(culori.size() == vecin.getCulriPosibile().size()){
                                if(culori.size()==1) {
                                    if (culori.get(0) == vecin.getCulriPosibile().get(0)) {
                                        ok = false;
                                        areSolutii = false;
                                    }
                                }
                            }else if(culori.size() > vecin.getCulriPosibile().size()){
                                ok = false;
                            }
                        }
                    }
                }
            }
            if(ok){
                Culoare culoare = culori.get(0);
                colorare(regiune.getNume(),culoare);
                for(String vecin : vecini){
                    eliminaCuloare(vecin,culoare);
                }
            }
        }
        afisareCulori();
    }

    public void afisareCulori(){
        for(Regiune regiune : this.regiuni){
            System.out.println(regiune);
        }
        System.out.println();
    }

    public void afisareCulori(List<Regiune>regiuni){
        for(Regiune regiune : regiuni){
            System.out.println(regiune);
        }
        System.out.println();
    }

    public void afisare(){
        for(Regiune regiune : this.regiuni){
            regiune.afisareParametri();
        }
        System.out.println();
    }

    public void afisare(List<Regiune> regiuni){
        for(Regiune regiune : regiuni){
            regiune.afisareParametri();
            System.out.println(regiune.getCuloare());
        }
        System.out.println();
    }
}
