import net.perata.entity.Apple;
import net.perata.entity.Bar;
import net.perata.entity.Foo;
import net.perata.entity.Product;
import net.perata.messenger.Messenger;

public class Main {


    public static void main(String[] args) {

        Messenger messenger = new Messenger();
        Product apple1 = new Apple(20);
        Product apple2 = new Apple(30);
        Product foo1 = new Foo(30);
        Product foo2 = new Foo(30);
        Product bar1 = new Bar(40);
        Product bar2 = new Bar(40);

        messenger.processMessage(apple1);
        messenger.processMessage(apple2);
        messenger.processMessage(foo1);
        messenger.processMessage(foo1);
        messenger.processMessage(bar1);
        messenger.processMessage(bar2);
    }
}
