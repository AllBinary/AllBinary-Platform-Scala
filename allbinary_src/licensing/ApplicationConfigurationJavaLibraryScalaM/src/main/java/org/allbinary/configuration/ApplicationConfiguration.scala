/* Generated Code Do Not Modify */
package org.allbinary.configuration

import _root_.java.io.Closeable
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.game.configuration.feature.Feature
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.AbDataInputStream
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.io.NullCloseable
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class ApplicationConfiguration private() {
    import _root_.org.allbinary.configuration.ApplicationConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    /*      * private boolean fullscreen = true; private boolean showTitleBar = true;      * protected boolean progressBarView = true;      */
    private var fullscreen : Boolean = true

    private var showTitleBar : Boolean = false

    private var progressBarView : Boolean = false

    private val FILE : String = "ReloadConfiguration.dat"

    //Constructor
    {
        try {
            if (FileFactory.getInstance().isFile(this.FILE)) {
                this.read()
            } else {
                this.write()
            }
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    private def read() : Unit = {
        val fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
        val fileInputStream : InputStream = fileInputStreamFactory.getFileInputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
        val dataInputStream : AbDataInputStream = new AbDataInputStream(fileInputStream)
        var fullScreen : Int = dataInputStream.readInt()
        if (fullScreen == 0) {
            this.setFullscreen(false)
        } else if (fullScreen == 1) {
            this.setFullscreen(true)
        } else {
            throw new Exception("Invalid FullScreen ActivityConfiguration")
        }
        val progressBarView : Int = dataInputStream.readInt()
        if (progressBarView == 0) {
            this.setProgressBarView(false)
        } else if (progressBarView == 1) {
            this.setProgressBarView(true)
        } else {
            throw new Exception("Invalid ProgressBarView ActivityConfiguration")
        }
        val showTitleBar : Int = dataInputStream.readInt()
        if (showTitleBar == 0) {
            this.setShowTitleBar(false)
        } else if (showTitleBar == 1) {
            this.setShowTitleBar(true)
        } else {
            throw new Exception("Invalid ShowTitleBar ActivityConfiguration")
        }
        //PreLogUtil.put("Read Configuration: " + this.toString(), this, "read");
        this.logUtil.putF("Read Configuration: " + this.toString(), this, "read")
    }

    def write() : Unit = {
        var closeable : Closeable = NullCloseable.NULL_CLOSEABLE
        try {
            //PreLogUtil.put("Write Configuration: " + this.toString(), this, "write");
            this.logUtil.putF("Write Configuration: " + this.toString(), this, "write")
            val fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            val fileOutputStream : OutputStream = fileInputStreamFactory.getFileOutputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
            val dataOutputStream : AbDataOutputStream = new AbDataOutputStream(fileOutputStream)
            closeable = dataOutputStream
            if (this.isFullscreen()) {
                dataOutputStream.writeInt(1)
            } else {
                dataOutputStream.writeInt(0)
            }
            if (this.isProgressBarView()) {
                dataOutputStream.writeInt(1)
            } else {
                dataOutputStream.writeInt(0)
            }
            if (this.isShowTitleBar()) {
                dataOutputStream.writeInt(1)
            } else {
                dataOutputStream.writeInt(0)
            }
            dataOutputStream.flush()
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            StreamUtil.getInstance().close(closeable)
        }
    }

    def update(gameFeature : Feature) : Unit = {
        if (gameFeature eq MainFeatureFactory.getInstance().FULL_SCREEN) {
            val features : Features = Features.getInstance()
            if (features.isFeature(gameFeature)) {
                if (!this.isFullscreen()) {
                    this.setFullscreen(true)
                    this.write()
                }
            } else {
                if (this.isFullscreen()) {
                    this.setFullscreen(false)
                    this.write()
                }
            }
        }
    }

    def setFullscreen(fullscreen : Boolean) : Unit = {
        this.fullscreen = fullscreen
    }

    def isFullscreen() : Boolean = {
        return this.fullscreen
    }

    def setShowTitleBar(showTitleBar : Boolean) : Unit = {
        this.showTitleBar = showTitleBar
    }

    def isShowTitleBar() : Boolean = {
        return this.showTitleBar
    }

    def setProgressBarView(progressBarView : Boolean) : Unit = {
        this.progressBarView = progressBarView
    }

    def isProgressBarView() : Boolean = {
        return this.progressBarView
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("isFullscreen: ")
        stringBuffer.appendboolean(this.isFullscreen())
        stringBuffer.append(" isProgressBarView: ")
        stringBuffer.appendboolean(this.isProgressBarView())
        stringBuffer.append(" isShowTitleBar: ")
        stringBuffer.appendboolean(this.isShowTitleBar())
        return stringBuffer.toString()
    }

}

object ApplicationConfiguration {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : ApplicationConfiguration = {
        if (ApplicationConfiguration.instance eq NullUtil.getInstance().NULL_OBJECT) {
            ApplicationConfiguration.instance = new ApplicationConfiguration()
        }
        return ApplicationConfiguration.instance.asInstanceOf[ApplicationConfiguration]
    }

}


