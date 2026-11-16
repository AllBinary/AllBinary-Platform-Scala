/* * AllBinary Open License Version 1 * Copyright (c) 2022 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.displayable.screen

import _root_.org.allbinary.game.paint.AboutPaintable
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author User  */
class AboutPaintableFactory private() {
    import _root_.org.allbinary.graphics.displayable.screen.AboutPaintableFactory.{*}

    var paintableArray : Array[Paintable] = Array[Paintable](NullPaintable.getInstance())

    //Constructor
    {
        /*         final String[] INTENTS = {                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 "Email Intent",                 StringUtil.getInstance().EMPTY_STRING,                 };                  final String[] LINKS = {                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 StringUtil.getInstance().EMPTY_STRING,                 //"https://www.allbinary.com/Privacy.jsp"                 };                 */
        val INFO : Array[String] = Array[String]("Built with the", "AllBinary Platform", StringUtil.getInstance().EMPTY_STRING, "Comments or Questions:", "support@allbinary.com")
        val DEVELOPERS : Array[String] = Array[String]("Developed By:", "Travis Berthelot")
        this.paintableArray = AboutPaintable.getInstance(INFO, DEVELOPERS).getPaintableArrayInstance()
    }

}

object AboutPaintableFactory {
    private val instance : AboutPaintableFactory = new AboutPaintableFactory()

    /**      * @return the instance      */
    def getInstance() : AboutPaintableFactory = {
        return AboutPaintableFactory.instance
    }

}


