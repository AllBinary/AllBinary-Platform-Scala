/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles

import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.game.configuration.event.ChangedGameFeatureListener
import _root_.org.allbinary.game.configuration.feature.Feature
import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.MainFeatureFactory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.string.StringUtil

class OpenGLConfiguration private() {
    import _root_.org.allbinary.graphics.opengles.OpenGLConfiguration.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var opengl : Boolean = false

    private var `type` : OpenGLFeature = OpenGLFeatureFactory.getInstance().OPENGL_AS_GAME_THREAD

    private var imageColor : OpenGLFeature = OpenGLFeatureFactory.getInstance().IMAGE_COLOR_DEPTH_4444

    private var color : OpenGLFeature = OpenGLFeatureFactory.getInstance().IMAGE_COLOR_DEPTH_4444

    private var versionSelector : OpenGLFeature = OpenGLFeatureFactory.getInstance().OPENGL_AUTO_SELECT

    def write() : Unit = {
    }

    def init() : Unit = {
        val features : Features = Features.getInstance()
        if (ChangedGameFeatureListener.getInstance().isChangedFeature(MainFeatureFactory.getInstance().STATIC)) {
            if (this.isOpenGL()) {
                if (!features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                    this.logUtil.putF("Turning on OpenGL", this, this.commonStrings.INIT)
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
                this.logUtil.putF("OpenGL is Off", this, this.commonStrings.INIT)
            }
        } else {
            if (this.isOpenGL() && !features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
                PreLogUtil.put("OpenGL is set but not Enabled since Statics where not cleared (Reboot or Complete exit is Required)", this, this.commonStrings.INIT)
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


