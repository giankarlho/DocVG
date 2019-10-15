package model;

import java.sql.Date;

public class DetEmpresa {

    private int idDEMP;
    private int IDPER;
    private int IDEMP;
    private String NOMPER;
    private String ESTASI;
    private String CARPER;
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

    public Date getFECASI() {
        return FECASI;
    }

    public void setFECASI(Date FECASI) {
        this.FECASI = FECASI;
    }

    public String getCARPER() {
        return CARPER;
    }

    public void setCARPER(String CARPER) {
        this.CARPER = CARPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getESTASI() {
        return ESTASI;
    }

    public void setESTASI(String ESTASI) {
        this.ESTASI = ESTASI;
    }

}
