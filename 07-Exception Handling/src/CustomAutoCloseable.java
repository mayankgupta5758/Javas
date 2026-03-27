
class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource Opened");
    }

    public void doWork() {
        System.out.println("Working...");
        throw new RuntimeException("Error inside work");
    }

    @Override
    public void close() {
        System.out.println("Resource Closed");
    }
}

public class CustomAutoCloseable {
    public static void main(String[] args) {

        try (MyResource res = new MyResource()) {
            res.doWork();
        } catch (Exception e) {
            System.out.println("Exception caught in main");
        }
    }
}