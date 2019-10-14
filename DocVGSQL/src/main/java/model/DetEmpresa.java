package model;

import java.sql.Date;

public class DetEmpresa {

    private int idDEMP;
    private int IDPER;
    private int IDEMP;
    private char ESTASI;
    private Date FECASI;

    public int getIdDEMP() {
        return idDEMP;
    }

    public void setIdDEMP(int idDEMP) {
        this.idDEMP = idDEMP;
    }

    public int getIDPER() {
        return IDPER;
    }

    public void setIDPER(int IDPER) {
        this.IDPER = IDPER;
    }

    public int getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(int IDEMP) {
        this.IDEMP = IDEMP;
    }

    public char getESTASI() {
        return ESTASI;
    }

    public void setESTASI(char ESTASI) {
        this.ESTASI = ESTASI;
    }

    public Date getFECASI() {
        return FECASI;
    }

    public void setFECASI(Date FECASI) {
        this.FECASI = FECASI;
    }

}