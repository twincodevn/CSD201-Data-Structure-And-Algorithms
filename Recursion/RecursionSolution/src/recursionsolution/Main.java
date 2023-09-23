/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursionsolution;

public class Main { 
    // tính tổng 1 -> n 
    static int sum(int n) {
        if(n<=1) return 1;
        return n+sum(n-1);
    }
    
    // tìm được min trong 1 mảng 
    static int findMin(int a[], int n) {
        if(n==1) return a[0]; // nếu kích thước chỉ có duy nhất là 1 
        // swap min value 
        if(a[0]>a[n-1]) a[0]=a[n-1]; // nếu thằng đầu tiên lớn hơn thằng cuối cùng thì swap  
        return findMin(a,n-1);
    }
    
    // dung de quy de tinh tong 
    static int findSum(int a[], int n) {
        if (n<=0) return 0;
        return a[n-1] + findSum(a, n-1);   
    }
    
    
    static int bSearch(int a[],int target,int left,int right) {
        int mid = (left+right)/2;
        if(right<left) {return -1;} // not found
        if(target==a[mid]) {return mid;}
        if(target<a[mid]) {return bSearch(a,target,left,mid-1);}
        if(target>a[mid]) {return bSearch(a,target,mid+1,right);}
        return -1;
    }
      
   // 
    static boolean isPalindrome(char a[], int n) {
        if(n==1) return true;
        int m=a.length;
        if(a[m-n] != a[n-1]) return false;
        else {return isPalindrome(a,n-1);}
    }
    
    

    public static void main(String[] args) {
        System.out.println(sum(8)); //36
        int [] a = {15, 12, 13, 8, 10, 21}; 
        System.out.println(findMin(a,a.length)); //8
        int [] b = {1, 2, 3, 4, 5, 6};
        System.out.println(findSum(b,b.length)); //21
        System.out.println(bSearch(b,5,0,b.length)); //4
        char[] c = "madam".toCharArray();
        System.out.println(isPalindrome(c,c.length)); //1
    }
}
