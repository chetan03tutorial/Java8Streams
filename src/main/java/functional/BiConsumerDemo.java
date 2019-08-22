
package functional;

        import java.util.function.BiConsumer;
        import java.util.function.Consumer;
        import java.util.function.Supplier;
        import java.util.stream.Stream;

public class BiConsumerDemo<T,U> {

    static class BiConsumerImpl<T,U> {

        private BiConsumer<T,U> accumlator;
        private Supplier<T> supplier;

        public BiConsumerImpl(Supplier<T> supplier,BiConsumer<T,U> accumlator){
            this.accumlator = accumlator;
            this.supplier = supplier;
        }

        public BiConsumerImpl(Supplier<T> supplier){
            this.supplier = supplier;
        }

        public BiConsumerImpl(BiConsumer<T,U> accumlator){
            this.accumlator = accumlator;
        }
    }

    public BiConsumerImpl collect1(){
        return new BiConsumerImpl<>(StringHelper::new);
    }

    public BiConsumerImpl collect2(){
        return new BiConsumerImpl<>(StringHelper::upperCase);
    }


    public  BiConsumerImpl<StringHelper,String> collect3(){
        return new BiConsumerImpl<>(()-> new StringHelper(),StringHelper::upperCase);
    }

    public static BiConsumerImpl<StringHelper,String> collect4(){
        return new BiConsumerImpl<>(()-> new StringHelper(),StringHelper::upperCase);
    }

    public static void main(String[] args) {
        System.out.println("Executing non-static collect3() in BiConsumerDemo");
        BiConsumerDemo<StringHelper,String> biConsumerDemo = new BiConsumerDemo<>();
        final BiConsumerImpl<StringHelper,String> biConsumer = biConsumerDemo.collect3();


        StringHelper supplier = biConsumer.supplier.get();
        BiConsumer<StringHelper,String> accumalator = biConsumer.accumlator;

        accumalator.accept(supplier,"Hello from non static method");
        toUpperCase((u)-> accumalator.accept(supplier,u));
        System.out.println("Executing static collect4() in BiConsumerDemo");


        final BiConsumerImpl<StringHelper,String> biConsumer2 = BiConsumerDemo.collect4();
        biConsumer.accumlator.accept(biConsumer2.supplier.get(),"Hello from static method ");
    }

    public static void toUpperCase(Consumer<String> action){
        action.accept("Ronaldo");
    }

}