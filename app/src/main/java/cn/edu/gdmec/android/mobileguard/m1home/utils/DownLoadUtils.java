package cn.edu.gdmec.android.mobileguard.m1home.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

/**
 * Created by lenovo on 2017/9/19.
 */

public class DownLoadUtils {
    public static DownLoadUtils downloadutils;

    public static void downloadApk(String url, String targetFile, Context context){
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
        //漫游
        request.setAllowedOverRoaming(false);
        //使用getSingleton()方法获得MimeTypeMap对象,Intent-Filter中的<data>有一个mimeType .
        // 它的作用是告诉Android系统本Activity可以处理的文件的类型。如设置为 “text/plain”
        // 表示可以处理“.txt”文件。
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String mimeString=mimeTypeMap.getMimeTypeFromExtension(mimeTypeMap.getFileExtensionFromUrl(url));
        request.setMimeType(mimeString);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setVisibleInDownloadsUi(true);
        //表示设置下载地址为sd卡的download文件夹，文件名为targetFile参数
        request.setDestinationInExternalPublicDir("/download",targetFile);
        DownloadManager downloadManager =(DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        long mTaskid=downloadManager.enqueue(request);

    }
}
