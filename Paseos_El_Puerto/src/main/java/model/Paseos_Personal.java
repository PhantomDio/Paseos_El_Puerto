package model;

public class Paseos_Personal {
    private int idPaseo;
    private int idPersonal;

    public Paseos_Personal() {
    }

    public Paseos_Personal(int idPaseo, int idPersonal) {
        this.idPaseo = idPaseo;
        this.idPersonal = idPersonal;
    }

    public int getIdPaseo() {
        return idPaseo;
    }

    public void setIdPaseo(int idPaseo) {
        this.idPaseo = idPaseo;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }
}
