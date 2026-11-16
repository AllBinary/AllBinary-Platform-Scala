/* Generated Code Do Not Modify */
package org.allbinary.animation

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil

class PathParser {
    import _root_.org.allbinary.animation.PathParser.{*}

}

object PathParser {
    // Basic space/comma string tokenizer
    private def tokenize(d : String) : Array[String] = {
        val tokens : BasicArrayList = new BasicArrayListD()
        val sb : StringBuffer = new StringBuffer()

        {
            var i : Int = 0
            while (i < d.length()) {
                var c : Char = d.charAt(i)
                if (((((c == ' ') || (c == ',')) || (c == '\t')) || (c == '\n')) || (c == '\r')) {
                    if (sb.length() > 0) {
                        tokens.add(sb.toString())
                        sb.setLength(0)
                    }
                } else if ((((((((((c == 'M') || (c == 'm')) || (c == 'L')) || (c == 'l')) || (c == 'V')) || (c == 'v')) || (c == 'C')) || (c == 'c')) || (c == 'Z')) || (c == 'z')) {
                    if (sb.length() > 0) {
                        tokens.add(sb.toString())
                        sb.setLength(0)
                    }
                    tokens.add(String.valueOf(c))
                } else {
                    sb.append(c)
                }
                i += 1
            }
        }
        if (sb.length() > 0) {
            tokens.add(sb.toString())
        }
        val res : Array[String] = new Array[String](tokens.size())
        tokens.toArrayType(res.asInstanceOf[Array[Object]])
        return res
    }

    def parsePath(d : String, outX : Array[Int], outY : Array[Int], maxPoints : Int) : Int = {
        var tokens : Array[String] = tokenize(d)
        var count : Array[Int] = Array[Int](0)
        val fixedPoint : FixedPoint = FixedPoint.getInstance()
        var curX : Int = 0
        var curY : Int = 0
        var startX : Int = 0
        var startY : Int = 0
        var idx : Int = 0

        {
            while (idx < tokens.length) {
                var tok : String = tokens({ val value_N71955 = idx; idx += 1; value_N71955 })
                var cmd : Char = tok.charAt(0)
                if ((cmd == 'M') || (cmd == 'm')) {
                    var x : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N74064 = idx; idx += 1; value_N74064 })))
                    var y : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N74150 = idx; idx += 1; value_N74150 })))
                    if (cmd == 'm') {
                        x += curX
                        y += curY
                    }
                    curX = x
                    curY = y
                    startX = x
                    startY = y
                    outX(count(0)) = curX
                    outY(count(0)) = curY
                    count(0) += 1
                } else if ((cmd == 'L') || (cmd == 'l')) {
                    var x : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N73641 = idx; idx += 1; value_N73641 })))
                    var y : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N73727 = idx; idx += 1; value_N73727 })))
                    if (cmd == 'l') {
                        x += curX
                        y += curY
                    }
                    curX = x
                    curY = y
                    outX(count(0)) = curX
                    outY(count(0)) = curY
                    count(0) += 1
                } else if ((cmd == 'V') || (cmd == 'v')) {
                    var y : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N73354 = idx; idx += 1; value_N73354 })))
                    if (cmd == 'v') {
                        y += curY
                    }
                    curY = y
                    outX(count(0)) = curX
                    outY(count(0)) = curY
                    count(0) += 1
                } else if ((cmd == 'C') || (cmd == 'c')) {
                    var x1 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72475 = idx; idx += 1; value_N72475 })))
                    var y1 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72561 = idx; idx += 1; value_N72561 })))
                    var x2 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72647 = idx; idx += 1; value_N72647 })))
                    var y2 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72733 = idx; idx += 1; value_N72733 })))
                    var x3 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72819 = idx; idx += 1; value_N72819 })))
                    var y3 : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N72905 = idx; idx += 1; value_N72905 })))
                    if (cmd == 'c') {
                        x1 += curX
                        y1 += curY
                        x2 += curX
                        y2 += curY
                        x3 += curX
                        y3 += curY
                    }
                    PGUtil.getInstance().flattenCubicBezier(curX, curY, x1, y1, x2, y2, x3, y3, outX, outY, count, maxPoints)
                    curX = x3
                    curY = y3
                } else if ((cmd == 'Z') || (cmd == 'z')) {
                    curX = startX
                    curY = startY
                    outX(count(0)) = curX
                    outY(count(0)) = curY
                    count(0) += 1
                }
                // Implicit next points handler (if next token is a number instead of a command)

                {
                    while ((idx < tokens.length) && !isCommand(tokens(idx))) {
                        // If it was lineTo/MoveTo parameters following without explicit token
                        if ((((cmd == 'M') || (cmd == 'm')) || (cmd == 'L')) || (cmd == 'l')) {
                            var x : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N74960 = idx; idx += 1; value_N74960 })))
                            var y : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N75046 = idx; idx += 1; value_N75046 })))
                            if ((cmd == 'm') || (cmd == 'l')) {
                                x += curX
                                y += curY
                            }
                            curX = x
                            curY = y
                            outX(count(0)) = curX
                            outY(count(0)) = curY
                            count(0) += 1
                        } else if ((cmd == 'V') || (cmd == 'v')) {
                            var y : Int = fixedPoint.toFixed(_root_.java.lang.Double.parseDouble(tokens({ val value_N74673 = idx; idx += 1; value_N74673 })))
                            if (cmd == 'v') {
                                y += curY
                            }
                            curY = y
                            outX(count(0)) = curX
                            outY(count(0)) = curY
                            count(0) += 1
                        }
                    }
                }
            }
        }
        return count(0)
    }

    private def isCommand(tok : String) : Boolean = {
        var c : Char = tok.charAt(0)
        return "MmLlVvCcZz".indexOf(c) >= 0
    }

}


