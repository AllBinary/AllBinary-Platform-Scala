/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.workflow

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.data.tables.BasicDataTableInterface
import _root_.org.allbinary.logic.control.workflow.WorkFlowInterface
import _root_.org.allbinary.logic.system.security.licensing.LicensingException

trait WorkFlowEntityInterface extends BasicDataTableInterface {

    def get(storeName : String) : BasicArrayList

    def get(name : String, storeName : String) : WorkFlowInterface

    def delete(name : String, storeName : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(updatedValues : HashMap[Object, Object]) : Unit

}


