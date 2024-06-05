package it.pi.registro.registro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@SpringBootApplication
@EnableScheduling
public class RegistroApplication {

	public static void main(String[] args) {

//		System.out.println("Bloccato");
//
//        File logFolder = new File("./logs");
//
//		if(logFolder.exists() && logFolder.isDirectory()){
//			System.out.println("Esiste e Folder");
//            long totalSize = 0;
//
//            File[] folders = logFolder.listFiles();
//
//            if(folders != null){
//                for (File folder : folders){
//                    if(folder.isDirectory()){
//
//                        System.out.println(folder.getName());
//                        long folderSize = 0;
//                        for(File cf: folder.listFiles()){
//                            System.out.println(cf.getName());
//                            folderSize += cf.length();
//                        }
//                        System.out.print("Folder " + folder.getName() + " is " + folderSize);
//
//                        //totalSize += file.length();
//                    }
//                    System.out.println(folder.getName());
//                }
//            }
//            double totalSizeMB = totalSize / (1024.0 * 1024.0);
//            System.out.println("Total size " + totalSizeMB);
//        } else {
//            System.out.println("Non esiste o no Folder");
//        }
		SpringApplication.run(RegistroApplication.class, args);
	}

}
