package com.github.Raouf16.model.preferenceUtils;

/**
 * Created by zina on 26/03/17.
 */
public class Preference
{
    public String level;
    public String cours;
    public String tdCMTD ;
    public String tpCMTP ;


    public void setLevel(String level) {
        this.level = level;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public String getTdCMTD() {
        return tdCMTD;
    }

    public void setTdCMTD(String tdCMTD) {
        this.tdCMTD = tdCMTD;
    }

    public String getTpCMTP() {
        return tpCMTP;
    }

    public void setTpCMTP(String tpCMTP) {
        this.tpCMTP = tpCMTP;
    }
}
