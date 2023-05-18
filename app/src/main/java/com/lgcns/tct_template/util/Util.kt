package com.lgcns.tct_template.util

import android.annotation.SuppressLint
import android.content.Context

/**
 * drawable 리소스 ID를 리턴 (없는경우 -1)
 *
 * @param imgName ic_test.png (X)  / ic_test (O)
 */
@SuppressLint("DiscouragedApi")
fun Context.getDrawableId(imgName: String): Int {
    return this.resources.getIdentifier(imgName, "drawable", this.packageName)
}

/**
 * strings.xml 리소스 ID를 리턴 (없는경우 -1)
 *
 * @param strName
 */
@SuppressLint("DiscouragedApi")
fun Context.getStringId(strName: String): Int {
    return this.resources.getIdentifier(strName, "string", this.packageName)
}

/**
 * layout 리소스 ID를 리턴 (없는경우 -1)
 *
 * @param layoutName
 */
@SuppressLint("DiscouragedApi")
fun Context.getLayoutId(layoutName: String): Int {
    return this.resources.getIdentifier(layoutName, "layout", this.packageName)
}

/**
 * 파일명으로된 문자열의 확장자를 제거한다.
 *
 * @receiver 파일이름형식의 문자열
 */
fun String.removeExtension(): String {
    return this.replaceFirst("[.][^.]+$".toRegex(), "")
}