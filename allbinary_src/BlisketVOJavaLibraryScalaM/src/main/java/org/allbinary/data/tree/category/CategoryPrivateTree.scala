/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tree.category

import _root_.org.allbinary.business.category.CategoryComponent
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.file.CryptFileWriter
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document

class CategoryPrivateTree(param_categoryFactoryInterface : CategoryFactoryInterface) {

    val logUtil : LogUtil = LogUtil.getInstance()

    var categoryFactoryInterface : CategoryFactoryInterface = null

    //Constructor
    {
        val categoryFactoryInterface : CategoryFactoryInterface = param_categoryFactoryInterface
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().CATEGORY)) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF(commonStrings.START, this, "CategoryPrivateTree(CategoryFactoryInterface categoryFactoryInterface)")
        }
        this.categoryFactoryInterface = categoryFactoryInterface
    }

    def save(categoryInterface : CategoryInterface) : Unit = this.synchronized {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil.putF("Saving Category File: " + categoryInterface.getFilePath(), this, "save()")
        }
        var document : Document = new CategoryComponent(categoryInterface).toXmlDoc()
        //overwrite old file with new
        var cryptFileWriter : CryptFileWriter = new CryptFileWriter(CategoryData.getInstance().UNCRYPTED_EXTENSION, CategoryData.getInstance().ENCRYPTED_EXTENSION)
        cryptFileWriter.write(categoryInterface.getFilePath(), document)
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
            this.logUtil.putF("end", this, "save()")
        }
    }

    def delete(categoryInterface : CategoryInterface) : Unit = this.synchronized {
        if (categoryInterface.isLeaf()) {
            var categoryFile : AbFile = AbFile.createAbFileFromAbPath(categoryInterface.getFilePath())
            if (categoryFile.delete()) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil.putF("Removed: " + categoryInterface.getFilePath(), this, "delete(CategoryInterface)")
                }
            }
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil.putF("Not a leaf unable to remove", this, "delete(CategoryInterface)")
            }
        }
    }

}


