public class Main {
    public static void main(String[] args) {

        System.out.println("A");
        int b = 0;
        int arr[] = {1,2,3};
        try {
//            System.out.println(arr[5]);
//            int a = 5 / b;
            func(14);
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("C");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        } catch (ArithmeticException ex){
            System.out.println("D");
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }catch (RuntimeException ex){
            System.out.println(ex.toString());
        }finally {
            System.out.println("finally block");
        }

        System.out.println("B");
    }

    public static void func(int age) throws ArrayIndexOutOfBoundsException,ArithmeticException{
        if(age<15){
            throw new RuntimeException("you are underage!!!");
        }
        int b=0;
        int arr[] = {1,2,3};
        int i = 8/b;
        System.out.println(arr[5]);
    }
}