import Controller.DVDLibraryControler;
import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import ui.ClassDvdView;
import ui.UserIOConsoleImpl;
import ui.UserIo;

public class App {

    public static void main(String[] args) {
        UserIo myIo = new UserIOConsoleImpl();
        ClassDvdView myView = new ClassDvdView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryControler controller =
                new DVDLibraryControler(myDao, myView);
        controller.run();
    }
}
