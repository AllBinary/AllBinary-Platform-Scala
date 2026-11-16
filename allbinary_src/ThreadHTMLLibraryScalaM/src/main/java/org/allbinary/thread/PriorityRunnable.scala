/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread


/**  *  * @author User  */
trait PriorityRunnable extends Runnable {

    def getPriority() : Int

    //This is not really about priority and is for HTML5 builds
    def isDone() : Boolean

    def reset() : Unit

}


