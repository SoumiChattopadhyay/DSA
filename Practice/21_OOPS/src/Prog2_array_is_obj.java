public class Prog2_array_is_obj {
    public static void main(String[] args) {
        int marks[];
        //This is wrong --> marks={2,3,4,5};
        marks = new int[4];

        int marks1[] = new int[]{1,2,3,4};

        for(int i=0;i<3;i++){
        System.out.print(marks[i]+" ");
        System.out.print(marks1[i]+" ");
        }
    }
}
