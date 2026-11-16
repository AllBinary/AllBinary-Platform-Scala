/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.media.image

import _root_.java.awt.image.BufferedImage
import _root_.java.io.File
import _root_.java.io.IOException
import _root_.java.util.Iterator
import _root_.javax.imageio.IIOImage
import _root_.javax.imageio.ImageIO
import _root_.javax.imageio.ImageWriteParam
import _root_.javax.imageio.ImageWriter
import _root_.javax.imageio.stream.ImageOutputStream
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbFileOutputStream
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.string.CommonStrings
import _root_.org.apache.batik.ext.awt.image.codec.png.PNGImageWriter

/**  *  * @author user  */
class ImagePersistanceUtil {
    import _root_.org.allbinary.media.image.ImagePersistanceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def saveWithBatik(file : AbFile, bufferedImage : BufferedImage) : Unit = {
        val batikPNGImageWriter : PNGImageWriter = new PNGImageWriter()
        val fileOutputStream : AbFileOutputStream = AbFileOutputStream.createFromAbFile(file)
        try {
            batikPNGImageWriter.writeImage(bufferedImage, fileOutputStream)
        } finally {
            fileOutputStream.flush()
            StreamUtil.getInstance().close(fileOutputStream)
        }
        this.logUtil.putF("Wrote Image: " + file.getAbsolutePath(), this, this.commonStrings.SAVE)
    }

    /*  protected static Map defaultColours(String design, String model) {      String ds3tfyDefaultColours = "bod,f35;acc,x01;nos,f10;cli,f10;cap,f10";      Map result = StdUtil.getInstance().createHashMap();   String[] records = ds3tfyDefaultColours.split(";");   for ( int i = 0; i < records.length; i++ ) {    String[] fields = records[i].split(",");    result.put(fields[0], fields[1]);   }      return result;  }     protected static RenderedImage getAlpha(RenderedImage img) {   int alphaBandIndex = 3;      ParameterBlock alphaPb = new ParameterBlock();   alphaPb.addSource(img);   alphaPb.add(new int[]{alphaBandIndex});   RenderedImage alphaImg = (RenderedImage)JAI.create("bandselect", alphaPb);      return alphaImg;  }       */
    def saveWithImageIO(filePath : String, bufferedImage : BufferedImage) : Unit = {
        this.saveWithImageIO(new File(filePath), bufferedImage)
    }

    def saveWithImageIO(file : File, bufferedImage : BufferedImage) : Unit = {
        var writer : ImageWriter = null
        var ios : ImageOutputStream = null
        try {
            // Obtain a writer based on the jpeg format.
            val iter : Iterator[? <: Object] = ImageIO.getImageWritersByFormatName("jpeg").asInstanceOf[Iterator[? <: Object]]
            // Validate existence of writer.
            if (!iter.hasNext()) {
                this.logUtil.putF("Unable to save image to jpeg file type.", this, this.commonStrings.SAVE)
                return
            }
            // Extract writer.
            writer = iter.next().asInstanceOf[ImageWriter]
            // Configure writer output destination.
            ios = ImageIO.createImageOutputStream(file)
            writer.setOutput(ios)
            // Set JPEG compression quality to 95%.
            val iwp : ImageWriteParam = writer.getDefaultWriteParam()
            iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT)
            iwp.setCompressionQuality(0.95f)
            //writer.write(null, (IIOImage) iioImageCacheable.getIioImage(), iwp);
            writer.write(null, new IIOImage(bufferedImage, null, null), iwp)
            //poolInterface.add(iioImageCacheable);
            this.logUtil.putF("Wrote Image: " + file.getAbsolutePath(), this, this.commonStrings.SAVE)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.SAVE, e)
            }
        } finally {
            try {
                if (ios != null) {
                    ios.flush()
                    //StreamUtil.getInstance().close(ios);
                    try {
                        if (ios != null) {
                            this.logUtil.putF(ios.toString(), ios, this.commonStrings.CLOSE)
                            ios.close()
                        }
                    } catch {
                        case e : Exception => {
                            this.logUtil.put(commonStrings.EXCEPTION, ios, commonStrings.CLOSE, e)
                        }
                    }
                }
                if (writer != null) {
                    writer.dispose()
                }
            } catch {
                case e2 : IOException => {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.SAVE, e2)
                }
            }
        }
    }

}

object ImagePersistanceUtil {
    private val instance : ImagePersistanceUtil = new ImagePersistanceUtil()

    def getInstance() : ImagePersistanceUtil = {
        return ImagePersistanceUtil.instance
    }

}


