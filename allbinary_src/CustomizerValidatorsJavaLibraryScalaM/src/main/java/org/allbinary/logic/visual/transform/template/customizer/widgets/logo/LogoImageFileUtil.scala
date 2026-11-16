/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.template.customizer.widgets.logo

import _root_.java.io.ByteArrayInputStream
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.apache.commons.fileupload.FileItem

class LogoImageFileUtil(param_imageAbPath : AbPath, param_imageFile : String) {

    private val directory : Directory = Directory.getInstance()

    private var fileName : String = null

    private var imageFileAbPath : AbPath = null

    //Save to default file type
    //Constructor
    {
        val imageAbPath : AbPath = param_imageAbPath
        val imageFile : String = param_imageFile
        this.fileName = imageFile
        this.imageFileAbPath = imageAbPath
    }

    def saveFiles(fileItem : FileItem) : Unit = {
        if (this.fileName == null) {
            throw new Exception("Image File Name Was Null")
        }
        if (!this.directory.create(this.imageFileAbPath)) {
            throw new Exception("Unable to save file to non creatable directory")
        }
        val originalImageFile : AbFile = AbFile.createAbFile(this.imageFileAbPath.toString() + this.fileName)
        originalImageFile.createNewFile()
        FileUtil.getInstance().write(new ByteArrayInputStream(fileItem.get()), originalImageFile)
    }

}


