/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.java.io.InputStream
import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.device.NullGL10
import _root_.org.allbinary.graphics.opengles.renderer.AllBinaryRendererBase3
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.image.ImageCache
import _root_.org.allbinary.image.ImageCacheFactory
import _root_.org.allbinary.image.PreResourceImageUtil
import _root_.org.allbinary.thread.SynchObject

//ImageCacheOpenGLESJavaLibrary
class OpenGLImageCache() extends ImageCache {

    private val imageCache : ImageCache = ImageCacheFactory.getInstance()

    private val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()

    private var gl : GL10 = NullGL10.NULL_GL10

    private val lock : SynchObject = new SynchObject()

    private val list : BasicArrayList = new BasicArrayListD()

    private var renderer : AllBinaryRendererBase3 = new AllBinaryRendererBase3()

    override def addListener(renderer : Object) : Unit = {
        this.renderer = renderer.asInstanceOf[AllBinaryRendererBase3]
    }

    def update(gl : GL10) : Unit = {
        //this.logUtil.putF(CommonLabels.getInstance().START_LABEL + list, this, this.commonStrings.UPDATE);
        this.gl = gl
        this.lock.synchronized {

            {
                var index : Int = this.list.size() - 1
                while (index >= 0) {
                    var openGLESImage : OpenGLESImage = (this.list.objectArray(index).asInstanceOf[OpenGLESImage])
                    if (openGLESImage ne OpenGLESImage.NULL_OPENGL_IMAGE) {
                        openGLESImage.set(gl)
                    }
                    index -= 1
                }
            }
        }
    }

    override def createImage(caller : String, param_width : Int, param_height : Int) : Image = {
        var width : Int = param_width
        var height : Int = param_height
        var textureSize : Int = width
        if (height > width) {
            textureSize = height
        }

        {
            while ((textureSize % 4) != 0) {
                textureSize += 1
            }
        }
        width = textureSize
        height = textureSize
        val image2 : Image = this.imageCache.get(caller, width, height)
        val image : Image = this.preResourceImageUtil.encapsulate(image2)
        //this.logUtil.putF("opengl: createImageD: " + image.getName(), this, this.commonStrings.CREATE);
        this.lock.synchronized {
            if (image ne NullImage.NULL_IMAGE) {
                this.list.add(image)
            }
        }
        return image
    }

    override def createImageFromInputStream(key : Object, inputStream : InputStream) : Image = {
        val cachedImage : Image = this.imageCache.getWithKey(key)
        //return new OpenGLESImage(cachedImage);
        val image : Image = this.preResourceImageUtil.encapsulate(cachedImage)
        //this.logUtil.putF("opengl: createImage: " + image.getName(), this, this.commonStrings.CREATE);
        this.lock.synchronized {
            if (image ne NullImage.NULL_IMAGE) {
                this.list.add(image)
            }
        }
        //this.logUtil.putF(key + " = " + image.toString(), this, this.commonStrings.GET);
        return image
    }

    def getGlP() : GL10 = {
        return this.gl
    }

    override def init(image : Image) : Unit = {
        try {
            //this.logUtil.putF(new StringMaker().append("opengl: init add ").append(image).append(image.getName()).toString(), this, this.commonStrings.INIT);
            this.lock.synchronized {
                if (this.list.contains(image)) {
                    throw new RuntimeException()
                }
                this.list.add(image)
            }
            this.renderer.add(image)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.INIT, e)
            }
        }
    }

}


