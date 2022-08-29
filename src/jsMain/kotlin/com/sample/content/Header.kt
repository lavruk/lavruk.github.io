package com.sample.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.sample.style.*
import kotlinx.browser.window

@Composable
fun Header() {
    Section(attrs = {
        classes(WtSections.wtSectionBgGrayDark)
    }) {
        Div({ classes(WtContainer.wtContainer) }) {
            Div({
                classes(WtRows.wtRow, WtRows.wtRowSizeM)
            }) {
                Logo()
                // TODO: support i18n
                //LanguageButton()
            }
        }
    }
}

@Composable
private fun Logo() {
    Div(attrs = {
        classes(WtCols.wtColInline)
    }) {
        Div({
            classes(WtCols.wtCol2, WtCols.wtColMd3)
            style {
                alignSelf(AlignSelf.Start)
            }
        }) {
            Img(src = "i1.svg", attrs = { classes(AppStylesheet.composeLogo) })
        }
//        A(attrs = {
//            target(ATarget.Blank)
//        }, href = "https://www.jetbrains.com/") {
//
//            Div(attrs = {
//                classes("jetbrains-logo", "_logo-jetbrains-square", "_size-3")
//            }) {
//                Img(src = "i1.svg", attrs = { classes(AppStylesheet.composeLogo) })
//            }
//        }
    }
}
//
//@Composable
//private fun LanguageButton() {
//    Div(attrs = {
//        classes(WtCols.wtColInline)
//    }) {
//        Button(attrs = {
//            classes(WtTexts.wtButton, WtTexts.wtLangButton)
//            onClick { window.alert("Oops! This feature is yet to be implemented") }
//        }) {
//            Img(src = "ic_lang.svg", attrs = { style {
//                paddingLeft(8.px)
//                paddingRight(8.px)
//            }})
//            Text("English")
//        }
//    }
//}