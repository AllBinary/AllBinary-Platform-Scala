/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.device.LoadTextures
import _root_.org.allbinary.device.OpenGLESGraphics
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvas
import _root_.org.allbinary.graphics.canvas.transition.progress.ProgressCanvasFactory
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.displayable.DisplayInfoSingleton
import _root_.org.allbinary.graphics.opengles.renderer.RendererStrings
import _root_.org.allbinary.image.PreResourceImageUtil
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.image.opengles.OpenGLImageCache
import _root_.org.allbinary.image.opengles.OpenGLImageCacheFactory
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.SynchObject
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class OpenGLUtil {
    import _root_.org.allbinary.graphics.opengles.OpenGLUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val renderStrings : RendererStrings = RendererStrings.getInstance()

    val canvasStrings : CanvasStrings = CanvasStrings.getInstance()

    val displayInfoSingleton : DisplayInfoSingleton = DisplayInfoSingleton.getInstance()

    private val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()

    private val lockObject : SynchObject = new SynchObject()

    private val anyType : SynchObject = new SynchObject()

    private val list : BasicArrayList = new BasicArrayListD()

    val runnableList : BasicArrayList = new BasicArrayListD()

    private var created : Boolean = false

    private var surfaceCreatedAndInitialized : Boolean = false

    def onSurfaceCreated(gl : GL10) : Unit = {
        try {
            if (!this.created) {
                this.created = true
                PreLogUtil.put(CommonLabels.getInstance().START_LABEL + OpenGLCapabilities.getInstance().toString(), this, this.renderStrings.ON_SURFACE_CREATED)
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.renderStrings.ON_SURFACE_CREATED, e)
            }
        }
    }

    def onSurfaceCreated(gl : GL10, loadTextures : LoadTextures) : Unit = {
        try {
            // gl.glMatrixMode(GL10.GL_MODELVIEW);
            loadTextures.load(gl)
            OpenGLLogUtil.getInstance().logError(gl)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.renderStrings.ON_SURFACE_CREATED, e)
            }
        }
    }

    def onSurfaceChanged(gl : GL10, graphics : OpenGLESGraphics) : Unit = {
        if (!this.surfaceCreatedAndInitialized) {
            graphics.init()
            this.surfaceCreatedAndInitialized = true
        }
        //Seems that mutable images must be reloaded on graphics change?
        graphics.update()
        val progressCanvas : ProgressCanvas = ProgressCanvasFactory.getInstance()
        progressCanvas.update(graphics)
        //        choiceGroupImageUtil.update(graphics);
        (OpenGLImageCacheFactory.getInstance().asInstanceOf[OpenGLImageCache]).update(gl)
        this.processRunnables()
        this.set(gl)
    }

    def addImage(image : Image) : Image = {
        val encapsulateImage : Image = this.preResourceImageUtil.encapsulate(image)
        if (encapsulateImage ne image) {
            //            this.logUtil.putF(new StringMaker().append("add image ").append(thread.getName()).toString(), this, this.renderStrings.ON_SURFACE_CHANGED);
            this.anyType.synchronized {
                this.list.add(encapsulateImage)
            }
            //this.logUtil.putF(new StringMaker().append("add image: ").append(encapsulateImage).append(CommonSeps.getInstance().SPACE).append(thread.getName()).toString(), this, this.renderStrings.ON_SURFACE_CHANGED);
            return encapsulateImage
        }
        return image
    }

    def clear() : Unit = {
        //        this.logUtil.putF(new StringMaker().append("clear: ").append(thread.getName()).toString(), this, RendererStrings.getInstance().ON_SURFACE_CHANGED);
        this.anyType.synchronized {
            this.list.clear()
        }
    }

    def addRunnable(runnable : Runnable) : Unit = {
        this.lockObject.synchronized {
            //this.logUtil.putF("try to add", this, RendererStrings.getInstance().ON_SURFACE_CHANGED);
            if (!this.runnableList.contains(runnable)) {
                //this.logUtil.putF("add", this, RendererStrings.getInstance().ON_SURFACE_CHANGED);
                this.runnableList.add(runnable)
                this.displayInfoSingleton.add(this.canvasStrings.SCALED_IMAGES)
            }
        }
    }

    private def processRunnables() : Unit = {
        this.lockObject.synchronized {
            var runnable : Runnable = null
            val size : Int = this.runnableList.size()
            //this.logUtil.putF(new StringMaker().append("size: ").append(size).toString(), this, RendererStrings.getInstance().ON_SURFACE_CHANGED);

            {
                var index : Int = 0
                while (index < size) {
                    runnable = this.runnableList.get(index).asInstanceOf[Runnable]
                    runnable.run()
                    index += 1
                }
            }
            this.runnableList.clear()
        }
    }

    private def set(gl : GL10) : Unit = {
        val size : Int = this.list.size()
        //        final String IMAGE = "image: ";
        var image : OpenGLESImage = null

        {
            var index2 : Int = 0
            while (index2 < size) {
                image = this.list.get(index2).asInstanceOf[OpenGLESImage]
                //            this.logUtil.putF(stringMaker.append(index2).append(IMAGE).append(image).append(CommonSeps.getInstance().SPACE).append(thread.getName()).toString(), this, this.renderStrings.ON_SURFACE_CHANGED);
                image.set(gl)
                index2 += 1
            }
        }
    }

}

object OpenGLUtil {
    private val instance : OpenGLUtil = new OpenGLUtil()

    def getInstance() : OpenGLUtil = {
        return OpenGLUtil.instance
    }

}


