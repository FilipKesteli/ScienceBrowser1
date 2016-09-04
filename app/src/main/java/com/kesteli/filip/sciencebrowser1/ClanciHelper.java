package com.kesteli.filip.sciencebrowser1;

/**
 * Created by Filip on 4.9.2016..
 */
public class ClanciHelper {

    private static final String fizika_clanci = "fizika_clanci";
    private static final String kemija_clanci = "fizika_clanci";
    private static final String matematika_clanci = "fizika_clanci";
    private static final String tehnika_clanci = "tehnika_clanci";
    private static final String medicina_clanci = "medicina_clanci";
    private static final String biologija_clanci = "biologija_clanci";
    private static final String astronomija_clanci = "astronomija_clanci";
    private static final String geologija_clanci = "geologija_clanci";

    public static String getFizika_clanci() {
        return fizika_clanci;
    }

    public static String getKemija_clanci() {
        return kemija_clanci;
    }

    public static String getMatematika_clanci() {
        return matematika_clanci;
    }

    public static String getTehnika_clanci() {
        return tehnika_clanci;
    }

    public static String getMedicina_clanci() {
        return medicina_clanci;
    }

    public static String getBiologija_clanci() {
        return biologija_clanci;
    }

    public static String getAstronomija_clanci() {
        return astronomija_clanci;
    }

    public static String getGeologija_clanci() {
        return geologija_clanci;
    }

    private String[] titles = {
            "Fizika",
            "Kemija",
            "Matematika",
            "Tehnika",
            "Medicina",
            "Biologija",
            "Astronomija",
            "Geologija"
    };

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    private String[] clanci_fizika = {
            "http://phys.org/physics-news/",
            "https://www.sciencedaily.com/news/matter_energy/physics/",
            "http://physicsworld.com/cws/channel/news",
            "http://www.physics.org/news.asp",
            "http://scitation.aip.org/content/aip/magazine/physicstoday/news",
            "http://www.scientificamerican.com/physics/",
            "http://discovermagazine.com/tags/physics",
            "https://physics.aps.org/",
            "https://www.newscientist.com/subject/physics/",
            "http://www.sci-news.com/news/physics"
    };

    private String[] fizika = {"phys.org", "science daily", "physics world", "physics.org", "scitation.aip", "sci american", "discover", "physics.aps", "new scientist", "sci news"};

    private String[] clanci_kemija = {
            "http://www.scientificamerican.com/chemistry/",
            "http://phys.org/chemistry-news/",
            "http://www.iflscience.com/chemistry/",
            "https://www.sciencedaily.com/news/matter_energy/chemistry/",
            "http://www.sciencemag.org/category/chemistry",
            "https://www.rsc.org/chemistryworld/news",
            "http://www.nytimes.com/topic/subject/chemistry",
            "http://www.sci-news.com/news/othersciences/chemistry",
            "http://cen.acs.org/news.html",
            "http://scienceworld.scholastic.com/Chemistry-News/"
    };

    private String[] kemija = {"sci american", "phys.org", "ifl science", "science daily", "science mag", "chem world", "ny times", "sci-news", "cen.acs.org", "science world"};

    private String[] clanci_matematika = {
            "http://www.scientificamerican.com/math/",
            "https://www.sciencedaily.com/news/computers_math/mathematics/",
            "http://phys.org/science-news/mathematics/",
            "https://plus.maths.org/content/News",
            "http://www.independent.co.uk/topic/Mathematics",
            "http://news.mit.edu/topic/mathematics",
            "http://www.usnews.com/topics/subjects/math",
            "http://math.alltop.com/",
            "http://www.nytimes.com/topic/subject/mathematics",
            "http://www.ams.org/news/math-in-the-media/mathdigest-index"
    };

    private String[] matematika = {"sci american", "science daily", "phys.org", "plus.maths.org", "independent.co.uk", "news mit", "us news", "math.alltop", "ny times", "ams.org"};

    private String[] clanci_tehnika = {
            "http://www.bbc.com/news/technology",
            "http://edition.cnn.com/tech",
            "http://www.cnet.com/news/",
            "http://www.technewsworld.com/",
            "http://www.theverge.com/tech",
            "http://timesofindia.indiatimes.com/tech/tech-news",
            "http://www.telegraph.co.uk/technology/news/",
            "http://www.extremetech.com/",
            "http://www.news.com.au/technology",
            "http://www.reuters.com/news/technology"
    };

    private String[] tehnika = {"bbc", "cnn", "cnet", "tech news world", "the verge", "times of india", "telegraph", "extreme tech", "news.com", "reuters"};

    private String[] clanci_medicina = {
            "http://www.bbc.com/news/us/health",
            "http://www.medicalnewstoday.com/",
            "https://www.sciencedaily.com/news/health_medicine/",
            "http://www.news-medical.net/",
            "http://www.livescience.com/health",
            "http://www.internalmedicinenews.com/",
            "http://www.medpagetoday.com/specialty",
            "http://med.stanford.edu/news.html",
            "http://med.stanford.edu/news/all-news.html",
            "http://edition.cnn.com/health"
    };

    private String[] medicina = {"bbc", "medical news today", "sci daily", "news medical", "live science", "inter med news", "med page", "standford", "stanford all", "cnn"};

