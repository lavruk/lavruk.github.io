package com.sample.content

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import com.sample.components.Card
import com.sample.components.ContainerInSection
import com.sample.components.LinkOnCard
import com.sample.style.*
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingTop

data class CardWithListPresentation(
    val title: String,
    val list: List<String>,
    val links: List<LinkOnCard> = emptyList()
)

private val GranularExperience = ExperienceData(
    title = "Granular | Principle Mobile Engineer | Jan 2019 - Present",
    bullets = listOf(
        "Designed and implemented a common SDK used by Android and iOS apps using Kotlin Multiplatform. This allowed achieving close to 80% reusability across platforms.",
        "Actively participated in architecting a new app from the ground up following best practices of functional/reactive programming."
    )
)

private val LookoutExperience = ExperienceData(
    title = "Lookout | Staff Software Engineer | Apr 2015 - Dec 2018 ",
    bullets = listOf(
        "As a team member, refactored 40% of the application to allow modularity and reusability of the business logic across multiple Android Applications.",
        "Improved development time of the new features by 20% by combining 12 repositories into monorepo.",
        "Led a 7-member team to develop and implement 3 new features in the Android client app.",
        "Improved user engagement by designing and implementing new activation and onboarding flow.",
        "Implemented the Out Of Box activation by integrating it into the initial device onboarding setup."
    )
)

private val OnefinestayExperience = ExperienceData(
    title = "Onefinestay | Senior Android Engineer | Apr 2014 - Apr 2015",
    bullets = listOf(
        "Reduced time of development by 30% by sharing code between the company apps.",
        "Improved app architecture by using dependency injection.",
        "Integrated app with Amazon Cloud Storage, implemented background upload/download to/from Amazon S3.",
        "Improved stability by using Espresso Test Kit."
    )
)

private val DigicodeExperience = ExperienceData(
    title = "Digicode | Android Engineer | Sept 2011 - Mar 2014",
    bullets = listOf(
        "Designed and implemented 5+ Android applications from the scratch in 2-3 month time frame per application.",
        "Implemented real-time socket communication system between android apps."
    )
)

private val FreelancerExperience = ExperienceData(
    title = "Freelancer | Software Engineer | Mar 2007 - Sept | 2011",
    bullets = listOf(
        "Developed TilesBreak Android game. Developed an Android application to monitor train schedule.",
        "Developed an online shop application using HTML and JQuery.",
        "Developed enterprise software.",
    )
)

data class ExperienceData(val title: String, val bullets: List<String>)

private val allExperiences = arrayOf(
    GranularExperience,
    LookoutExperience,
    OnefinestayExperience,
    DigicodeExperience,
    FreelancerExperience,
)

@Composable
private fun ExperianceBlock(experience: ExperienceData) {
    Div(attrs = {
        classes(WtRows.wtRow, WtRows.wtRowSizeM, WtOffsets.wtTopOffset12, )
    }) {
        Img(src = "compose_bullet.svg") {
            attr("with", "24")
            attr("height", "24")
        }

        Div({
            classes(WtTexts.wtH3)
            style {
                padding(0.px, 12.px)
            }
        }) {
            Text(experience.title)
        }

        Div(attrs = {
            classes(WtTexts.wtText1, WtTexts.wtText1HardnessHard, WtOffsets.wtTopOffset24)
        }) {
            Ul {
                experience.bullets.forEach {
                    Li {
                        Text(it)
                    }
                }
            }
        }
    }
}

@Composable
fun Experience() {
    ContainerInSection(WtSections.wtSectionBgGrayLight) {
        H2(attrs = { classes(WtTexts.wtH2) }) {
            Text("Experience")
        }

        Div(attrs = {
            classes(WtRows.wtRow, WtRows.wtRowSizeM)
        }) {
            Div(attrs = {
                classes(WtCols.wtCol6, WtCols.wtColMd6, WtCols.wtColSm12, WtOffsets.wtTopOffset24)
            }) {
                P(attrs = {
                    classes(WtTexts.wtText1)
                }) {
                    Text("Over 15 years of experience building Android applications")
                }
            }
        }

//        Div(attrs = {
//            classes(WtRows.wtRow, WtRows.wtRowSizeXs, WtOffsets.wtTopOffset24)
//        }) {
            allExperiences.forEach {
                ExperianceBlock(it)
            }
//        }

        A(attrs = {
            classes(WtTexts.wtButton, WtTexts.wtButtonThemeLight, WtOffsets.wtTopOffset48, WtOffsets.wtTopOffsetSm24)
            target(ATarget.Blank)
        }, href = "https://www.linkedin.com/in/lavruk") {
            Text("See more on LinkedIn")
        }
    }
}

@Composable
private fun CardWithList(card: CardWithListPresentation) {
    Card(
        title = card.title,
        links = card.links
    ) {
        Ul(attrs = {
            classes(WtTexts.wtText2)
        }) {
            card.list.forEachIndexed { _, it ->
                Li({
                    style {
                        paddingTop(24.px)
                    }
                }) { Text(it) }
            }
        }
    }
}
