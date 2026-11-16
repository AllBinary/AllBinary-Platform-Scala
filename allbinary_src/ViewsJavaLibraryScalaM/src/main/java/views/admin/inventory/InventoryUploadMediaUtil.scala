/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package views.admin.inventory

import _root_.java.io.ByteArrayInputStream
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.commerce.inventory.item.ItemInterface
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.file.upload.media.UploadMediaSingleton
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.file.FileUtil
import _root_.org.allbinary.logic.io.path.AbPathData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.visual.media.MediaData
import _root_.org.allbinary.logic.visual.media.MediaTypeData
import _root_.org.allbinary.logic.visual.media.MediaUtil
import _root_.org.allbinary.string.CommonStrings

class InventoryUploadMediaUtil(param_storeFrontInterface : StoreFrontInterface, param_itemInterface : ItemInterface) {

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final FileItemUtil fileItemUtil = FileItemUtil.getInstance();
    private val mediaUtil : MediaUtil = MediaUtil.getInstance()

    private val LARGEWIDTH : Int = 1024

    private val LARGEHEIGHT : Int = 1024

    private val MEDIUMWIDTH : Int = 256

    private val MEDIUMHEIGHT : Int = 256

    private val SMALLWIDTH : Int = 128

    private val SMALLHEIGHT : Int = 128

    private val SMALL : String = "Small"

    private val MEDIUM : String = "Medium"

    private val LARGE : String = "Large"

    private var storeFrontInterface : StoreFrontInterface = null

    private var itemInterface : ItemInterface = null

    //Save to default file type
    //Constructor
    {
        val storeFrontInterface : StoreFrontInterface = param_storeFrontInterface
        val itemInterface : ItemInterface = param_itemInterface
        this.storeFrontInterface = storeFrontInterface
        this.itemInterface = itemInterface
    }

