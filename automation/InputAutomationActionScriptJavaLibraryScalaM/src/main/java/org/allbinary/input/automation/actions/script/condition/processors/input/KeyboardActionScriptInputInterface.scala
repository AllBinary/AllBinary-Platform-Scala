/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script.condition.processors.input


trait KeyboardActionScriptInputInterface extends ProfileActionScriptInputInterface {

    def getDelayBetweenKeys() : Int

    def getKeyArray() : Array[Integer]

    //void setKeyArray(Integer key[]);
    def isPress() : Boolean

    def isRelease() : Boolean

    def isNormal() : Boolean

    def setPress(press : Boolean) : Unit

    def setRelease(release : Boolean) : Unit

    def setNormal() : Unit

    def getText() : String

    def setText(text : String) : Unit

    def log() : Unit

}


