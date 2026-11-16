/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.category

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.category.Category
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryFactoryInterface
import _root_.org.allbinary.business.init.db.InventoryDbInitInfo
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.string.StringMaker

class CategoryEntity private (super_1 : InventoryDbInitInfo, constructor_ : Unit) extends AbSqlBean(super_1) with CategoryEntityInterface {

    val logUtil_CategoryEntity : LogUtil = LogUtil.getInstance()

    val tableName : String = "categories"

    //private CategoryFactoryInterface categoryFactoryInterface;
    def this(categoryFactoryInterface : CategoryFactoryInterface) = {
        this(new InventoryDbInitInfo(), ())
        //this.categoryFactoryInterface = categoryFactoryInterface;
        this.setTableName(this.tableName)
    }

    def this() = {
        this(new InventoryDbInitInfo(), ())
        this.setTableName(this.tableName)
    }

    //ignore child categories
    def insert(category : Category) : Unit = {
        try {
            var categoryVector : BasicArrayList = category.toVector()
            var values : BasicArrayList = new BasicArrayListD()
            values.add(categoryVector.get(0))
            values.add(categoryVector.get(1))
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_CategoryEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def delete(value : String) : Unit = {
        try {
            super.deleteWhere(CategoryData.getInstance().NAME, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_CategoryEntity.putF(this.commonStrings.SUCCESS, this, this.commonStrings.delete)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_CategoryEntity.put(this.commonStrings.FAILURE, this, this.commonStrings.delete, e)
                }
            }
        }
    }

    final def createTableStatement() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE)
        stringBuffer.append(this.tableName)
        stringBuffer.append(this.sqlStrings.START)
        stringBuffer.append(CategoryData.getInstance().NAME)
        stringBuffer.append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL)
        stringBuffer.append(CategoryData.getInstance().LEVEL)
        stringBuffer.append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL)
        stringBuffer.append(this.sqlStrings.PRIMARY_KEY)
        stringBuffer.append(CategoryData.getInstance().NAME)
        stringBuffer.append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    def update(updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(CategoryData.getInstance().NAME, updatedValues.get(CategoryData.getInstance().NAME).asInstanceOf[String], updatedValues)
    }

    override def dropTable() : String = {
        return super.dropTable()
    }

    //Needed for polyglot do not remove
    override def insert(values : BasicArrayList) : Unit = {
        super.insert(values)
    }

}


