/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.thread


/**  *  * @author User  */
class ThreadPoolStrings {
    import _root_.org.allbinary.thread.ThreadPoolStrings.{*}

    val ADD_TASK : String = "addTask"

    val START_TASK : String = "Started Task: "

    val COMPLETE_TASK : String = "Completed Task: "

}

object ThreadPoolStrings {
    private val instance : ThreadPoolStrings = new ThreadPoolStrings()

    /**      * @return the instance      */
    def getInstance() : ThreadPoolStrings = {
        return ThreadPoolStrings.instance
    }

}


