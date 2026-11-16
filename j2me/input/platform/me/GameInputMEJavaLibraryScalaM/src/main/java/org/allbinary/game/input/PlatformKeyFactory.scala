/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author user  */
class PlatformKeyFactory {
    import _root_.org.allbinary.game.input.PlatformKeyFactory.{*}

    def getString(keyCode : Int) : String = {
        return J2MEGameKey.getString(keyCode)
    }

    def isSubmission(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isSubmission(input)
    }

    def isDelete(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isDelete(input)
    }

    def isBackSpace(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isBackSpace(input)
    }

    def isLeft(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isLeft(input)
    }

    def isRight(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isRight(input)
    }

    def isUp(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isUp(input)
    }

    def isDown(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isDown(input)
    }

    def isEnter(input : Input) : Boolean = {
        return J2MEKeyFactory.getInstance().isEnter(input)
    }

}

object PlatformKeyFactory {
    private var instance : Object = NullUtil.getInstance().NULL_OBJECT

    def getInstance() : PlatformKeyFactory = {
        if (PlatformKeyFactory.instance eq NullUtil.getInstance().NULL_OBJECT) {
            PlatformKeyFactory.instance = new PlatformKeyFactory()
        }
        return PlatformKeyFactory.instance.asInstanceOf[PlatformKeyFactory]
    }

}


