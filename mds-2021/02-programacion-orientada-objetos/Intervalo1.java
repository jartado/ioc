
public class Intervalo1 {

    private double inferior;

    private double superior;


    public Intervalo1(double inferior, double superior) {
        assert inferior <= superior : "Inferior no puede ser mayor que superior";
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo1(double superior) {
        this(0, superior);
    }

    public Intervalo1(Intervalo1 intervalo) {
        this(intervalo.inferior, intervalo.superior);
    }

    public Intervalo1() {
        this(0, 0);
    }

    public Intervalo1 clone() {
        return new Intervalo1(this);
    }

    public double longitud() {
        return this.superior - this.inferior;
    }

    public void desplazar(double desplazamiento) {
        this.inferior += desplazamiento;
        this.superior += desplazamiento;
    }

    public Intervalo1 desplazado(double desplazamiento) {
        Intervalo1 intervalo = this.clone();
        intervalo.desplazado(desplazamiento);
        return intervalo;
    }

    public boolean equals(Intervalo1 intervalo) {
        assert intervalo != null;
        return intervalo.inferior == this.inferior
            && intervalo.superior == this.superior;
    }

    public boolean incluye(double valor) {
        return valor >= this.inferior
            && valor <= this.superior;
    }

    public boolean incluye(Intervalo1 intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior)
            && this.incluye(intervalo.superior);
    }

    public boolean intersecta(Intervalo1 intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior)
            || this.incluye(intervalo.superior)
            || intervalo.incluye(this);
    }

    public Intervalo1 interseccion(Intervalo1 intervalo) {
        assert this.intersecta(intervalo);
        if(this.incluye(intervalo)) {
            return intervalo.clone();
        } else if(intervalo.incluye(this)) {
            return this.clone();
        } else if(this.incluye(intervalo.inferior)) {
            return new Intervalo1(intervalo.inferior,this.superior);
        } else {
            return new Intervalo1(this.inferior,intervalo.superior);
        }
    }

    public void oponer() {
        double inferiorInicial = inferior;
        double superiorInicial = superior;
        this.inferior = -superiorInicial;
        this.superior = -inferiorInicial;
    }

    public void doblar() {
        double longitudInicial = this.longitud();
        this.inferior -= longitudInicial/2;
        this.superior += longitudInicial/2;
    }

    public void recoger() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Inferior?");
        inferior = gestorIO.inDouble();
        gestorIO.out("Superior?");
        superior = gestorIO.inDouble();
    }

    public void mostrar() {
        System.out.println("Intervalo --> [" + this.inferior + ", " + this.superior + "]");
    }

    public Intervalo1[] trocear(int trozos) {
        Intervalo1 intervalos[] = new Intervalo1[trozos];
        double longitudTrozo = this.longitud() / trozos;
        double inferior = this.inferior;
        double superior = this.inferior + longitudTrozo;
        for(int i = 0; i < trozos; i++) {
            intervalos[i] = new Intervalo1(inferior, superior);
            inferior = superior;
            superior += longitudTrozo;
        };
        return intervalos;
    }


}
