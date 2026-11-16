/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.animation.text


/**  *  * @author User  */
trait TextInterface {

    def setTextWithOnMeasure(text : String, textChangeListener : TextChangeListener) : Unit

    def getText() : String

    def setText(text : String) : Unit

    def getFontHeight() : Int

    def getWidth() : Int

}


