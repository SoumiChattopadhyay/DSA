public class Prog4_dataTypes {
    static int dataTypeSize(String str) {
        switch(str){//No need of break statement as return is there
            case "Character":
                return 2;//size of char is 2 bytes in Java
            case "Integer":
                return 4;
            case "Long":
                return 8;
            case "Float":
                return 4;
            case "Double":
                return 8;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(Prog4_dataTypes.dataTypeSize("Double"));
    }
}