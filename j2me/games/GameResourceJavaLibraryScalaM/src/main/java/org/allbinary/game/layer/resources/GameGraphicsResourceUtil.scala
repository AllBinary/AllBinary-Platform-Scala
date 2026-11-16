/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.resources

import _root_.org.allbinary.game.configuration.feature.Features
import _root_.org.allbinary.game.configuration.feature.GraphicsFeature
import _root_.org.allbinary.game.configuration.feature.GraphicsFeatureFactory
import _root_.org.allbinary.graphics.displayable.CanvasStrings
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

/**  *  * @author Berthelot, Travis  * @version 1.0  */
class GameGraphicsResourceUtil() {
    import _root_.org.allbinary.game.layer.resources.GameGraphicsResourceUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val SPRITE : String = "_sprite"

    val QUARTER : String = "_quarter"

    private var name : String = StringUtil.getInstance().EMPTY_STRING

    //Constructor
    {
        try {
            this.name = this.getString()
        } catch {
            case e : Exception => {
                val commonStrings : CommonStrings = CommonStrings.getInstance()
                this.logUtil.put(commonStrings.EXCEPTION, this, commonStrings.CONSTRUCTOR, e)
            }
        }
    }

    private def getString() : String = {
        val graphicsFeatureFactory : GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()
        var graphicsFeature : GraphicsFeature = graphicsFeatureFactory.NONE
        val features : Features = Features.getInstance()
        if (features.isFeature(graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS)) {
            graphicsFeature = graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS
        } else if (features.isFeature(graphicsFeatureFactory.SPRITE_FULL_GRAPHICS)) {
            graphicsFeature = graphicsFeatureFactory.SPRITE_FULL_GRAPHICS
        } else if (features.isFeature(graphicsFeatureFactory.SPRITE_QUARTER_ROTATION_GRAPHICS)) {
            graphicsFeature = graphicsFeatureFactory.SPRITE_QUARTER_ROTATION_GRAPHICS
        } else if (features.isFeature(graphicsFeatureFactory.IMAGE_ROTATION_ON_THE_FLY)) {
            graphicsFeature = graphicsFeatureFactory.IMAGE_ROTATION_ON_THE_FLY
        }
        return this.getStringForFeature(graphicsFeature)
    }

    def getStringForFeature(graphicsFeature : GraphicsFeature) : String = {
        val stringBuffer : StringMaker = new StringMaker()
        val graphicsFeatureFactory : GraphicsFeatureFactory = GraphicsFeatureFactory.getInstance()
        stringBuffer.delete(0, stringBuffer.length())
        val features : Features = Features.getInstance()
        if (features.isFeature(graphicsFeatureFactory.VECTOR_GRAPHICS)) {
        } else if (features.isFeature(graphicsFeatureFactory.IMAGE_GRAPHICS)) {
            if ((graphicsFeature eq graphicsFeatureFactory.IMAGE_TO_ARRAY_GRAPHICS) || (graphicsFeature eq graphicsFeatureFactory.IMAGE_ROTATION_ON_THE_FLY)) {
            } else if (graphicsFeature eq graphicsFeatureFactory.SPRITE_FULL_GRAPHICS) {
                stringBuffer.append(this.SPRITE)
            } else if (graphicsFeature eq graphicsFeatureFactory.SPRITE_QUARTER_ROTATION_GRAPHICS) {
                stringBuffer.append(this.QUARTER)
                stringBuffer.append(this.SPRITE)
            } else {
                throw new Exception("None/Unknown Sub Image Resource Type Specified")
            }
        } else if (OpenGLFeatureUtil.getInstance().isAnyThreed()) {
            stringBuffer.append(CanvasStrings.getInstance().OBJ_MODEL)
        } else {
            throw new Exception("None/Unknown Main Image Resource Type Specified")
        }
        return stringBuffer.toString()
    }

    def getName() : String = {
        return this.name
    }

}

object GameGraphicsResourceUtil {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : GameGraphicsResourceUtil = {
        if (GameGraphicsResourceUtil.instance eq NullUtil.getInstance().NULL_OBJECT) {
            GameGraphicsResourceUtil.instance = new GameGraphicsResourceUtil()
        }
        return GameGraphicsResourceUtil.instance.asInstanceOf[GameGraphicsResourceUtil]
    }

}


