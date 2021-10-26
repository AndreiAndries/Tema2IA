import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void Exemplul1(){
         /**
         WA: {SA, NT}
         SA: {WA, NT}
         NT: {WA, SA}
         Culorile disponibile pentru fiecare regiune sunt:
         WA: {red, green, blue}, SA: {red, green}, NT: {green}.
         */

        Regiune WA = new Regiune("WA");
        Regiune SA = new Regiune("SA");
        Regiune NT = new Regiune("NT");

        List<String>veciniWA = new ArrayList<>();
        veciniWA.add("SA");
        veciniWA.add("NT");

        List<String>veciniSA = new ArrayList<>();
        veciniSA.add("WA");
        veciniSA.add("NT");

        List<String>veciniNT = new ArrayList<>();
        veciniNT.add("SA");
        veciniNT.add("WA");

        List<Culoare>culoriWA = new ArrayList<>();
        culoriWA.add(Culoare.ROSU);
        culoriWA.add(Culoare.VERDE);
        culoriWA.add(Culoare.ALBASTRU);

        List<Culoare>culoriSA = new ArrayList<>();
        culoriSA.add(Culoare.ROSU);
        culoriSA.add(Culoare.VERDE);

        List<Culoare>culoriNT = new ArrayList<>();
        culoriNT.add(Culoare.VERDE);

        WA.setCulriPosibile(culoriWA);
        SA.setCulriPosibile(culoriSA);
        NT.setCulriPosibile(culoriNT);

        WA.setVecini(veciniWA);
        SA.setVecini(veciniSA);
        NT.setVecini(veciniNT);

        List<Regiune> regiuni = new ArrayList<>();
        regiuni.add(WA);
        regiuni.add(SA);
        regiuni.add(NT);

        Solver solver = new Solver(regiuni);
        solver.forwardCheckingBKT();

    }

    public static void Exemplul2(){
        /**
        T: {V}
        WA: {NT, SA}
        NT: {WA, Q, SA}
        SA: {WA, NT, Q, NSW, V}
        Q: {NT, SA, NSW}
        NSW: {Q, SA, V}
        V: {SA, NSW, T}

        WA: {red}, NT: {red, blue, green}, SA: {red, blue, green}, Q: {green}, NSW: {red, blue, green}, V: {red, blue, green}, T: {red, blue, green}
        */

        Regiune WA = new Regiune("WA");
        Regiune SA = new Regiune("SA");
        Regiune NT = new Regiune("NT");
        Regiune Q = new Regiune("Q");
        Regiune V = new Regiune("V");
        Regiune T = new Regiune("T");
        Regiune NSW = new Regiune("NSW");

        List<String>veciniWA = new ArrayList<>();
        veciniWA.add("SA");
        veciniWA.add("NT");

        List<String>veciniSA = new ArrayList<>();
        veciniSA.add("WA");
        veciniSA.add("NT");
        veciniSA.add("Q");
        veciniSA.add("NSW");
        veciniSA.add("V");

        List<String>veciniNT = new ArrayList<>();
        veciniNT.add("SA");
        veciniNT.add("WA");
        veciniNT.add("Q");

        List<String>veciniQ = new ArrayList<>();
        veciniQ.add("NT");
        veciniQ.add("WA");
        veciniQ.add("NSW");

        List<String>veciniNSW = new ArrayList<>();
        veciniNSW.add("SA");
        veciniNSW.add("V");
        veciniNSW.add("Q");

        List<String>veciniT = new ArrayList<>();
        veciniT.add("V");

        List<String>veciniV = new ArrayList<>();
        veciniV.add("T");
        veciniV.add("SA");
        veciniV.add("NSW");

        List<Culoare>culoriWA = new ArrayList<>();
        culoriWA.add(Culoare.ROSU);

        List<Culoare>culoriSA = new ArrayList<>();
        culoriSA.add(Culoare.ROSU);
        culoriSA.add(Culoare.VERDE);
        culoriSA.add(Culoare.ALBASTRU);

        List<Culoare>culoriNT = new ArrayList<>();
        culoriNT.add(Culoare.VERDE);
        culoriNT.add(Culoare.ALBASTRU);
        culoriNT.add(Culoare.ROSU);

        List<Culoare>culoriQ = new ArrayList<>();
        culoriQ.add(Culoare.VERDE);

        List<Culoare>culoriNSW = new ArrayList<>();
        culoriNSW.add(Culoare.ROSU);
        culoriNSW.add(Culoare.ALBASTRU);
        culoriNSW.add(Culoare.VERDE);

        List<Culoare>culoriV = new ArrayList<>();
        culoriV.add(Culoare.ROSU);
        culoriV.add(Culoare.ALBASTRU);
        culoriV.add(Culoare.VERDE);

        List<Culoare>culoriT = new ArrayList<>();
        culoriT.add(Culoare.ROSU);
        culoriT.add(Culoare.ALBASTRU);
        culoriT.add(Culoare.VERDE);

        WA.setCulriPosibile(culoriWA);
        SA.setCulriPosibile(culoriSA);
        NT.setCulriPosibile(culoriNT);
        NSW.setCulriPosibile(culoriNSW);
        T.setCulriPosibile(culoriT);
        Q.setCulriPosibile(culoriQ);
        V.setCulriPosibile(culoriV);

        WA.setVecini(veciniWA);
        SA.setVecini(veciniSA);
        NT.setVecini(veciniNT);
        NSW.setVecini(veciniNSW);
        T.setVecini(veciniT);
        Q.setVecini(veciniQ);
        V.setVecini(veciniV);

        List<Regiune> regiuni = new ArrayList<>();
        regiuni.add(WA);
        regiuni.add(SA);
        regiuni.add(NT);
        regiuni.add(NSW);
        regiuni.add(V);
        regiuni.add(Q);
        regiuni.add(T);

        List<Regiune> cpy = new ArrayList<>(regiuni);
        Solver solver = new Solver(regiuni);
        solver.forwardCheckingMVR();
    }

    public static void main(String[] args) {
        Exemplul1();
        System.out.println();
        System.out.println();
        Exemplul2();
    }
}
