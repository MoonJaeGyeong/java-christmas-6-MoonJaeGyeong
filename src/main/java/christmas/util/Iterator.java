package christmas.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Iterator {
    private final Consumer<String> error_Message;

    public Iterator(Consumer<String> error_Message) {
        this.error_Message = error_Message;
    }

    public <R> R iterate(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                error_Message.accept(e.getMessage());
            }
        }
    }

}
