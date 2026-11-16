/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.w3c.dom.Node

trait CategoryFactoryInterface {

    def getRootInstance() : CategoryInterface

    def getRootInstance(categoryPath : AbPath) : CategoryInterface

    def getRootInstanceFromNode(node : Node) : CategoryInterface

    //New Category With Parent Child Relationships
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, name : String) : CategoryInterface

    //CategoryInterface getInstance(Node node, int level);
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, node : Node) : CategoryInterface

    //CategoryInterface getInstance(HashMap categoryPropertiesHashMap, int level);
    def getInstance(rootCategoryInterface : CategoryInterface, parentCategoryInterface : CategoryInterface, categoryPropertiesHashMap : HashMap[Object, Object]) : CategoryInterface

}


