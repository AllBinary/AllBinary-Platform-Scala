/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.java.io.Closeable
import _root_.java.io.DataInputStream
import _root_.java.io.InputStream
import _root_.java.io.OutputStream
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.io.AbDataOutputStream
import _root_.org.allbinary.logic.io.FileStreamFactory
import _root_.org.allbinary.logic.io.StreamUtil
import _root_.org.allbinary.logic.io.file.FileFactory
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.feature.Feature
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.io.NullCloseable

class OpenGLConfiguration private() {
    import _root_.org.allbinary.graphics.opengles.OpenGLConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val FILE : String = "OpenGLConfiguration.dat"

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private var opengl : Boolean = false

    private var `type` : OpenGLFeature = OpenGLFeatureFactory.getInstance().OPENGL_AS_GAME_THREAD

    private var imageColor : OpenGLFeature = OpenGLFeatureFactory.getInstance().IMAGE_COLOR_DEPTH_4444

    private var color : OpenGLFeature = OpenGLFeatureFactory.getInstance().IMAGE_COLOR_DEPTH_4444

    private var versionSelector : OpenGLFeature = OpenGLFeatureFactory.getInstance().OPENGL_AUTO_SELECT

    //Constructor
    {
        //PreLogUtil.put(color.getName(), this, "Constructor - color - depth");
        try {
            if (FileFactory.getInstance().isFile(this.FILE)) {
                this.read()
            } else {
                this.write()
            }
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    private def read() : Unit = {
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        val fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
        val fileInputStream : InputStream = fileInputStreamFactory.getFileInputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
        val dataInputStream : DataInputStream = new DataInputStream(fileInputStream)
        val openGLValue : Int = dataInputStream.readInt()
        if (openGLValue == 0) {
            this.setOpenGL(false)
        } else if (openGLValue == 1) {
            this.setOpenGL(true)
        } else {
            throw new Exception("Invalid OpenGL Setting")
        }
        val version : String = dataInputStream.readUTF()
        if (this.tsUtil.compareTo(version, openGLFeatureFactory.OPENGL_AUTO_SELECT.getName()) == 0) {
            this.setVersionSelector(openGLFeatureFactory.OPENGL_AUTO_SELECT)
        } else if (this.tsUtil.compareTo(version, openGLFeatureFactory.OPENGL_MINIMUM.getName()) == 0) {
            this.setVersionSelector(openGLFeatureFactory.OPENGL_MINIMUM)
        } else {
            throw new Exception("OpenGLConfiguration: Error reading version selector: " + version)
        }
        val `type` : String = dataInputStream.readUTF()
        if (this.tsUtil.compareTo(`type`, openGLFeatureFactory.OPENGL_AS_GAME_THREAD.getName()) == 0) {
            this.setType(openGLFeatureFactory.OPENGL_AS_GAME_THREAD)
        } else if (this.tsUtil.compareTo(`type`, openGLFeatureFactory.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS.getName()) == 0) {
            this.setType(openGLFeatureFactory.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS)
        } else {
            throw new Exception("OpenGLConfiguration: Error reading image color")
        }
        val imageColor : String = dataInputStream.readUTF()
        if (this.tsUtil.compareTo(imageColor, openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444.getName()) == 0) {
            this.setImageColor(openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444)
        } else if (this.tsUtil.compareTo(imageColor, openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444.getName()) == 0) {
            this.setImageColor(openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444)
        } else if (this.tsUtil.compareTo(imageColor, openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444.getName()) == 0) {
            this.setImageColor(openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444)
        } else {
            throw new Exception("OpenGLConfiguration: Error reading image color: " + imageColor)
        }
        val color : String = dataInputStream.readUTF()
        if (this.tsUtil.compareTo(color, openGLFeatureFactory.OPENGL_COLOR_DEPTH_4444.getName()) == 0) {
            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_4444)
        } else if (this.tsUtil.compareTo(color, openGLFeatureFactory.OPENGL_COLOR_DEPTH_565.getName()) == 0) {
            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_565)
        } else if (this.tsUtil.compareTo(color, openGLFeatureFactory.OPENGL_COLOR_DEPTH_8888.getName()) == 0) {
            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_8888)
        } else {
            throw new Exception("OpenGLConfiguration: Error reading color: " + color)
        }
        PreLogUtil.put("Read Configuration: " + this.toString(), this, "read")
    }

    def write() : Unit = {
        var closeable : Closeable = NullCloseable.NULL_CLOSEABLE
        try {
            //this.logUtil.putF("Write Configuration: " + this.toString(), this, "write");
            PreLogUtil.put("Write Configuration: " + this.toString(), this, "write")
            val fileInputStreamFactory : FileStreamFactory = FileStreamFactory.getInstance()
            val fileOutputStream : OutputStream = fileInputStreamFactory.getFileOutputStreamInstance(StringUtil.getInstance().EMPTY_STRING, this.FILE)
            val dataOutputStream : AbDataOutputStream = new AbDataOutputStream(fileOutputStream)
            closeable = dataOutputStream
            if (this.isOpenGL()) {
                dataOutputStream.writeInt(1)
            } else {
                dataOutputStream.writeInt(0)
            }
            dataOutputStream.writeUTF(this.getVersionSelector().getName())
            dataOutputStream.writeUTF(this.getType().getName())
            dataOutputStream.writeUTF(this.getImageColor().getName())
            dataOutputStream.writeUTF(this.getColor().getName())
            dataOutputStream.flush()
        } catch {
            case e : Exception => {
                throw e
            }
        } finally {
            StreamUtil.getInstance().close(closeable)
        }
    }

    def init() : Unit = {
        val features : Features = Features.getInstance()
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(MainFeatureFactory.getInstance().STATIC)) {
            val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
            if (this.isOpenGL()) {
                //this.logUtil.putF("OpenGL is enabled", this, this.commonStrings.INIT);
                if ((features.isFeature(openGLFeatureFactory.OPENGL_2D) || features.isFeature(openGLFeatureFactory.OPENGL_3D)) || features.isFeature(openGLFeatureFactory.OPENGL_2D_AND_3D)) {
                    if (!features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                        this.logUtil.putF("Turning on OpenGL as Default", this, this.commonStrings.INIT)
                        features.addDefault(OpenGLFeatureFactory.getInstance().OPENGL)
                        this.logUtil.putF("Using OpenGL Type Feature: " + this.getType(), this, this.commonStrings.INIT)
                        features.addDefault(this.getType())
                        this.logUtil.putF("Using OpenGL ImageColor Feature: " + this.getImageColor(), this, this.commonStrings.INIT)
                        features.addDefault(this.getImageColor())
                        this.logUtil.putF("Using OpenGL Color Feature: " + this.getColor(), this, this.commonStrings.INIT)
                        features.addDefault(this.getColor())
                        this.logUtil.putF("Using OpenGL Version Selector Feature: " + this.getVersionSelector(), this, this.commonStrings.INIT)
                        features.addDefault(this.getVersionSelector())
                    }
                } else {
                    this.logUtil.putF("OpenGL is enabled, but this game does not support OpenGL (Probably from installing with the same package name from a game that had OpenGL available)", this, this.commonStrings.INIT)
                }
            } else {
                this.logUtil.putF("OpenGL is Off", this, this.commonStrings.INIT)
            }
        } else {
            if (this.isOpenGL() && !features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                PreLogUtil.put("OpenGL is set but not Enabled since statics where not cleared (Reboot or Complete exit is Required)", this, this.commonStrings.INIT)
            }
        }
        PreLogUtil.put(this.toString(), this, this.commonStrings.INIT)
    }

    def update(gameFeature : Feature, colorLocked : Boolean) : Unit = {
        val features : Features = Features.getInstance()
        val openGLFeatureFactory : OpenGLFeatureFactory = OpenGLFeatureFactory.getInstance()
        var modified : Boolean = false
        if (gameFeature eq openGLFeatureFactory.OPENGL) {
            if (features.isFeature(gameFeature)) {
                if (!this.isOpenGL()) {
                    this.setOpenGL(true)
                    modified = true
                }
            } else {
                if (this.isOpenGL()) {
                    this.setOpenGL(false)
                    modified = true
                }
            }
        }
        if ((gameFeature eq openGLFeatureFactory.OPENGL_AND_GAME_HAVE_DIFFERENT_THREADS) || (gameFeature eq openGLFeatureFactory.OPENGL_AS_GAME_THREAD)) {
            if (features.isFeature(gameFeature)) {
                if (gameFeature ne this.getType()) {
                    this.setType(gameFeature.asInstanceOf[OpenGLFeature])
                    modified = true
                }
            }
        }
        if (((gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444) || (gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_565)) || (gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_8888)) {
            if (features.isFeature(gameFeature)) {
                if (this.getImageColor() ne gameFeature) {
                    this.setImageColor(gameFeature.asInstanceOf[OpenGLFeature])
                    if (colorLocked) {
                        if (gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_4444) {
                            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_4444)
                        } else if (gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_565) {
                            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_565)
                        } else if (gameFeature eq openGLFeatureFactory.IMAGE_COLOR_DEPTH_8888) {
                            this.setColor(openGLFeatureFactory.OPENGL_COLOR_DEPTH_8888)
                        }
                    }
                    modified = true
                }
            }
        }
        if (((gameFeature eq openGLFeatureFactory.OPENGL_COLOR_DEPTH_4444) || (gameFeature eq openGLFeatureFactory.OPENGL_COLOR_DEPTH_565)) || (gameFeature eq openGLFeatureFactory.OPENGL_COLOR_DEPTH_8888)) {
            if (features.isFeature(gameFeature)) {
                if (this.getColor() ne gameFeature) {
                    this.setColor(gameFeature.asInstanceOf[OpenGLFeature])
                    modified = true
                }
            }
        }
        if ((gameFeature eq openGLFeatureFactory.OPENGL_AUTO_SELECT) || (gameFeature eq openGLFeatureFactory.OPENGL_MINIMUM)) {
            if (features.isFeature(gameFeature)) {
                this.setVersionSelector(gameFeature.asInstanceOf[OpenGLFeature])
            }
            modified = true
        }
        if (modified) {
            this.write()
        }
    }

    def setOpenGL(opengl : Boolean) : Unit = {
        this.opengl = opengl
    }

    def isOpenGL() : Boolean = {
        return this.opengl
    }

    def setImageColor(imageColor : OpenGLFeature) : Unit = {
        //PreLogUtil.put(imageColor.getName(), this, "setImageColor - depth");
        this.imageColor = imageColor
    }

    def getImageColor() : OpenGLFeature = {
        return this.imageColor
    }

    def setColor(color : OpenGLFeature) : Unit = {
        //PreLogUtil.put(imageColor.getName(), this, "setColor - depth");
        this.color = color
    }

    def getColor() : OpenGLFeature = {
        return this.color
    }

    def setVersionSelector(versionSelector : OpenGLFeature) : Unit = {
        this.versionSelector = versionSelector
    }

    def getVersionSelector() : OpenGLFeature = {
        return this.versionSelector
    }

    def setType(`type` : OpenGLFeature) : Unit = {
        this.`type` = `type`
    }

    def getType() : OpenGLFeature = {
        return this.`type`
    }

    override def toString() : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val stringUtil : StringUtil = StringUtil.getInstance()
        stringBuffer.append(" isOpenGL: ")
        stringBuffer.appendboolean(this.isOpenGL())
        stringBuffer.append(" VersionSelector: ")
        stringBuffer.append(stringUtil.toString(this.getVersionSelector()))
        stringBuffer.append(" Type: ")
        stringBuffer.append(stringUtil.toString(this.getType()))
        stringBuffer.append(" Image Color: ")
        stringBuffer.append(stringUtil.toString(this.getImageColor()))
        stringBuffer.append(" Color: ")
        stringBuffer.append(stringUtil.toString(this.getColor()))
        return stringBuffer.toString()
    }

}

object OpenGLConfiguration {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : OpenGLConfiguration = {
        if (OpenGLConfiguration.instance eq NullUtil.getInstance().NULL_OBJECT) {
            OpenGLConfiguration.instance = new OpenGLConfiguration()
        }
        return OpenGLConfiguration.instance.asInstanceOf[OpenGLConfiguration]
    }

}