    private String[] clanci_biologija = {
            "http://www.scientificamerican.com/biology/",
            "https://www.sciencedaily.com/news/plants_animals/biology/",
            "http://www.sci-news.com/news/biology",
            "http://phys.org/biology-news/",
            "http://www.biologynews.net/",
            "https://nsf.gov/news/index.jsp?prio_area=3",
            "http://www.sciencemag.org/category/biology",
            "http://www.usnews.com/topics/subjects/biology",
            "https://www.theguardian.com/science/biology",
            "http://scienceworld.scholastic.com/Biology-News/"
    };

    private String[] biologija = {"sci american", "sci daily", "sci news", "phys.org", "bio news", "nsf.gov", "science mag", "us news", "the guardian", "sci world"};

    private String[] clanci_astronomija = {
            "http://www.astronomy.com/news",
            "http://www.skyandtelescope.com/astronomy-news/",
            "http://phys.org/space-news/astronomy/",
            "https://www.sciencedaily.com/news/space_time/astronomy/",
            "https://astronomynow.com/category/news/",
            "http://www.sci-news.com/news/astronomy",
            "http://www.space.com/science-astronomy",
            "https://www.newscientist.com/subject/space/",
            "http://www.universetoday.com/",
            "http://www.skyatnightmagazine.com/astronomy-news"
    };

    private String[] astronomija = {"astronomy.com", "sky and telescope", "phys.org", "sci daily", "astronomy now", "sci news", "space", "new scientist", "universe today", "sky and night"};

    private String[] clanci_geologija = {
            "https://www.sciencedaily.com/news/earth_climate/geology/",
            "http://geology.com/",
            "http://www.sci-news.com/news/geology",
            "https://www.theguardian.com/science/geology",
            "http://geology.alltop.com/",
            "http://www.nature.com/subjects/geology",
            "http://www.livescience.com/environment",
            "http://www.geosociety.org/news/",
            "http://www.telegraph.co.uk/news/earth/environment/geology/",
            "http://www.independent.co.uk/topic/Geology"
    };

    private String[] geologija = {"sci daily", "geology", "sci news", "the guardian", "geology.alltop", "nature", "live sci", "geo society", "telegraph", "independent"};

    private int[] images = {
            R.drawable.ic_wifi_tethering_white_24dp,
            R.drawable.ic_local_drink_white_24dp,
            R.drawable.ic_all_inclusive_white_24dp,
            R.drawable.ic_directions_boat_white_24dp,
            R.drawable.ic_local_hospital_white_24dp,
            R.drawable.ic_local_florist_white_24dp,
            R.drawable.ic_star_white_24dp,
            R.drawable.ic_filter_hdr_white_24dp
    };

    public String[] getClanci_fizika() {
        return clanci_fizika;
    }

    public void setClanci_fizika(String[] clanci_fizika) {
        this.clanci_fizika = clanci_fizika;
    }

    public String[] getFizika() {
        return fizika;
    }

    public void setFizika(String[] fizika) {
        this.fizika = fizika;
    }

    public String[] getClanci_kemija() {
        return clanci_kemija;
    }

    public void setClanci_kemija(String[] clanci_kemija) {
        this.clanci_kemija = clanci_kemija;
    }

    public String[] getKemija() {
        return kemija;
    }

    public void setKemija(String[] kemija) {
        this.kemija = kemija;
    }

    public String[] getClanci_matematika() {
        return clanci_matematika;
    }

    public void setClanci_matematika(String[] clanci_matematika) {
        this.clanci_matematika = clanci_matematika;
    }

    public String[] getMatematika() {
        return matematika;
    }

    public void setMatematika(String[] matematika) {
        this.matematika = matematika;
    }

    public String[] getClanci_tehnika() {
        return clanci_tehnika;
    }

    public void setClanci_tehnika(String[] clanci_tehnika) {
        this.clanci_tehnika = clanci_tehnika;
    }

    public String[] getTehnika() {
        return tehnika;
    }

    public void setTehnika(String[] tehnika) {
        this.tehnika = tehnika;
    }

    public String[] getClanci_medicina() {
        return clanci_medicina;
    }

    public void setClanci_medicina(String[] clanci_medicina) {
        this.clanci_medicina = clanci_medicina;
    }

    public String[] getMedicina() {
        return medicina;
    }

    public void setMedicina(String[] medicina) {
        this.medicina = medicina;
    }

    public String[] getClanci_biologija() {
        return clanci_biologija;
    }

    public void setClanci_biologija(String[] clanci_biologija) {
        this.clanci_biologija = clanci_biologija;
    }

    public String[] getBiologija() {
        return biologija;
    }

    public void setBiologija(String[] biologija) {
        this.biologija = biologija;
    }

    public String[] getClanci_astronomija() {
        return clanci_astronomija;
    }

    public void setClanci_astronomija(String[] clanci_astronomija) {
        this.clanci_astronomija = clanci_astronomija;
    }

    public String[] getAstronomija() {
        return astronomija;
    }

    public void setAstronomija(String[] astronomija) {
        this.astronomija = astronomija;
    }

    public String[] getClanci_geologija() {
        return clanci_geologija;
    }

    public void setClanci_geologija(String[] clanci_geologija) {
        this.clanci_geologija = clanci_geologija;
    }

    public String[] getGeologija() {
        return geologija;
    }

    public void setGeologija(String[] geologija) {
        this.geologija = geologija;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
