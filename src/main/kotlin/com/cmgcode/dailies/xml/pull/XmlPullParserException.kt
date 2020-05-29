package com.cmgcode.dailies.xml.pull

class XmlPullParserException : Exception {
    var detail: Throwable? = null
        protected set
    var lineNumber = -1
        protected set
    var columnNumber = -1
        protected set

    constructor(s: String?) : super(s) {}
    constructor(msg: String?, parser: XmlPullParser?, chain: Throwable?) : super((if (msg == null) "" else "$msg ") + (if (parser == null) "" else "(position:" + parser.positionDescription + ") ") + if (chain == null) "" else "caused by: $chain") {
        if (parser != null) {
            lineNumber = parser.lineNumber
            columnNumber = parser.columnNumber
        }
        detail = chain
    }

    override fun printStackTrace() {
        if (detail == null) {
            super.printStackTrace()
        } else {
            synchronized(System.err) {
                System.err.println(super.message + "; nested exception is:")
                detail!!.printStackTrace()
            }
        }
    }
}
