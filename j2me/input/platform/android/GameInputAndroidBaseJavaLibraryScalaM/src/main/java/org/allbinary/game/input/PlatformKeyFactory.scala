/* Generated Code Do Not Modify */
package org.allbinary.game.input

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author user  */
class PlatformKeyFactory {
    import _root_.org.allbinary.game.input.PlatformKeyFactory.{*}

    private val androidKeyFactory : AndroidKeyFactory = ActivityFractureControllerUtilFactory.getInstance()

    def getString(keyCode : Int) : String = {
        return AndroidGameKey.getString(keyCode)
    }

    def isSubmission(input : Input) : Boolean = {
        return this.androidKeyFactory.isSubmission(input)
    }

    def isDelete(input : Input) : Boolean = {
        return this.androidKeyFactory.isDelete(input)
    }

    def isBackSpace(input : Input) : Boolean = {
        return this.androidKeyFactory.isBackSpace(input)
    }

    def isLeft(input : Input) : Boolean = {
        return this.androidKeyFactory.isLeft(input)
    }

    def isRight(input : Input) : Boolean = {
        return this.androidKeyFactory.isRight(input)
    }

    def isUp(input : Input) : Boolean = {
        return this.androidKeyFactory.isUp(input)
    }

    def isDown(input : Input) : Boolean = {
        return this.androidKeyFactory.isDown(input)
    }

    def isEnter(input : Input) : Boolean = {
        return this.androidKeyFactory.isEnter(input)
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


