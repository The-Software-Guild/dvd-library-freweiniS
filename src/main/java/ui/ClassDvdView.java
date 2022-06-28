package ui;

import dto.DVDLibrary;

import java.time.LocalDate;
import java.util.List;

public class ClassDvdView {
    private UserIo io;

    public ClassDvdView(UserIo io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    public DVDLibrary getNewDVDInfo() {
        String title = io.readString("Please enter DVD title");
        String MPAARating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director Name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter your Rating/Note");
        String releaseDate = io.readString("Please enter Release Date");
        DVDLibrary newDvd = new DVDLibrary(title);
        newDvd.setMpaaRating(MPAARating);
        newDvd.setDirectorName(directorName);
        newDvd.setStudio(studio);
        newDvd.setUserRating(userRating);
        newDvd.setReleaseDate(releaseDate);
        return newDvd;
    }
    public void displayDVDList(List<DVDLibrary> DVDList) {
        for (DVDLibrary dvd : DVDList) {
            String dvdInfo = String.format("#%s : %s %s",
                    dvd.getTitle(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorName());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");

    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVDLibrary dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirectorName());
            io.print(dvd.getMpaaRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVDLibrary DvdLibrary) {
        if(DvdLibrary != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
}
