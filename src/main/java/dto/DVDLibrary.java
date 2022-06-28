package dto;

public class DVDLibrary {

    private String title;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;
    private String releaseDate;


    public String getReleaseDate() {

        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {

        this.releaseDate = releaseDate;
    }




    public DVDLibrary(String title, String mpaaRating, String directorName, String studio, String userRating, String releaseDate) {
        this.title = title;
        this.setMpaaRating(mpaaRating);
        this.setDirectorName(directorName);
        this.setStudio(studio);
        this.setUserRating(userRating);
        this.setReleaseDate(releaseDate);
    }
    public DVDLibrary(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

/*    public void setTitle(String title) {
       this.title = title;
   }*/

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        if (mpaaRating.equals("G") || mpaaRating.equals("PG") || mpaaRating.equals("PG-13") || mpaaRating.equals("R") || mpaaRating.equals("NR")) {
            this.mpaaRating = mpaaRating;
        } else {
            this.mpaaRating = "NR";
        }

    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
