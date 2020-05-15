package ru.iitdgroup.nir;

import java.io.File;
import java.util.Objects;

public class App
{
    private static void RecursivePrint(File[] arr, int index, int level)
    {

        if(index == arr.length)
            return;


        for (int i = 0; i < level; i++)
            System.out.print("\t");


        if(arr[index].isFile())
            System.out.println(arr[index].getName());


        else if(arr[index].isDirectory())
        {
            System.out.println("[" + arr[index].getName() + "]");


            RecursivePrint(Objects.requireNonNull(arr[index].listFiles()), 0, level + 1);
        }


        RecursivePrint(arr,++index, level);
    }


    public static void main(String[] args)
    {

        String maindirpath = ".";


        File maindir = new File(maindirpath);

        if(maindir.exists() && maindir.isDirectory())
        {

            File arr[] = maindir.listFiles();

            System.out.println("**********************************************");
            System.out.println("Files from main directory : " + maindir);
            System.out.println("**********************************************");


            RecursivePrint(arr,0,0);
        }
    }
}