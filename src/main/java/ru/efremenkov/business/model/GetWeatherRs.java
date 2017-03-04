package ru.efremenkov.business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author efremenkov
 * @ created 04.03.2017
 * $Author$
 * $Revision$
 */
public class GetWeatherRs {

    public CC cc = new CC();
    public List<FCD> fcd = new ArrayList<>();
    public List<FCH> fch = new ArrayList<>();
    public LOC loc = new LOC();
    public String licensed_to;
    public String hits;
    public String hit_limit;

    public class CC {
        public String dt;
        public String station;
        public Integer t;
        public Integer tf;
        public Integer p;
        public String s;
        public Integer ws;
        public Integer uv;
        public String wn;
        public Integer wd;
        public Integer rh;
        public Integer pr;
        public Integer v;
        public Integer dp;
        public Integer pw;
    }
    public class FCD {
        public String dt;
        public Integer tn;
        public Integer tx;
        public String s;
        public Integer p;
        public Integer ws;
        public String wn;
        public Integer wd;
        public Integer rn;
        public Integer rx;
        public Integer px;
        public Integer pn;
        public Integer uv;
        public String sr;
        public String ss;
        public Integer dl;
    }
    public class FCH {
        public String dt;
        public String dtu;
        public Integer t;
        public Integer tf;
        public String s;
        public Integer ws;
        public String wn;
        public Integer wв;
        public Integer p;
        public Integer dp;
        public Integer pr;
        public Integer rh;
        public Integer uv;
    }
    public class LOC {
        public Integer id;
        public String lon;
        public String lat;
        public String tz;
        public String tzd;
        public String name;
        public String country;
    }
}
