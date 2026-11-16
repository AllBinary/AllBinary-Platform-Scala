/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.draw

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.AndroidUtil
import _root_.org.allbinary.J2MEUtil
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.graphics.opengles.OpenGLFeatureUtil
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil

/**  *  * @author user  */
class DrawStringUtil {
    import _root_.org.allbinary.graphics.draw.DrawStringUtil.{*}

    private val EMPTY_STRING : String = StringUtil.getInstance().EMPTY_STRING

    private var anchor : Int = Anchor.TOP_LEFT

    def drawCenterString(graphics : Graphics, string : String, offset : Int, length : Int, x : Int, y : Int) : Unit = {
        val width : Int = (graphics.getFont().substringWidth(string, offset, length) >> 1)
        //width = (width * length) / string.length();
        try {
            graphics.drawSubstring(string, offset, length, x - width, y, this.anchor)
        } catch {
            case e : Exception => {
                PreLogUtil.put(new StringMaker().append("Exception: stringLength: ").appendint(string.length()).append(" offset: ").appendint(offset).append(" currentLength: ").appendint(length).toString(), this, "drawCenterString")
            }
        }
    }

    def drawCenterStrings(graphics : Graphics, stringArray : Array[String], maxWidth : Int, charHeight : Int, x : Int, y : Int) : Unit = {
        var extraLines : Int = 0

        {
            var index : Int = 0
            while (index < stringArray.length) {
                var string : String = stringArray(index)
                if (string ne this.EMPTY_STRING) {
                    var width : Int = graphics.getFont().stringWidth(string)
                    var minTotalLines : Int = 1
                    if (width > maxWidth) {
                        minTotalLines = (width / maxWidth) + 1
                    }
                    var linePortion : Int = string.length() / minTotalLines
                    var offset : Int = 0
                    var currentLength : Int = linePortion
                    //for (int lineIndex = 0; lineIndex < minTotalLines; lineIndex++)
                    var size : Int = string.length()

                    {
                        while (offset < size) {
                            //|| lineIndex == minTotalLines - 1
                            if ((offset + currentLength) > size) {
                                currentLength = size - offset
                            }
                            if ((offset + currentLength) != size) {

                                {
                                    while ((currentLength > 0) && (stringArray(index).charAt(offset + currentLength) != ' ')) {
                                        currentLength -= 1
                                    }
                                }
                                //If no spaces after tab size then stick with limit
                                if (currentLength <= 4) {
                                    currentLength = linePortion
                                }
                            }
                            //PreLogUtil.put("stringLength: ").append(string.length()).append(" offset: ").append(offset).append(" currentLength: ").append(currentLength, graphics, "drawCenterStrings");
                            this.drawCenterString(graphics, string, offset, currentLength, x, y + ((index + { val value_N68739 = extraLines; extraLines += 1; value_N68739 }) * charHeight))
                            offset = offset + currentLength
                            currentLength = linePortion
                        }
                    }
                    extraLines -= 1
                }
                index += 1
            }
        }
    }

}

object DrawStringUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : DrawStringUtil = new DrawStringUtil()

    def getInstance() : DrawStringUtil = {
        return DrawStringUtil.instance
    }

}


