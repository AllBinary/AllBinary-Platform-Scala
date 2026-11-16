/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.input


/**  *  * @author User  */
trait KeyInterface {

    def keyPressed(keyCode : Int) : Unit

    def keyReleased(keyCode : Int) : Unit

    def keyPressedByDevice(keyCode : Int, deviceId : Int) : Unit

    def keyReleasedByDevice(keyCode : Int, deviceId : Int) : Unit

}


