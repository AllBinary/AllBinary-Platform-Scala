/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.hierarchy.CategoryHierarchyInterface
import _root_.org.allbinary.business.category.properties.CategoryPropertiesInterface
import _root_.org.allbinary.data.tables.TableMappingInterface
import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.allbinary.logic.io.path.AbPath

trait CategoryInterface extends TableMappingInterface with ValidationInterface {

    def getChildNodes() : BasicArrayList

    def addChildProperty(categoryPropertiesInterface : CategoryPropertiesInterface) : Boolean

    def addChild(categoryInterface : CategoryInterface) : Boolean

    def removeChild(categoryInterface : CategoryInterface) : Boolean

    def isLeaf() : Boolean

    def getProperties() : CategoryPropertiesInterface

    def setProperties(categoryPropertiesInterface : CategoryPropertiesInterface) : Unit

    def getHierarchy() : CategoryHierarchyInterface

    def setHierarchy(categoryHierarchyInterface : CategoryHierarchyInterface) : Unit

    def getPath() : AbPath

    def getFilePath() : AbPath

    def getWebAppPath() : AbPath

    def getRootFilePath() : AbPath

    def log() : Unit

}


