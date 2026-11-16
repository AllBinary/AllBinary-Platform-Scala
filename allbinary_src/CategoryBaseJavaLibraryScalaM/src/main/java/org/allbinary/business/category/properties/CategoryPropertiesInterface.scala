/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.properties

import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.io.path.AbPath

trait CategoryPropertiesInterface extends TableMappingInterface with ValidationInterface {

    def setValue(value : String) : Unit

    def getValue() : String

    //Provides the path of the category
    def getWebAppPath() : AbPath

    def getPath(categoryHierarchyInterface : CategoryHierarchyInterface) : AbPath

    def getFileName() : String

    def isRoot() : Boolean

    def isRealRoot() : Boolean

}


