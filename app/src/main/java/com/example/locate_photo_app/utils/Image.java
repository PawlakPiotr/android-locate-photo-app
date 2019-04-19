package com.example.locate_photo_app.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Image extends AppCompatActivity {

    private static String IMG_DIR = Environment.getExternalStorageDirectory() + "/PRM_IMAGES";
    private static String EXTENSION = ".jpg", FILE_NAME = "IMG_", DIR = "PRM_IMAGES";

    String datePattern = "yyyy-MM-dd_HH:mm", imageName = null;
    File imgFile;

    public File setImage() {
        String timeStamp = new SimpleDateFormat(datePattern).format(new Date());

        String folderPath = IMG_DIR;
        File folder = new File(folderPath);

        if (!folder.exists()) {
            File dir = new File(folderPath);
            dir.mkdirs();
        }

        imageName = FILE_NAME + timeStamp + EXTENSION;

        File imagesFolder = new File(Environment.getExternalStorageDirectory(), DIR);
        File image = new File(imagesFolder, imageName);
        System.out.println("##" + Environment.getExternalStorageDirectory());
        System.out.println("### => " + image.getAbsolutePath());
        imgFile = image;

        return  imgFile;
    }

    public File getImgFile() { return imgFile; }

    public String getImageName() {
        return imageName;
    }

}
