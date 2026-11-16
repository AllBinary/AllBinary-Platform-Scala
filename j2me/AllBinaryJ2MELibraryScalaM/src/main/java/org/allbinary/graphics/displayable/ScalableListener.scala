/*  * AllBinary Open License Version 1  * Copyright (c) 2011 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable


/**  *  * @author user  */
trait ScalableListener {

    def getRatio(ratio : Float) : Float

    def getLeft(xOffset : Int) : Int

    def getTop(yOffset : Int) : Int

    def scale(ratio : Float) : Unit

}


