public class Prog20_Book_Allocation_Problem {
    static int is_Allocation_Possible1(int[] arr, int m){
        int low = Integer.MIN_VALUE, high=0;
        for(int el: arr){
            low = Math.max(el,low);
            high += el;
        }
        for(int maxPages=low;maxPages<=high;maxPages++){
            int cntStudents = allocateBooks(arr, maxPages);
            if(cntStudents==m){
                return maxPages;
            }
        }
        return -1;
    }
    static int allocateBooks(int[] arr, int maxPages){
        int stu=1, pagesStudent=0;
        for(int i=0;i<arr.length;i++){
            if(pagesStudent+arr[i]<=maxPages){
                pagesStudent+=arr[i];
            }
            else{
                stu++;
                pagesStudent=arr[i];
            }
        }
        return stu;
    }
    public static void main(String[] args) {
        int[] books = {25,46,28,49,24};
        int students=4;
        System.out.println(is_Allocation_Possible1(books, students));
    }
}