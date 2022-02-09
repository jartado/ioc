import java.util.StringTokenizer;

class Fecha {

    private int dia;
    private int mes;
    private int año;


    // Contructors

    public Fecha() {
        this(1,1,1);
    }
    
    public Fecha(int dia, int mes, int año) {
        this.setFecha(dia, mes, año);
    }

    public Fecha(Fecha fecha) {
        this(fecha.dia, fecha.mes, fecha.año);
    }

    public Fecha(String fechaCadena) {
        StringTokenizer analizador = new StringTokenizer(fechaCadena, "/");
        this.dia = Integer.parseInt(analizador.nextToken());
        this.mes = Integer.parseInt(analizador.nextToken());
        this.año = Integer.parseInt(analizador.nextToken());
    }

    public Fecha(int timeStamp) {
    }


    // Private

    private void setFecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    private int diasOrigen() {
        return 0;
    }


    // Public

    public void setFecha(Fecha fecha) {
        this.setFecha(fecha.dia, fecha.mes, fecha.año);
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAño() {
        return this.año;
    }

    public Fecha clone() {
        return new Fecha(this);
    }

    public String getStringESP() {
        return dia + "/" + mes + "/" + año;
    }

    public String getStringUSA() {
        return mes + "/" + dia + "/" + año;
    }

    public boolean igual(Fecha fecha) {
        return this.diasOrigen() == fecha.diasOrigen();
    }

    public boolean anterior(Fecha fecha) {
        return this.diasOrigen() < fecha.diasOrigen();
    }

    public boolean posterior(Fecha fecha) {
        return this.diasOrigen() > fecha.diasOrigen();
    }

    public int diferenciaDias(Fecha fecha) {
        return this.diasOrigen() - fecha.diasOrigen();
    }

    public boolean festivo() {
        return false;
    }

    public String getString() {
        return null;
    }

    public void getUTC() {
    }

    public double getDays(Fecha date) {
        return 0;
    }

}