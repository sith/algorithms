package org.sith.algorithms.combinatorics;

public class PermutaionsGenerator2 {


    public void backtrack(int[] a, int k) {

        if (k == a.length) {
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
        } else {
            for (int i = k; i < a.length; i++) {
                swap(a, k, i);
                backtrack(a, k+1);
                swap(a, k, i);
            }
        }

        /*permute(i)
        if i == N  output A[N]
        else
        for j = i to N do
            swap(A[i], A[j])
        permute(i+1)
        swap(A[i], A[j])*/
    }

    private void swap(int[] a, int i, int k) {
        int tmp = a[i];
        a[i] = a[k];
        a[k] = tmp;
    }


/*

    public static void main (String arg[]){

        List<String> str = new ArrayList<String>();

        str.add("A");
        str.add("B");
        str.add("C");
//		str.add("D");

        Permutate(0, str);
        Permute2("ABC" , "");
        sets("ABC", "");

    }


    *//* Find all the permutation of strings*//*
    private static void Permutate(int start, List<String> str){

        if(start == str.size() -1){
            System.out.println("----" + str);
        }

        for(int i = start; i < str.size(); i++){
            String c = str.get(i);
            str.set(i,str.get(start));
            str.set(start, c);

            Permutate(start+1, str );

            String c2 = str.get(i);
            str.set(i,str.get(start));
            str.set(start, c2);

        }

    }

    *//* Find all the permutation of strings*//*
    private static void Permute2( String left , String soFar){

        if(left.equalsIgnoreCase("")){
            System.out.println(soFar);
            return;
        }

        for(int i = 0 ; i < left.length(); i++){
            String new2 = soFar + left.charAt(i);
            String remaining = left.substring(0,i) + left.substring(i+1);
            Permute2(remaining, new2);
        }

    }

    *//* Find all the sets of strings*//*
    private static void sets (String left, String soFar){

        if(left.equalsIgnoreCase("")){
            System.out.println(soFar);
            return;
        }

        sets(left.substring(1), soFar + left.substring(0,1));
        sets(left.substring(1), soFar);
    }*/
}
