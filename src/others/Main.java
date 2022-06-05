package others;

import builder.RouteBuilder;
import com.google.inject.Guice;
import commands.*;
import dao.VectorDao;
import read.ConsoleReader;
import read.FileReader;
import com.google.inject.Injector;
import java.util.*;

import collectionClass.Route;
public class Main {
    public static void main(String[] args) throws Exception {
        Route route=new Route();
        InformationCollectionRoute informationCollectionRoute=new InformationCollectionRoute("Vector", route.getLocalDate(), 0);
        VectorDao vectorDao= new VectorDao(informationCollectionRoute);
        BuildCollectionRouteVector buildCollectionRouteVector=new BuildCollectionRouteVector(informationCollectionRoute, vectorDao);
        FileReader fileReader=new FileReader(args[0], buildCollectionRouteVector);
        try{
            fileReader.read();
        }
        catch(Exception e){
            System.out.println("Что-то пошло не так");
            throw new Exception();
        }
        System.out.println("Программа запущена");
        List <Route> routes=vectorDao.getAll();
        long id=0 ;
        for (Route r: routes){
            if (r.getId()>id){
                id=r.getId();
            }
        }
        RouteBuilder routeBuilder=new RouteBuilder(id+1);
        FileWrite fileWrite=new FileWrite(args[0]);
        ConsoleReader consoleReader=new ConsoleReader();
        Executor executor=new Executor();
        ReadDataConsole interactive=new ReadDataConsole(consoleReader, executor);
        Map<String, InterfaceCommand> commands=new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand(vectorDao, informationCollectionRoute));
        commands.put("show", new ShowCommand(vectorDao));
        commands.put("add", new AddElementCommand(vectorDao));
        commands.put("update", new UpdateIdElementCommand(vectorDao));
        commands.put("clear", new ClearCommand(vectorDao));
        commands.put("save", new SaveCommand(fileWrite, vectorDao,args[0]));
        commands.put("sort", new SortCommand(vectorDao));
        commands.put("remove_first", new RemoveFirstCommand(vectorDao));
        commands.put("min_by_id", new MinByIdCommand(vectorDao));
        commands.put("remove_by_id", new RemoveByIdCommand(vectorDao, informationCollectionRoute));
        commands.put("add_if_min", new AddIfMinCommand(vectorDao));
        commands.put("filter_contains_name", new FilterContainsNameCommand(vectorDao));
        commands.put("filter_less_than_distance", new FilterLessThanDistanceCommand(vectorDao));
        commands.put("execute_script", new ExecuteScriptCommand(executor));
        executor.setCommands(commands);
        interactive.go(consoleReader, executor);
    }
}
