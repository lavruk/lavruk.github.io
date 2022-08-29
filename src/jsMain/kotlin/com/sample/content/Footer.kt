package com.sample.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.sample.style.*


@Composable
fun PageFooter() {
    Footer({
        style {
            flexShrink(0)
            boxSizing("border-box")
        }
    }) {
        Section({
            classes(WtSections.wtSectionBgGrayDark)
            style {
                padding(24.px, 0.px)
            }
        }) {
            Div({ classes(WtContainer.wtContainer) }) {
                Div({
                    classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter)
                    style {
                        justifyContent(JustifyContent.Center)
                        flexWrap(FlexWrap.Wrap)
                    }
                }) {

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        P({
                            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
                        }) {
                            Text("Contacts:")
                        }
                    }

                    Div({
                        classes(WtCols.wtColInline)
                    }) {
                        getSocialLinks().forEach { SocialIconLink(it) }
                    }
                }

                CopyrightInFooter()
            }
        }
    }
}

@Composable
private fun CopyrightInFooter() {
    Div({
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtRows.wtRowSmAlignItemsCenter, WtOffsets.wtTopOffset48)
        style {
            justifyContent(JustifyContent.SpaceEvenly)
            flexWrap(FlexWrap.Wrap)
            padding(0.px, 12.px)
        }
    }) {
        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Copyright © 2000-2021  Lavruk")
        }

        Span({
            classes(WtTexts.wtText3, WtTexts.wtTextPale)
        }) {
            Text("Developed with drive and IntelliJ IDEA")
        }
    }
}

@Composable
private fun SocialIconLink(link: SocialLink) {
    A(attrs = {
        classes(WtTexts.wtSocialButtonItem)
        target(ATarget.Blank)
    }, href = link.url) {
        Img(src = link.iconSvg, attrs = {
            attr("width", "24")
            attr("height", "24")
        })
        Div({
            classes(WtTexts.wtText1, WtTexts.wtText1ThemeDark)
            style {
                padding(0.px, 12.px)
            }
        }) {
            Text(link.title)
        }
    }
}

private data class SocialLink(
    val id: String,
    val url: String,
    val title: String,
    val iconSvg: String
)

private fun getSocialLinks(): List<SocialLink> {
    return listOf(
        SocialLink("email", "mailto:volodymyr.lavruk@gmail.com", "Email", "ic_mail.svg"),
        SocialLink("phone", "tel:+12258007468", "Phone", "ic_phone.svg"),
        SocialLink(
            "linkedin",
            "https://www.linkedin.com/in/lavruk",
            "Linkedin",
            "ic_linkedin.svg"
        ),
    )
}