package dao;

import dto.DVDLibrary;

import java.io.*;
import java.util.*;


public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVDLibrary> dvds = new HashMap<>();
    @Override
    public DVDLibrary addDVD(String DVDTitle, DVDLibrary dvd) {
        DVDLibrary prevDVD = dvds.put(DVDTitle, dvd);
        return prevDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVDs() {
        return new ArrayList<DVDLibrary>(dvds.values());
    }

    @Override
    public DVDLibrary getDVDs(String title) {
        return dvds.get(title);
    }

    @Override
    public DVDLibrary removeDVD(String title) {
        DVDLibrary removedDVD = dvds.remove(title);
        return removedDVD;
    }

    @Override
    public DVDLibrary editDVD(String title) {
       // DVDLibrary editDVD = dvds.replace()
        return null;
    }
    private DVDLibrary unmarshallDVD(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVDLibrary dvdFromFile = new DVDLibrary(title);
        dvdFromFile.setMpaaRating(dvdTokens[1]);
        dvdFromFile.setDirectorName(dvdTokens[2]);
        dvdFromFile.setStudio(dvdTokens[3]);
        dvdFromFile.setUserRating(dvdTokens[4]);
        dvdFromFile.setReleaseDate(dvdTokens[5]);
        return dvdFromFile;


            DVDLibrary currentDVD;
        Scanner scanner;
        while (scanner.hasNextLine()) {
                dvds.put(currentDVD.getTitle(), currentDVD);
            }
            scanner.close();
        }

    private String marshallDVD(DVDLibrary aDVD){

        String DVDAsText = aDVD.getTitle() + DELIMITER;

        DVDAsText += aDVD.getMpaaRating() + DELIMITER;
        DVDAsText += aDVD.getDirectorName() + DELIMITER;
        DVDAsText += aDVD.getStudio();
        DVDAsText += aDVD.getUserRating() + DELIMITER;
        DVDAsText += aDVD.getReleaseDate() + DELIMITER;
        return DVDAsText;
    }
    private void writeDVD() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        String DVDAsText;
        List<DVDLibrary> DVDList = this.getAllDVDs();
        for (DVDLibrary currentDVD : DVDList) {
            DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}