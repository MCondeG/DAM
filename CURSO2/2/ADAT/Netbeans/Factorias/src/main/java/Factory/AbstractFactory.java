package Factory;

public class AbstractFactory {
    public FactoryJPA factoryJPA = new FactoryJPA();
    public FactoryJDBC factoryJDBC = new FactoryJDBC();   
}
