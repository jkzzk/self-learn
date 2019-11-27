package com.jkzzk.io.fileFilter;

import java.io.File;
import java.io.FileFilter;

/**
 *  创建FileFilter的实现类，重写accpect方法
 */
public class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File pathname) {

        if(pathname.isDirectory()) {
            return true;
        }

        return pathname.getPath().toLowerCase().endsWith(".java");
    }
}
