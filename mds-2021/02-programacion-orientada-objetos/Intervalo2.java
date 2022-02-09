
public class Intervalo2 {

    private double longitud;

    private double puntoMedio;


    public Intervalo2(double inferior, double superior) {
        assert inferior <= superior;
        this.longitud = superior - inferior;
        this.puntoMedio = (inferior + superior) / 2;
    }

    public Intervalo2(double superior) {
        this(0, superior);
    }

    public Intervalo2(Intervalo2 intervalo) {
        this.longitud = intervalo.longitud;
        this.puntoMedio = intervalo.puntoMedio;
    }

    public Intervalo2() {
        this(0, 0);
    }

    public Intervalo2 clone() {
        return new Intervalo2(this);
    }

    public double longitud() {
        return this.longitud;
    }

    public void desplazar(double desplazamiento) {
        this.puntoMedio += desplazamiento;
    }

    public Intervalo2 desplazado(double desplazamiento) {
        Intervalo2 intervalo = this.clone();
        intervalo.desplazado(desplazamiento);
        return intervalo;
    }
    
    public boolean equals(Intervalo2 intervalo) {
        assert intervalo != null;
        return intervalo.longitud == this.longitud
            && intervalo.puntoMedio == this.puntoMedio; 
    }

    public boolean incluye(double valor) {
        return valor >= this.puntoMedio - (this.longitud / 2)
            && valor <= this.puntoMedio + (this.longitud / 2);
    }

    public boolean incluye(Intervalo2 intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.puntoMedio - (intervalo.longitud / 2))
            && this.incluye(intervalo.puntoMedio + (intervalo.longitud / 2));
    }

    public boolean intersecta(Intervalo2 intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.puntoMedio - (intervalo.longitud / 2))
        || this.incluye(intervalo.puntoMedio + (intervalo.longitud / 2))
        || intervalo.incluye(this);
    }

    public Intervalo2 interseccion(Intervalo2 intervalo) {
        assert this.intersecta(intervalo);
        if(this.incluye(intervalo)) {
            return intervalo.clone();
        } else if(intervalo.incluye(this)) {
            return this.clone();
        } else if(this.incluye(intervalo.puntoMedio - (intervalo.longitud / 2))) {
            return new Intervalo2(intervalo.puntoMedio - (intervalo.longitud / 2), this.puntoMedio + (this.longitud / 2));
        } else {
            return new Intervalo2(this.puntoMedio - (this.longitud / 2), intervalo.puntoMedio + (intervalo.longitud / 2));
        }
    }

    public void oponer() {
        this.puntoMedio *= -1;
    }

    public void doblar() {
        this.longitud *= 2;
    }

    public void recoger() {
        
    }

    public void mostrar() {
        System.out.println("Intervalo --> [" + this.longitud + ", " + this.puntoMedio + "]");
    }

    public Intervalo2[] trocear(int trozos) {
        Intervalo2 intervalos[] = new Intervalo2[trozos];
        double longitudTrozo = this.longitud / trozos;
        double puntoMedio = this.puntoMedio - (this.longitud / 2) + (longitudTrozo / 2);
        for(int i = 0; i < trozos; i++) {
            intervalos[i] = new Intervalo2(longitudTrozo, puntoMedio);
            puntoMedio += longitudTrozo;
        };
        return intervalos;
    }


}
