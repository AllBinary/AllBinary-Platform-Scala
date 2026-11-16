/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.life


trait LifeInterface {

    def get() : Short

    def set(lives : Short) : Unit

    def reset() : Unit

    def add(lives : Short) : Unit

    def deaths(lives : Short) : Unit

    def getMaxlives() : Short

    def isAlive() : Boolean

}


