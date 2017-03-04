package ru.efremenkov.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class GetWeatherRs implements Serializable{

    public CC cc = new CC();
    public List<FCD> fcd = new ArrayList<>();
    public List<FCH> fch = new ArrayList<>();
    public LOC loc = new LOC();
    public String licensed_to;
    public String hits;
    public String hit_limit;

    public class CC implements Serializable{
        public String dt;
        public String station;
        public Double t;
        public Double tf;
        public Double p;
        public String s;
        public Double ws;
        public Double uv;
        public String wn;
        public Double wd;
        public Double rh;
        public Double pr;
        public Double v;
        public Double dp;
        public Double pw;
    }
    public class FCD implements Serializable{
        public String dt;
        public Double tn;
        public Double tx;
        public String s;
        public Double p;
        public Double ws;
        public String wn;
        public Double wd;
        public Double rn;
        public Double rx;
        public Double px;
        public Double pn;
        public Double uv;
        public String sr;
        public String ss;
        public Double dl;
    }
    public class FCH implements Serializable{
        public String dt;
        public String dtu;
        public Double t;
        public Double tf;
        public String s;
        public Double ws;
        public String wn;
        public Double wв;
        public Double p;
        public Double dp;
        public Double pr;
        public Double rh;
        public Double uv;
    }
    public class LOC implements Serializable{
        public Double id;
        public String lon;
        public String lat;
        public String tz;
        public String tzd;
        public String name;
        public String country;
    }
}
