/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.transform.info

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.data.tables.BasicDataTableInterface
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface

trait TransformInfoEntityInterface extends BasicDataTableInterface {

    def get(name : String, propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformInfoInterface

    //public TransformInfoInterface get(String name) throws Exception;
    def getObjectConfigs(storeName : String) : BasicArrayList

    def getNames(storeName : String) : BasicArrayList

    def delete(name : String) : Unit

    def insert(values : BasicArrayList) : Unit

    def update(updatedValues : HashMap[Object, Object]) : Unit

}