    def saveFiles(byteArray : Array[Byte], fileName : String, mediaData : MediaData) : ItemInterface = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF("Start FileName: " + fileName, this, "saveFiles()")
        }
        if (StringValidationUtil.getInstance().isEmpty(fileName)) {
            throw new Exception("Image File Name Was Null")
        }
        var fileUtil : FileUtil = FileUtil.getInstance()
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(URLGLOBALS.getWebappPath())
        stringBuffer.append(this.storeFrontInterface.getCurrentHostNamePath())
        //storeFrontInterface.getCategoryPath()
        stringBuffer.append(this.itemInterface.getCategory())
        var fullPath : String = stringBuffer.toString()
        var imageDirectoryFile : AbFile = AbFile.createAbFile(fullPath)
        if (!imageDirectoryFile.isDirectory()) {
            throw new Exception("Unable to save file to non existant directory")
        }
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(fullPath)
        stringBuffer.append(fileName)
        stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
        stringBuffer.append(mediaData.getName())
        var originalImageFile : AbFile = AbFile.createAbFile(stringBuffer.toString())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil.putF("Saving Original Image: " + originalImageFile, this, "saveFiles()")
        }
        originalImageFile.createNewFile()
        fileUtil.write(new ByteArrayInputStream(byteArray), originalImageFile)
        //fileItemUtil.write(fileItem, originalImageFile);
        var uploadMedia : UploadMediaSingleton = UploadMediaSingleton.getInstance()
        var isMediaSupported : Boolean = uploadMedia.isWriterSupported(mediaData.getName()) || uploadMedia.isReaderSupported(mediaData.getName())
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("Is Image Type: ")
            stringBuffer.append(mediaData.getName())
            stringBuffer.append(" supported: ")
            stringBuffer.appendboolean(isMediaSupported)
            this.logUtil.putF(stringBuffer.toString(), this, "saveFiles()")
        }
        var defaultMediaData : MediaData = MediaData.getDefault()
        this.setFileNames(fileName)
        if (isMediaSupported) {
            var isMediaResizable : Boolean = uploadMedia.isWriterMedia(mediaData.getName(), MediaTypeData.getInstance().RESIZABLE_MEDIA)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                stringBuffer.delete(0, stringBuffer.length())
                stringBuffer.append("Is ")
                stringBuffer.append(mediaData.toString())
                stringBuffer.append(" Image Resize Supported:")
                stringBuffer.appendboolean(uploadMedia.isSupported(mediaData.getName()))
                stringBuffer.append(" WriterMedia: ")
                stringBuffer.appendboolean(isMediaResizable)
                this.logUtil.putF(stringBuffer.toString(), this, "saveFiles()")
            }
            //Is the uploaded File an image that ImageIO can resize
            if (isMediaResizable) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                    this.logUtil.putF("Saving Small Image: " + this.itemInterface.getSmallImage(), this, "saveFiles()")
                }
                this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getSmallImage(), fullPath, mediaData, this.SMALLWIDTH, this.SMALLHEIGHT)
                this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getMediumImage(), fullPath, mediaData, this.MEDIUMWIDTH, this.MEDIUMHEIGHT)
                this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getLargeImage(), fullPath, mediaData, this.LARGEWIDTH, this.LARGEHEIGHT)
            } else {
                //a different ImageIO format
                var isConvertable : Boolean = mediaData.isConvertableTo(defaultMediaData)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                    stringBuffer.delete(0, stringBuffer.length())
                    stringBuffer.append("Converting: ")
                    stringBuffer.append(defaultMediaData.getName())
                    stringBuffer.append(" into ")
                    stringBuffer.append(mediaData.getName())
                    stringBuffer.append(" if Convertable is it: ")
                    stringBuffer.appendboolean(isConvertable)
                    this.logUtil.putF(stringBuffer.toString(), this, "saveFiles()")
                }
                if (isConvertable) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                        this.logUtil.putF("Saving Small Image: " + this.itemInterface.getSmallImage(), this, "saveFiles()")
                    }
                    this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getSmallImage(), fullPath, defaultMediaData, this.SMALLWIDTH, this.SMALLHEIGHT)
                    this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getMediumImage(), fullPath, defaultMediaData, this.MEDIUMWIDTH, this.MEDIUMHEIGHT)
                    this.mediaUtil.saveImageFile(originalImageFile, this.itemInterface.getLargeImage(), fullPath, defaultMediaData, this.LARGEWIDTH, this.LARGEHEIGHT)
                } else {
                    //Create Multiple files without resizing
                    var smallImageFile : AbFile = AbFile.createAbFile(this.itemInterface.getSmallImage())
                    smallImageFile.createNewFile()
                    fileUtil.write(new ByteArrayInputStream(byteArray), smallImageFile)
                    //fileItemUtil.write(fileItem, smallImageFile);
                    var mediumImageFile : AbFile = AbFile.createAbFile(this.itemInterface.getMediumImage())
                    smallImageFile.createNewFile()
                    fileUtil.write(new ByteArrayInputStream(byteArray), mediumImageFile)
                    //fileItemUtil.write(fileItem, mediumImageFile);
                    var largeImageFile : AbFile = AbFile.createAbFile(this.itemInterface.getSmallImage())
                    largeImageFile.createNewFile()
                    fileUtil.write(new ByteArrayInputStream(byteArray), largeImageFile)
                }
            }
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.END, this, "saveFiles()")
        }
        return this.itemInterface
    }

    private def setFileNames(fileName : String) : Unit = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.itemInterface.getId())
        stringBuffer.append(AbPathData.getInstance().EXTENSION_SEP)
        stringBuffer.append(MediaData.getDefault().getName())
        var END : String = stringBuffer.toString()
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(fileName)
        stringBuffer.append(this.SMALL)
        stringBuffer.append(END)
        var newImageFileName : String = stringBuffer.toString()
        this.itemInterface.setSmallImage(newImageFileName)
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(fileName)
        stringBuffer.append(this.MEDIUM)
        stringBuffer.append(END)
        newImageFileName = stringBuffer.toString()
        this.itemInterface.setMediumImage(newImageFileName)
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append(fileName)
        stringBuffer.append(this.LARGE)
        stringBuffer.append(END)
        newImageFileName = stringBuffer.toString()
        this.itemInterface.setLargeImage(newImageFileName)
    }

}


