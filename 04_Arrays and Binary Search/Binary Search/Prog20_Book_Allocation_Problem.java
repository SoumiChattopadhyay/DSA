public class Prog20_Book_Allocation_Problem {
    // Linear Search
    static int is_Allocation_Possible1(int[] arr, int m){
        int n=arr.length;
        if(m>n) return -1;
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
    // Binary Search
    static int is_Allocation_Possible2(int[] arr, int m){
        int n=arr.length;
        if(m>n) return -1;
        int low = Integer.MIN_VALUE, high=0;
        for(int el: arr){
            low = Math.max(el,low);
            high += el;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int cntStudents = allocateBooks(arr, mid);
            if(cntStudents<=m){//if cntStudents<m means we have increased maxPages a lot so one student holds many books while another student gets none. So decrease maxPages. And if cntStudents=m means this is a possible ans so store it and look for better ans (see if we decrease maxPages more and get an ans)
                ans = mid;
                high=mid-1;
            }
            else{//if cntStudents>m means we have decreased maxPages a lot so count of students has exceeded m. So increase maxPages.
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] books = {25,46,28,49,24};
        int students=4;
        System.out.println(is_Allocation_Possible1(books, students));
        System.out.println(is_Allocation_Possible2(books, students));
    }
}