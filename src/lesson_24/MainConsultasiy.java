package lesson_24;

public class MainConsultasiy {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            double maxSize = 0;
            double minSize = 0;

            switch (args[i]) {
                case "byte": {
                    maxSize = Byte.MAX_VALUE;
                    minSize = Byte.MAX_VALUE;
                    System.out.println(minSize + maxSize);
                    break;
                }
                case "double": {
                    maxSize = Byte.MAX_VALUE;
                    minSize = Byte.MAX_VALUE;
                    System.out.println(minSize + maxSize);
                    break;
                }
                case "float": {
                    maxSize = Byte.MAX_VALUE;
                    minSize = Byte.MAX_VALUE;
                    System.out.println(minSize + maxSize);
                    break;
                }
            }
        }
    }
}