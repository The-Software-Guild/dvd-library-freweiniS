package dao;

import dto.DVDLibrary;

import java.util.List;

public interface DVDLibraryDao {
    DVDLibrary addDVD(String DVDTitle, DVDLibrary dvd);
    List<DVDLibrary> getAllDVDs();
    DVDLibrary getDVDs(String title);
    DVDLibrary removeDVD(String title);
    DVDLibrary editDVD(String title);
}
