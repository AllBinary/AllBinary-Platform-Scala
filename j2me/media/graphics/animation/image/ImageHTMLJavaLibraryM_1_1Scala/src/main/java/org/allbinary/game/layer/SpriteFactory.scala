/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.game.Sprite
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.communication.log.LogUtil

/**  *  * @author User  */
class SpriteFactory extends SpriteFactoryInterface {
    import _root_.org.allbinary.game.layer.SpriteFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonSeps commonSeps = CommonSeps.getInstance();
    override def createSprite(image : Image, frameWidth : Int, frameHeight : Int) : Sprite = {
        //this.logUtil.putF(new StringMaker().append(image.getWidth()).append(commonSeps.COLON).append(image.getHeight()).append(commonSeps.FORWARD_SLASH).append(frameWidth).append(commonSeps.COLON).append(frameHeight).toString(), this, this.commonStrings.PROCESS);
        return new Sprite(image, frameWidth, frameHeight)
    }

}

object SpriteFactory {
    private val instance : SpriteFactory = new SpriteFactory()

    /**      * @return the instance      */
    def getInstance() : SpriteFactory = {
        return SpriteFactory.instance
    }

}


