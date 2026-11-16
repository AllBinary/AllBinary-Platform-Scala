/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.category

import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.directory.Directory
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class CategoryModifierTree(param_categoryFactoryInterface : CategoryFactoryInterface) extends CategoryPrivateTree(param_categoryFactoryInterface) with CategoryModifierTreeInterface {

    val logUtil_CategoryModifierTree : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val directory : Directory = Directory.getInstance()

    //Constructor
    {
        val categoryFactoryInterface : CategoryFactoryInterface = param_categoryFactoryInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            this.logUtil_CategoryModifierTree.putF(this.commonStrings.START, this, "CategoryModifierTree(CategoryFactoryInterface categoryFactoryInterface)")
        }
    }

    //Add Category
    def insert(parentCategoryInterface : CategoryInterface, newChildCategoryInterface : CategoryInterface) : Unit = this.synchronized {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                this.logUtil_CategoryModifierTree.putF("Inserting", this, "insert()")
            }
            if (parentCategoryInterface.isValid().booleanValue()) {
                //This could cause a problem adding it before saving the data but who cares
                parentCategoryInterface.addChild(newChildCategoryInterface)
                var directoryToBeCreatedAbPath : AbPath = new AbPath(newChildCategoryInterface.getRootFilePath().toString() + newChildCategoryInterface.getPath().toString(), StringUtil.getInstance().EMPTY_STRING)
                this.directory.create(directoryToBeCreatedAbPath)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
                    this.logUtil_CategoryModifierTree.putF("Saving", this, "insert()")
                }
                this.save(parentCategoryInterface)
                this.save(newChildCategoryInterface)
            } else {
                throw new Exception("Will Not Add Null Category")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryModifierTree.put(this.commonStrings.FAILURE, this, "insert", e)
                }
            }
        }
    }

    def delete(parentCategoryInterface : CategoryInterface, existingChildCategoryInterface : CategoryInterface) : Unit = this.synchronized {
        try {
            if (parentCategoryInterface.isValid().booleanValue()) {
                parentCategoryInterface.addChild(existingChildCategoryInterface)
                var directoryToBeDeletedAbPath : AbPath = new AbPath(existingChildCategoryInterface.getRootFilePath().toString() + existingChildCategoryInterface.getPath().toString(), StringUtil.getInstance().EMPTY_STRING)
                this.delete(existingChildCategoryInterface)
                parentCategoryInterface.removeChild(existingChildCategoryInterface)
                this.save(parentCategoryInterface)
                this.directory.remove(directoryToBeDeletedAbPath)
            } else {
                throw new Exception("Will Not Add Null Category")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryModifierTree.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

}


