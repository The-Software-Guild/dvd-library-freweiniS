package Controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import dto.DVDLibrary;
import ui.ClassDvdView;
import ui.UserIOConsoleImpl;


import java.util.List;

public class DVDLibraryControler {
    private ClassDvdView view;
    private DVDLibraryDao dao;

    public DVDLibraryControler(DVDLibraryDao dao, ClassDvdView view) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    //io.print("Edit DVDLibrary");
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                   unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    private void createDVD() {
        view.displayCreateDVDBanner();
        DVDLibrary newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }
    private void listDVDs() {
        view.displayDisplayAllBanner();
        List<DVDLibrary> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }
    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVDLibrary dvd = dao.getDVDs(title);
        view.displayDVD(dvd);
    }
    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVDLibrary removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }


}
