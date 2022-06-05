package others;
import com.google.inject.AbstractModule;
import dao.InterfaceDao;
import dao.VectorDao;
import read.ConsoleReader;
import read.FileReader;
import read.InterfaceRead;

public class BillingModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(InterfaceDao.class).to(VectorDao.class);
        bind(InterfaceInformationCollection.class).to(InformationCollectionRoute.class);
        bind(InterfaceRead.class).to(ConsoleReader.class);
        bind(InterfaceWrite.class).to(FileWrite.class);
        bind(InterfaceBuildCollection.class).to(BuildCollectionRouteVector.class);

    }
}
