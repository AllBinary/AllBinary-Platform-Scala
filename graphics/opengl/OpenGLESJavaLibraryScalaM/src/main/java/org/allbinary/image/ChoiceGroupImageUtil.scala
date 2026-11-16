/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.image

import _root_.javax.microedition.khronos.opengles.GL
import _root_.javax.microedition.lcdui.ChoiceGroupImageFactory
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureFactory
import _root_.org.allbinary.game.configuration.feature.Features

class ChoiceGroupImageUtil {
    import _root_.org.allbinary.image.ChoiceGroupImageUtil.{*}

    def init() : Unit = {
        val features : Features = Features.getInstance()
        val choiceGroupFactory : ChoiceGroupImageFactory = ChoiceGroupImageFactory.getInstance()
        val imageArray : Array[Image] = choiceGroupFactory.getImageArray()
        if (features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()
            val size : Int = imageArray.length

            {
                var index : Int = 0
                while (index < size) {
                    imageArray(index) = preResourceImageUtil.encapsulate(imageArray(index))
                    index += 1
                }
            }
            choiceGroupFactory.init(imageArray)
        }
    }

    def update(gl : GL) : Unit = {
        val features : Features = Features.getInstance()
        val choiceGroupFactory : ChoiceGroupImageFactory = ChoiceGroupImageFactory.getInstance()
        val imageArray : Array[Image] = choiceGroupFactory.getImageArray()
        if (features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()
            val size : Int = imageArray.length

            {
                var index : Int = 0
                while (index < size) {
                    preResourceImageUtil.updateGL(gl, imageArray(index))
                    index += 1
                }
            }
        }
        choiceGroupFactory.init(imageArray)
    }

    def update(graphics : Graphics) : Unit = {
        val features : Features = Features.getInstance()
        val choiceGroupFactory : ChoiceGroupImageFactory = ChoiceGroupImageFactory.getInstance()
        val imageArray : Array[Image] = choiceGroupFactory.getImageArray()
        if (features.isDefault(OpenGLFeatureFactory.getInstance().OPENGL)) {
            val preResourceImageUtil : PreResourceImageUtil = PreResourceImageUtil.getInstance()
            val size : Int = imageArray.length

            {
                var index : Int = 0
                while (index < size) {
                    preResourceImageUtil.update(graphics, imageArray(index))
                    index += 1
                }
            }
        }
        choiceGroupFactory.init(imageArray)
    }

}

object ChoiceGroupImageUtil {
    private val instance : ChoiceGroupImageUtil = new ChoiceGroupImageUtil()

    /**      * @return the instance      */
    def getInstance() : ChoiceGroupImageUtil = {
        return ChoiceGroupImageUtil.instance
    }

}


