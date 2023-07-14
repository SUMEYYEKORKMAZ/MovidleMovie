package com.example.movidlemovie;

public class Movie {


    private String MName;
    private String MYear;
    private String MGenre;
    private String MOrigin;
    private String MDirector;
    private String MStar;
    private String MID;
    private String MLink;
    private String MQuotes;


    public Movie(String MName, String MYear, String MGenre, String MOrigin, String MDirector, String MStar, String MID, String MLink, String MQuotes) {
     this(MName, MYear, MGenre, MOrigin, MDirector, MStar, MID, MLink);
     this.MQuotes = MQuotes;

    }

    public Movie(String MName, String MYear, String MGenre, String MOrigin, String MDirector, String MStar, String MID, String MLink) {
        this.MName = MName;
        this.MYear = MYear;
        this.MGenre = MGenre;
        this.MOrigin = MOrigin;
        this.MDirector = MDirector;
        this.MStar = MStar;
        this.MID = MID;
        this.MLink = MLink;
    }

    public String getMName() {
        return MName;
    }

    public String getMYear() {
        return MYear;
    }

    public String getMGenre() {
        return MGenre;
    }

    public String getMOrigin() {
        return MOrigin;
    }

    public String getMDirector() {
        return MDirector;
    }

    public String getMStar() {
        return MStar;
    }

    public String getMQuotes() { return MQuotes;}

     public void setMQuotes(String quotes) {
            this.MQuotes = quotes;
        }

    @Override
    public String toString() {
        return "Movie :" +
                "MID='" + MID + '\'' +
                ", MName='" + MName + '\'' +
                ", MYear='" + MYear + '\'' +
                ", MGenre='" + MGenre + '\'' +
                ", MOrigin='" + MOrigin + '\'' +
                ", MDirector='" + MDirector + '\'' +
                ", MStar='" + MStar + '\'' +
                ", MLink='" + MLink + '\''+ ", MQuotes='" + MQuotes + '\'';

    }


}

