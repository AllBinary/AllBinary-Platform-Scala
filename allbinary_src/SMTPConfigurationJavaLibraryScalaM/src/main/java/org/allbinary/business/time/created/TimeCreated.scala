/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.time.created

import _root_.org.allbinary.business.time.Time

class TimeCreated private (super_1 : Long, constructor_ : Unit) extends Time(super_1) {

    def this(time : String) = {
        this(_root_.java.lang.Long.parseLong(time), ())
    }

    def this(time : Long) = {
        this(time, ())
    }

}


